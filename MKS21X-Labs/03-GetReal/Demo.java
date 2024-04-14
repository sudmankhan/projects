public class Demo {
  public static void main(String[] args) {
    RealNumber a = new RealNumber(2.4);
    RealNumber b = new RealNumber(2.4);
    RationalNumber c = new RationalNumber(5,10);
    RationalNumber d = new RationalNumber(5,10);
    RationalNumber e = new RationalNumber(5,11);
    System.out.println(a.add(b));
    System.out.println(a.subtract(b));
    System.out.println(a.multiply(b));
    System.out.println(a.divide(b));
    System.out.println(c.getValue());
    System.out.println(c.reciprocal().getValue());
    System.out.println(c.equals(d));
    System.out.println(c.equals(e));
    System.out.println(c.toString());
    System.out.println(c.multiply(d));
    System.out.println(c.divide(d));
    System.out.println(c.add(e));
    System.out.println(c.subtract(e));
    System.out.println(gcd(45, 210));
    System.out.println(gcd(210, 45));
    System.out.println(a.compareTo(b));
  }

  public static int gcd(int a, int b){
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

}
