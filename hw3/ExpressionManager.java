import java.util.*;
   
class ExpressionManager {
   
    public static List<Token> infixToPostfix(List<Token> list){
       Stack<Operator> workst = new Stack<Operator>();      // work stack
       ArrayList<Token> postfixList = new ArrayList<Token>();        //postfixList of tokens
       int leftbrack = 0;
       int rightbrack = 0;
       while (list.isEmpty()==false){
         Token x = list.remove(0);
         if (x.isNumber()==true){
           postfixList.add(x);
         }
         if (x.equals("(")){
             workst.push((Operator)x);
             leftbrack++;
         }
         else if (x.equals(")")){
             while ((workst.peek()).equals("(")==false){
               Operator previous = workst.pop();
               postfixList.add(previous);
             }
             workst.pop();
             rightbrack++;
         }
         else if (x.isOperator()==true){
             Operator y = (Operator)x;
             while ((workst.isEmpty()==false)&&((workst.peek()).getPriority()>=(y.getPriority()))){
               Operator previous = workst.pop();
               postfixList.add(previous);
             }
             workst.push(y);
         }
           
        }
        while (workst.isEmpty()==false){
           Token a = workst.pop();
           postfixList.add(a);
        }
        
        if (leftbrack!=rightbrack){
          throw new ArithmeticException("Mismatched parenthesis");
        }

       
       
    return postfixList;
    }
    
    public static Expression buildExpression(List<Token> postfixList){
      Stack<Expression> workst = new Stack<Expression>();    //Work stack
      
      while (postfixList.isEmpty()==false){  //will loop while the list still has tokens
        Token x = postfixList.remove(0); //will remove the token in the first slot of the list
        if (x.isNumber()==true){      //cheking if it is a number
          Number y = (Number)x;
          workst.push(y);            //pushes the number into the working stack
        }
        else if (x.isOperator()==true){    //check if it is an operator
          Operator y = (Operator)x;
          Number a = (Number)workst.pop();
          Number b = (Number)workst.pop();
          Expression result = new BinaryExpression(y, b, a);  
          workst.push(result);   //pushes the new number into the stack
        }
        else{    //if it is neither an operator nor a number
          throw new RuntimeException("Not an operator or a Number");
        }
      
      }
      Expression retE = workst.pop();
    return retE;
    }
       
}
