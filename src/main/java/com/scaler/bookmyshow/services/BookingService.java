package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.dtos.CreateBookingRequest;
import com.scaler.bookmyshow.enums.BookingStatus;
import com.scaler.bookmyshow.enums.seatStatus;
import com.scaler.bookmyshow.models.Booking;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositries.BookingRepository;
import com.scaler.bookmyshow.repositries.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BookingService {
    private BookingRepository bookingRepository;
    private UserService userService;
    private ShowService showService;

    private ShowSeatService showSeatService;;
   // private ShowSeatRepository showSeatRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(CreateBookingRequest request) {
         //Step1 Get the user using id
        //Step 1 b if user is not present throw error

        User user=userService.getUserInternal(request.getUserId());
        if(user==null){
            throw  new NoSuchElementException("Invalid user ID : "+request.getUserId());
        }

        //step 2 Get the show using show id
        //Step 2 b if show is not present throw error
        Show show=showService.getShow(request.getShowId());
        //step 3 Get the showseats using showseat ids

        List<ShowSeat> showSeats = showSeatService.getShowSeats(request.getShowSeatId());
        //Step 4 check if all the seats available
        for(ShowSeat seat:showSeats){
            if(seat.getStatus()!= seatStatus.AVAILABLE){
                throw  new InvalidParameterException("Seat is not available");
            }
        }
        //Step 5 Mark all thee seats locked
        for(ShowSeat seat:showSeats){
            seat.setStatus(seatStatus.LOCKED);

        }
        List<ShowSeat> savedSeats = showSeatService.saveAll(showSeats);
        //Step 6 calculate the amount
        //I can have multiple ways of calculating amount
        //which design ppattern should I use
        //Strategy-Price calculator Strategy
        Double amount=null;
        //create and save the booking
        Booking booking=Booking.builder()
                        .user(user)
                        .show(show)
                        .seats(savedSeats)
                        .amount(amount)
                .status(BookingStatus.PENDING)
                .bookedAt(new Date())
                .build();

        return bookingRepository.save(booking);
    }
}
