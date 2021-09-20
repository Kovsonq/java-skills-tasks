package course.functional.chapter1.receipt;

@FunctionalInterface
public interface ReceiptPrinter<X extends Receipt> {

    void print(X receipt);

    private double getDiscountPrice(X receipt){
        return receipt.price - (receipt.price * receipt.discount);
    }

    default double computeTotal(X receipt){
        double discountPrice = getDiscountPrice(receipt);
        return discountPrice + (discountPrice * receipt.tax);
    }
}
