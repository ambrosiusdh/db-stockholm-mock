package com.demodb.demodb.service;

import com.demodb.demodb.model.UserRole;
import com.demodb.demodb.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole createUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole updateUserRole(UserRole userRole) {
        if(userRoleRepository.findById(userRole.getUserRoleId()).isPresent())
            return userRoleRepository.save(userRole);
        return null;
    }

    @Override
    public UserRole findUserRoleById(Integer id) {
        if(userRoleRepository.findById(id).isPresent())
            return userRoleRepository.findById(id).get();
        return null;
    }

    @Override
    public UserRole deleteUserRole(Integer id) {
        if(userRoleRepository.findById(id).isPresent()){
            UserRole temp = userRoleRepository.findById(id).get();
            userRoleRepository.deleteById(id);
            return temp;
        }
        return null;
    }

    @Override
    public List<UserRole> findAllUserRole() {
        return userRoleRepository.findAll();
    }
}
