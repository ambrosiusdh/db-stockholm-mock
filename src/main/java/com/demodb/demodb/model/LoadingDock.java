package com.demodb.demodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "loading_dock")
public class LoadingDock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loading_dock_id")
    private Integer loadingDockId;

    @Column(name = "loading_dock_name")
    private String loadingDockName;

    @Column(name = "loading_dock_quantity")
    private Integer loadingDockQuantity;


}
