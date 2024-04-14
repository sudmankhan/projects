import java.util.*;

public class UserInput {

  public static void main(String[] args) {
    ArrayList<Double> arr = new ArrayList<Double>();
    Scanner x = new Scanner(System.in);
    System.out.print("Enter a non negative number. A negative number will end the program:\n");
    Double num = x.nextDouble();
    while (num >= 0.0) {
      arr.add(num);
      System.out.print("Enter a non negative number. A negative number will end the program:\n");
      num = x.nextDouble();
    }
    double sum = 0.0;
    double mean = 0.0;
    double min = arr.get(0);
    double max = arr.get(0);
    for (int i = 0; i < arr.size(); i++) {
      sum += arr.get(i);
    }
    mean = sum / arr.size();
    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) < min) {
        min = arr.get(i);
      }
    }
    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) > max) {
        max = arr.get(i);
      }
    }
    System.out.println("You entered: " + arr);
    System.out.println("Mean: " + mean);
    System.out.println("Min value: " + min);
    System.out.println("Max value: " + max);
  }

}
