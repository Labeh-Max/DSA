package solution_gui.caseStudyGraphics;

import java.awt.*;

public abstract class MyBoundedShape extends MyShape{

    private boolean isFilled;

    public MyBoundedShape(){
        super();
        isFilled = false;
    }
    public MyBoundedShape(int x1, int y1, int width, int height, Color color, boolean filled){
        super(x1, y1, width, height, color);

        isFilled = filled;
    }

    public void setFilled(boolean filled){
        isFilled = filled;
    }

    public boolean getFilled(){
        return isFilled;
    }

    public int getUpperLeftX(){
        int upperLeftX = getX1();
        if(getX2() < getX1()){
            upperLeftX = getX2();
            return upperLeftX;
        }
        return upperLeftX;
    }

    public int getUpperLeftY(){
        int upperLeftY = getY1();
        if(getY2() < getY1()){
            upperLeftY = getY2();
            return upperLeftY;
        }
        return upperLeftY;
    }

    public int getWidth(){
        return Math.abs(getX1()-getX2());
    }

    public int getHeight(){
        return Math.abs(getY1()-getY2());
    }
}
