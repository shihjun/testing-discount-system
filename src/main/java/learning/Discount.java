package learning;

import java.time.LocalDate;

public class Discount {
  public int absoluteValue;
  public int percentageValue;
  public String[] applicableProducts = { "Latitude", "Vostro", "Alienware" };
  public LocalDate startDate = LocalDate.of(2019, 8, 1);
  public LocalDate endDate = LocalDate.of(2019, 8, 31);

  Discount(int discountValue) {
    this.absoluteValue = discountValue;
    this.percentageValue = discountValue;
  }

}