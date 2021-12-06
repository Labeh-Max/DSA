package solution_gui.caseStudyGraphics;
import java.awt.*;

public class MyOval extends MyBoundedShape{


    //no argument constructor
    public MyOval(){
        super(); //call to superclass no argument constructor
    }

    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean isFilled){
        super(x1, y1, x2, y2, color,isFilled);

    }

    //draw Oval shape
    @Override
    public void draw(Graphics g){
        g.setColor(getColor());

        if(getFilled()){
            g.fillOval(getX1(), getY2(), getWidth(), getHeight());
        }else{
            g.drawOval(getX1(), getY2(), getWidth(), getHeight());
        }

    }


}
