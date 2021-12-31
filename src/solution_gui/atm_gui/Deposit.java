package solution_gui.atm_gui;

public class Deposit extends Transaction {

    private double amount; //amount to deposit
    private DepositSlot depositSlot; //reference to deposit slot
    public static final int ENVELOP_RECEIVED = 1;


    //Deposit constructor
    public Deposit(int userAccountNumber, BankDatabase atmBankDatabase, DepositSlot atmDepositSlot, int amount){

        //initialize superclass variables
        super(userAccountNumber, atmBankDatabase);

        //initialize references to keypad and deposit slot
        depositSlot = atmDepositSlot;
        this.amount = amount;
    }//Deposit constructor

    //perform transaction
    @Override
    public int execute(){
        BankDatabase bankDatabase = getBankDatabase(); // get reference

            //received deposit envelope
            boolean envelopeReceived = depositSlot.isEnvelopeReceived();

            //check whether deposit envelope was received
            if(envelopeReceived){

                //credit account to reflect the deposit
                bankDatabase.credit(getAccountNumber(), amount);
                return ENVELOP_RECEIVED;
            }else { //deposit envelop not received
                return 0;
            }//end else

    }//end method execute

}
