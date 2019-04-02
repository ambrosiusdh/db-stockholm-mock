package com.demodb.demodb.seeder;

import com.demodb.demodb.model.User;
import com.demodb.demodb.model.UserRole;
import com.demodb.demodb.model.Warehouse;
import com.demodb.demodb.model.WarehouseRole;
import com.demodb.demodb.service.UserRoleService;
import com.demodb.demodb.service.UserService;
import com.demodb.demodb.service.WarehouseRoleService;
import com.demodb.demodb.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WarehouseRoleSeeder {

    private WarehouseService warehouseService;
    private UserService userService;
    private UserRoleService userRoleService;
    private WarehouseRoleService warehouseRoleService;

    @Autowired
    public WarehouseRoleSeeder(WarehouseService warehouseService, UserService userService, UserRoleService userRoleService, WarehouseRoleService warehouseRoleService) {
        this.warehouseService = warehouseService;
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.warehouseRoleService = warehouseRoleService;
    }

    public void seedWarehouseRoleTable(){
        int i = 0;

        while (i < 8){
            User user = userService.findUserById((i%4) + 1);
            UserRole userRole;
            if(i > 3)
                userRole = userRoleService.findUserRoleById(((i+1) % 2) + 1);
            else
                userRole = userRoleService.findUserRoleById((i%2) + 1);
            Warehouse warehouse = warehouseService.findWarehouseById(i+1);
            warehouseRoleService.createWarehouseRole(
                    new WarehouseRole(
                            user,
                            warehouse,
                            userRole
                    )
            );
            userService.updateUser(user);
            userRoleService.updateUserRole(userRole);
            warehouseService.updateWarehouse(warehouse);
            i++;
        }
    }
}
