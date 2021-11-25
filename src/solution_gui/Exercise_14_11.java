package solution_gui;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
public class Exercise_14_11 {
    public static void main(String[] args) {

        //Create Textarea
        JTextArea areaOne = new JTextArea(5,5);
        JTextArea areaTwo = new JTextArea(5, 3);
        JTextArea areaThree = new JTextArea(4, 5);


        //create JLabels
        JLabel labelOne = new JLabel("   Printer: MyPrinter"); //create JLabel
        JLabel labelTwo = new JLabel("   PrintQuality");
        labelOne.setHorizontalTextPosition(SwingConstants.LEFT);

        //create JList
        String [] quality = {"High", "Medium", "Low"};
        JList printQuality = new JList(quality);
        printQuality.setVisibleRowCount(1);

        //Create Box for checklist
        Box checklistBox = Box.createVerticalBox();
        checklistBox.add(new JCheckBox("Image"));
        checklistBox.add(new JCheckBox("Text"));
        checklistBox.add(new JCheckBox("Code"));

        JCheckBox fileCheckBox = new JCheckBox("Print to File");
        //fileCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);

        //Create radio buttons
        JRadioButton radioOne = new JRadioButton("Selection", false);
        JRadioButton radioTwo = new JRadioButton("All", true);
        JRadioButton radioThree = new JRadioButton("Applet", false);

        //create radio button group to form logical relationship amongst radio buttons
        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(radioOne);
        radioButtons.add(radioTwo);
        radioButtons.add(radioThree);

        //create vertical box to contain radio buttons
        Box radioButtonsBox = Box.createVerticalBox();
        radioButtonsBox.add(radioOne);
        radioButtonsBox.add(radioTwo);
        radioButtonsBox.add(radioThree);


        //create JButtons
        JButton buttonOne = new JButton("OK");
        JButton buttonTwo = new JButton("Cancel");
        JButton buttonThree = new JButton("Setup...");
        JButton buttonFour = new JButton("Help");

        //JPanel to contain all items
        JPanel mainPanel = new JPanel();
        mainPanel.add(areaOne);
        mainPanel.add(checklistBox);
        mainPanel.add(areaTwo);
        mainPanel.add(radioButtonsBox);
        mainPanel.add(areaThree);

        //JPanel to contain bottom items
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(labelTwo);
        bottomPanel.add(new JScrollPane(printQuality));
        bottomPanel.add(fileCheckBox);





        //create a JPanel for buttons
        JPanel buttonBox = new JPanel(new GridLayout(4, 1, 5, 8));
        buttonBox.add(buttonOne);
        buttonBox.add(buttonTwo);
        buttonBox.add(buttonThree);
        buttonBox.add(buttonFour);

        //create a JPanel #bottom





        JFrame application = new JFrame("Printer");
        //application.setLayout();
        application.add(labelOne, BorderLayout.NORTH);
        application.add(mainPanel, BorderLayout.WEST);
        application.add(buttonBox, BorderLayout.EAST);
        application.add(bottomPanel, BorderLayout.SOUTH);
        application.setSize(400, 200);
        application.setVisible(true);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
