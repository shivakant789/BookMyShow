package com.scaler.bookmyshow.repositries;

import com.scaler.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
}