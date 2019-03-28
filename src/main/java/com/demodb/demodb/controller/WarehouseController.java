package com.demodb.demodb.controller;

import com.demodb.demodb.model.Warehouse;
import com.demodb.demodb.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WarehouseController {

    private WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @RequestMapping(
            value = "/warehouse",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse){
        return warehouseService.createWarehouse(warehouse);
    }

    @RequestMapping(
            value = "/warehouse",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Warehouse> findAllWarehouse(){
        return warehouseService.findAll();
    }
}
