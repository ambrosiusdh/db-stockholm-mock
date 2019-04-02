package com.demodb.demodb.service;

import com.demodb.demodb.model.User;
import com.demodb.demodb.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
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
            return userRepository.save(user );
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

    @Override
    public User findUserByEmailAndPassword(String userEmail, String userPassword) {
        return userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
    }

    @Override
    public User validateUserLogin(Object object) {
        log.info("" + object);

        Object data;
        List<String> dataset = new ArrayList<>();

        for (Field field: object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                data = field.get(object);

                if(data.toString().contains("="))
                    dataset.add(data.toString());

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        List<String> userData = new ArrayList<>();

        for (String s:dataset) {
            String[] parts = s.split("=");
            log.info(parts[1]);
            userData.add(parts[1]);
        }

        return findUserByEmailAndPassword(userData.get(0), userData.get(1));
    }
}
