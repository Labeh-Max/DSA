package solution_gui.atm_gui;

import java.util.InputMismatchException;

public class AtmFunction {
    private boolean userAuthenticated; //whether user is authenticated
    private int currentAccountNumber; //current user's account number
    private int currentAccountPin; //current user's pin
    private String message; //atm message
    private Withdrawal withdrawal;
    private Deposit deposit;
    private BankDatabase atmDatabase;
    private CashDispenser cashDispenser;
    private DepositSlot depositSlot;
    private int billCount;


    public AtmFunction() {
        userAuthenticated = false;
        atmDatabase = new BankDatabase();
        cashDispenser = new CashDispenser();
        depositSlot = new DepositSlot();


    }

    public String welcomeMsg() {
        return message = "Welcome!\n";
    }

    public String accountRequest() {
        return "Please enter your account number: ";
    }

    public String pinRequest() {
        return "\nEnter your PIN: ";
    }

    public String showMenu() {
        return "Main menu:\n\n1 - View my balance\n2 - Withdraw cash\n3 - Deposit funds\n4 - Exit";
    }

    public String withdrawOption() {
        return "Withdrawal menu:\n1 - N1000\n2 - N2000\n3 - N3000\n4 - N5000\n5 - N10,000\n\nPress Clear to cancel>";
    }

    public String depositMsg() {
        return "Please enter a deposit amount in THOUSANDS: \n";
    }

    public boolean isUserAuthenticated() {
        return userAuthenticated;
    }

    public void setUserAuthenticated() {
        userAuthenticated = true;
    }

    public boolean authenticateUser(int accountNo, int accountPIN) {
        return atmDatabase.authenticateUser(accountNo, accountPIN);

    }

    public void setCurrentAccountNumber(int accountNumber) {
        currentAccountNumber = accountNumber;
    }

    public void setCurrentAccountPin(int accountPin) {
        currentAccountPin = accountPin;
    }

    public int getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    public int getCurrentAccountPin() {
        return currentAccountPin;
    }

    public int makeWithdrawal(int amount) {
        withdrawal = new Withdrawal(currentAccountNumber, atmDatabase, cashDispenser);
        withdrawal.setAmount(amount);
        return withdrawal.execute();
    }

    public double getAvailableBalance(int accountNo) {
        return atmDatabase.getAvailableBalance(accountNo);

    }

    public double getTotalBalance(int accountNo) {
        return atmDatabase.getTotalBalance(accountNo);
    }
    public int getBillCount(){
        return billCount;
    }

    public boolean acceptDeposit(String depositAmount) {
        try {
            int deposit = Integer.parseInt(depositAmount);
            if (deposit % 1000 == 0) {
                billCount = deposit / 1000;
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }


    }
    public String makeDeposit(){
        int depositAmount = billCount * 1000;
        deposit = new Deposit(currentAccountNumber, atmDatabase, depositSlot, depositAmount);
       if(deposit.execute() == Deposit.ENVELOP_RECEIVED){
           return "\nYour envelope has been " +
                   "received. \nNOTE: The money just deposited will not " +
                   "be available until we verify the amount of any " +
                   "enclosed cash and your checks clear.";
       }
       else{
           return "\nYou did not insert an " +
                   "envelope, so the ATM has canceled your transaction.";
       }


    }


}
