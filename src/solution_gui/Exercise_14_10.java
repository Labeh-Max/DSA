package solution_gui;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.*;

//This code creates a color selection GUI
public class Exercise_14_10 {
    public static void main(String[] args) {
        String [] colors = {"Blue", "Red", "Green", "Black", "White", "Yellow"};

        JList colorList = new JList(colors);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        colorList.setVisibleRowCount(1);

        JCheckBox checkBoxOne = new JCheckBox("Background");
        JCheckBox checkBoxTwo = new JCheckBox("Foreground");

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");


        //container for checkboxes
        JPanel box = new JPanel();
        box.add(checkBoxOne);
        box.add(checkBoxTwo);

        //container for buttons
        JPanel box2 = new JPanel();
        box2.add(okButton);
        box2.add(cancelButton);



        JFrame application = new JFrame("Color Select"); //create a new JFrame
        application.add(new JScrollPane(colorList), BorderLayout.NORTH);
        application.add(box, BorderLayout.CENTER);
        application.add(box2, BorderLayout.SOUTH);

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(260, 130);
        application.setVisible(true);
    }
}
