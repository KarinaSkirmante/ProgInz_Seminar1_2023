package lv.venta.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lv.venta.models.Product;

@DataJpaTest
class IProductRepoTest {

	Product p2 = new Product("Abols", 0.99f, "Sarkans", 12);
	
	Product p3 = new Product("Tomats", 0.99f, "Zals", 12);
	
	@Autowired
	IProductRepo prodRepo;
	
	@Test
	void testInsertProduct() {
		prodRepo.save(p2);
		
		Product productFromDB = prodRepo.findByTitleAndPriceAndDescriptionAndQuantity("Abols", 0.99f, "Sarkans", 12);
		assertNotNull(productFromDB);
		
	}
	@Test
	void testUpdateProduct() {
		prodRepo.save(p3);
		Product productFromDB = prodRepo.findByTitleAndPriceAndDescriptionAndQuantity("Tomats", 0.99f, "Zals", 12);
		productFromDB.setTitle("Burkans");
		prodRepo.save(productFromDB);
		ArrayList<Product> productFromDBAfterUpdate = prodRepo.findByTitle("Burkans");
		assertEquals(1, productFromDBAfterUpdate.size());
	}
	
	@Test
	void testDeleteProduct() {
		
	}
	
	@Test
	void testRetrieveByIdProduct() {
		
	}
	
	

}
