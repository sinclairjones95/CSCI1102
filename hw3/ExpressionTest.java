import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ExpressionTest extends TestCase {

  
  public void testExpression() {
    Expression e1 = new Number(46);
    assertEquals("e1",46,e1.valueOf());
    Expression e2 = new BinaryExpression(new Operator("*"),new Number(23),new Number(100));
    assertEquals("e2",2300,e2.valueOf());
    Expression e3 = new BinaryExpression(new Operator("+"),e2,e1);
    assertEquals("e3",2346,e3.valueOf());
    
    Expression e4 = new BinaryExpression(new Operator("/"), e3, e3);
    assertEquals("e4",1,e4.valueOf());
    
    assertEquals("e3 infix", "((23*100)+46)", e3.toInfix());
    assertEquals("e3 prefix", "+ * 23 100 46", e3.toPrefix());
    assertEquals("e3 Postfix", "23 100 * 46 +", e3.toPostfix());
    assertEquals("e3 toString", "((23*100)+46)", e3.toString());
  }
}
