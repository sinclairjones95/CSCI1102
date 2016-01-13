/*
 SpeedingBall -- Subclass of Ball. The ball speeds up randomly at first, and then geometrically.
 author: Richard Jones
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SpeedingBall extends Ball 
  implements ActionListener{
  
    SpeedingBall(int width, int height){
      super(width, height);     
    }
    
    public void move(){
     super.move();
     if (xvelocity<15) {
       xvelocity += Math.random();
     }
     else {
       xvelocity = xvelocity*1.04;
     }
     if (yvelocity<15){
       yvelocity += Math.random();
     }
     else{
       yvelocity = yvelocity*1.04;
     }
     
   }
    
}