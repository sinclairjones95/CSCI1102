/*
 CurveBall -- Subclass of Ball. The ball moves in a curved path
 
 author: Richard Jones
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CurveBall extends Ball 
  implements ActionListener{
  
    CurveBall(int width, int height){
      super(width, height);
    }
    
   double curvature = 18;
   public void move(){
     super.move();
     xvelocity -= yvelocity/curvature;
     yvelocity += xvelocity/curvature;
   }
    
   
}
 
