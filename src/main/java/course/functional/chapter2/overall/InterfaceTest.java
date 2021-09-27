package course.functional.chapter2.overall;

import course.functional.chapter1.receipt.Receipt;
import course.functional.chapter1.receipt.ReceiptPrinter;
import course.functional.chapter1.staticMethod.GenericInterface;

public class InterfaceTest {
    static <T> void m2(Z<T> arg){}

    public static void main(String[] args) {
        m2((A x) -> x.i);
        /**
         * It's impossible to call default interface method from lambda expression
         * in this case we should call it outside -> to use object of this FIU
         */
        ReceiptPrinter<Receipt> printer = receipt -> System.out.println("Hi" + receipt.item);
        Receipt receipt = new Receipt("shirt",200,0.2, 0.111);

        System.out.println(printer.computeTotal(receipt));

        /**
         * cant use lambda with abstract classes
         */
//        TwoInteger integer = (x, y) -> x / y;

        GenericInterface<Integer> twoInteger = (x, y) -> x/y;
    }
}
