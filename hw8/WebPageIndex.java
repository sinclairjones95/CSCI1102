import java.util.*;
import java.io.*;

public class WebPageIndex {
   
   MyTreeMap<String, List<Integer>> treeMap;
   String url;
   int numWords;
   

   // WebPageIndex constructor
   WebPageIndex(String baseUrl) throws IOException{
     this.url = baseUrl;
       HTMLScanner indexScanner = new HTMLScanner(url);
       numWords = 0;
       int index = 0;
       treeMap = new MyTreeMap<String, List<Integer>>();   //initiates treeMap
       while (indexScanner.hasNext()){                           //iterate through website
         String token = indexScanner.next().toLowerCase();
         List<Integer> list = treeMap.get(token);          //gets any existing list
         if (list!=null){          //there's data already
           list.add(index);
           treeMap.put(token, list);               //overwrites existing listwith updated list
         }
         else{
           List<Integer> newList = new LinkedList<Integer>();  
           newList.add(index);
           treeMap.put(token, newList); 
         }
         numWords++;   
         index++;
       }
   }     
   
   // Returns a count of the words in this web page
   public int getWordCount() {
      //returns the wordc count in website
      return numWords;
   }
   
   public String getUrl() {
      // returns the url
      return url;
   }
   
   public boolean contains(String s) {
     return treeMap.get(s.toLowerCase())!=null;   //if the get method returns a non-null list returns true
   }
   
   public int getCount(String s) {
      List<Integer> list = treeMap.get(s.toLowerCase());
      if (list!=null)
        return list.size();
      else
        return 0;
   }
   
   public double getFrequency(String s) {       //returns correct to 1 decimal place
     double frequency = (double)getCount(s)/numWords;    //number of occurances divided by number of words
     return frequency;
   }
   
   public List<Integer> getLocations(String s) {
      List<Integer> list = treeMap.get(s.toLowerCase());      //gets value for key
      if(list!=null)      //if list is not empty
        return list;
      else
        return null;
   }

   // return an Iterator over all the words in the index
   public Iterator<String> words() {
      // returns iterator through all keys
      return treeMap.keys();
   }
   
   public String toString() {
      // returns MyTreMap's toString()
      return treeMap.toString();
   }

   // The main method is an application using a WebPageIndex
   public static void main(String[] args) throws IOException { // change this to try catch
     WebPageIndex wpi;     
     if(!(args.length>0) || (!(args[0].toLowerCase().startsWith("http://")) 
             && !(args[0].toLowerCase().startsWith("https://"))) ){     
         System.out.println("You must provide a valid URL");
         System.exit(1);
      }
      wpi = new WebPageIndex(args[0]);
      Iterator<String> iterator = wpi.words();
      
      System.out.println("Frequency and index of words in " + args[0]);
      while (iterator.hasNext()){
        String word = iterator.next();
        System.out.println(word + "\t\t\t" + wpi.getFrequency(word) + "\t" + wpi.getLocations(word));
      }

      
   }

   
   /* 
    * additional features you might add to support multi-word phrases 
    *
    * work on these after you have the previous methods working correctly
    */
   
   public boolean containsPhrase(String s) {
      Scanner scanner = new Scanner(s.toLowerCase());    // lower case
      List<Integer> previous = new LinkedList<Integer>();
      String token;
      
      while (scanner.hasNext()){   //   iterate through phrase
        token = scanner.next();
        List<Integer> list = treeMap.get(token);
        if (list!=null){
          if (previous.isEmpty()){      //previous is only empty on the first iteration
            previous = list;
          }
          else{
            List<Integer> workList = new LinkedList<Integer>();   //to add all the instances where there are subsequent words
            //iterate though list size
            for (int j=0; j<list.size(); j++){
              int a = list.remove(0);
              if (previous.contains(a - 1)){      //check if there is an index diference of 1
                workList.add(a);
              }
            }
            // after iteration work list becomes the previous list, if empty then returns false
            if(workList.isEmpty())
              return false;  //no subsequent words
            else
              previous = workList;    //previous is not empty
          }
        }
        else{      // will exit when one of the words does not exist on the treeMap
          return false;
        }
        
      }
      return true;  //if iterates through all the phrase and does not exit before
   }
   
   public int getPhraseCount(String s) {
     //same method as containsPhrase, but returns the size of the list=number of times 
      Scanner scanner = new Scanner(s.toLowerCase());    // lower case
      List<Integer> previous = new LinkedList<Integer>();
      String token;
      
      while (scanner.hasNext()){   //   iterate through phrase
        token = scanner.next();
        List<Integer> list = treeMap.get(token);
        if (list!=null){
          if (previous.isEmpty()){      //previous is only empty on the first iteration
            previous = list;
          }
          else{
            List<Integer> workList = new LinkedList<Integer>();   //to add all the instances where there are subsequent words
            //iterate though list size
            for (int j=0; j<list.size(); j++){
              int a = list.remove(0);
              if (previous.contains(a - 1)){      //check if there is an index diference of 1
                workList.add(a);
              }
            }
            // after iteration work list becomes the previous list, if empty then returns false
            if(workList.isEmpty())
              return 0;  // no subsequent words
            else
              previous = workList;    //previous is not empty
          }
        }
        else{      // will exit when one of the words does not exist on the treeMap
          return 0;
        }
        
      }
      return previous.size();
   }
   
   public double getPhraseFrequency(String s) {
      double freq = (double)getPhraseCount(s)/numWords;
      return freq;
   }

   public List<Integer> getPhraseLocations(String s) {
       //same structure as containsPhrase, but returns the index of the first word of every phrase
      Scanner scanner = new Scanner(s.toLowerCase());    // lower case
      List<Integer> initial = new LinkedList<Integer>();
      String token;
      int i = 0;
      while (scanner.hasNext()){   //   iterate through phrase
        token = scanner.next();
        List<Integer> list = treeMap.get(token);
        if (list!=null){
          if (initial.isEmpty()){      //previous is only empty on the first iteration
            initial = list;
          }
          else{
            List<Integer> workList = new LinkedList<Integer>();   //to add all the instances where there are subsequent words
            //iterate though list size
            for (int j=0; j<list.size(); j++){
              int a = list.remove(0);
              if (initial.contains(a - i)){      //check if there is an index diference of i
                workList.add(a);
              }
            }
            // after iteration work list becomes the previous list, if empty then returns false
            if(workList.isEmpty()){ //no subsequent words
              return workList;    //workList is empty, return so that iteration stops
            }
            
          }
          i++;
        }
        else{      // will exit when one of the words does not exist on the treeMap
          return new LinkedList<Integer>();   //new empty list
        }
        
      }
      return initial;
   }
   
   
}
