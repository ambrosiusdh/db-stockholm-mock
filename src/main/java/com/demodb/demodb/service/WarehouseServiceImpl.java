package com.demodb.demodb.service;

import com.demodb.demodb.model.Warehouse;
import com.demodb.demodb.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public Warehouse updateWarehouse(Warehouse warehouse) {
        if(!warehouseRepository.findById(warehouse.getWarehouseId()).isPresent())
            return warehouseRepository.save(warehouse);

        return null;
    }

    @Override
    public List<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse findById(Integer id) {
        if(warehouseRepository.findById(id).isPresent())
            return warehouseRepository.findById(id).get();
        else
            return null;
    }

    @Override
    public Warehouse deleteWarehouse(Integer id) {
        Warehouse temp;
        if(warehouseRepository.findById(id).isPresent())
            temp = warehouseRepository.findById(id).get();
        else
            return null;

        warehouseRepository.delete(temp);
        return temp;
    }
}
