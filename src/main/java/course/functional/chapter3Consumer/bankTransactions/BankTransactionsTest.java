package course.functional.chapter3Consumer.bankTransactions;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BankTransactionsTest {
    private static final ArrayList<BankAccount> accounts = new ArrayList<>();
    private static int numAccounts = 0;
    private static double prevBalance = 0.0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        BiConsumer<String, Double> openAccount = (x, y) -> {
            numAccounts = accounts.size();
            Random generator = new Random();
            accounts.add(new BankAccount(generator.nextInt(10000), y, x));
        };

        BiConsumer<String, Double> openVerification = (x, y) -> {
            if (accounts.size() == (numAccounts + 1) && accounts.get(numAccounts).getName().equals(x)){
                System.out.println("Account for " + x
                + " Opened successfully.\n" + accounts.get(numAccounts));
            } else {
                System.out.println("Could not open account for " + x);
            }
        };

        BiConsumer<Integer, Double> deposit = (x,y)-> {
            BankAccount bankAccount = findBankAccount(x);
            if (bankAccount != null){
                prevBalance = bankAccount.getBalance();
                bankAccount.setBalance(bankAccount.getBalance() + y);
            }
        };

        BiConsumer<Integer,Double> depositVerification = (x,y)-> {
            BankAccount bankAccount = findBankAccount(x);
            if (bankAccount != null && bankAccount.getBalance() == (prevBalance + y)){
                System.out.println("Deposit of " + y
                + " INTO account " + x + "\n" + accounts.get(numAccounts));
            } else {
                System.out.println("Account " + x + " NOT FOUND");
            }
        };

        BiConsumer<Integer, Double> withdraw = (x,y)-> {
            BankAccount bankAccount = findBankAccount(x);
            if (bankAccount != null){
                prevBalance = bankAccount.getBalance();
                if ((bankAccount.getBalance() - y) >= 0.0) {
                    bankAccount.setBalance(bankAccount.getBalance() - y);
                }
            }
        };

        BiConsumer<Integer, Double> withdrawVerification = (x,y)->{
            BankAccount bankAccount = findBankAccount(x);
            if (bankAccount != null){
                if (bankAccount.getBalance() == (prevBalance - y)){
                    System.out.println("Withdraw of $" + y
                    + " From account " + x + " Successful\n" + bankAccount);
                } else {
                    System.out.println("INSUFFICIENT FUNDS TO WITHDRAW" + y + " FROM Account " + x + "\n" + bankAccount);
                }
            }
        };

        Consumer<Integer> close = x -> {
            numAccounts = accounts.size();
            BankAccount account = findBankAccount(x);
            if (account != null) {
                accounts.remove(account);
            }
        };

        Consumer<Integer> closeVerification = x -> {
            if (accounts.size() == (numAccounts -1)){
                System.out.println("ACCOUNT " + x + " Successfully closed");
            } else {
                System.out.println("Could not close account " + x);
            }
        };

        boolean done = false;
        while (!done){
            String transactionSelected = promptTransaction();
            switch (transactionSelected.toUpperCase()){
                case "OPENACC" -> openAccount.andThen(openVerification).accept(promptName(), promptAmount());
                case "DEPOSIT" -> deposit.andThen(depositVerification).accept(promptId(),promptAmount());
                case "WITHDRAW" -> withdraw.andThen(withdrawVerification).accept(promptId(), promptAmount());
                case "CLOSEACC" -> close.andThen(closeVerification).accept(promptId());
                case "QUIT" -> done = true;
                default -> System.out.println("Invalid selection");
            }
        }
    }


    public static String promptTransaction() {
        System.out.print("Enter Transaction type:\n" +
                "OPENACC\n" +
                "DEPOSIT\n" +
                "WITHDRAW\n" +
                "CLOSEACC\n" +
                "QUIT\n" +
                "your enter: ");
        return scanner.nextLine();
    }

    public static double promptAmount() {
        System.out.print("Enter amount:");
        return Double.parseDouble(scanner.nextLine());
    }

    public static String promptName() {
        System.out.print("Enter Name:");
        return scanner.nextLine();
    }

    public static int promptId() {
        System.out.print("Enter Id:");
        return Integer.parseInt(scanner.nextLine());
    }

    public static BankAccount findBankAccount(int id) {
        int index = accounts.indexOf(new BankAccount(id, 0.0, null));
        return (index > -1) ? accounts.get(index) : null;
    }
}
