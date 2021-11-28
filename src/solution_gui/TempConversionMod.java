package solution_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class TempConversionMod extends JFrame{
    JTextField inputField;
    JRadioButton [] radioButtons = new JRadioButton[6];
    JTextField outputField;
    JLabel labelOne;
    JLabel labelTwo;
    JLabel labelThree;
    JLabel labelFour;



    public TempConversionMod(){
        super("Temperature Conversion");
        setLayout(new GridLayout(8, 1, 5, 2));

        labelOne = new JLabel("Convert from:");
        labelTwo = new JLabel("Convert To:");
        labelThree = new JLabel("Enter Numeric Temperature");
        labelFour = new JLabel("Comparable Temperature is:");

        inputField = new JTextField(10);
        outputField = new JTextField(20);
        outputField.setEditable(false);


        radioButtons[0] = new JRadioButton("Fahrenheit", true);
        radioButtons[1] = new JRadioButton("Celsius");
        radioButtons[2] = new JRadioButton("Kelvin");
        radioButtons[3] = new JRadioButton("Fahrenheit", true);
        radioButtons[4] = new JRadioButton("Celsius");
        radioButtons[5] = new JRadioButton("Kelvin");

        ButtonGroup radioButtons1 = new ButtonGroup();
        radioButtons1.add(radioButtons[0]);
        radioButtons1.add(radioButtons[1]);
        radioButtons1.add(radioButtons[2]);

        ButtonGroup radioButtons2 = new ButtonGroup();
        radioButtons2.add(radioButtons[3]);
        radioButtons2.add(radioButtons[4]);
        radioButtons2.add(radioButtons[5]);


        //create JPanels
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();
        JPanel panelThree = new JPanel();
        JPanel panelFour = new JPanel();
        JPanel panelFive = new JPanel();
        JPanel panelSix = new JPanel();
        JPanel panelSeven = new JPanel();
        JPanel panelEight = new JPanel();

        //add first label
        panelOne.add(labelOne);

        //add first radio buttons
        panelTwo.add(radioButtons[0]);
        panelTwo.add(radioButtons[1]);
        panelTwo.add(radioButtons[2]);

        //add next prompt label
        panelThree.add(labelThree);

        //add text field
        panelFour.add(inputField);

        //add convert to label
        panelFive.add(labelTwo);

        //add radio button
        panelSix.add(radioButtons[3]);
        panelSix.add(radioButtons[4]);
        panelSix.add(radioButtons[5]);

        //add result label
        panelSeven.add(labelFour);

        //add result field
        panelEight.add(outputField);

        //add panels to JFrame
        add(panelOne);
        add(panelTwo);
        add(panelThree);
        add(panelFour);
        add(panelFive);
        add(panelSix);
        add(panelSeven);
        add(panelEight);

        //add event listeners
        inputField.addActionListener(new Handler());




    }

    private class Handler implements ActionListener{



        public void actionPerformed(ActionEvent event){

            //Get the value entered by users
            if(inputField.getText() != null){
                try {
                    //convert string to Double
                    double tempInput = Double.parseDouble(inputField.getText());

                    //Fahrenheit to Fahrenheit
                    if(radioButtons[0].isSelected() && radioButtons[3].isSelected()){
                        outputField.setText("" + tempInput);
                    }

                    //Celsius to Celsius
                    else if(radioButtons[1].isSelected() && radioButtons[4].isSelected()){
                        outputField.setText("" + tempInput);
                    }

                    //Kelvin to Kelvin
                    else if(radioButtons[2].isSelected() && radioButtons[5].isSelected()){
                        outputField.setText("" + tempInput);
                    }

                    //Fahrenheit to Celsius
                    else if(radioButtons[0].isSelected() && radioButtons[4].isSelected()){
                        double celsius = 0.6 * (tempInput - 32);
                        outputField.setText("" + celsius);
                    }

                    //Fahrenheit to kelvin
                    else if(radioButtons[0].isSelected() && radioButtons[5].isSelected()){
                        double kelvin =  ((tempInput - 32) * 0.56) + 273.15;
                        outputField.setText("" + kelvin);
                    }

                    //Celsius to Fahrenheit
                    else if (radioButtons[1].isSelected() && radioButtons[3].isSelected()){
                        double celsius = (tempInput - 32) * 0.5556;
                        outputField.setText("" + celsius);
                    }

                    //Celsius to Kelvin
                    else if(radioButtons[1].isSelected() && radioButtons[5].isSelected()){
                        double kelvin = tempInput + 273.15;
                        outputField.setText("" + kelvin);
                    }

                    //Kelvin to Fahrenheit
                    else if(radioButtons[2].isSelected() && radioButtons[3].isSelected()){
                        double fahrenheit = ((tempInput - 273.15) * 1.8) + 32;
                        outputField.setText("" + fahrenheit);
                    }

                    //Kelvin to Celsius
                    else if(radioButtons[2].isSelected() && radioButtons[4].isSelected()){
                        double celsius = tempInput - 273.15;
                        outputField.setText("" + celsius);
                    }



                }
                catch (NumberFormatException ex){
                    outputField.setText("Wrong value format entered");
                }
                catch (Exception ex){
                    outputField.setText("Illegal value entered");
                }
            }


        }
//
//
    }

    public static void main(String[] args) {

        TempConversionMod app = new TempConversionMod();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(300, 400);
        app.setVisible(true);


    }
}
