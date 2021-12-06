package solution_gui.caseStudyGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DrawFrame extends JFrame {
    private JButton undo;
    private JButton clear;
    private JButton clearAll;
    private String [] colors = {"Blue", "Red", "Green", "Cyan", "Yellow", "White", "Black", "Gray", "Pink", "Light Grey",
    "Dark Grey", "Magenta", "Orange"};
    private static final Color[] colorList = { Color.BLUE, Color.RED,
            Color.GREEN, Color.CYAN, Color.YELLOW, Color.WHITE,
            Color.BLACK, Color.GRAY, Color.PINK, Color.LIGHT_GRAY,
            Color.DARK_GRAY, Color.MAGENTA, Color.ORANGE};
    private String [] shapes = {"Line", "Oval", "Rectangle"};
    private JComboBox colorSelection;
    private JComboBox shapeSelection;
    private JCheckBox filledShape;

    public DrawFrame (){
        super("Drawing Panel");
        JLabel statusUpdate = new JLabel("Draw Shapes");
        undo = new JButton("Undo");
        clear = new JButton("Clear");
        colorSelection = new JComboBox(colors);
        shapeSelection = new JComboBox(shapes);
        filledShape = new JCheckBox("Filled");

        DrawPanel panel = new DrawPanel(statusUpdate);


        JPanel panel1 = new JPanel();
        panel1.add(undo);
        panel1.add(clear);
        panel1.add(colorSelection);
        panel1.add(shapeSelection);
        panel1.add(filledShape);

        add(panel1, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(panel.statusLabel, BorderLayout.SOUTH);

        //Action handler for undo button
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.clearLastShape();
            }
        });

        //Action handler for clear button
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.clearDrawing();
            }
        });

        //Item selection handler for color selection combo box
        colorSelection.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                   panel.setCurrentColor(colorList[colorSelection.getSelectedIndex()]);

                }
            }
        });

        //Item selection handler for shape selection combo box
        shapeSelection.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    panel.setShapeType(shapeSelection.getSelectedIndex() + 1);
                }
            }
        });

        //Item selected handler for filled shape checkbox
        filledShape.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                    panel.setFilledShape(filledShape.isSelected());
            }
        });






    }
}
