package lv.venta.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

class ProductValidationTest {

	Product p2 = new Product("Abols", 0.99f, "Sarkans", 12);
	Product p3 = new Product("&6826187462", -3.44f, "$$$$$", -12);

	ValidatorFactory validFactory = Validation.buildDefaultValidatorFactory();
	Validator validor = validFactory.getValidator();
	
	@Test
	void testGoodProduct() {

		Set<ConstraintViolation<Product>> violations = validor.validate(p2);
		assertEquals(0, violations.size());
		
	}
	
	@Test
	void testBadProduct() {
		Set<ConstraintViolation<Product>> violations = validor.validate(p3);
		assertEquals(4, violations.size());
	}

}
