/**
   This program illustrates the use of a for loop in Java.

   It computes the sums of the even and odd integers between
   0 and 99.

   @author: John Donaldson
*/
public class Example2 {

   static public void main(String[] args){
      int even=0, odd=0;
      for(int i=0; i<100; i++){
         if(i % 2 == 0){
            even += i;
         }
         else {
            odd += i;
         }
      }
      System.out.println("The sum of the even values is " + even);
      System.out.println("The sum of the odd values is " + odd);
   }
 
}