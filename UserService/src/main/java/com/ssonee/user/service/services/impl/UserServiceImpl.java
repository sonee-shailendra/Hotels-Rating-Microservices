package com.ssonee.user.service.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssonee.user.service.entities.Hotel;
import com.ssonee.user.service.entities.Rating;
import com.ssonee.user.service.entities.User;
import com.ssonee.user.service.exceptions.ResourceNotFoundException;
import com.ssonee.user.service.external.service.HotelService;
import com.ssonee.user.service.repositories.UserRepositories;
import com.ssonee.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Value("${ratingService.userRating.endpointURL}")
    private String userRatingServiceUrl;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User createUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepositories.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositories.findAll();
    }

    @Override
    public User getUser(String userId) {
        User usr = userRepositories.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with given id is not found on server !! : "+userId));
        //http://localhost:8083/ratings/user/94528b18-856e-49f8-842e-e4622250e4e2
        String userRatingUrl = userRatingServiceUrl+usr.getUserId();
        logger.info("UserRatingServiceUrl : "+userRatingUrl);
        Rating [] ratings =  restTemplate.getForObject(userRatingUrl, Rating[].class);
        List<Rating> userRatings = Arrays.stream(ratings).toList();

        logger.info("{}", userRatings);

        List<Rating> ratingList = userRatings.stream().map(rating -> {
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        } ).collect(Collectors.toList());

        logger.info("{}", ratingList);
        usr.setRatings(ratingList);
        return usr;
    }

}
