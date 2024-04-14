import java.util.ArrayList;

public class Demo {
  public static void main(String[] args) {
    ArrayList<String> demo = new ArrayList<String>();
    for (int i = 0; i < demo.size(); i++) {
      if(i % 2 == 0) {
        demo.set(i, "");
      }
      else {
        demo.set(i, "yes");
      }
    }
    System.out.println(replaceEmpty(demo));
  }
}
