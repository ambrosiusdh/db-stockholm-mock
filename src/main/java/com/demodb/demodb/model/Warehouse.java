package com.demodb.demodb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@Entity
@Table(name = "warehouse")
public class Warehouse {

    public Warehouse(Integer warehouseId, String warehouseName, Integer warehouseCreate, Integer warehousePending, Integer warehouseFulfilled) {
        this.warehouseName = warehouseName;
        this.warehouseCreate = warehouseCreate;
        this.warehousePending = warehousePending;
        this.warehouseFulfilled = warehouseFulfilled;
        warehouseRoles = new ArrayList<>();
    }

    @Id
    @Column(name = "warehouse_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warehouseId;

    @Column(name = "warehouse_name")
    private String warehouseName;

    @Column(name = "warehouse_create")
    private Integer warehouseCreate;

    @Column(name = "warehouse_pending")
    private Integer warehousePending;

    @Column(name = "warehouse_fulfilled")
    private Integer warehouseFulfilled;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<WarehouseRole> warehouseRoles;
}
