package solution_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Craps extends JFrame{
    private JLabel [] labels;
    private JTextField fields [];
    private enum Status {CONTINUE, WON, LOST};
    private JButton rollButton;
    private Random randomNum = new Random();
    private int die1;
    private int die2;
    private int sumOfDice;
    private int rollCount = 1;
    Status gameStatus;

    //constants that represent common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    private int myPoint = 0;


    public Craps (){
        super("Craps Game");



        labels = new JLabel[5];
        fields = new JTextField[4];

        rollButton = new JButton("Roll Dice");

        labels[0] = new JLabel("Dice 1");
        labels[1] = new JLabel("Dice 2");
        labels[2] = new JLabel("Sum");
        labels[3] = new JLabel("Point");
        labels[4] = new JLabel("Game Status");

        fields[0] = new JTextField(3);
        fields[1] = new JTextField(3);
        fields[2] = new JTextField(3);
        fields[3] = new JTextField(3);

        //set first panel
        JPanel panel1 = new JPanel(new BorderLayout());
        labels[4].setHorizontalAlignment(SwingConstants.CENTER);
        panel1.add(labels[4], BorderLayout.CENTER);

        //set second panel
        JPanel panel2 = new JPanel(new GridLayout(2, 4, 5, 0 ));
        panel2.add(fields[0]);
        panel2.add(fields[1]);
        panel2.add(fields[2]);
        panel2.add(fields[3]);
        panel2.add(labels[0]);
        panel2.add(labels[1]);
        panel2.add(labels[2]);
        panel2.add(labels[3]);



        //set third panel
        JPanel panel3 = new JPanel();
        rollButton.setHorizontalAlignment(SwingConstants.CENTER);
        panel3.add(rollButton);

        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);


        //register event handler
        rollButton.addActionListener(new handler());


    }

    private class handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            die1 = rollDice();
            die2 = rollDice();
            sumOfDice = die1 + die2;


            fields[0].setText(""+die1);
            fields[1].setText(""+die2);
            fields[2].setText(""+sumOfDice);



            if(rollCount == 1){
                //determine game status and point based on first roll
                switch (sumOfDice){
                    case SEVEN: //win with 7 on first roll
                    case YO_LEVEN: //win with 11 on first roll
                        gameStatus = Status.WON;
                        fields[3].setText(""+sumOfDice);
                        labels[4].setText("Game Won");
                        break;
                    case SNAKE_EYES:// lose with 2 on first roll
                    case TREY: //lose with 3 on first roll
                    case BOX_CARS://lose with 12 on first roll
                        gameStatus = Status.LOST;
                        fields[3].setText(""+sumOfDice);
                        labels[4].setText("Game Lost");
                        break;
                    default: //did not win or lose, so remember point
                        gameStatus = Status.CONTINUE;
                        myPoint = sumOfDice;
                        fields[3].setText(""+myPoint);
                        labels[4].setText("Game Continues. Point is: "+myPoint);
                }
                ++rollCount;

            }else if (gameStatus != Status.LOST && gameStatus != Status.WON){
                if(sumOfDice == myPoint){
                    gameStatus = Status.WON;
                    labels[4].setText("Game Won");
                }else if(sumOfDice == SEVEN){
                    gameStatus = Status.LOST;
                    labels[4].setText("Game Lost");

                }

            }






        }
    }

    public int rollDice(){
        return 1 + randomNum.nextInt(5);
    }

    public static void main(String[] args) {

        Craps app = new Craps();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(300, 150);
        app.setVisible(true);


    }



}
