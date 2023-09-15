package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.CreateHallRequest;
import com.scaler.bookmyshow.models.Hall;
import com.scaler.bookmyshow.services.HallService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HallController {
    private HallService hallService;
    @PostMapping("/hall")
    public Hall createHall(@RequestBody CreateHallRequest request){
        return null;
    }
}
