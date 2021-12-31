package solution_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ecofont extends JFrame {

    private JTextField textBox;
    private JButton sizeUp;
    private JButton sizeDown;
    private Font font;
    private int fontSize;
    private JLabel fontNum;

    public Ecofont (){
        super("Ecofont");
        setLayout(new FlowLayout());
        fontSize = 9;
        font = new Font("Spranq eco sans", Font.PLAIN, fontSize);
        textBox = new JTextField(20);
        textBox.setFont(font);
        textBox.setSize(100, 100);
        fontNum = new JLabel(""+fontSize);

        sizeUp = new JButton("Increase Font Size");
        sizeDown = new JButton("Decrease Font Size");
        add(sizeUp);
        add(textBox);
        add(sizeDown);
        add(fontNum);

        sizeUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++fontSize;
                font = new Font("Spranq eco sans", Font.PLAIN, fontSize);
                textBox.setFont(font);
                fontNum.setText(""+fontSize);
               // revalidate();
            }
        });

        sizeDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                --fontSize;
                font = new Font("Spranq eco sans", Font.PLAIN, fontSize);
                textBox.setFont(font);
                fontNum.setText(""+fontSize);


            }
        });


    }

    public static void main(String[] args) {
        Ecofont app = new Ecofont();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(400,300);
        app.setVisible(true);


    }
}
