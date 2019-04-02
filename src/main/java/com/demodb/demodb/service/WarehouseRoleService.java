package com.demodb.demodb.service;

import com.demodb.demodb.model.WarehouseRole;

import java.util.List;

public interface WarehouseRoleService {

    WarehouseRole createWarehouseRole(WarehouseRole warehouseRole);
    WarehouseRole updateWarehouseRole(WarehouseRole warehouseRole);
    WarehouseRole findWarehouseRoleById(Integer id);
    WarehouseRole deleteWarehouseRoleById(Integer id);
    List<WarehouseRole> findAllWarehouseRole();
    WarehouseRole authenticateWarehouseRole(Object object);

}
