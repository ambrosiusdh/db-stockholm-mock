package com.demodb.demodb.seeder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DatabaseSeeder {

    private AsnSeeder asnSeeder;
    private LoadingDockSeeder loadingDockSeeder;
    private WarehouseSeeder warehouseSeeder;
    private UserRoleSeeder userRoleSeeder;
    private UserSeeder userSeeder;
    private WarehouseRoleSeeder warehouseRoleSeeder;

    @Autowired
    public DatabaseSeeder(AsnSeeder asnSeeder, LoadingDockSeeder loadingDockSeeder, WarehouseSeeder warehouseSeeder, UserRoleSeeder userRoleSeeder, UserSeeder userSeeder, WarehouseRoleSeeder warehouseRoleSeeder) {
        this.asnSeeder = asnSeeder;
        this.loadingDockSeeder = loadingDockSeeder;
        this.warehouseSeeder = warehouseSeeder;
        this.userRoleSeeder = userRoleSeeder;
        this.userSeeder = userSeeder;
        this.warehouseRoleSeeder = warehouseRoleSeeder;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        asnSeeder.seedAsnTable();
        loadingDockSeeder.seedLoadingDockTable();
        warehouseSeeder.seedWarehouseTable();
        userRoleSeeder.seedUserRoleTable();
        userSeeder.seedUserTable();
        warehouseRoleSeeder.seedWarehouseRoleTable();
    }

}
