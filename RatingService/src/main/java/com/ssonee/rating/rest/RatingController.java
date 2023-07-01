package com.ssonee.rating.rest;

import com.ssonee.rating.entities.Rating;
import com.ssonee.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));

    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUser(@PathVariable("userId") String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingsByUser(userId));
    }

    @GetMapping("hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotel(@PathVariable("hotelId") String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingsByHotel(hotelId));
    }
}
