package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositries.UserRepositries;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

     private UserRepositries userRepositries;
    public User createUser(User user){
        System.out.println("Got service request for "+ user.getEmail()+" with pwd: "+ user.getPassword());
        //save this to database
        return userRepositries.save(user);

    }

    public User getUserInternal(Long userId) {

        return userRepositries.findById(userId).orElse(null);
    }
}
