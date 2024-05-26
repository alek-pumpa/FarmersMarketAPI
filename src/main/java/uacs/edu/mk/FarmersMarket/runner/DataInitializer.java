package uacs.edu.mk.FarmersMarket.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import uacs.edu.mk.FarmersMarket.entity.Produce;
import uacs.edu.mk.FarmersMarket.entity.Vendor;
import uacs.edu.mk.FarmersMarket.repository.ProduceRepository;
import uacs.edu.mk.FarmersMarket.repository.VendorRepository;

import java.util.List;

@Component
public class DataInitializer implements ApplicationRunner {

    @Autowired
    private ProduceRepository produceRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Vendor vendor1 = new Vendor("Vendor 1", "Vendor 1 Description", "Address 1", "123456789", "vendor1@example.com");
        Vendor vendor2 = new Vendor("Vendor 2", "Vendor 2 Description", "Address 2", "987654321", "vendor2@example.com");

        vendorRepository.saveAll(List.of(vendor1, vendor2));

        Produce produce1 = new Produce("Tomato", 1.5, vendor1);
        Produce produce2 = new Produce("Potato", 0.75, vendor2);

        produceRepository.saveAll(List.of(produce1, produce2));
    }
}