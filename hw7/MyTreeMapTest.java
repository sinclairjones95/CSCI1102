import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class MyTreeMapTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testMyTreeMap() {
    
    MyTreeMap<Integer, String> mainTree = new MyTreeMap<Integer, String>(1, "a");
    
    mainTree.put(2, "b");
    mainTree.put(3, "c"); //                    4
    mainTree.put(4, "d"); //             2             6
    mainTree.put(5, "e"); //          1     3       5     7
    mainTree.put(6, "f"); //                                8
    mainTree.put(7, "g");
    mainTree.put(8, "h");
    assertEquals("Tree Height", 3, mainTree.getHeight());
    assertEquals("left.right", 3, (int)mainTree.left.right.key);
    assertEquals("root", 4, (int)mainTree.key);
    assertEquals("right-most leaf", 8, (int)mainTree.right.right.right.key);
    assertEquals("right.left", 5, (int)mainTree.right.left.key);
    assertEquals("right.left.left.left should be empty", null, mainTree.right.left.left.key);
    assertEquals("get fuct", "d", mainTree.get(4));
    assertEquals("get function", "g", mainTree.get(7));
    
    MyTreeMap<Integer, String> secondTree = new MyTreeMap<Integer, String>(8, "h");
    
    secondTree.put(7, "g");
    secondTree.put(6, "f");  //                     5
    secondTree.put(5, "e");  //              3             7
    secondTree.put(4, "d");  //           2     4       6      8
    secondTree.put(3, "c");  //         1
    secondTree.put(2, "b");
    secondTree.put(1, "a");
    assertEquals("Tree Height", 3, secondTree.getHeight());
    assertEquals("root", 5, (int)secondTree.key);
    assertEquals("left-most", 1, (int)secondTree.left.left.left.key);
    assertEquals("right-most", 8, (int)secondTree.right.right.key);
    
    
    MyTreeMap<Integer, String> thirdTree = new MyTreeMap<Integer, String>(8, "h");
    
    thirdTree.put(1, "a");
    thirdTree.put(3, "c");  //                      5
    thirdTree.put(4, "d");  //                3           7
    thirdTree.put(5, "e");  //             1     4     6     8
    thirdTree.put(6, "f");  //               2
    thirdTree.put(7, "g");    
    thirdTree.put(2, "b");
    
     assertEquals("Tree Height", 3, thirdTree.getHeight());
     assertEquals("root", 5, (int)thirdTree.key);
     assertEquals("lowest", 1, (int)thirdTree.left.left.key);
     assertEquals("lowest level", 2, (int)thirdTree.left.left.right.key);
     assertEquals("max", 8, (int)thirdTree.right.right.key);
     assertEquals("max", 8, (int)thirdTree.right.right.key);
     
     //overwriting
     thirdTree.put(1, "overwrite");
     assertEquals("get function", "overwrite", thirdTree.get(1));
    
  }
  
}
