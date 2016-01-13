import junit.framework.TestCase;
import java.util.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class MyPriorityQueueTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testMyPriorityQueue() {
    
    MyPriorityQueue<String> queueTest = new MyPriorityQueue<String>(new StringComparator());
    
    for (int i=1; i<99; i++){
      
      queueTest.add(""+i);
      
    }

    for (int j=1; j<50; j++){
      String valueFound = queueTest.remove();
      System.out.println(valueFound + "and next: " + queueTest.heap.get(0) + " next: " + queueTest.heap.get(1));
      
      assertEquals("testing if last added element is equal to 100", valueFound, "" + (99-j));
      
    }
  

    
  }
  
}
