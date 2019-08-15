package learning;

import java.time.LocalDate;

public class DiscountChecker {

	public static int applyAbsoluteDiscount(int price, Discount discount) {
		return price - discount.absoluteValue;
	}

	public static int applyPercentageDiscount(int price, Discount discount) {
		return price - (price * discount.absoluteValue / 100);
	}

	public static int applyValidityPeriodDiscount(int price, Discount discount, LocalDate date) {
		Boolean withinValidityPeriod = (!date.isBefore(discount.startDate)) && (date.isBefore(discount.endDate));
		if (withinValidityPeriod == true) {
			return price - discount.absoluteValue;
		}
		return 0;
	}

	public static int applyProdcutSpecificDiscount(int price, Discount discount, String productName) {
		for (int i = 0; i < discount.applicableProducts.length; i++) {
			if (discount.applicableProducts[i].equals(productName)) {
				return price - discount.absoluteValue;
			}
		}
		return 0;
	}

	public static int applyShoppingCartDiscount(int productPrice1, int productPrice2, int productPrice3,
			Discount discount) {
		int subtotal = productPrice1 + productPrice2 + productPrice3;
		return subtotal - discount.absoluteValue;
	}

}