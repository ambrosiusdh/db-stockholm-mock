package com.demodb.demodb.service;

import com.demodb.demodb.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User updateUser(User user);
    User findUserById(Integer id);
    List<User> findAllUser();
    User deleteUser(Integer id);
    User findUserByEmailAndPassword(String userEmail, String userPassword);
    User validateUserLogin(Object object);
}
