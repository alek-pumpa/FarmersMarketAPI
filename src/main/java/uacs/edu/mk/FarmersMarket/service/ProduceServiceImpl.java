package uacs.edu.mk.FarmersMarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uacs.edu.mk.FarmersMarket.entity.Produce;
import uacs.edu.mk.FarmersMarket.repository.ProduceRepository;

@Service
public class ProduceServiceImpl implements ProduceService {

    @Autowired
    private ProduceRepository produceRepository;

    @Override
    public List<Produce> getAllProduces() {
        return produceRepository.findAll();
    }

    @Override
    public Optional<Produce> getProduceById(Long id) {
        return produceRepository.findById(id);
    }

    @Override
    public Produce createProduce(Produce produce) {
        return produceRepository.save(produce);
    }

    @Override
    public Produce updateProduce(Long id, Produce produce) {
        Optional<Produce> existingProduce = produceRepository.findById(id);
        if (existingProduce.isPresent()) {
            Produce existingProduceObj = existingProduce.get();
            existingProduceObj.setName(produce.getName());
            existingProduceObj.setDescription(produce.getDescription());
            existingProduceObj.setPrice(produce.getPrice());
            existingProduceObj.setAvailability(produce.getAvailability());
            return produceRepository.save(existingProduceObj);
        } else {
            throw new RuntimeException("Produce not found with id " + id);
        }
    }
    @Override
    public void decreaseProduceQuantity(Long produceId, double quantity) {
        Produce produce = getProduceById(produceId).orElseThrow(() -> new RuntimeException("Produce not found."));
        if (produce.getQuantity() >= Math.round(quantity)) {
            produce.setQuantity(produce.getQuantity() - Math.round(quantity));
            updateProduce(produceId, produce);
        } else {
            throw new RuntimeException("Insufficient produce quantity.");
        }
    }

    @Override
    public void save(Produce produce) {
        produceRepository.save(produce);
    }

    @Override
    public void deleteById(Long produceId) {

    }

    @Override
    public List<Produce> findByVendorId(Long vendorId) {
        return List.of();
    }

    @Override
    public void deleteProduce(Long id) {
        produceRepository.deleteById(id);
    }

    @Override
    public long countAllProduces() {
        return produceRepository.count();
    }
}