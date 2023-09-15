package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.User;
import lombok.Data;

@Data
public class createuserRequest {

    private String name;
    private String email;

    private String password;



    public User toUser(){
        return new User(name,email,password);
    }
}
