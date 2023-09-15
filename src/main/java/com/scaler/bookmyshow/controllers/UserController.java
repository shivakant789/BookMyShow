package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.GetuserResponse;
import com.scaler.bookmyshow.dtos.createuserRequest;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController

@AllArgsConstructor
public class UserController {

     //@RequestMapping(path="/user", method = RequestMethod.POST)

    private UserService userService;
    @PostMapping("/user")
     public GetuserResponse createUser(@RequestBody createuserRequest request){
        User user=userService.createUser(request.toUser());
        //System.out.println("Got request for "+ request.getEmail()+" with pwd: "+ request.getPassword());
        return GetuserResponse.fromUser(user);
     }



}
