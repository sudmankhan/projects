public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    this.numerator = nume;
    this.denominator = deno;
    reduce();
  }

  public double getValue(){
    return (numerator + 0.0) / denominator;
  }

  public int getNumerator(){
    return this.numerator;
  }

  public int getDenominator(){
    return this.denominator;
  }

  public RationalNumber reciprocal(){
    RationalNumber x = new RationalNumber(this.denominator, this.numerator);
    return x;
  }

  public boolean equals(RationalNumber other){
    return this.numerator == other.numerator && this.denominator == other.denominator;
  }

  public String toString(){
    return this.numerator + "/" + this.denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    //http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    int x = a;
    int y = b;
    if (b > a) {
      x = b;
      y = a;
    }
    if ((a % b) == 0) {
      return b;
    }
    return gcd(b, a % b);
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int gcd = gcd(this.numerator, this.denominator);
    this.numerator = this.numerator / gcd;
    this.denominator = this.denominator / gcd;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    int num = this.numerator * other.numerator;
    int deno = this.denominator * other.denominator;
    RationalNumber x = new RationalNumber(num, deno);
    return x;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    RationalNumber x = other.reciprocal();
    int num = this.numerator * x.numerator;
    int deno = this.denominator * x.denominator;
    RationalNumber y = new RationalNumber(num, deno);
    return y;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    if (this.denominator == other.denominator) {
      int num = this.numerator + other.numerator;
      int deno = this.denominator;
      RationalNumber x = new RationalNumber(num, deno);
      return x;
    } else {
        int deno = this.denominator * other.denominator;
        int num = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        RationalNumber x = new RationalNumber(num, deno);
        return x;
      }
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    if (this.denominator == other.denominator) {
      int num = this.numerator - other.numerator;
      int deno = this.denominator;
      RationalNumber x = new RationalNumber(num, deno);
      return x;
    } else {
        int deno = this.denominator * other.denominator;
        int num = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        RationalNumber x = new RationalNumber(num, deno);
        return x;
      }
  }
}
