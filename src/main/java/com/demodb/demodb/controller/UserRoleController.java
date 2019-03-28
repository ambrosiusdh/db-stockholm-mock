package com.demodb.demodb.controller;

import com.demodb.demodb.model.UserRole;
import com.demodb.demodb.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserRoleController {

    private UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @RequestMapping(
            value = "/user-role",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public UserRole createUserRole(@RequestBody UserRole userRole){
        return userRoleService.createUserRole(userRole);
    }

    @RequestMapping(
            value = "/user-role",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<UserRole> findAllUserRole(){
        return userRoleService.findAllUserRole();
    }

}
