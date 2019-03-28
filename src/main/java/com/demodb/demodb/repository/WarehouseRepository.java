package com.demodb.demodb.repository;

import com.demodb.demodb.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    List<Warehouse> findAllByWarehouseName(String warehouseName);

}
