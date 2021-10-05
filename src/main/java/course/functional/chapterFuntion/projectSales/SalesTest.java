package course.functional.chapterFuntion.projectSales;

import course.functional.chapterFuntion.overall.BiFunction;

import java.util.ArrayList;

public class SalesTest {
    final  static Customer[] customers = {
            new Customer("John Smith", "0998938323", "football", "Giants", 3.51,
                    null, 1, "Marta Stya, 32423423"),
            new Customer("Mary Dana", "09923423323", "tennis", null, 3.92,
                    "Java", 0, null),
            new Customer("Klod Mone", "09989356343", "golf", null, 3.79,
                    "Physics", 1, "Gregory Donnava, 1231234"),
            new Customer("Adam Smith", "0954638323", "tennis", "Giants", 3.61,
                    null, 0, null),
            new Customer("Jack Kork", "0998934723", "football", "Eagles", 3.74,
                    null, 1, "Gold John, 33000990"),
            new Customer("Bonny Press", "1231238323", "tennis", null, 3.55,
                    null, 0, null),
            new Customer("Adama Temm", "4444938323", "football", "Eagles", 3.12,
                    null, 0, null),
            new Customer("Sarra Conor", "2222238323", "football", "Giants", 3.66,
                    null, 1, "Gennady Alow, 55566776"),
    };

    public static void main(String[] args) {
        ArrayList<BiFunction<Customer,Integer, ? extends Record>> biFunctions = new ArrayList<>();
        biFunctions.add(SalesQueryUtils.getFriendsRecord(customers));
        biFunctions.add(SalesQueryUtils.getGpaRecord(customers));
        biFunctions.add(SalesQueryUtils.getSportRecord(customers));

        System.out.println("Sunday football promo - call to:");
        matchCustomers(new Customer(null,null,"football",null,Double.MAX_VALUE, null,
                Integer.MAX_VALUE, null), biFunctions);
        System.out.println("Tuesday high-tech promo - call to:");
        matchCustomers(new Customer(null,null,null,null,3.75, null,
                Integer.MAX_VALUE, null), biFunctions);
        System.out.println("Friday bring a friend promo - call to:");
        matchCustomers(new Customer(null,null,null,null, Double.MAX_VALUE, null,
               1, null), biFunctions);

    }

    public static void matchCustomers(Customer c, ArrayList<BiFunction<Customer,Integer, ? extends Record>> biFunctions){
        for (int j = 0; j < biFunctions.size(); ++j) {
            Record record;
            int index = 0;
            do {
                record = biFunctions.get(j).apply(c,index);
                if (record != null){
                    System.out.println(record);
                    index = record.getIndex() + 1;
                }
            } while (null != record);
        }
        System.out.println("-------------the end----------");
    }
}
