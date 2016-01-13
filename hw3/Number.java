public class Number implements Token, Expression {
   
   int number;
   
   public Number(int number){
      this.number = number;
   }
      
   public boolean isNumber(){
      return true;
   }
   
   public boolean isOperator(){
      return false;
   }
   
   public int valueOf(){
     return number;
   }
   
   public String toPrefix(){
     return (""+number);
   }
   
   public String toInfix(){
     return (""+number);
   }
   
   public String toPostfix(){
     return (""+number);
   }
   
   public String toString(){
     return (""+number);
   }
   
   
}