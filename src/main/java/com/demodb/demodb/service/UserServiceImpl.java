package com.demodb.demodb.service;

import com.demodb.demodb.model.User;
import com.demodb.demodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if(userRepository.findById(user.getUserId()).isPresent())
            return userRepository.findById(user.getUserId()).get();
        return null;
    }

    @Override
    public User findUserById(Integer id) {
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        return null;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User deleteUser(Integer id) {
        if(userRepository.findById(id).isPresent()) {
            User temp = userRepository.findById(id).get();
            userRepository.deleteById(id);
            return temp;
        }
        return null;
    }
}
