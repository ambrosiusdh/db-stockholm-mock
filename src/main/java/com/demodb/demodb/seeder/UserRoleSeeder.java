package com.demodb.demodb.seeder;

import com.demodb.demodb.model.UserRole;
import com.demodb.demodb.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRoleSeeder {

    private UserRoleService userRoleService;

    @Autowired
    public UserRoleSeeder(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    public void seedUserRoleTable(){
        userRoleService.createUserRole(new UserRole(
                "Admin"
        ));
        userRoleService.createUserRole(new UserRole(
                "Member"
        ));
    }
}
