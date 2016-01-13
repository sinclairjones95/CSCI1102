import java.util.*;
import java.io.*;

/*
 * 
 * Written by: Richard S. Jones and Jacob Martz
 * 
 * 
 */

public class Encode{
  
  public static void main(String[] args){
    
    Scanner scanner= null;
    try{
          scanner = new Scanner(new File(args[0]));
    }
    catch(IOException e){
        System.out.println(e+args[0]);
        System.exit(0);
    }
    
    Map<Character, Double> hashMapFreq = new HashMap<Character, Double>();
    
    while(scanner.hasNext()){
        char s = (char) scanner.nextInt();
        double d = scanner.nextDouble();
        hashMapFreq.put(s,d);
    }
    
    
    HuffmanCode huffmanCode = new HuffmanCode(hashMapFreq);
    
    System.out.println("Write a message to encode:");
    
    Scanner input = new Scanner(System.in);

    while(input.hasNextLine()){

      String line = input.nextLine();

      line = line +"\n";
      String encode = huffmanCode.encode(line);

      
      System.out.println(encode);
      
    }
    
    
    
  }
  
}