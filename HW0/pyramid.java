import java.util.Scanner;
import java.io.*;

public class pyramid {
  static public void main(String [ ] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the height of the pyramid: "); 
    int height = input.nextInt();
    
    if (height>0){                          // the program is checking if the integer is positive
      for (int i=0; i < height; i++){       // The program will loop for the number especified by the hight
        String ast= "";
          for (int j=0; j< (i+1); j++){     // concatinating the number of asterics in each row of the pyramid
            ast = ast + "* ";
          }
          for (int k=0; k < (height - i); k++){   // concatinating the number of spaces before the first asterics in each row of the pyramid
            ast = " " + ast;
          }
      
        System.out.println(ast);
      }
    
    }
    else {
      System.out.println("You must provide a positive number");
      
    }
  }
}