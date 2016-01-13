/*
 * This program computes the sum of the odd integers from 1 to 39.
 * After adding each integer, it prints the running total.
 */
public class Example3 {

   static public void main(String[] args){
      int sum=0;
      for(int i=1; i<=40; i+=2)
         sum += i;
      System.out.println("Running total = "+sum); 
      
   }
 
} 