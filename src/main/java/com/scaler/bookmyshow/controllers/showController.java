package com.scaler.bookmyshow.controllers;


import com.scaler.bookmyshow.dtos.createShowRequest;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class showController {
    //GET API for show
    private ShowService showService;

    @GetMapping("/show/{id}")
    public Show readshow(@PathVariable Long id){
        return showService.getShow(id);
    }
    @PostMapping("/show")
    public Show createShow(@RequestBody createShowRequest request){

        return showService.createShow(request);
    }
}
