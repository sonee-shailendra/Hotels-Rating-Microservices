package com.ssonee.hotel.repostitories;

import com.ssonee.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {


}
