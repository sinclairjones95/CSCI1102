import junit.framework.TestCase;
import java.util.*;
/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class RationalTest extends TestCase {
 
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testRationalC() {
    Rational test = new RationalC(10,3);
    assertEquals("Numerator after construction of 10/3", 10, test.getNumerator());
    assertEquals("Denominator after construction of 10/3", 3, test.getDenominator());
    test = new RationalC(10,2);
    assertEquals("Numerator after construction of 10/2", 5, test.getNumerator());
    assertEquals("Denominator after construction of 10/2", 1, test.getDenominator());
  }
  public void testCompareTo(){
    Rational a = new RationalC(2,3);
    Rational b = new RationalC(3,5);
    Rational c = new RationalC(2,3);
    Rational d = new RationalC(30,50);
    
    assertTrue("compare 2/3, 3/5", a.compareTo(b) > 0);
    assertTrue("compare 3/5, 2/3", b.compareTo(a) < 0);
    assertTrue("compare 2/3, 2/3", a.compareTo(c) == 0);
    assertTrue("compare 3/5, 30/50", b.compareTo(d) == 0);
    assertTrue("compare 30/50, 3/5", d.compareTo(b) ==0 );
  }
  
  public void testAdd(){
    Rational a= new RationalC(2,4);
    Rational b= new RationalC(3,-6);
    Rational c= new RationalC(21,100);
    
    assertEquals("Sum of 2/4 and -3/6 numerator", 0 , (a.add(b)).getNumerator());
    assertEquals("Sum of 2/4 and -3/6 denominator", 1 , (a.add(b)).getDenominator());
    assertEquals("Sum of -3/6 and 21/100 numerator", -29 , (b.add(c)).getNumerator());
    assertEquals("Sum of -3/5 and  21/100 denominator", 100 , (b.add(c)).getDenominator());
    
    ArrayList<Rational> testa= new ArrayList<Rational>();
    
    Rational sum = new RationalC(0,1);
    for (int i=1; i<10; i++){
      Rational temp = new RationalC(i, i+1);
      sum = temp.add(sum);
    }
    
    assertEquals("Sum of ArrayList numerator", 17819 , sum.getNumerator());
    assertEquals("Sum of ArrayList denominator", 2520 , sum.getDenominator());
    
  }
  
  public void testMultiply(){
    Rational a= new RationalC(2,4);
    Rational b= new RationalC(3,-6);
    Rational c= new RationalC(21,100);
    
    assertEquals("Multiplication of 2/4 and -3/6 numerator", -1 , (a.multiply(b)).getNumerator());
    assertEquals("Multiplication of 2/4 and -3/6 denominator", 4 , (a.multiply(b)).getDenominator());
    assertEquals("Multiplication of -3/6 and 21/100 numerator", -21 , (b.multiply(c)).getNumerator());
    assertEquals("Multiplication of -3/5 and  21/100 denominator", 200 , (b.multiply(c)).getDenominator());
    
    ArrayList<Rational> testa= new ArrayList<Rational>();
    
    Rational multi = new RationalC(1,1);
    for (int i=1; i<10; i++){
      Rational temp = new RationalC(i, i+1);
      multi = temp.multiply(multi);
    }
    
    assertEquals("Multiplication of ArrayList numerator", 1 , multi.getNumerator());
    assertEquals("Multiplication of ArrayList denominator", 10 , multi.getDenominator());
    
  }
  
  public void testToString(){
    Rational a= new RationalC(2,4);
    Rational b= new RationalC(3,-6);

    assertTrue("Transforming Rational number to string", (a.toString()).equals("1 / 2") );
    assertTrue("Transforming Rational number to string", (b.toString()).equals("-1 / 2") );
  }
  
  public void testEquals(){
    Rational a= new RationalC(2,4);
    Rational b= new RationalC(3,-6);
    Rational c= new RationalC(2,4);
    
    assertTrue("Checking if two numbers are equal to each other", (a.equals(b))==false );
    assertTrue("Checking if two numbers are equal to each other", (a.equals(c))==true );
  }
}
