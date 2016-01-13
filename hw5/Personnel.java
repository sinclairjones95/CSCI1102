/*
 * 
 * Edited by: Richard S. Jones
 * 
 */

class Personnel implements Comparable<Personnel> {
   String ssn;
   String first;
   String last;
   
   Personnel(String ssn, String first, String last){
      this.ssn = ssn;
      this.first = first;
      this.last = last;
   }
   
   public int compareTo(Personnel other){
     int a = Integer.parseInt(this.ssn);
     int b = Integer.parseInt(other.ssn);
     if (a>b){
       return 1;
     }
     else if (a==b){
       return 0;
     }
     else {
       return -1;
     }
   }
   
   public String toString(){
      return ssn+" "+last+", "+first;
   }
   
}
