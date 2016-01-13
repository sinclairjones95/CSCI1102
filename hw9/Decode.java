import java.util.*;
import java.io.*;


/*
 * 
 * Written by: Richard S. Jones and Jacob Martz
 * 
 * 
 */
public class Decode{
  
  public static void main(String[] args){
    
    Scanner scanner= null;
    try{
          scanner = new Scanner(new File(args[0]));        //takes input file with scanner
    }
    catch(IOException e){
        System.out.println(e+args[0]);
        System.exit(0);
    }
    
    Map<Character, Double> hashMapFreq = new HashMap<Character, Double>();   //creates a Map for the frequency
    
    while(scanner.hasNext()){             //builds the map with the file given
        char s = (char) scanner.nextInt();
        double d = scanner.nextDouble();
        hashMapFreq.put(s,d);
    }
    
    
    HuffmanCode huffmanCode = new HuffmanCode(hashMapFreq);   //creates the Huffman Code with the Frequency map
    
    System.out.println("Write an encoded message to decode:");
    
    Scanner input = new Scanner(System.in);
      System.out.println("I'm here1");
    while(input.hasNext()){
      System.out.println("I'm here");
      String line = input.next();
      
      String decode = huffmanCode.decode(line);    //decodes the code given and returns a string
      
      System.out.println(decode);     //prints out decoded messay
      
    }
    
  }
  
}