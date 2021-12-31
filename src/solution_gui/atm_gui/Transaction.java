package solution_gui.atm_gui;



public abstract class Transaction {
    private int accountNumber; //indicates account involved
    private BankDatabase bankDatabase; //account info database

    //ATMProj.Transaction constructor invoked by subclasses using super()
    public Transaction(int userAccountNumber, BankDatabase atmBankDatabase){
        accountNumber = userAccountNumber;
        bankDatabase = atmBankDatabase;

    }

    //return account number
    public int getAccountNumber(){
        return accountNumber;
    }


    //return reference to bank database
    public BankDatabase getBankDatabase() {
        return bankDatabase;
    }

    //perform the transaction (overridden by each subclass)
     abstract public int execute();


}
