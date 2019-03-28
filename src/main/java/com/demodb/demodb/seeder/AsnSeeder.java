package com.demodb.demodb.seeder;


import com.demodb.demodb.model.Asn;
import com.demodb.demodb.service.AsnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AsnSeeder {

    private AsnService asnService;
    private List<Asn> asnList;
    private List<String> asnSupplier;
    private List<String> asnType;
    private List<String> asnStatus;
    private List<String> asnDock;

    @Autowired
    public AsnSeeder(AsnService asnService) {
        this.asnService = asnService;

        asnList = new ArrayList<>();
        asnSupplier = new ArrayList<>();
        asnType = new ArrayList<>();
        asnStatus = new ArrayList<>();
        asnDock = new ArrayList<>();

        this.asnSupplier.add("Toko Seoul TC");
        this.asnSupplier.add("Toko Jakarta");
        this.asnSupplier.add("Toko Singapore");

        this.asnType.add("Purchase Order");
        this.asnType.add("Consignment Final");
        this.asnType.add("Inventory Request");

        this.asnStatus.add("Created");
        this.asnStatus.add("Closed");

        this.asnDock.add("Dock Medan");
        this.asnDock.add("Dock Jakarta");
        this.asnDock.add("Dock Makassar");
    }

    public void seedAsnTable(){
        int i = 0;
        while (i < 10){
            asnList.add(
                    new Asn(
                        null,
                        "ASN/PO/III-2019/072" + i,
                        "MCT/PO/1903/2065" + i,
                        asnSupplier.get(i%3),
                        asnType.get(i%3),
                        asnStatus.get(i%2),
                        asnDock.get(i%3)
                    ));
            i++;

            for (Asn asn: asnList) {
                asnService.createAsn(asn);
            }
        }
    }
}
