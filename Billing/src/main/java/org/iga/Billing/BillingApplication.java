package org.iga.Billing;

import java.util.Collection;
import java.util.Date;
import org.iga.Billing.Model.Bill;
import org.iga.Billing.Model.ProductItem;
import org.iga.Billing.Repository.BillingRepository;
import org.iga.Billing.Repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.Data;


@Projection(name = "fullBill",types = Bill.class)
interface BillProjection {
	public Long getId();
	public Date getBillingDate();
	public Long getCustomerId();
	public Collection<ProductItem> getProductItems();
}

@Data
class Customer {
	private Long id;
	private String name;
	private String email;
}

@FeignClient(name="CUSTOMER-SERVICE")
interface CustomerService{
	@GetMapping("/customers/{id}")
	public Customer findCustomerById(@PathVariable(name="id")Long id);
}

@Data
class Product{
	private Long id;
	private String name;
	private double price;
}

@FeignClient(name="INVENTORY-SERVICE")
interface InventoryService{
	@GetMapping("/products/{id}")
	public Product findProductById(@PathVariable(name="id")Long id);
	@GetMapping("/products")
	public PagedModel<Product> findAllProducts();
}

@SpringBootApplication
@EnableFeignClients
public class BillingApplication implements CommandLineRunner {
	@Autowired
	CustomerService customerService;
	@Autowired
	InventoryService inventoryService;
	@Autowired
	BillingRepository billRepository;
    @Autowired
    ProductItemRepository productItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer c1 = customerService.findCustomerById(1L);
		Bill bill1 = billRepository.save(new Bill(null, new Date(), c1.getId(), null));
		PagedModel<Product> products = inventoryService.findAllProducts();
		products.getContent().forEach(p->{
			productItemRepository.save(new ProductItem(null, p.getId(), p.getPrice(), 30, bill1));
		});
	}
	


}
