package domashka.module1_2;

public class DiscountedProduct extends Product {
    private double discount;

    public DiscountedProduct(String name, double price, boolean available, double discount) {
        super(name, price, available);
        this.discount = discount;
    }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public double priceWithDiscount() {
        return getPrice() * (1 - discount / 100.0);
    }
}
