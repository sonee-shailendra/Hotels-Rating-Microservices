package com.ssonee.user.service.repositories;

import com.ssonee.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, String> {


}
