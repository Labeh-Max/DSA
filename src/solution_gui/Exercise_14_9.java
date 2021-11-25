package solution_gui;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

//This code creates a simple calculator GUI

public class Exercise_14_9 {

    public static void main(String[] args) {


        JTextField outputArea = new JTextField(12); // creates a JTextField component
        outputArea.setBounds(0, 0, 280, 50);
        JPanel buttonsPanel = new JPanel(new GridLayout(4, 4, 3, 3)); //creates a Jpanel with Grid layout manager

        //create buttons 0 - 9
        JButton [] buttons = new JButton[10];
        for(int i = 0; i <= 9; i++){
            buttons[i] = new JButton(""+i);


        }

        //create operation buttons
        JButton divideButton = new JButton("/");
        JButton multiplyButton = new JButton("*");
        JButton subButton = new JButton("-");
        JButton addButton = new JButton("+");
        JButton pointButton  = new JButton(".");
        JButton equalButton = new JButton("=");

        //add buttons to JPanel container and position SOUTH;
        buttonsPanel.add(buttons[7]);
        buttonsPanel.add(buttons[8]);
        buttonsPanel.add(buttons[9]);
        buttonsPanel.add(divideButton);
        buttonsPanel.add(buttons[4]);
        buttonsPanel.add(buttons[5]);
        buttonsPanel.add(buttons[6]);
        buttonsPanel.add(multiplyButton);
        buttonsPanel.add(buttons[1]);
        buttonsPanel.add(buttons[2]);
        buttonsPanel.add(buttons[3]);
        buttonsPanel.add(subButton);
        buttonsPanel.add(buttons[0]);
        buttonsPanel.add(pointButton);
        buttonsPanel.add(equalButton);
        buttonsPanel.add(addButton);

        //create JFrame to display calculator
        JFrame application = new JFrame("Calculator"); //create a new JFrame
        application.add(buttonsPanel, BorderLayout.CENTER); //display buttons in CENTER
        application.add(outputArea, BorderLayout.NORTH); //display calculator output area NORTH
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(250, 250);
        application.setVisible(true);





    }

}
