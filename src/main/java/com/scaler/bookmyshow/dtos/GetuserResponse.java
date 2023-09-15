package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.User;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetuserResponse {
    private Long id;
    private String name;
    private String email;

    public static GetuserResponse fromUser(User user){
        return  new GetuserResponse(user.getId(),user.getName(),user.getEmail());
    }
}
