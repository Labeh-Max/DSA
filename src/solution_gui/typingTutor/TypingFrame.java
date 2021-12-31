package solution_gui.typingTutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class TypingFrame extends JFrame {
    private JLabel labelOne;
    private JLabel labelTwo;
    private JTextArea textDisplay;
    private JPanel panelOne;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelFive;
    private JPanel keysPanel;
    private JButton[] buttons;
    private Color defaultColor;
    private int [] keyCodes = {KeyEvent.VK_BACK_QUOTE, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4,
            KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9, KeyEvent.VK_0, KeyEvent.VK_MINUS,
            KeyEvent.VK_EQUALS, KeyEvent.VK_BACK_SPACE, KeyEvent.VK_TAB, KeyEvent.VK_Q, KeyEvent.VK_W, KeyEvent.VK_E, KeyEvent.VK_R,
            KeyEvent.VK_T, KeyEvent.VK_Y, KeyEvent.VK_U, KeyEvent.VK_I, KeyEvent.VK_O, KeyEvent.VK_P, KeyEvent.VK_OPEN_BRACKET,
            KeyEvent.VK_CLOSE_BRACKET, KeyEvent.VK_BACK_SLASH, KeyEvent.VK_CAPS_LOCK, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_F,
            KeyEvent.VK_G, KeyEvent.VK_H, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, KeyEvent.VK_SEMICOLON, KeyEvent.VK_QUOTE,
            KeyEvent.VK_ENTER, KeyEvent.VK_SHIFT, KeyEvent.VK_Z, KeyEvent.VK_X, KeyEvent.VK_C, KeyEvent.VK_V, KeyEvent.VK_B, KeyEvent.VK_N,
            KeyEvent.VK_M, KeyEvent.VK_COMMA, KeyEvent.VK_PERIOD, KeyEvent.VK_SLASH, KeyEvent.VK_UP, KeyEvent.VK_SPACE, KeyEvent.VK_LEFT, KeyEvent.VK_DOWN,
            KeyEvent.VK_RIGHT};
    private String userInput = "";
    private String [] words = {"The", "Brown", "Method", "lazy", "WIZKID", "Victony", "Isreal", "AbuJA"};
    private String preStoredText = "";
    private Random randomNumber;

    public TypingFrame() {
        super("Typing Application");
        String lineOne = "Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed.";

       String lineTwo = "Note: Clicking the buttons will not perform any action";
        String [] keys = { "`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0","-", "+", "Backspace","Tab","Q", "W", "E", "R", "T",
        "Y", "U", "I", "O", "P", "[", "]", "\\", "Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "Enter", "Shift",
                "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?", "up",  "space", "left", "down", "right",};

        //Create a random number object
        randomNumber = new Random();

        labelOne = new JLabel(lineOne);
        labelTwo = new JLabel(lineTwo);

        textDisplay = new JTextArea(20, 50);
        preStoredText = getPreStoredText();
        textDisplay.setText(preStoredText);
        textDisplay.setEditable(false);
        textDisplay.setLineWrap(true);

        //create 57 buttons
        buttons = new JButton[57];

        //initialize buttons
        for (int i = 0; i < keys.length; i++) {
            buttons[i] = new JButton(keys[i]);
        }

        //Vertical Box to contain labels
        Box labelBox = Box.createVerticalBox();
        labelBox.add(labelOne);
        labelBox.add(labelTwo);



        panelTwo = new JPanel(new GridLayout(2, 14, 2, 2));
        for (int a = 0; a <= 27; a++){

            panelTwo.add(buttons[a]);
        }

        panelThree = new JPanel(new GridLayout(1, 13, 2, 2));
        for(int b = 28; b <= 40; b++){
            buttons[b].setPreferredSize(new Dimension(106, 25));
            panelThree.add(buttons[b]);
        }

        panelFour = new JPanel(new GridLayout(1, 12, 1, 2));
        for (int c = 41; c <= 52; c++){
            buttons[c].setPreferredSize(new Dimension(106, 25));
            panelFour.add(buttons[c]);
        }

        FlowLayout bottomLayout = new FlowLayout();
        bottomLayout.setAlignment(FlowLayout.CENTER);
        panelFive = new JPanel(bottomLayout);
        buttons[53].setPreferredSize(new Dimension(1000, 30));
        panelFive.add(buttons[53]);
        buttons[54].setPreferredSize(new Dimension(100, 25));
        panelFive.add(buttons[54]);
        buttons[55].setPreferredSize(new Dimension(100, 25));
        panelFive.add(buttons[55]);
        buttons[56].setPreferredSize(new Dimension(100, 25));
        panelFive.add(buttons[56]);

        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.CENTER);
        keysPanel = new JPanel(layout);
        //keysPanel.add(textDisplay);
        keysPanel.add(panelTwo);
        keysPanel.add(panelThree);
        keysPanel.add(panelFour);


     JPanel typingPanel = new JPanel(new GridLayout(4, 1));

     typingPanel.add(labelBox);
     typingPanel.add(textDisplay);
     typingPanel.add(keysPanel);
     typingPanel.add(panelFive);

     //defaultColor = buttons[0].getBackground();

     add(typingPanel);
     textDisplay.setFocusTraversalKeysEnabled(false);
     textDisplay.addKeyListener(new Handler());

    }

    public String getPreStoredText() {
        // randomly select the number of words to display between 1 and 6
        int numberOfWords = 1 + randomNumber.nextInt(words.length);
        String generatedText = "";

        //loop and add randomly chosen words from "words" array
        for (int i = 0; i < numberOfWords; i++){
           generatedText += words[randomNumber.nextInt(words.length)];
            if((numberOfWords - i) > 1){
                generatedText += " ";
            }

        }
        generatedText += "\n";

        return generatedText;
    }

    //inner class to handle key events
    private class Handler implements KeyListener{
        @Override
       public void keyTyped(KeyEvent e) {
            if(userInput.length() < preStoredText.length()){
                if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE){
                    userInput += String.format("%s", e.getKeyChar());
                    textDisplay.setText(preStoredText + userInput);

                }

          }

            if(userInput.length() == preStoredText.length()){
                String incorrectLetters = "";
                //Compare each character in the userInput and the pre-stored text
                int correct = 0;
                for (int i = 0; i < preStoredText.length(); i++){
                    String letterOne = String.format("%s", userInput.charAt(i));
                    String letterTwo = String.format("%s", preStoredText.charAt(i));
                    if(letterOne.equals(letterTwo)){
                        ++correct;
                    }
                    else {
                        incorrectLetters += letterTwo;
                    }
                }

                JOptionPane.showMessageDialog(TypingFrame.this, "" + correct + " Correct letter(s)\n" +(userInput.length()-correct) + " Incorrect letter(s) " + incorrectLetters, "Accuracy", JOptionPane.INFORMATION_MESSAGE);
                preStoredText = getPreStoredText();
                userInput = "";
                textDisplay.setText(preStoredText + userInput);

                //set all button colors to null
                for(int j = 0; j < buttons.length; j++){
                    buttons[j].setBackground(null);
                }


            }
            revalidate();
            //textDisplay.append( String.format("%s",e.getKeyChar()));






        }

        @Override
        public void keyPressed(KeyEvent e) {

            for (int i = 0; i < 57; i++){
                if(keyCodes[i]== e.getKeyCode()){
                    //defaultColor = buttons[i].getBackground();
                    buttons[i].setBackground(Color.GREEN);
                    i = 99;
                }

            }
//            if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
//                if(userInput.length() > 0){
//                    userInput =  userInput.substring(0, userInput.length()-1);
//                    textDisplay.setText(userInput);
//                 //   revalidate();
//
//                }
//

        }

        @Override
        public void keyReleased(KeyEvent e) {
            for(int i = 0; i < 57; i++){
                if (keyCodes[i] == e.getKeyCode()){
                    buttons[i].setBackground(null);
                    i = 99;
                }
            }



        }
    }

    public static void main(String[] args) {
        TypingFrame app = new TypingFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1500,600);
        app.setVisible(true);


    }
}
