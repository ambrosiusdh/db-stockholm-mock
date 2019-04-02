package com.demodb.demodb.service;

import com.demodb.demodb.model.Warehouse;

import java.util.List;

public interface WarehouseService {

    Warehouse createWarehouse(Warehouse warehouse);
    Warehouse updateWarehouse(Warehouse warehouse);
    List<Warehouse> findAllWarehouse();
    Warehouse findWarehouseById(Integer id);
    Warehouse deleteWarehouse(Integer id);
}
