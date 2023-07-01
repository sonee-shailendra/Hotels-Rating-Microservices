package com.ssonee.user.service.services;

import com.ssonee.user.service.entities.User;

import java.util.List;

public interface UserService {

    //User Operations

    public User createUser(User user);

    public List<User> getAllUsers();

    //get User with userId

    public User getUser(String userId);
}
