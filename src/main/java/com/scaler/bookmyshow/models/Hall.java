package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.MovieFeatures;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity

public class Hall extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "hall")
    private List<Seat> seats=new ArrayList<>();

    @ElementCollection
    @Enumerated
    private List<MovieFeatures> shows=new ArrayList<>();

}