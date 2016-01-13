/**
 * This class contains the code to compute the relevance score of a
 * web page, in response to a query.  It also contains a method to
 * compare the scores of two web pages.
 *
 * @author John Donaldson (Fall 2014)
 */

/*
 * 
 * Edited by: Richard Jones
 * 
 */

import java.util.*;

class URLScorer implements Comparator<WebPageIndex> {

   List<String> query;
   
   URLScorer(List<String> query){
      this.query = query;
   }
   
   public int score(WebPageIndex idx){ 
     int countWords = 0;
     for (String s : query){
       countWords+=idx.getCount(s);         //counts the freq for each word in the query
     }
     return countWords;
   }
      
    public int compare(WebPageIndex idx1, WebPageIndex idx2){ 
      if ( score(idx1) > score(idx2) ){
        return 1;
      }else if ( score(idx1) == score(idx2)){
       return 0;
      } else {
        return -1;
      }
    }

}
