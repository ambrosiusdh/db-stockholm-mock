package com.demodb.demodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_roles")
public class UserRole {

    public UserRole(String userRoleName, User... users){
        this.userRoleName = userRoleName;
        this.users = Stream.of(users).collect(Collectors.toList());
        this.users.forEach(x->x.setUserRole(this));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Integer userRoleId;

    @Column(name = "user_role_name")
    private String userRoleName;

    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    private List<User> users;

    public void addUser(User user){
        users.add(user);
    }

}
