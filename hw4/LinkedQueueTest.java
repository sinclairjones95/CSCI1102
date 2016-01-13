import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 * 
 * Author: Richard S. Jones
 */
public class LinkedQueueTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  @SuppressWarnings("unchecked")
  public void testLinkedQueue() {
    
    String a ="First";
    int b = 23;
    String c = "Test string";

    
    LinkedQueue testQueue = new LinkedQueue();
     
    testQueue.enqueue(a);
    
    Object x = testQueue.dequeue();
    
    assertTrue("First Queue", x==("First"));
    testQueue.enqueue(a);
    testQueue.enqueue(b);
    testQueue.enqueue(c);
    Object y = testQueue.dequeue();
    Object z = testQueue.dequeue();
    Object last = testQueue.dequeue();     //after this dequeue, the testQueue is empty
    assertTrue("Testing multiple enqueues", y==("First"));
    assertEquals("Testing multiple dequeues", 23, z);
    assertTrue("Testing multiple enqueues", last==("Test string"));
    assertTrue("Testing the isEmpty method", testQueue.isEmpty()==true);

  }
  
}
