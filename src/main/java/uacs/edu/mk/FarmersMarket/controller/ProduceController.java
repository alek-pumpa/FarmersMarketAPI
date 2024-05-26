package uacs.edu.mk.FarmersMarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uacs.edu.mk.FarmersMarket.entity.Produce;
import uacs.edu.mk.FarmersMarket.service.ProduceService;


@RestController
@RequestMapping("/api/produce")
public class ProduceController {

    @Autowired
    private ProduceService produceService;

    @GetMapping
    public List<Produce> getAllProduce() {
        return produceService.getAllProduces();
    }

    @GetMapping("/{id}")
    public Produce getProduceById(@PathVariable Long id) {
        return produceService.getProduceById(id).orElseThrow(() -> new RuntimeException("Produce not found"));
    }

    @PostMapping
    public Produce createProduce(@RequestBody Produce produce) {
        return produceService.createProduce(produce);
    }

    @PostMapping("/{id}")
    public Produce updateProduce(@PathVariable Long id, @RequestBody Produce produce) {
        return produceService.updateProduce(id, produce);
    }

    @PostMapping("/delete/{id}")
    public void deleteProduce(@PathVariable Long id) {
        produceService.deleteProduce(id);
    }
}