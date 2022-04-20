package course.functional.chapter7Suppliers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class TestTicket {
    private static ArrayList<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        tickets.add(new HardwareTicket("Kalpana Aida", 54434, "Cell phone won't goes back",
                7, "Ckock", "RV345", "SN434532-01"));
        tickets.add(new HardwareTicket("Sopthis Aida", 50211, "Cell phone won't power on",
                4, "Smartie", "SM250", "SN434532-45"));
        tickets.add(new SoftwareTicket("Chester Rodriguez", 50220, "MapApp can't find house",
                2, "MapApp", "1.10", SoftwareTicket.Domain.PHONE_HOSTED));
        tickets.add(new SoftwareTicket("Kapph Patel", 50001, "Can't change banking info on web",
                1, "awesome.com", "2.44", SoftwareTicket.Domain.WEB_HOSTED));

        LocalDate today = LocalDate.now();

        Supplier<? extends Ticket> nextTicket = () -> {
            Ticket next = null;

            for (int i = 0; i < tickets.size(); ++i) {
                Ticket t = tickets.get(i);

                if (t.getServicedDate().compareTo(today) < 0) {
                    if (next == null || t.compareTo(next) < 0) {
                        next = t;
                    }
                }
            }

            if (next != null){
                next.setServicedDate(today);
            }
            return next;
        };

        BooleanSupplier canClose = () -> {
            boolean result = false;
            Scanner scan = new Scanner(System.in);
            System.out.println("\n Can you close the ticket (Y or N)? ");

            if (scan.nextLine().charAt(0) == 'Y'){
                result = true;
            }
            return result;
        };

        BooleanSupplier isQuittingTime = () -> {
            boolean result = false;
            Scanner scan = new Scanner(System.in);
            System.out.println("Is it quitting time (Y or N)?");

            if (scan.nextLine().charAt(0) == 'Y'){
                result = true;
            }
            return result;
        };

        Ticket next;
        boolean done = false;
        do {
            next = nextTicket.get();
            if (next != null){
                System.out.println("\n" + next);

                if (canClose.getAsBoolean()){
                    tickets.remove(next);
                }
                if (isQuittingTime.getAsBoolean()){
                    done = true;
                }
            }
        } while (next != null && !done);

        if (next == null){
            System.out.println("\n Congrats, you get a $50 bonus!");
        } else {
            System.out.println("\nSee you tommorrow.");
        }

    }
}
