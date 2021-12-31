package solution_gui.atm_gui;

public class Withdrawal extends Transaction {

    private int amount; //amount to withdraw
    private CashDispenser cashDispenser; //reference to cash dispenser
    private static final int CASH_DISPENSED = 5;
    private static final int INSUFFICIENT_FUND = 6;
    private static final int DISPENSER_INSUFFICIENT = 7;



    //Withdrawal constructor
    public Withdrawal(int userAccountNumber, BankDatabase atmBankDatabase, CashDispenser atmCashDispenser) {

        //initialize superclass variables
        super(userAccountNumber, atmBankDatabase);

        cashDispenser = atmCashDispenser;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    //perform transaction
    @Override
    public int execute() {
        boolean cashDispensed = false; //cash was not dispensed yet
        double availableBalance; //amount available for withdrawal

        //get reference to bank database
        BankDatabase bankDatabase = getBankDatabase();


        //get available balance of account involved
        availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

        //check whether the user has enough money in the account
        if (amount <= availableBalance) {

            //check whether the cash dispenser has enough money
            if (cashDispenser.isSufficientCashAvailable(amount)) {

                //update the account involved to reflect the withdrawal
                bankDatabase.debit(getAccountNumber(), amount);

                cashDispenser.dispenseCash(amount); //dispense cash
                cashDispensed = true; //cash was dispensed
                return CASH_DISPENSED;

            } else { //cash dispenser does not have enough cash
                return DISPENSER_INSUFFICIENT;
            }

        } else {//not enough money available in user's account
            return INSUFFICIENT_FUND;
        }

    }

}
