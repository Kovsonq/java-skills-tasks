package course.functional.chapter1.receipt;

public class ReceiptTest {

    public static void main(String[] args) {

        ReceiptPrinter<Receipt> simpleReceiptPrinter = new ReceiptPrinter<>() {
            @Override
            public void print(Receipt receipt) {
                System.out.println("\nItem: \t" + receipt.item);
                System.out.println("Price: \t" + receipt.price);
                System.out.println("Disc: \t" + receipt.discount);
                System.out.println("Tax: \t" + receipt.tax);
                System.out.println("Total: \t" + computeTotal(receipt));
            }
        };

        ReceiptPrinter<ReceiptCountry> expertReceiptPrinter = new ReceiptPrinter<>() {
            @Override
            public void print(ReceiptCountry receipt) {
                System.out.println("\nItem: \t" + receipt.item);
                System.out.println("Price: \t" + receipt.price);
                System.out.println("Disc: \t" + receipt.discount);
                System.out.println("Country tax: \t" + receipt.countryTax);
                System.out.println("Total: \t" + computeTotal(receipt));
            }
            @Override
            public double computeTotal(ReceiptCountry receipt){
                return receipt.price - (receipt.price * receipt.discount) +
                        (receipt.price * receipt.countryTax);
            }
        };

        Receipt receipt = new Receipt("shirt", 20.0, 0.6, 0.04);
        ReceiptCountry receiptCountry = new ReceiptCountry(receipt, 0.05);
        simpleReceiptPrinter.print(receipt);
        expertReceiptPrinter.print(receiptCountry);
    }
}
