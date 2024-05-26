package uacs.edu.mk.FarmersMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import uacs.edu.mk.FarmersMarket.service.ProduceService;
import uacs.edu.mk.FarmersMarket.service.VendorService;

@SpringBootApplication
@EntityScan("uacs.edu.mk.FarmersMarket.entity")
@EnableJpaRepositories("uacs.edu.mk.FarmersMarket.repository")
@EnableTransactionManagement
public class FarmersMarketApiApplication {

    private final ProduceService produceService;
    private final VendorService vendorService;

    public FarmersMarketApiApplication(ProduceService produceService, VendorService vendorService) {
        this.produceService = produceService;
        this.vendorService = vendorService;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FarmersMarketApiApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = app.run(args);

        FarmersMarketApiApplication apiApp = context.getBean(FarmersMarketApiApplication.class);
        apiApp.run();
        SpringApplication.run(FarmersMarketApiApplication.class, args);
    }

    private void run() {
        System.out.println("Number of produces: " + produceService.countAllProduces());
        System.out.println("Offered produce: " + produceService.getAllProduces());
        System.out.println("Number of vendors: " + vendorService.countAllVendors());
        System.out.println("Offered vendors: " + vendorService.getAllVendors());
    }
}