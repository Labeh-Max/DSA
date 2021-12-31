package solution_gui.atm_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmFrame extends JFrame {
    private JTextArea screen;
    private JPanel buttonPanel;
    private JPanel operationPanel;
    private JButton dispenseButton;
    private JButton depositButton;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton zero;
    private JButton clear;
    private JButton enter;

    private String userInput;
    String asterisk_acct;
    String asterisk_pin;

    private static final int AUTHENTICATION_ACCT = 1;
    private static final int AUTHENTICATION_PIN = 2;
    private static final int MENU_VIEW = 3;
    private static final int WITHDRAWAL_MODE = 4;
    private static final int TAKE_CASH = 5;
    private static final int DEPOSIT_MODE = 6;
    private static final int INSERT_DEPOSIT = 7;

    private AtmFunction atm; //handles common functions




    private int status;

    public AtmFrame (){
        super("ATM");
       // setBackground(Color.BLUE);
        getContentPane().setBackground(Color.CYAN);
        screen = new JTextArea(7, 21);
        screen.setEditable(false);
        //Initialize ATM capabilities
        atm = new AtmFunction();

        screen.setText(atm.welcomeMsg() + atm.accountRequest());

        status = AUTHENTICATION_ACCT;
        userInput = "";
        asterisk_acct = "";
        asterisk_pin = "";


        //create buttons
        one = new JButton("1");
        one.setBackground(Color.magenta);
        one.setForeground(Color.white);
        two = new JButton("2");
        two.setBackground(Color.black);
        two.setForeground(Color.white);
        three = new JButton("3");
        four = new JButton("4");
        four.setBackground(Color.magenta);
        four.setForeground(Color.white);
        five = new JButton("5");
        five.setBackground(Color.black);
        five.setForeground(Color.white);
        six = new JButton("6");
        seven = new JButton("7");
        seven.setBackground(Color.magenta);
        seven.setForeground(Color.white);
        eight = new JButton("8");
        eight.setBackground(Color.black);
        eight.setForeground(Color.white);
        nine = new JButton("9");
        zero = new JButton("0");
        zero.setBackground(Color.magenta);
        zero.setForeground(Color.white);
        clear = new JButton("Clear");
        clear.setBackground(Color.lightGray);
        clear.setForeground(Color.black);
        enter = new JButton("Enter");
        enter.setBackground(Color.GREEN);
        //enter.setForeground(Color.GRAY);

        //create button panel
        buttonPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        buttonPanel.setBackground(Color.cyan);
        buttonPanel.add(one);
        buttonPanel.add(two);
        buttonPanel.add(three);
        buttonPanel.add(four);
        buttonPanel.add(five);
        buttonPanel.add(six);
        buttonPanel.add(seven);
        buttonPanel.add(eight);
        buttonPanel.add(nine);
        buttonPanel.add(zero);
        buttonPanel.add(clear);
        buttonPanel.add(enter);

        //create operation panel
        operationPanel = new JPanel(new GridLayout(2, 1, 6, 10));
        operationPanel.setBackground(Color.cyan);
        dispenseButton = new JButton("Take cash here");
        operationPanel.add(dispenseButton);
        depositButton = new JButton("Insert deposit envelope here");
        operationPanel.add(depositButton);

        //add panels to frame
        add(screen, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.WEST);
        add(operationPanel, BorderLayout.EAST);

        //add action listeners to buttons
        one.addActionListener(new ButtonHandler());
        two.addActionListener(new ButtonHandler());
        three.addActionListener(new ButtonHandler());
        four.addActionListener(new ButtonHandler());
        five.addActionListener(new ButtonHandler());
        six.addActionListener(new ButtonHandler());
        seven.addActionListener(new ButtonHandler());
        eight.addActionListener(new ButtonHandler());
        nine.addActionListener(new ButtonHandler());
        zero.addActionListener(new ButtonHandler());
        clear.addActionListener(new ButtonHandler());
        dispenseButton.addActionListener(new ButtonHandler());
        enter.addActionListener(new ButtonHandler());
        depositButton.addActionListener(new ButtonHandler());

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (status) {
                    case AUTHENTICATION_ACCT:
                        if (!userInput.isBlank()) {
                            try {
                                atm.setCurrentAccountNumber(Integer.parseInt(userInput));
                                userInput = "";
                                status = AUTHENTICATION_PIN;

                            } catch (Exception ex) {
                                asterisk_acct = "";
                                screen.setText("Wrong value input" + atm.accountRequest() + asterisk_acct);

                            }
                        }


                    case AUTHENTICATION_PIN:
                        screen.setText(screen.getText() + atm.pinRequest() + asterisk_pin);
                        if (!userInput.isBlank()) {
                            try {
                                atm.setCurrentAccountPin(Integer.parseInt(userInput));
                                userInput = "";
                                if (atm.authenticateUser(atm.getCurrentAccountNumber(), atm.getCurrentAccountPin())) {
                                    atm.setUserAuthenticated();
                                    status = MENU_VIEW;
                                    screen.setText(atm.showMenu());
                                } else {
                                    status = AUTHENTICATION_ACCT;
                                    asterisk_acct = "";
                                    asterisk_pin = "";
                                    atm.setCurrentAccountNumber(0);
                                    atm.setCurrentAccountPin(0);
                                    screen.setText("User authentication failed\n" + atm.accountRequest());
                                }


                            } catch (Exception ex) {
                                asterisk_pin = "";
                                ex.printStackTrace();
                                screen.setText("Wrong input\n" + atm.welcomeMsg() + atm.accountRequest() + asterisk_acct + atm.pinRequest() + asterisk_pin);
                            }

                            }
                        break;
                    case DEPOSIT_MODE:
                        int state = 0;

                            break;

                        }
                }
        });




    }

    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {


            if(status == AUTHENTICATION_ACCT || status == AUTHENTICATION_PIN){
                if(e.getSource() == one){
                    userInput = userInput += "1";

                    if(status == AUTHENTICATION_ACCT){
                        asterisk_acct += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct);
                    }
                    else if(status == AUTHENTICATION_PIN){
                        asterisk_pin += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct + atm.pinRequest() + asterisk_pin);
                    }

                }
                if(e.getSource() == two){
                    userInput = userInput += "2";
                    if(status == AUTHENTICATION_ACCT){
                        asterisk_acct += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct);
                    }
                    else if(status == AUTHENTICATION_PIN){
                        asterisk_pin += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct + atm.pinRequest() + asterisk_pin);
                    }

                }
                if(e.getSource() == three){
                    userInput = userInput += "3";
                    if(status == AUTHENTICATION_ACCT){
                        asterisk_acct += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct);
                    }
                    else if(status == AUTHENTICATION_PIN){
                        asterisk_pin += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct + atm.pinRequest() + asterisk_pin);
                    }
                }
                if(e.getSource() == four){
                    userInput = userInput += "4";
                    if(status == AUTHENTICATION_ACCT){
                        asterisk_acct += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct);
                    }
                    else if(status == AUTHENTICATION_PIN){
                        asterisk_pin += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct + atm.pinRequest() + asterisk_pin);
                    }
                }
                if(e.getSource() == five){
                    userInput = userInput += "5";
                    if(status == AUTHENTICATION_ACCT){
                        asterisk_acct += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct);
                    }
                    else if(status == AUTHENTICATION_PIN){
                        asterisk_pin += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct + atm.pinRequest() + asterisk_pin);
                    }
                }
                if(e.getSource() == six){
                    userInput = userInput += "6";
                    if(status == AUTHENTICATION_ACCT){
                        asterisk_acct += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct);
                    }
                    else if(status == AUTHENTICATION_PIN){
                        asterisk_pin += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct + atm.pinRequest() + asterisk_pin);
                    }
                }
                if(e.getSource() == seven){
                    userInput = userInput += "7";
                    if(status == AUTHENTICATION_ACCT){
                        asterisk_acct += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct);
                    }
                    else if(status == AUTHENTICATION_PIN){
                        asterisk_pin += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct + atm.pinRequest() + asterisk_pin);
                    }
                }
                if(e.getSource() == eight){
                    userInput = userInput += "8";
                    if(status == AUTHENTICATION_ACCT){
                        asterisk_acct += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct);
                    }
                    else if(status == AUTHENTICATION_PIN){
                        asterisk_pin += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct + atm.pinRequest() + asterisk_pin);
                    }
                }
                if(e.getSource() == nine){
                    userInput = userInput += "9";
                    if(status == AUTHENTICATION_ACCT){
                        asterisk_acct += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct);
                    }
                    else if(status == AUTHENTICATION_PIN){
                        asterisk_pin += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct + atm.pinRequest() + asterisk_pin);
                    }
                }
                if(e.getSource() == zero){
                    userInput = userInput += "0";
                    if(status == AUTHENTICATION_ACCT){
                        asterisk_acct += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct);
                    }
                    else if(status == AUTHENTICATION_PIN){
                        asterisk_pin += "*";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct + atm.pinRequest() + asterisk_pin);
                    }
                }
                if(e.getSource() == clear){
                    if (status == AUTHENTICATION_ACCT){
                        userInput = "";
                        asterisk_acct = "";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest());
                    }
                    else if(status == AUTHENTICATION_PIN){
                        userInput = "";
                        asterisk_pin = "";
                        screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct + atm.pinRequest() + asterisk_pin);

                    }



                }

            }
            else if(status == MENU_VIEW){
                if(e.getSource() == one){
                    //view my balance
                   screen.setText("Available balance: " + atm.getAvailableBalance(atm.getCurrentAccountNumber()) + "\n");
                   screen.append("Total balance: " + atm.getTotalBalance(atm.getCurrentAccountNumber()) + "\n\n\n");
                   screen.append("Press Clear button to go to main menu >");


                }
                else if(e.getSource() == two){
                    //Withdraw cash
                    screen.setText(atm.withdrawOption());//show withdrawal options
                    status = WITHDRAWAL_MODE;

                }
                else if(e.getSource() == three){
                    //Deposit funds
                    screen.setText(atm.depositMsg());
                    status = DEPOSIT_MODE;

                }
                else if(e.getSource() == four){
                    //exit
                    status = AUTHENTICATION_ACCT;
                    asterisk_acct = "";
                    asterisk_pin = "";
                    userInput = "";
                    screen.setText(atm.welcomeMsg() + atm.accountRequest() + asterisk_acct);


                }
                else if(e.getSource() == clear){
                    //main menu
                    screen.setText(atm.showMenu());
                }

            }
            else if(status == WITHDRAWAL_MODE){
                int [] amounts = {0, 1000, 2000, 3000, 5000, 10000};
                if(e.getSource() == one || e.getSource() == two || e.getSource() == three || e.getSource() == four || e.getSource() == five || e.getSource() == clear){
                    int choice = 0;
                    if(e.getSource() == one){
                        choice = 1;
                    }
                    else if(e.getSource() == two){
                        choice = 2;
                    }
                    else if(e.getSource() == three){
                        choice = 3;
                    }
                    else if (e.getSource() == four){
                        choice = 4;
                    }
                    else if (e.getSource() == five){
                        choice = 5;
                    }
                    else if (e.getSource() == clear){
                        screen.setText(atm.showMenu());
                        status = MENU_VIEW;
                    }
                    if(e.getSource() != clear){
                        int withdrawalResult = atm.makeWithdrawal(amounts[choice]);
                        switch (withdrawalResult){
                            case 5:
                                screen.setText("Please take your cash :)\n");
                                status = TAKE_CASH;
                                break;
                            case 6:
                                screen.setText("Insufficient funds in your account :(\n");
                                screen.append(atm.showMenu());
                                status = MENU_VIEW;
                                break;
                            case 7:
                                screen.setText("Insufficient cash in dispenser :(\n");
                                screen.append(atm.showMenu());
                                status = MENU_VIEW;
                                break;
                        }
                    }

                }

            }
            else if(status == TAKE_CASH){
                if(e.getSource() == dispenseButton){
                    screen.setText("Cash collected!\n");
                    screen.append(atm.showMenu());
                    status = MENU_VIEW;
                }

            }
            else if(status == DEPOSIT_MODE){
                if(e.getSource() == one){
                    userInput += "1";
                    screen.setText(atm.depositMsg() + userInput);
                }
                if(e.getSource() == two){
                    userInput += "2";
                    screen.setText(atm.depositMsg() + userInput);
                }
                if (e.getSource() == three){
                    userInput += "3";
                    screen.setText(atm.depositMsg() + userInput);
                }
                if(e.getSource() == four){
                    userInput += "4";
                    screen.setText(atm.depositMsg() + userInput);
                }
                if(e.getSource() == five){
                    userInput += "5";
                    screen.setText(atm.depositMsg() + userInput);
                }
                if(e.getSource() == six){
                    userInput += "6";
                    screen.setText(atm.depositMsg() + userInput);
                }
                if(e.getSource() == seven){
                    userInput += "7";
                    screen.setText(atm.depositMsg() + userInput);
                }
                if(e.getSource() == eight){
                    userInput += "8";
                    screen.setText(atm.depositMsg() + userInput);
                }
                if (e.getSource() == nine){
                    userInput += "9";
                    screen.setText(atm.depositMsg() + userInput);
                }
                if (e.getSource() == zero){
                    userInput += "0";
                    screen.setText(atm.depositMsg() + userInput);
                }
                if(e.getSource() == clear){
                    status = MENU_VIEW;
                    userInput = "";
                    screen.setText(atm.showMenu());
                }
                if(e.getSource() == enter){
                //validate data entry
                if(atm.acceptDeposit(userInput)){

                    screen.setText("Please insert a deposit envelop containing " + atm.getBillCount()+ "000\n" +
                            "NOTE: The money just deposited will not be available until we verify\n the amount" +
                            "of any enclosed cash and your checks clear.");
                    status = INSERT_DEPOSIT;

                }
                else {
                    JOptionPane.showMessageDialog(AtmFrame.this, "Please try again following the displayed instruction","Deposit Error",JOptionPane.ERROR_MESSAGE);
                    userInput = "";
                    screen.setText(atm.showMenu());
                    status = MENU_VIEW;
                }

                }

            }

            else  if(status == INSERT_DEPOSIT){
                userInput = "";
                if(e.getSource() == depositButton){
                    JOptionPane.showMessageDialog(AtmFrame.this, atm.makeDeposit(), "ATM Deposit", JOptionPane.INFORMATION_MESSAGE);
                }
                status = MENU_VIEW;
                screen.setText(atm.showMenu());
            }

        }
    }
}
