package com.ssonee.rating.services;

import com.ssonee.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    public Rating createRating(Rating rating);

    public List<Rating> getAllRatings();

    public List<Rating> getRatingsByUser(String userId);

    public List<Rating> getRatingsByHotel(String hotelId);
}
