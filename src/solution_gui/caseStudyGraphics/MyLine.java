package solution_gui.caseStudyGraphics;

import java.awt.*;

public class MyLine extends MyShape {

    //no argument constructor
    public MyLine(){
        super(); //call to super class no argument constructor
    }

    //constructor with input values
    public MyLine(int x1, int y1, int x2, int y2, Color color){
    super(x1, y1, x2, y2, color); //call to superclass argument constructor;
    }//end MyLine constructor


    //Draw the line in the specified color
    @Override
    public void draw(Graphics g){
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2() );
    }//end method draw
}//end class MyLine
