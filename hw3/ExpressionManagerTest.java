import junit.framework.TestCase;
import java.util.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ExpressionManagerTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testExpressionManager() {
    
    ArrayList<Token> postfix = new ArrayList<Token>();
    postfix.add(new Number(37));
    Expression e1 = ExpressionManager.buildExpression(postfix);
    assertEquals("build test 1",37,e1.valueOf());
    postfix.clear();
    postfix.add(new Number(20));
    postfix.add(new Number(13));
    postfix.add(new Operator("*"));
    Expression e2 = ExpressionManager.buildExpression(postfix);
    assertEquals("build test 2",260,e2.valueOf());
    
    List<Token> infix = new ArrayList<Token>();
    infix.add(new Number(20));
    infix.add(new Number(13));
    infix.add(new Operator("-"));
    List<Token> postfixx = ExpressionManager.infixToPostfix(infix);
    Expression e22 = ExpressionManager.buildExpression(postfixx);
    assertEquals("build test2",7,e22.valueOf());
    infix.clear();
    infix.add(new Number(2));
    infix.add(new Number(3));
    infix.add(new Operator("^"));
    List<Token> postfixxx = ExpressionManager.infixToPostfix(infix);
    Expression e23 = ExpressionManager.buildExpression(postfixxx);
    assertEquals("build test3",8,e23.valueOf());
    
  }
  
}
