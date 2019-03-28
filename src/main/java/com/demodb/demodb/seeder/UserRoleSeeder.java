package com.demodb.demodb.seeder;

import com.demodb.demodb.model.User;
import com.demodb.demodb.model.UserRole;
import com.demodb.demodb.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRoleSeeder {

    private UserRoleService userRoleService;

    @Autowired
    public UserRoleSeeder(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    public void seedUserRoleTable(){
        userRoleService.createUserRole(new UserRole(
                "Admin",
                new User("ambrosius.haryono@gdn-commerce.com", "ambrosius"),
                new User("ambrosius.david@gdn-commerce.com", "ambrosius")
        ));
        userRoleService.createUserRole(new UserRole(
                "Member",
                new User("david.haryono@gdn-commerce.com", "ambrosius"),
                new User("david.ambrosius@gdn-commerce.com", "ambrosius")));
    }
}
