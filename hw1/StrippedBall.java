/*
 StrippedBall -- Subclass of Ball. A stripped ball that behaves normally (Random color for stripe and random color of ball)
 author: Richard Jones
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class StrippedBall extends Ball 
  implements ActionListener{
  
    StrippedBall(int width, int height){
      super(width, height);
    }
    
    Color colorS = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
    
    public void draw(Graphics g){
      super.draw(g);
      g.setColor(color);
      g.fillOval(xpos,ypos,diameter,diameter);
      g.setColor(colorS);
      g.fillRect(xpos, ypos+(diameter/2)-(diameter/14), diameter, diameter/7);
      
   }
    
    public void move(){
     super.move();
   }
    
}