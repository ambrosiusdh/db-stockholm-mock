package com.demodb.demodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asn")
public class Asn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asn_id")
    private Integer asnId;

    @Column(name = "asn_number")
    private String asnNumber;

    @Column(name = "asn_reference")
    private String asnReference;

    @Column(name = "asn_supplier")
    private String asnSupplier;

    @Column(name = "asn_type")
    private String asnType;

    @Column(name = "asn_status")
    private String asnStatus;

    @Column(name = "asn_dock")
    private String asnDock;
}
