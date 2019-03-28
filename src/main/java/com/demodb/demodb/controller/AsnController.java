package com.demodb.demodb.controller;

import com.demodb.demodb.model.Asn;
import com.demodb.demodb.service.AsnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AsnController {

    private AsnService asnService;

    @Autowired
    public AsnController(AsnService asnService) {
        this.asnService = asnService;
    }

    @RequestMapping(
            value = "/asn",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Asn createAsn(@RequestBody Asn asn){
        return asnService.createAsn(asn);
    }

    @RequestMapping(
            value = {
                    "/asn",
                    "/asn/findAllByAsnNumber/",
                    "/asn/findAllByAsnReference/",
                    "/asn/findAllByAsnSupplier/"
                    },
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Asn> findAll(){
        return asnService.findAll();
    }

    @RequestMapping(
            value = "/asn/findAllByAsnNumber/{asnNumber}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Asn> findAllByAsnNumber(@PathVariable("asnNumber") String asnNumber){
        return asnService.findAllByAsnNumber(asnNumber);
    }

    @RequestMapping(
            value = "/asn/findAllByAsnReference/{asnReference}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Asn> findAllByAsnReference(@PathVariable("asnReference") String asnReference){
        return asnService.findAllByReferenceNumber(asnReference);
    }

    @RequestMapping(
            value = "/asn/findAllByAsnSupplier/{asnSupplier}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Asn> findAllByAsnSupplier(@PathVariable("asnSupplier") String asnSupplier){
        return asnService.findAllBySupplier(asnSupplier);
    }

    @RequestMapping(
            value = "/asn/findAllByAsnType/{asnType}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Asn> findAllByAsnType(@PathVariable("asnType") String asnType){
        if(asnType.equals("Semua"))
            return asnService.findAll();
        return asnService.findAllByInventoryType(asnType);
    }

    @RequestMapping(
            value = "/asn/findAllByAsnStatus/{asnStatus}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Asn> findAllByAsnStatus(@PathVariable("asnStatus") String asnStatus){
        if(asnStatus.equals("Semua"))
            return asnService.findAll();
        return asnService.findAllByAsnStatus(asnStatus);
    }
}
