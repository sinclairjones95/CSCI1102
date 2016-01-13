/* This ADT will get a numerator and denominator, transform it to its reduced form. 
 * 
 * 
 * Author: Richard S. Jones
*/



import java.io.*;

class RationalC implements Rational{
  private int d;
  private int n;
  
  public RationalC (int numerator, int denominator){   //main method

    if (denominator == 0) {
           throw new RuntimeException ("Zero denominator - math error");
    }
    
    int factor = getFactor(numerator, denominator);
    
    n = numerator/factor;
    d = denominator/factor;
    
  }
  
  public RationalC (int numerator){           //main method when there's no given denominator
    
    n = numerator;
    d = 1;
    
  }
  
  public int getFactor(int num, int den){         //function to get the gcd
    if (0 == den){
      return num;
    }
    else {
      return getFactor(den, num % den);
    }
  }
  
  public boolean equals(Object other){
    if (other instanceof Rational){
      Rational otherR=(Rational)other;
      int num = otherR.getNumerator();
      int den = otherR.getDenominator();
      if ((num==this.n)&&(den==this.d)){
        return true;
      }
      else{
        return false;
      }
    }
    else {
      return false;
    }
    
  }
  
  public Rational add(Rational other){         //this function adds two rational numbers
    int numerator;
    int denominator;
    int num = other.getNumerator();
    int den = other.getDenominator();
    
    denominator = this.d*den;
    numerator = this.n*den + num*this.d;
    
    return new RationalC(numerator, denominator);     //return new values
  }
  
  public int compareTo(Rational other){       //this function compares two rational numbers
    int num = other.getNumerator();
    int den = other.getDenominator();
    
    int thisra = this.n*den;
    int otherra = num*this.d;
    
    if (thisra>otherra){
      return 1;
    }
    else if (thisra==otherra){
      return 0;
    }
    else{
      return -1;
    }
  }
  
  public Rational multiply(Rational other){      //this function compares two rational numbers
    int numerator;
    int denominator;
    int num = other.getNumerator();
    int den = other.getDenominator();
    
    numerator = this.n*num;
    denominator = this.d*den;
    return new RationalC(numerator, denominator);  // returns new values for the numerator and denominator
  }
  
  public String toString(){            //transforms the rational number into a string
    
    if (d<0){
      d=-d;
      n=-n;
    }
    
    if (n==0){
      return ("0 / 1");
    }
    else{
      return (n + " / " + d);
    }
    
  }
  
  public int getNumerator(){            //returns the numerator
    if (d>0){
      return n;
    }
    else {
      return -n;
    }
  }
  
  public int getDenominator(){          //returns the denominator
    if (d>0){
      return d;
    }
    else {
      return -d;
    }
  }
  
}