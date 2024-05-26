package uacs.edu.mk.FarmersMarket.service;

import java.util.List;
import java.util.Optional;

import uacs.edu.mk.FarmersMarket.entity.Produce;
import uacs.edu.mk.FarmersMarket.entity.Vendor;

public interface VendorService {
    List<Vendor> getAllVendors();
    Optional<Vendor> getVendorById(Long id);
    Vendor createVendor(Vendor vendor);
    Vendor updateVendor(Long id, Vendor vendor);
    void deleteVendor(Long id);
    long countAllVendors();
    void decreaseProduceQuantity(Long produceId, double quantity);
    Optional<Produce> getProduceById(Long produceId);
    void deleteById(Long vendorId);
}