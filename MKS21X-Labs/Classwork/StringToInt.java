import java.util.ArrayList;
public class StringToInt {

  public static int stringToInt(String s){
    //return the value of Integer.parseInt(s) but do it yourself!
    //Do not use any built in parse methods.
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      result = result * 10;
      result += valueOfDigit(s.charAt(i));
    }
    return result;
  }

  public static int valueOfDigit(char c) {
    return c - '0';
  }

  public static void main(String[] args) {
    System.out.println(stringToInt("133163"));
  }

}
