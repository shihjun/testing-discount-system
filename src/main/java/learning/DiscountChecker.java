package learning;

import java.time.LocalDate;

public class DiscountChecker {

	public static int applyDiscount(String discountType, int price, Discount discount, String productName) {
		if (discountType.equals("absolute")) {
			return price - discount.absoluteValue;
		} else if (discountType.equals("percentage")) {
			return price - (price * discount.absoluteValue / 100);
		} else if (discountType.equals("prodcutSpecific")) {
			for (int i = 0; i < discount.applicableProducts.length; i++) {
				if (discount.applicableProducts[i].equals(productName)) {
					return price - discount.absoluteValue;
				}
			}
		} else if (discountType.equals("validityPeriod")) {
			LocalDate today = LocalDate.now();
			Boolean withinValidityPeriod = (!today.isBefore(discount.startDate)) && (today.isBefore(discount.endDate));
			if (withinValidityPeriod == true) {
				return price - discount.absoluteValue;
			}
		} else if (discountType.equals("shoppingCart")) {
			return price - discount.absoluteValue;
		}
		return 0;
	}
}
