package com.demodb.demodb.service;

import com.demodb.demodb.model.Warehouse;
import com.demodb.demodb.model.WarehouseRole;
import com.demodb.demodb.repository.WarehouseRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class WarehouseRoleServiceImpl implements WarehouseRoleService {

    private WarehouseRoleRepository warehouseRoleRepository;
    private UserService userService;
    private WarehouseService warehouseService;

    @Autowired
    public WarehouseRoleServiceImpl(WarehouseRoleRepository warehouseRoleRepository, UserService userService, WarehouseService warehouseService) {
        this.warehouseRoleRepository = warehouseRoleRepository;
        this.userService = userService;
        this.warehouseService = warehouseService;
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
    public WarehouseRole findWarehouseRoleByUserUserIdAndWarehouseWarehouseId(Integer userId, Integer warehouseId) {
        return warehouseRoleRepository.findWarehouseRoleByUserUserIdAndWarehouseWarehouseId(userId, warehouseId);
    }

    @Override
    public WarehouseRole authenticateWarehouseRole(Object object) {
        Object data;
        log.info(object+"");
        List<String> dataset = new ArrayList<>();
        for (Field field: object.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                data = field.get(object);

                if(data.toString().contains("="))
                    dataset.add(data.toString());

            }catch (Exception e){
                e.printStackTrace();
            }
        }


        String[] users = dataset.get(0).split("=");
        log.info(users[1]);
        Integer userId = Integer.parseInt(users[1]);

        String[] warehouses = dataset.get(1).split("=");
        log.info(warehouses[1]);
        Warehouse warehouse = warehouseService.findWarehouseByWarehouseName(warehouses[1]);
        log.info("" + warehouse.getWarehouseId());


        return warehouseRoleRepository.findWarehouseRoleByUserAndWarehouse(userService.findUserById(userId), warehouse);
    }
}
