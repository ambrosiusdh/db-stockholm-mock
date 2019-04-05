package com.demodb.demodb.seeder;

import com.demodb.demodb.model.Warehouse;
import com.demodb.demodb.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class WarehouseSeeder {

    private WarehouseService warehouseService;
    private List<Warehouse> warehouseList;
    private List<String> warehouseName;

    @Autowired
    public WarehouseSeeder(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
        this.warehouseList = new ArrayList<>();
        this.warehouseName = new ArrayList<>();

        warehouseName.add("Gudang Jakarta");
        warehouseName.add("Gudang Makassar");
        warehouseName.add("Gudang Medan");
        warehouseName.add("Gudang Singapore");
    }

    public void seedWarehouseTable() {
        int i = 0;

        Random random = new Random();


        while (i < 4){
            int fulfilled= random.nextInt(50) + 1;
            int pending = random.nextInt(50) + 1;

            if (i == 0){
                warehouseList.add(
                    new Warehouse(
                            null,
                            warehouseName.get(i),
                            fulfilled+pending,
                            pending,
                            fulfilled
                    ));
            }else if (i == 1){
                warehouseList.add(
                        new Warehouse(
                                null,
                                warehouseName.get(i),
                                fulfilled+pending,
                                pending,
                                fulfilled
                        ));
            }else {
                warehouseList.add(
                        new Warehouse(
                                null,
                                warehouseName.get(i),
                                fulfilled + pending,
                                pending,
                                fulfilled
                        ));
            }
            i++;
        }

        for (Warehouse warehouse : warehouseList) {
            warehouseService.createWarehouse(warehouse);
        }
    }
}
