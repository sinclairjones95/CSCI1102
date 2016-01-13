import java.util.*;
import java.util.Scanner;
import java.lang.Character;

/*
 * Author: Richard S. Jones
 */


public class RadixSort{
  @SuppressWarnings("unchecked")
  public static void main(String [ ] args){
    
    LinkedQueue<String>[] bins = new LinkedQueue[26];
    
    LinkedQueue<String> masterQueue = new LinkedQueue();
    int i=0; 
    
    int numberWords=0;
    
    System.out.print("How many words are you enterring? "); 
    Scanner number = new Scanner(System.in);
    while (number.hasNextLine()){
      String line = number.nextLine();
      Scanner s2 = new Scanner(line);
      if  (s2.hasNextInt()) {
        numberWords=s2.nextInt();
        break;
      } else{
        System.out.print("That's not a number. Try again: ");
        continue;
      }
    }
    
    while(i<numberWords){       // this program runs for the number of words specified by the user
      System.out.print("Enter a 7-letter word: "); 
      Scanner input = new Scanner(System.in);
      String x = input.nextLine();
      if (x.length()==7){
        masterQueue.enqueue(x);
        i++;
      }
      else {
        System.out.print("The word need to have 7 letters, enter a new word: "); 
        continue;
      }
    }
    int j=0;
    while(j<7){     //for each of the characters
      
      for(int x = 0; x < bins.length; x++){     //clearing all the bins
          LinkedQueue xd = bins[x];
          xd.clear();
          bins[x]=xd;
      }
      
      int k=0;
      while (k<numberWords){          //iterates for every word in the queue
          String word = masterQueue.dequeue();
          char pth = word.charAt(j);      //gets the char in the j position
          int position = (int)pth;
          bins[position-97].enqueue(word);      //enqueues them on the bin corresponding to the letter - 97 is the value of 'a'
          int h=0;
          k++;
      }
      
      int h=0; 
      while (h<26){                      
            masterQueue.append(bins[h]);
            h++;
      }    
      
      j++;
    }
      
      while (!masterQueue.isEmpty()){      //printing out the items enqueued in correct order
        String output = masterQueue.dequeue();
        System.out.println(output); 
      }
      
    }
  
  }