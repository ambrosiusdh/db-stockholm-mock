package com.demodb.demodb.service;

import com.demodb.demodb.model.Asn;

import java.util.List;

public interface AsnService {

    Asn createAsn(Asn asn);
    Asn updateAsn(Asn asn);
    List<Asn> findAll();
    Asn findById(Integer id);
    Asn deleteAsn(Integer id);
    List<Asn> findAllByAsnNumber(String asnNumber);
    List<Asn> findAllByReferenceNumber(String asnReference);
    List<Asn> findAllBySupplier(String asnSupplier);
    List<Asn> findAllByInventoryType(String asnType);
    List<Asn> findAllByAsnStatus(String asnStatus);
}
