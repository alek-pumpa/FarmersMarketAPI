package uacs.edu.mk.FarmersMarket.service;

import java.util.List;
import java.util.Optional;

import uacs.edu.mk.FarmersMarket.entity.Produce;

public interface ProduceService {
    List<Produce> getAllProduces();
    Optional<Produce> getProduceById(Long id);
    Produce createProduce(Produce produce);
    Produce updateProduce(Long id, Produce updatedProduce);
    void deleteProduce(Long id);
    long countAllProduces();
    void decreaseProduceQuantity(Long produceId, double quantity);
    void save(Produce produce);
    void deleteById(Long produceId);
    List<Produce> findByVendorId(Long vendorId);
}