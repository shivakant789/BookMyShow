package com.scaler.bookmyshow.repositries;


import com.scaler.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@Repository
public interface UserRepositries extends JpaRepository<User,Long> {


}
