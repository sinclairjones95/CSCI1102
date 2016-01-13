/*
 BlinkBall -- Subclass of Ball. The ball blinks in random colors periodically
 author: Richard Jones
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class BlinkBall extends Ball 
  implements ActionListener{
  
    BlinkBall(int width, int height){
      super(width, height);
      
    }
    
    public void move(){
     super.move();
     color=new Color((float)Math.random(),(float)Math.random(),(float)Math.random());           //changes to a random color each time it moves
   }
    
}