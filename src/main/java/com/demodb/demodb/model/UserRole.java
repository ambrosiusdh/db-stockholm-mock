package com.demodb.demodb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_roles")
public class UserRole {

    public UserRole(String userRoleName) {
        this.userRoleName = userRoleName;
        this.warehouseRoles = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Integer userRoleId;

    @Column(name = "user_role_name")
    private String userRoleName;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<WarehouseRole> warehouseRoles;

}
