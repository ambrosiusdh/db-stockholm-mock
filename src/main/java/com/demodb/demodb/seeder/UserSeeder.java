package com.demodb.demodb.seeder;

import com.demodb.demodb.model.User;
import com.demodb.demodb.model.UserRole;
import com.demodb.demodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserSeeder {

    private UserService userService;
    private List<String> userNameList;
    private List<String> userEmailList;

    @Autowired
    public UserSeeder(UserService userRoleService) {
        this.userService = userRoleService;

        userNameList = new ArrayList<>();
        userEmailList = new ArrayList<>();

        userNameList.add("Ambrosius David");
        userNameList.add("Ambrosius Haryono");
        userNameList.add("David Haryono");
        userNameList.add("David Ambrosius");

        userEmailList.add("ambrosius.david@gdn-commerce.com");
        userEmailList.add("ambrosius.haryono@gdn-commerce.com");
        userEmailList.add("david.haryono@gdn-commerce.com");
        userEmailList.add("david.ambrosius@gdn-commerce.com");
    }

    public void seedUserTable(){
        int i = 0;

        while (i < 4){
            userService.createUser(
                    new User(
                        userNameList.get(i),
                        userEmailList.get(i),
                        "ambrosius"
                    )
            );
            i++;
        }
    }
}
