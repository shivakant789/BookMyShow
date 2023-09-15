package com.scaler.bookmyshow.services;


import com.scaler.bookmyshow.dtos.createShowRequest;
import com.scaler.bookmyshow.models.Movie;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.repositries.ShowRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ShowService {

    private ShowRepository showRepository;



    public Show createShow(createShowRequest request){
        //Task 1 get movie by id by calling MovieService
        Movie movie=null;
        Show show=Show.builder()
                .startTime(request.getStartTime())
                .duration(request.getDuration())
                .movie(movie)
                .build();

        Show savedshow=showRepository.save(show);

        //Task 2
        //Get the seats in the hall using hallId
        //create the shoSeats using savedshow
        //Save the show again
        List<ShowSeat> seats= Collections.emptyList();
        return showRepository.save(savedshow.toBuilder().showSeats(seats).build());
    }

    public  Show getShow(Long id){
        return showRepository
                .findById(id)
                .orElseThrow(()->new NoSuchElementException("Invalid Show id:"));



    }
}
