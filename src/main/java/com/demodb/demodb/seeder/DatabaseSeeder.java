package com.demodb.demodb.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    private AsnSeeder asnSeeder;
    private LoadingDockSeeder loadingDockSeeder;
    private WarehouseSeeder warehouseSeeder;
    private UserRoleSeeder userRoleSeeder;

    @Autowired
    public DatabaseSeeder(AsnSeeder asnSeeder, LoadingDockSeeder loadingDockSeeder, WarehouseSeeder warehouseSeeder, UserRoleSeeder userRoleSeeder) {
        this.asnSeeder = asnSeeder;
        this.loadingDockSeeder = loadingDockSeeder;
        this.warehouseSeeder = warehouseSeeder;
        this.userRoleSeeder = userRoleSeeder;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        asnSeeder.seedAsnTable();
        loadingDockSeeder.seedLoadingDockTable();
        warehouseSeeder.seedWarehouseTable();
        userRoleSeeder.seedUserRoleTable();
    }

}
