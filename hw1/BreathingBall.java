/*
 CurveBall -- Subclass of Ball. The ball's radius changes as it moves
 
 author: Richard Jones
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class BreathingBall extends Ball 
  implements ActionListener{
  
    BreathingBall(int width, int height){
      super(width, height);
    }
    
    int growth = 15;
    public void move(){
     int growth = (int)(12*Math.random());
     super.move();
     if (diameter<75) {   //depending on the ball size, ball will either expand or contract
       diameter+=growth;
     }
     else {
       diameter-=growth;
     }     
    }
 
}