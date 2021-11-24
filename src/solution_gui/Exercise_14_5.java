package solution_gui;
import javax.swing.*;
import java.awt.*;

public class Exercise_14_5 {
    public static void main(String[] args) {
        JFrame application = new JFrame("Align");
        application.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));

        JCheckBox firstCheckbox = new JCheckBox("Snap to Grid");
        JCheckBox secondCheckbox = new JCheckBox("Show Grid");
        JTextField firstTextField = new JTextField(3);
        JTextField secondTextField = new JTextField(3);
        JLabel labelOne = new JLabel("X:");
        JLabel labelTwo = new JLabel("Y:");
        JButton firstButton = new JButton("OK");
        JButton secondButton = new JButton("Cancel");
        JButton thirdButton = new JButton("Help");
        GridLayout gridLayout = new GridLayout(3, 1, 5, 5);
        JPanel jPanel = new JPanel(gridLayout);


        Box boxOne = Box.createVerticalBox();
        Box boxTwo = Box.createVerticalBox();

        Box boxFour = Box.createVerticalBox();

        boxOne.add(firstCheckbox);
        boxOne.add(secondCheckbox);
        boxTwo.add(firstTextField);
        boxTwo.add(secondTextField);
        jPanel.add(firstButton);
        jPanel.add(secondButton);
        jPanel.add(thirdButton);
        boxFour.add(labelOne);
        boxFour.add(labelTwo);

        application.add(boxOne);
        application.add(boxFour);
        application.add(boxTwo);
        application.add(jPanel);

        application.setSize(300, 150);
        application.setVisible(true);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }
}
