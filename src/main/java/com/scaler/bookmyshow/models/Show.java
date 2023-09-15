package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
@Table(name="shows")
public class Show extends BaseModel {

    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Integer duration;
    @OneToMany
    private List<ShowSeat> showSeats = new ArrayList<>();

    @ManyToOne
    private Hall hall;

}