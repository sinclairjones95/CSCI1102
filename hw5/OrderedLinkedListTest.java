import junit.framework.TestCase;
import java.util.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */

/*
 * 
 * Author Richard S. Jones
 * 
 */

public class OrderedLinkedListTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testOrderedLinkedList() {
    int iterate = 50; 
    OrderedLinkedList<Double> list= new OrderedLinkedList<Double>();
    ArrayList<Double> list2 = new ArrayList<Double>();
    
    assertTrue("The list is empty right now, should be true", list.isEmpty());
    
    for (int i=0; i<iterate; i++){
      double val = Math.random();
      System.out.println(""+val);         //used for debugging purposes, to know what's being compared
      list.add(val);
      list2.add(val);
    }
    
    assertFalse("The list is empty right now, should be true", list.isEmpty());   //the list is not empty
    
    Collections.sort(list2);
    for (int j=0; j<iterate; j++){
      assertEquals("Checking if the elements in Ordered list and arraylist are the same", list2.get(j), list.remove(0));   //this tests the add and remove method
    }
    
    assertTrue("The list is empty right now, should be true", list.isEmpty());     //list is empty again
    
    double x = 1.56;
    list.add(x);
    assertTrue("Checking if list contains 1.56", list.contains(x));
    assertFalse("Checking if list contains 2.56", list.contains(2.56));
    
    assertEquals("Checking the index method", 0, list.indexOf(x));
    assertTrue("checking the remove(object)", list.remove(x));   //the list should now be empty
    
    assertTrue("The list is empty right now, should be true", list.isEmpty()); 
    
  }
}
