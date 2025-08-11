package org.sapient.ordermanagement.model;
import java.util.List;

public class Order {

    private List<Double> itemPrices;
    private boolean discountEligible;

    public Order(List<Double> itemPrices, boolean discountEligible) {
        this.itemPrices = itemPrices;
        this.discountEligible = discountEligible;
    }

    public List<Double> getItemPrices() {
        return itemPrices;
    }

    public boolean isDiscountEligible() {
        return discountEligible;
    }
}
