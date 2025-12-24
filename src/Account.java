import java.math.BigDecimal;

public class Account {
    private String accountNumber;
    private  String pin;
    private BigDecimal balance;

    public Account(String accountNumber,String pin, String balance){
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = new BigDecimal(balance);
    }
    private  void  deposit(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) > 0){
            this.balance = balance.add(amount);
            System.out.println("You have successfully deposited:  ₦"+amount);
        }
        System.out.println("Invalid deposit amount ");

    }
    public void withdraw(BigDecimal amount){
     if(this.balance.compareTo(amount) < 0){
         System.out.println("Insufficient funds: You don't have enough ₦");
     }else {
         this.balance = balance.subtract(amount);
         System.out.println("Withdrawal successful! Remaining balance: ₦"+this.balance);
     }
    }
    public   boolean  validatePin(String enteredPin){
     return this.pin.equals(enteredPin);
    }
    public BigDecimal getBalance(){
        return this.balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

}
