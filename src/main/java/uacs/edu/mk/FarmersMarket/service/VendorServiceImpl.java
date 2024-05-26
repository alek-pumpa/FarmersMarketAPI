package uacs.edu.mk.FarmersMarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uacs.edu.mk.FarmersMarket.entity.Produce;
import uacs.edu.mk.FarmersMarket.entity.Vendor;
import uacs.edu.mk.FarmersMarket.repository.VendorRepository;
import uacs.edu.mk.FarmersMarket.service.ProduceService;
import uacs.edu.mk.FarmersMarket.service.ProduceServiceImpl;


@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private final ProduceService produceService;


    @Autowired
    private VendorRepository vendorRepository;

    public VendorServiceImpl(ProduceService produceService) {
        this.produceService = produceService;
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
   }

    @Override
    public Optional<Vendor> getVendorById(Long id) {
        return vendorRepository.findById(id);
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public void decreaseProduceQuantity(Long produceId, double quantity) {
        produceService.decreaseProduceQuantity(produceId, quantity);
    }

    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        Optional<Vendor> existingVendor = vendorRepository.findById(id);
        if (existingVendor.isPresent()) {
            Vendor existingVendorObj = existingVendor.get();
            existingVendorObj.setName(vendor.getName());
            existingVendorObj.setDescription(vendor.getDescription());
            existingVendorObj.setContactInfo(vendor.getContactInfo());
            return vendorRepository.save(existingVendorObj);
        } else {
            throw new RuntimeException("Vendor not found with id " + id);
        }
    }
    @Override
    public Optional<Produce> getProduceById(Long produceId) {
        return produceService.getProduceById(produceId);
    }

    @Override
    public void deleteById(Long vendorId) {

    }

    public void createProduce(Produce produce) {
        produceService.save(produce);
    }

    public void subtractProduceFromVendor(Long vendorId, Long produceId, double quantity) {
        Vendor vendor = getVendorById(vendorId).orElseThrow(() -> new RuntimeException("Vendor not found."));
        Produce produce = getProduceById(produceId).orElseThrow(() -> new RuntimeException("Produce not found."));

        if (produce.getVendor().equals(vendor)) {
            decreaseProduceQuantity(produceId, quantity);
        } else {
            throw new RuntimeException("Produce not associated with the vendor.");
        }
    }
    public void addProduceToVendor(Long vendorId, Produce produce) {
        Vendor vendor = getVendorById(vendorId).orElseThrow(() -> new RuntimeException("Vendor not found."));
        produce.setVendor(vendor);
        createProduce(produce);
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }

    @Override
    public long countAllVendors() {
        return vendorRepository.count();
    }
}