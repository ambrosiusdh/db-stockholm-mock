package com.demodb.demodb.repository;

import com.demodb.demodb.model.User;
import com.demodb.demodb.model.Warehouse;
import com.demodb.demodb.model.WarehouseRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRoleRepository extends JpaRepository<WarehouseRole, Integer> {

    WarehouseRole findWarehouseRoleByUserAndWarehouse(User user, Warehouse warehouse);
    WarehouseRole findWarehouseRoleByUserUserIdAndWarehouseWarehouseId(Integer userId, Integer warehouseId);

}
