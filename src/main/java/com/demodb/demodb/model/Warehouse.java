package com.demodb.demodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "warehouse")
public class Warehouse {

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
}
