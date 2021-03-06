import java.util.*;
import java.io.*;

/*
 * 
 * Author Richard S. Jones
 * 
 */
public class Reader {
   static public void main(String[] args) throws IOException {
      Scanner scanner = null;
      
      OrderedLinkedList<Personnel> orderedList1 = new OrderedLinkedList<Personnel>(new PersonnelComparator());
      OrderedLinkedList<Personnel> orderedList2 = new OrderedLinkedList<Personnel>();
      
      if(args.length>0){
         scanner = new Scanner(new File(args[0]));
      }
      else {
         scanner = new Scanner(System.in);
      }
      
      while (scanner.hasNext()){     //for each person
        String x ="";
        while(scanner.hasNext()){    //for SSN
          String val = scanner.next();
          if (val.equals(" ")){
            break;
          } else{
            x = x+val;
          }
          break;
        }
        String y = "";
        while(scanner.hasNext()){    //for last name
          String val = scanner.next();
          if (val.equals(" ")){
            break;
          }else {
            y = y+val;
          }
          break;
        }
        String z = " ";
        while(scanner.hasNext()){      //For first 
          String val = scanner.next();
          if (val.equals(" ")){
            break;
          } else {
            z = z+val;
          }
          break;
        }
        
        orderedList1.add(new Personnel(x, z, y));      //(ssn, first, last)
        orderedList2.add(new Personnel(x, z, y));
        
      }
      System.out.println("Printing OrderedLinkedList with Comparator");
      int i=1;
      while (!orderedList1.isEmpty()){
        Personnel information = orderedList1.remove(0);
        String output = information.toString();
        System.out.println(output);
        i++;
      }
      
      System.out.println("Printing OrderedLinkedList without Comparator");
      while (!orderedList2.isEmpty()){
        Personnel information = orderedList2.remove(0);
        String output = information.toString();
        System.out.println(output);
      }
   }
}