package course.functional.chapter1.receipt;

public class ReceiptCountry extends Receipt {

    double countryTax;

    public ReceiptCountry(Receipt receipt, double countryTax) {
        super(receipt);
        this.countryTax = countryTax;
    }

}
