package com.demodb.demodb.service;

import com.demodb.demodb.model.WarehouseRole;
import com.demodb.demodb.repository.WarehouseRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WarehouseRoleServiceImpl implements WarehouseRoleService {

    private WarehouseRoleRepository warehouseRoleRepository;

    @Autowired
    public WarehouseRoleServiceImpl(WarehouseRoleRepository warehouseRoleRepository) {
        this.warehouseRoleRepository = warehouseRoleRepository;
    }

    @Override
    public WarehouseRole createWarehouseRole(WarehouseRole warehouseRole) {
        return warehouseRoleRepository.save(warehouseRole);
    }

    @Override
    public WarehouseRole updateWarehouseRole(WarehouseRole warehouseRole) {
        if(warehouseRoleRepository.findById(warehouseRole.getWarehouseRoleId()).isPresent())
            return warehouseRoleRepository.save(warehouseRole);
        return null;
    }

    @Override
    public WarehouseRole findWarehouseRoleById(Integer id) {
        if(warehouseRoleRepository.findById(id).isPresent())
            return warehouseRoleRepository.findById(id).get();
        return null;
    }

    @Override
    public WarehouseRole deleteWarehouseRoleById(Integer id) {
        WarehouseRole temp;
        if(warehouseRoleRepository.findById(id).isPresent()) {
            temp = warehouseRoleRepository.findById(id).get();
            warehouseRoleRepository.deleteById(id);
            return temp;
        }
        return null;
    }

    @Override
    public List<WarehouseRole> findAllWarehouseRole() {
        return warehouseRoleRepository.findAll();
    }

    @Override
    public WarehouseRole authenticateWarehouseRole(Object object) {
        return null;
    }
}
