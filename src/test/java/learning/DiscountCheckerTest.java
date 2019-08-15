package learning;

import junit.framework.TestCase;

public class DiscountCheckerTest extends TestCase {

	public void testAbsolute() {
		// Given
		String discountType = "absolute";
		int productPrice = 500;
		Discount discount = new Discount(200);
		String productName = "";
		// When
		int finalPrice = DiscountChecker.applyDiscount(discountType, productPrice, discount, productName);
		// Then
		assertEquals(300, finalPrice);
	}

	public void testPercentage() {
		// Given
		String discountType = "percentage";
		int productPrice = 500;
		Discount discount = new Discount(20);
		String productName = "";
		// When
		int finalPrice = DiscountChecker.applyDiscount(discountType, productPrice, discount, productName);
		// Then
		assertEquals(400, finalPrice);
	}

	public void testValidityPeriod() {
		// Given
		String discountType = "validityPeriod";
		int productPrice = 1000;
		Discount discount = new Discount(200);
		String productName = "";
		// When
		int finalPrice = DiscountChecker.applyDiscount(discountType, productPrice, discount, productName);
		// Then
		assertEquals(800, finalPrice);
	}

	public void testProductSpecific() {
		// Given
		String discountType = "prodcutSpecific";
		int productPrice = 500;
		Discount discount = new Discount(200);
		String productName = "Latitude";
		// When
		int finalPrice = DiscountChecker.applyDiscount(discountType, productPrice, discount, productName);
		// Then
		assertEquals(300, finalPrice);
	}

	public void testDiscountOnShoppingCart() {
		// Given
		String discountType = "shoppingCart";
		int productPrice1 = 1000;
		int productPrice2 = 1000;
		int productPrice3 = 1000;
		int subtotal = productPrice1 + productPrice2 + productPrice3;
		Discount discount = new Discount(500);
		String productName = "";
		// When
		int finalPrice = DiscountChecker.applyDiscount(discountType, subtotal, discount, productName);
		// Then
		assertEquals(2500, finalPrice);
	}

}
