public class makeWords {

  public static void makeWords(int size, String ans) {
    if(size == 0) {
      System.out.println(ans);
    } else {
      makeWords(size-1, ans + );
    }
  }

  public static void main(String[] args) {
    makeWords(3, "");
    for(char c = 'a'; c <= 'z'; c++) {
      System.out.print(c);
    }
    System.out.println();
  }

}
