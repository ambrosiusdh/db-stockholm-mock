package com.demodb.demodb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "warehouse_role")
public class WarehouseRole {

    public WarehouseRole(User user, Warehouse warehouse, UserRole userRole) {
        this.user = user;
        user.getWarehouseRoles().add(this);
        this.warehouse = warehouse;
        warehouse.getWarehouseRoles().add(this);
        this.userRole = userRole;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warehouseRoleId;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn
    private UserRole userRole;

}
