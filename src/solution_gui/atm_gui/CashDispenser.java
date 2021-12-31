package solution_gui.atm_gui;

public class CashDispenser {

    //the default initial number of bills in the cash dispenser
    private final static int INITIAL_COUNT = 500;
    private int count; //number of N1000 bills remaining

    //no-argument ATMProj.CashDispenser constructor initializes count to default
    public CashDispenser(){
        count = INITIAL_COUNT; //set count attribute to default
    }

    //simulates dispensing of specified amount of cash
    public void dispenseCash(int amount){
        int billsRequired = amount/1000; //number of N1000 bills required
        count -= billsRequired; //update the count of bills
    }

    //indicates whether cash dispenser can dispense desired amount
    public boolean isSufficientCashAvailable(int amount){
        int billsRequired = amount/1000; //number of N1000 bills required

        if(count >= billsRequired)
            return true; //enough bills available
        else
            return false; //not enough bills available
    }
}
