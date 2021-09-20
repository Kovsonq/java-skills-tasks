package course.functional.chapter1.receipt;

public class Receipt {
    String item;
    double price;
    double discount;
    double tax;

    public Receipt(String item, double price, double discount, double tax) {
        this.item = item;
        this.price = price;
        this.discount = discount;
        this.tax = tax;
    }

    public Receipt(Receipt receipt) {
        this.item = receipt.item;
        this.price = receipt.price;
        this.discount = receipt.discount;
        this.tax = receipt.tax;
    }
}
