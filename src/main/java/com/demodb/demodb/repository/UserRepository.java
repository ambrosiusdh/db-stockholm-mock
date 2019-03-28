package com.demodb.demodb.repository;

import com.demodb.demodb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
