

public interface Rational {   
    //  public RationalC(int numerator, int denominator);
    //  public RationalC(int numerator);  //  if only the numerator is given, let the denominator be 1.
    
    public int getNumerator();
    public int getDenominator();
    public Rational add(Rational other);   
    public Rational multiply(Rational other);
    public int compareTo(Rational other);
    public boolean equals(Object other);
    public String toString();
 }