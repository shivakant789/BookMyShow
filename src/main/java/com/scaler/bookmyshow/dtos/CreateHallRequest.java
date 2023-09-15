package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.enums.MovieFeatures;
import com.scaler.bookmyshow.enums.SeatType;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CreateHallRequest {
    private String name;
    private List<MovieFeatures> feature= new ArrayList<>();

    private Map<SeatType,List<SeatPosition>> seatrange= new HashMap<>();
}
