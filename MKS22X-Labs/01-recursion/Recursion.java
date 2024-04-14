public class Recursion {

  public static void printAllWords(int length){
    printAllWords(length,"");
  }

  public static void printAllWords(int length,String word){
    if(length == 0) {
      System.out.println(word);
    } else {
      for(char c = 'a'; c <= 'c'; c++) {
        printAllWords(length-1, word + c);
      }
    }
  }

  public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"",letters);
  }

  public static void printNoDoubleLetterWords(int length,String word,char[]letters){
    if(length == 0) {
      System.out.println(word);
    }
    else if (word.length() > 0) {
      for(int i = 0; i < letters.length; i++) {
        char c = letters[i];
         if (c != word.charAt(word.length()-1)) {
           printNoDoubleLetterWords(length-1, word + c, letters);
         }
      }
    }
    else {
      for(int i = 0; i < letters.length; i++) {
        char c = letters[i];
        printNoDoubleLetterWords(length-1, word + c, letters);
      }
    }
  }

  public static String reverse(String s){
    if (s.length() == 0){
      return s;
    }
    else {
      return reverse(s.substring(1)) + s.substring(0,1);
    }
  }

  public static double sqrt(double n){
    return sqrt(n, 1);
  }

  public static double sqrt(double n, double guess){
    if(n == 0) {
      return 0;
    }
    if (Math.abs(guess * guess - n) / n * 100 <= 0.001) {
      return guess;
    }
    else {
      guess = (n / guess + guess) / 2;
      return sqrt(n, guess);
    }
  }

  public static long countNoDoubleLetterWords(int length,String word){
    long s = 0;
    if(length == 0) {
      return 1l;
    }
    else if (word.length() > 0) {
      for(char c = 'a'; c <= 'z'; c++) {
        if (c != word.charAt(word.length()-1)) {
          s += countNoDoubleLetterWords(length-1, word + c);
        }
      }
    }
    else {
      for(char c = 'a'; c <= 'z'; c++) {
        s += countNoDoubleLetterWords(length-1, word + c);
      }
    }
    return s;
  }

  public static int fibIter(int n, int f1, int f2){
    if (n == 0) {
      return f2;
    } else {
      return fibIter(n-1, f1 + f2, f1);
    }
  }

  public static void main(String[] args) {
    // printAllWords(3);
    // System.out.println();
    // char[] x = {'a','b','c'};
    // printNoDoubleLetterWords(2,"",x);
    // System.out.println(countNoDoubleLetterWords(3,""));
    // System.out.println(fibIter(0,1,0));
    // System.out.println(fibIter(1,1,0));
    // System.out.println(fibIter(2,1,0));
    // System.out.println(fibIter(3,1,0));
    // System.out.println((int) sqrt(100,1));
  }

}
