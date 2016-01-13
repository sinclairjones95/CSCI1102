public class BinaryExpression implements Expression{
  
  Expression left;
  Expression right;
  Operator sign;
  public BinaryExpression(Operator sign, Expression left, Expression right){
    
    this.left = left;
    this.right = right;
    this.sign = sign;
    
  }
  
  public int valueOf(){            //returns the value for the operation of the two numbers 
      int result;
      int resultleft = left.valueOf();
      int resultright = right.valueOf();
      result = sign.apply(resultleft, resultright);
      return result;
  }
  
  public String toPostfix(){  //postix representation of the operation
    String leftr = left.toPostfix();
    String rightr = right.toPostfix();
    return (leftr + " " + rightr + " " + sign);
  }
  
  public String toPrefix(){         //prefix representation of the operation
    String leftr = left.toPrefix();
    String rightr = right.toPrefix();
    return (sign + " " + leftr + " " + rightr);
  }
  
  public String toInfix(){          //infix representation of the operation
    String leftr = left.toInfix();
    String rightr = right.toInfix();
    return ("("+leftr+sign+rightr+")");
  }
  
  public String toString(){      //calls the toPrefix function to return the same string
    return toInfix();
  }
}