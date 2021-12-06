package solution_gui.caseStudyGraphics;

import java.awt.*;

public class MyRectangle extends MyBoundedShape{

    //no argument constructor
    public MyRectangle(){
        super(); //call to superclass no argument constructor
    }

    public MyRectangle(int x1, int y1, int width, int height, Color color, boolean isFilled){
       super(x1, y1, width, height, color, isFilled);
    }

    //Draw the rectangles in the specified color
    @Override
    public void draw(Graphics g){
        g.setColor(getColor());
        if(getFilled()){
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
        }else{
            g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
        }

    }//end method draw


}
