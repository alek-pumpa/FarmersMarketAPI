package uacs.edu.mk.FarmersMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uacs.edu.mk.FarmersMarket.entity.Produce;
import uacs.edu.mk.FarmersMarket.entity.Vendor;
import uacs.edu.mk.FarmersMarket.service.ProduceService;
import uacs.edu.mk.FarmersMarket.service.VendorService;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private ProduceService produceService;

    @Autowired
    private VendorService vendorService;

    @GetMapping("/menu")
    public String showMenu() {
        return "menu";
    }

    private static final String REDIRECT_TO_MENU = "redirect:/menu";

    @GetMapping("/menu/showProduceByVendor")
    public String showProduceByVendor(@RequestParam("vendorId") Long vendorId, Model model) {
        List<Produce> produces = produceService.findByVendorId(vendorId);
        model.addAttribute("produces", produces);
        return "produce-list";
    }

    @GetMapping("/menu/addProduce")
    public String addProduce(Model model) {
        model.addAttribute("produce", new Produce());
        return "produce-form";
    }

    @GetMapping("/menu/addVendor")
    public String addVendor(Model model) {
        model.addAttribute("vendor", new Vendor());
        return "vendor-form";
    }

    @GetMapping("/menu/removeProduce")
    public String removeProduce(@RequestParam("produceId") Long produceId) {
        produceService.deleteById(produceId);
        return REDIRECT_TO_MENU;
    }

    @GetMapping("/menu/removeVendor")
    public String removeVendor(@RequestParam("vendorId") Long vendorId) {
        vendorService.deleteById(vendorId);
        return REDIRECT_TO_MENU;
    }

    @GetMapping("/menu/saveChanges")
    public String saveChanges() {
        return REDIRECT_TO_MENU;
    }
}