package course.functional.chapter4Predicate.projectCar;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CarTest {

    static List<Customer> customerList = Arrays.asList(
            new Customer("female", 43, "New York", "highschool"),
            new Customer("male",45, "New York", "bachelor"),
            new Customer("female",52, "New York", "PhD"),
            new Customer("female",22, "Pennsylvania", "bachelor"));

    static List<CarQualifier> carQualifiers = List.of(
            new ElantraCarQualifier(),
            new PriusCarQualifier(),
            new OdysseyCarQualifier());

    public static void main(String[] args) {

        for (CarQualifier carQualifier : carQualifiers){
            int step = 0;

            for (Customer customer : customerList){

                if (qualifyCustomer(customer, carQualifier.getCarQualifier())) {
                    System.out.println("Sell customer " + customer + " \nThe car " + carQualifier.getQualifierName());
                    break;
                }
                step++;
            }

            if (step == customerList.size()){
                System.out.println("No customer for the " + carQualifier.getQualifierName());
            }
        }
    }

    private static boolean qualifyCustomer(Customer c, List<Predicate<Customer>> predicates){
        int count = 0;
        for (Predicate<Customer> predicate : predicates){
            if (predicate.test(c)){
                count++;
                System.out.println("Match " + count);
            }
        }
        return count >= 3;
    }
}
