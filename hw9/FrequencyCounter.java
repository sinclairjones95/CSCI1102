/*
 FrequencyCounter

 This program reads a file of text and creates a table of the
 frequencies of each character in the file.  The file name is 
 optionally specified as a command-line argument; if the name
 is not present, the program reads from System.in.  The table
 is written to System.out.  On each line of the output is an
 integer representing the ASCII code of a character, followed
 by a floating point number indicating the relative frequency
 of that character.

 Usage:  java FrequencyCounter input-file
   or
         java FrequencyCounter < input-file

 Note:  Any character in the range 0-127 that does not appear
 in the input is given a small non-zero frequency.

 @author John Donaldson
  */
import java.util.*;
import java.io.*;

public class FrequencyCounter {

    public static void main(String[] args) throws IOException {
 // create a TreeMap for to count frequencies
       Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
       InputStream fis; // either args[0] or System.in
       
       if(args.length<1) {
          fis = System.in;
       }
       else {
          fis = new FileInputStream(new File(args[0]));
       }
       
       // the following loop reads one character at a time
       // and counts it
       int ch;
       int n = 0;
       while((ch=fis.read())>=0){
          Integer count = map.get(ch);
          if(count==null)
             map.put(ch,1);
          else
             map.put(ch,count+1);
          n++;
       }

       // how many characters never appear in the input?
       int unusedct = 0;
       for(int c=0; c<128; c++){
    if(map.get(c)==null)
        unusedct++;
       }

       // compute the relative frequency of each character
       // and write to System.out
       double flen = (double)(n+1);
       for(int key=0; key<128; key++){
    Integer count = map.get(key);
    if(count==null)
        System.out.println(key+" "+1/flen/unusedct);
    else
        System.out.println(key+" "+count/flen);
       }       
    }
    
}
