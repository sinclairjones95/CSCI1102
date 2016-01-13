import java.util.*;
import java.io.*;

class ProcessQueries {
  ArrayList<WebPageIndex> urlArray = new ArrayList<WebPageIndex>();
  
  ProcessQueries (List urlList){
    for (Object url : urlList){
      try {
        WebPageIndex idx = new WebPageIndex( (String)url);
        urlArray.add(idx);
      } catch (IOException e){
       System.out.println("Error reading URL: "+url+" ("+e.getMessage()+")");
      }
    }
  }
  
  public static void main(String[] args) {
    List<String> listUrl = new LinkedList<String>();  //creates empty list
    for (int i=0; i<args.length; i++){                //copies the array input into the list
      listUrl.add(args[i]);
    }
    
    ProcessQueries processQ = new ProcessQueries(listUrl);   //constructs a ProcessQueries
    System.out.println("Search: ");                          //requests the user for a seach query
    Scanner scanner = new Scanner(System.in);
    List<String> query = new LinkedList<String>();           //creates an empty list for the query
    while(scanner.hasNext()){
      String s = scanner.next();
      query.add(s);
    }
    
    URLScorer urlScorer = new URLScorer(query);
    MyPriorityQueue<WebPageIndex> priorityQueue = new MyPriorityQueue<WebPageIndex>(urlScorer);
    
    for (int j=0; j<processQ.urlArray.size(); j++){
      priorityQueue.add(processQ.urlArray.get(j));
    }
    
    System.out.println("Printing the url by score");
    while (!priorityQueue.isEmpty()){
      WebPageIndex wpi = priorityQueue.remove();
      System.out.println("(Score: " + urlScorer.score(wpi) + ") \r" + wpi.url);
    }
      
    
  }
  
  
}