package com.demodb.demodb.controller;

import com.demodb.demodb.model.WarehouseRole;
import com.demodb.demodb.service.WarehouseRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WarehouseRoleController {

    private WarehouseRoleService warehouseRoleService;

    @Autowired
    public WarehouseRoleController(WarehouseRoleService warehouseRoleService) {
        this.warehouseRoleService = warehouseRoleService;
    }

    @RequestMapping(
            value = "/warehouse-role",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WarehouseRole createWarehouse(@RequestBody WarehouseRole warehouseRole){
        return warehouseRoleService.createWarehouseRole(warehouseRole);
    }

    @RequestMapping(
            value = "/warehouse-role",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<WarehouseRole> findAllWarehouseRole(){
        return warehouseRoleService.findAllWarehouseRole();
    }

    @RequestMapping(
            value = "/warehouse-role/{userId}/{warehouseId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WarehouseRole findWarehouseRoleByUserAndWarehouse(@PathVariable("userId") Integer userId, @PathVariable("warehouseId") Integer warehouseId){
        return warehouseRoleService.findWarehouseRoleByUserUserIdAndWarehouseWarehouseId(userId, warehouseId);
    }

    @RequestMapping(
            value = "/warehouse-role/authenticate",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WarehouseRole authenticateWarehouseRole(@RequestBody Object warehouseData){
        return warehouseRoleService.authenticateWarehouseRole(warehouseData);
    }
}
