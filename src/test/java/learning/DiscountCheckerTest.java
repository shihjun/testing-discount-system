package learning;

import java.time.LocalDate;

import junit.framework.TestCase;

public class DiscountCheckerTest extends TestCase {

	public void testAbsolute() {
		// Given
		int productPrice = 500;
		Discount discount = new Discount(200);
		// When
		int finalPrice = DiscountChecker.applyAbsoluteDiscount(productPrice, discount);
		// Then
		assertEquals(300, finalPrice);
	}

	public void testPercentage() {
		// Given
		int productPrice = 500;
		Discount discount = new Discount(20);
		// When
		int finalPrice = DiscountChecker.applyPercentageDiscount(productPrice, discount);
		// Then
		assertEquals(400, finalPrice);
	}

	public void testValidityPeriod() {
		// Given
		int productPrice = 1000;
		Discount discount = new Discount(200);
		LocalDate date = LocalDate.now();
		// When
		int finalPrice = DiscountChecker.applyValidityPeriodDiscount(productPrice, discount, date);
		// Then
		assertEquals(800, finalPrice);
	}

	public void testProductSpecific() {
		// Given
		int productPrice = 500;
		Discount discount = new Discount(200);
		String productName = "Latitude";
		// When
		int finalPrice = DiscountChecker.applyProdcutSpecificDiscount(productPrice, discount, productName);
		// Then
		assertEquals(300, finalPrice);
	}

	public void testDiscountOnShoppingCart() {
		// Given
		int productPrice1 = 1000;
		int productPrice2 = 1000;
		int productPrice3 = 1000;
		Discount discount = new Discount(500);
		// When
		int finalPrice = DiscountChecker.applyShoppingCartDiscount(productPrice1, productPrice2, productPrice3, discount);
		// Then
		assertEquals(2500, finalPrice);
	}

}
