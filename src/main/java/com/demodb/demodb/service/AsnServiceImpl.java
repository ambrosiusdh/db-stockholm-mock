package com.demodb.demodb.service;

import com.demodb.demodb.model.Asn;
import com.demodb.demodb.repository.AsnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AsnServiceImpl implements AsnService{

    private AsnRepository asnRepository;

    @Autowired
    public AsnServiceImpl(AsnRepository asnRepository) {
        this.asnRepository = asnRepository;
    }


    @Override
    public Asn createAsn(Asn asn) {
        return asnRepository.save(asn);
    }

    @Override
    public Asn updateAsn(Asn asn) {
        if(!asnRepository.findById(asn.getAsnId()).isPresent())
            return asnRepository.save(asn);

        return null;
    }

    @Override
    public List<Asn> findAll() {
        return asnRepository.findAll();
    }

    @Override
    public Asn findById(Integer id) {
        if(asnRepository.findById(id).isPresent())
            return asnRepository.findById(id).get();
        else
            return null;
    }

    @Override
    public Asn deleteAsn(Integer id) {
        Asn temp;
        if(asnRepository.findById(id).isPresent())
            temp = asnRepository.findById(id).get();
        else
            return null;

        asnRepository.delete(temp);
        return temp;
    }

    @Override
    public List<Asn> findAllByAsnNumber(String asnNumber){
        return asnRepository.findAllByAsnNumberContaining(asnNumber);
    }

    @Override
    public List<Asn> findAllByReferenceNumber(String asnReference) {
        return asnRepository.findAllByAsnReferenceContaining(asnReference);
    }

    @Override
    public List<Asn> findAllBySupplier(String asnSupplier) {
        return asnRepository.findAllByAsnSupplierContaining(asnSupplier);
    }

    @Override
    public List<Asn> findAllByInventoryType(String asnType) {
        return asnRepository.findAllByAsnTypeLike(asnType);
    }

    @Override
    public List<Asn> findAllByAsnStatus(String asnStatus) {
        return asnRepository.findAllByAsnStatusLike(asnStatus);
    }
}
