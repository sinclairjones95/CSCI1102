import java.util.*;
class StringComparator implements Comparator<String> {
   public int compare(String s1, String s2){
      int i1 = Integer.parseInt(s1);
      int i2 = Integer.parseInt(s2);
      if (i1>i2){
        return 1;
      } else if( i1==i2){
        return 0;
      }else{
        return -1;
      }
   }
}