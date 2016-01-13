/*
 ChangeBall -- Subclass of Ball. The ball grows arithmetically
 author: Richard Jones
*/


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ChangeBall extends Ball 
  implements ActionListener{
  int growth = (int)(10*Math.random());
    ChangeBall(int width, int height){
      super(width, height);      
    }
    
    public void move(){
     super.move(); 
     diameter = diameter + growth;
   }
    
}