package com.demodb.demodb.service;

import com.demodb.demodb.model.UserRole;

import java.util.List;

public interface UserRoleService {

    UserRole createUserRole(UserRole userRole);
    UserRole updateUserRole(UserRole userRole);
    UserRole findUserRoleById(Integer id);
    UserRole deleteUserRole(Integer id);
    List<UserRole> findAllUserRole();

}
