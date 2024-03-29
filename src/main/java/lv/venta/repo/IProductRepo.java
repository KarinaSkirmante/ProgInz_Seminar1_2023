package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Product;

public interface IProductRepo extends CrudRepository<Product, Integer> {
	//SELECT * FROM product_table WHERE price < var;
	ArrayList<Product> findByPriceLessThan(float var);
	
	//atlasa pēc nosaukuma
	//SELECT * FROM product_table WHERE title='<var>';
	ArrayList<Product> findByTitle(String var);
	
	//TODO atlase tos produktus, kuru daudzums ir lielāks par 10, bet cena mazaka par 4 eur
	//SELECT * FROM product_table WHERE quantity > varQ AND price < varP;
	ArrayList<Product> findByQuantityGreaterThanAndPriceLessThan(int varQ, float varP);

	Product findByTitleAndPriceAndDescriptionAndQuantity(String string, float f, String string2, int i);

	//@Query(nativeQuery = countBy)
	//ArrayList<Product> funcNameDoesNotMatter();
}
