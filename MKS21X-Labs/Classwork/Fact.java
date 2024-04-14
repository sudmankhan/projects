public class Fact {

  public static int fact(int n){
    if (n > 0) {
     return n * fact(n-1);
    }
    return 1;
  }

  public static boolean isEven(int x) {
    if(n > 1) {
      return(isEven(x-2) == 0);
      }

  }

  public static void main(String[] args) {
    System.out.println(fact(5));
    System.out.println(fact(0));
    System.out.println(fact(10));
  }
}
