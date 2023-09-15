package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Language;
import com.scaler.bookmyshow.enums.MovieFeatures;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity

public class Movie extends BaseModel {
    private String name;

    private Double rating;

    @ElementCollection
    @Enumerated
    private List<Language> languages=new ArrayList<>();

    @ElementCollection
    @Enumerated
    private List<MovieFeatures> features= new ArrayList<>();
}