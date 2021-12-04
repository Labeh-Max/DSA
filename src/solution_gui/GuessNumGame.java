package solution_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessNumGame extends JFrame {

    private JLabel welcomeLabel;
    private JLabel promptLabel;
    private JLabel guessLabel;

    private JTextField userGuess;
    private JTextField answer;
    private JButton playAgain;
    private JButton showAnswer;
    private int guessCount = 0;
    private int randomNumber;
    boolean toggle = true;


    public GuessNumGame(){
        super("Guess The Number Game");

        setLayout(new GridLayout(4, 1, 5, 2));
        String prompt = "I have a number between 1 and 1000.\n Can you guess my number?\n";


        welcomeLabel = new JLabel(prompt);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        promptLabel = new JLabel("Please enter your guess");
        guessLabel = new JLabel("Guess");


        userGuess = new JTextField(10);
        answer = new JTextField(4);
        answer.setVisible(false);

        playAgain = new JButton("Play Again");

        showAnswer = new JButton("Display Answer");

        JPanel panelOne = new JPanel();
        panelOne.add(userGuess);
        panelOne.add(guessLabel);

        JPanel panelTwo = new JPanel();
        panelTwo.add(showAnswer);
        panelTwo.add(answer, FlowLayout.LEFT);
        panelTwo.add(playAgain, FlowLayout.RIGHT);

        JPanel panelThree = new JPanel();
        panelThree.add(promptLabel);

        add(welcomeLabel);
        add(panelThree);
        add(panelOne);
        add(panelTwo);

        //get random number
        randomNumber = generateRandomNum();

        userGuess.addActionListener(new Handler());
        showAnswer.addActionListener(new Handler());
        playAgain.addActionListener(new Handler());

    }

    public int generateRandomNum(){
        Random random = new Random();
        return 1 +  random.nextInt(999);
    }

    private class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == userGuess && e.getActionCommand() != null){
                try{
                    int userInput = Integer.parseInt(e.getActionCommand());
                    ++guessCount;
                    guessLabel.setText("Guess: " + guessCount);
                    if(randomNumber == userInput){
                        welcomeLabel.setText("Correct!");
                        getContentPane().setBackground(Color.GREEN);
                        userGuess.setEditable(false);
                    }
                    else if(userInput > randomNumber && (userInput - randomNumber) >= 100){
                        welcomeLabel.setText("Too High");
                        getContentPane().setBackground(new Color(255, 127, 127));
                    }
                    else if(userInput > randomNumber && (userInput - randomNumber) <= 99){
                        welcomeLabel.setText("High");
                        getContentPane().setBackground(new Color(255, 127, 127));
                    }

                    else if(userInput < randomNumber && (randomNumber - userInput) >= 100){
                        welcomeLabel.setText("Too Low");
                        getContentPane().setBackground(new Color(173, 216, 230));
                    }

                    else if(userInput < randomNumber && (randomNumber - userInput) <= 99){
                        welcomeLabel.setText("Low");
                        getContentPane().setBackground(new Color(173, 216, 230));
                    }
                }
                catch (NumberFormatException ex){
                    welcomeLabel.setText("Invalid input");
                    getContentPane().setBackground(Color.WHITE);
                }
                catch (Exception ex){
                    welcomeLabel.setText("Illegal value");
                }
            }
            else if(e.getSource() == showAnswer){

                if(toggle) {
                    answer.setVisible(true);
                    answer.setText("" + randomNumber);
                    answer.setEditable(false);
                }
                else {
                    answer.setVisible(false);
                }
                getContentPane().validate();
                toggle = !toggle;
            }

            else if(e.getSource() == playAgain){

                //get new random number
                randomNumber = generateRandomNum();
                getContentPane().setBackground(null);
                userGuess.setEditable(true);
                guessCount = 0;
                guessLabel.setText("Guess: " + guessCount);
                welcomeLabel.setText("I have a number between 1 and 1000.\n Can you guess my number?\n");
                getContentPane().validate();
            }
        }

    }

    public static void main(String[] args) {

        GuessNumGame app = new GuessNumGame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500, 400);
        app.setVisible(true);


    }
}
