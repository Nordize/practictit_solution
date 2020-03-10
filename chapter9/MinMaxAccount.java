public class MinMaxAccount extends BankingAccount {
    private int minBalance;
    private int maxBalance;
    
    public MinMaxAccount(Startup s) {
        
        //pass s to BankingAccount(s) so MinMax accounts are setup like Banking accounts
        super(s);
        
        //start the min and max for this account as the starting balance
        minBalance = s.startup_getBalance();
        maxBalance = s.startup_getBalance();
    }
    
    
    //Override the functionality of debit and credit to account for tracking min/max
    public void debit(Debit d) {
        super.debit(d);
        
        int balance = getBalance();
        
        if(balance < minBalance)
            minBalance = balance;
        
        if(balance > maxBalance)
            maxBalance = balance;
    }
    
    public void credit(Credit c) {
        super.credit(c);
        
        int balance = getBalance();
        
        if(balance < minBalance)
            minBalance = balance;
        
        if(balance > maxBalance)
            maxBalance = balance;
    }
    
    //accessors for min and max
    public int getMin() {
        return minBalance;
    }
    
    public int getMax() {
        return maxBalance;
    }
}
