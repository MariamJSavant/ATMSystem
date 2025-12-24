import java.math.BigDecimal;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Bank myBank = new Bank();
        Account acc1 = new Account("001","1234","500000");
        Account acc2 = new Account("002","3412","30000");
        Account acc3 = new Account("003","1423","1000000");
        Account acc4 = new Account("004","3421","120000");
        Account acc5 = new Account("005","4312","520000");
        myBank.registerAccount(acc1);
        myBank.registerAccount(acc2);
        myBank.registerAccount(acc3);
        myBank.registerAccount(acc4);
        myBank.registerAccount(acc5);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the CBN ₦-ATM");
        System.out.print("Enter your Account Number: ");
        String idInput = scanner.nextLine();

        Account currentAccount = myBank.getAccountById(idInput);

        if (currentAccount != null){
            System.out.println("Enter PIN: ");
            String pinInput = scanner.nextLine();
            if (currentAccount.validatePin(pinInput)){
                System.out.println("Login Successful! ₦");
                runATMenu(currentAccount,scanner);
            }else {
                System.out.println("Incorrect PIN Access Denied");
            }
        }else {
            System.out.println("Account not found");
        }
        scanner.close();
    }
    public  static  void runATMenu(Account account, Scanner scanner){
        boolean quit = false;
        while (!quit){
            System.out.println("\n1 Check Balance\n2 Withdraw\n3 Exit");
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> System.out.println("Balance: ₦"+account.getBalance());
                case "2" ->{
                    System.out.println("Enter the amount to withdraw: ");
                    BigDecimal amount = new BigDecimal(scanner.nextLine());
                    account.withdraw(amount);
                }
                case "3" -> quit = true;
                default -> System.out.println("Invalid choice");
            }
        }
        System.out.println("Thank you for using our ATM ");
    }
}
