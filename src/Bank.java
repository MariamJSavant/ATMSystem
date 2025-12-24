import java.util.HashMap;

public class Bank {
    private HashMap<String,Account> accountRegistry;
    public Bank(){
        this.accountRegistry = new HashMap<>();
    }

    public void registerAccount(Account acc){
        accountRegistry.put(acc.getAccountNumber(), acc);

    }

    public Account getAccountById(String id){
        return accountRegistry.get(id);
    }
}
