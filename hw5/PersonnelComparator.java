import java.util.*;
/*
 * 
 * Author: Richard S. Jones
 * 
 */
class PersonnelComparator implements Comparator<Personnel> {
   public int compare(Personnel p1, Personnel p2){
      int ssn1 = Integer.parseInt(p1.ssn);
      int ssn2 = Integer.parseInt(p2.ssn);
      if (ssn1>ssn2){
        return 1;
      }
      else if (ssn1==ssn2){
       return 0;
     }
      else{
        return -1; 
      }
   }
}
            