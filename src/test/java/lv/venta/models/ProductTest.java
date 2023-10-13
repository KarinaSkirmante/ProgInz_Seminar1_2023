package lv.venta.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

	Product p1 = new Product();
	Product p2 = new Product("Abols", 0.99f, "Sarkans", 12);
	Product p3 = new Product("&6826187462", -3.44f, "$$$$$", -12);
	Product p4 = new Product(null, 0, null, 0);
	
	@Test
	public void testDefaultProduct() {
		assertEquals(0, p1.getId());
		assertEquals("", p1.getTitle());
		assertEquals(0.0f, p1.getPrice(), 0.001);
		assertEquals("", p1.getDescription());
		assertEquals(0, p1.getQuantity());
		
	}
	
	@Test
	public void testGoodProduct()
	{
		assertEquals(0, p2.getId());
		assertEquals("Abols", p2.getTitle());
		assertEquals(0.99f, p2.getPrice(),0.001);
		assertEquals("Sarkans", p2.getDescription());
		assertEquals(12, p2.getQuantity());
	}
	
	@Test
	public void testBadProduct() {
		assertEquals(0, p3.getId());
		assertEquals("", p3.getTitle());
		assertEquals(0.00f, p3.getPrice(), 0.001);
		assertEquals("", p3.getDescription());
		assertEquals(0, p3.getQuantity());
	}
	
	@Test
	public void testNullProduct() {
		assertEquals("", p4.getTitle());
		assertEquals("", p4.getDescription());
	}

}
