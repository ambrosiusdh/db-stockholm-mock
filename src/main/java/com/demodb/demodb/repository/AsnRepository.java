package com.demodb.demodb.repository;

import com.demodb.demodb.model.Asn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsnRepository extends JpaRepository<Asn, Integer> {

    List<Asn> findAllByAsnNumberContaining(String asnNumber);
    List<Asn> findAllByAsnReferenceContaining(String asnReference);
    List<Asn> findAllByAsnSupplierContaining(String asnSupplier);
    List<Asn> findAllByAsnTypeLike(String asnType);
    List<Asn> findAllByAsnStatusLike(String asnStatus);

}
