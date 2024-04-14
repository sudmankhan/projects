import java.util.*;
public class Calculator{

  public static double eval(String s) {
    Deque<Double> deque = new ArrayDeque<Double>();
    Scanner scan = new Scanner(s);
    while (scan.hasNext() ) {
      String x = scan.next();
      double a,b;
      switch (x) {
        case "+":
        if (deque.size() < 2) {
          throw new IllegalArgumentException("too few operands for operation +");
        }
          a = deque.removeLast();
          b = deque.removeLast();
          deque.add(b + a);
          break;
        case "-":
        if (deque.size() < 2) {
          throw new IllegalArgumentException("too few operands for operation -");
        }
          a = deque.removeLast();
          b = deque.removeLast();
          deque.add(b - a);
          break;
        case "/":
        if (deque.size() < 2) {
          throw new IllegalArgumentException("too few operands for operation /");
        }
          a = deque.removeLast();
          b = deque.removeLast();
          deque.add(b / a);
          break;
        case "*":
        if (deque.size() < 2) {
          throw new IllegalArgumentException("too few operands for operation *");
        }
          a = deque.removeLast();
          b = deque.removeLast();
          deque.add(b * a);
          break;
        case "%":
        if (deque.size() < 2) {
          throw new IllegalArgumentException("too few operands for operation %");
        }
          a = deque.removeLast();
          b = deque.removeLast();
          deque.add(b % a);
          break;
        default:
        Double e = Double.parseDouble(x);
        deque.add(e);
      }
    }
    if (deque.size() > 1) {
      throw new IllegalArgumentException("too many operands");
    }
    else if (deque.size() < 1) {
      throw new IllegalArgumentException("too few operands");
    }
    else {
      return deque.peek();
    }
  }

  public static void main(String[] args) {
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("10 2.0 +"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(eval("1 2 3 4 5 + * - -"));
    System.out.println(eval("1 1 1 +"));
    System.out.println(eval(""));
    System.out.println(eval("1 1 1 - * +"));
  }

}
