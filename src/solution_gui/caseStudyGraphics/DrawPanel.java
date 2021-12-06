package solution_gui.caseStudyGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawPanel extends JPanel {

    private MyShape [] shapes; //this will store all the shapes the user draws
    private int shapeCount; //this count the number of shapes in the array
    private int shapeType; //this determines the type of shape to draw.
    private MyShape currentShape; //that represents the current shape the user is drawing
    private Color currentColor; //this represents the current drawing color
    private boolean filledShape; //this determines whether to draw a filled shape
    JLabel statusLabel;//this represents the status bar. The status bar will display the coordinates of the current mouse position
    private final static int LINE = 1;
    private final static int OVAL = 2;
    private final static int RECTANGLE = 3;

    public DrawPanel( JLabel label){
        statusLabel = label;
        shapes = new MyShape[100];
        shapeCount = 0;
        shapeType = LINE;
        currentShape = null;
        filledShape = false;
        currentColor = Color.BLACK;
        setBackground(Color.WHITE);

        //add(statusLabel);


        addMouseListener(new handler());
        addMouseMotionListener(new handler());

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(currentShape != null){
            if(currentShape instanceof MyRectangle){
                MyRectangle rectangle = (MyRectangle) currentShape;
                rectangle.setFilled(filledShape);
                rectangle.draw(g);
            }
            else if(currentShape instanceof MyOval){
                MyOval oval = (MyOval) currentShape;
                oval.setFilled(filledShape);
                oval.draw(g);
            }
            else {
                currentShape.draw(g);
            }
        }

            for(int i = 0; i < shapeCount; i++){

                shapes[i].draw(g);
            }


    }

    public void setShapeType(int shapeType){ //sets shape type

        this.shapeType = shapeType;
    }

    public void setCurrentColor(Color currentColor){ //sets current color
        this.currentColor = currentColor;
    }

    public void setFilledShape(boolean filledShape){ //sets whether filled or not
        this.filledShape = filledShape;
    }

    public void clearLastShape(){ //clears the last
        shapeCount = Math.max((shapeCount - 1), 0);
        repaint();


    }
    public void clearDrawing(){ //removes all shapes in the current drawing
        shapeCount = 0;
        repaint();
    }

    private class handler extends MouseAdapter implements MouseMotionListener{
        @Override
        public void mouseDragged(MouseEvent e) {
            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());
            repaint();
            statusLabel.setText("Position X:"+ e.getX() + " " + "Position Y:"+e.getY());





        }

        @Override
        public void mouseMoved(MouseEvent e) {
            statusLabel.setText("Position X:"+ e.getX() + " | " + "Position Y:"+e.getY());
            repaint();

        }

        @Override
        public void mousePressed(MouseEvent e) {

            switch (shapeType) {
                case LINE -> currentShape = new MyLine();
                case OVAL -> currentShape = new MyOval();
                case RECTANGLE -> currentShape = new MyRectangle();
            }

            currentShape.setX1(e.getX());
            currentShape.setY1(e.getY());
            currentShape.setColor(currentColor);
            repaint();


        }

        @Override
        public void mouseReleased(MouseEvent e) {

            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());


            shapes[shapeCount] = currentShape;

            //set currentShape to null


            //increment the number of shapes drawn


            //refresh panel

            ++shapeCount;
            currentShape = null;
            repaint();

        }
    }

}
