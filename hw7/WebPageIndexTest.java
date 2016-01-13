import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class WebPageIndexTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testWebPageIndex(){
    WebPageIndex wpi = new WebPageIndex("http://www.bc.edu");
    
    int count1 = wpi.getCount("College");
    int wordCount = wpi.numWords;
    System.out.println("'College' count: " + count1);
    System.out.println("Number of words: " + wordCount);
    System.out.println("value for left: " + wpi.treeMap.left.value);
    System.out.println("key for left: " + wpi.treeMap.left.key);
    System.out.println(wpi.getCount("content"));
    assertEquals("checking getCount", wpi.getCount("Content"), 1);
    assertTrue("checking contains", wpi.contains("only"));
    System.out.println(wpi.getFrequency("college"));
    double freq = (double)count1/wordCount;
    assertEquals("checking frequency", wpi.getFrequency("college"), freq);
    System.out.println("'College' locations: " + wpi.getLocations("college"));
    assertEquals("Size of list for locations must be equal to count1", wpi.getLocations("College").size(), count1);
    assertEquals("Checking for an empty list", wpi.getLocations("SinclairJonesForTheWorld"), null);
    
    
// contains phrase
    System.out.println("Woods: " + wpi.getLocations("Woods"));
    System.out.println("College: " + wpi.getLocations("College"));
    System.out.println("of: " + wpi.getLocations("of"));
    System.out.println("Advancing: " + wpi.getLocations("Advancing"));
    System.out.println("Studies: " + wpi.getLocations("Studies"));
    
    assertTrue("testing contains phrase", wpi.containsPhrase("Woods College of Advancing Studies"));
    System.out.println(wpi.getPhraseCount("of the"));
  }
  
}
