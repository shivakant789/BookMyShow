package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Seat extends BaseModel {

   private Integer rowNo;
   private Integer colNo;

   @Enumerated
   private SeatType seatType;
   @ManyToOne
   @JoinColumn(name = "hall_id")
   private Hall hall;

}