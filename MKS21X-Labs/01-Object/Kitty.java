public class Kitty {
  private int age;
  private String name;

  public Kitty() {
    age = 2;
    name = "Mittens";
  }

  public Kitty(String n, int a) {
    name = n;
    age = a;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String toString() {
    return "The amazing " + name;
  }

  public void changeName(String x) {
    name = x;
  }

  public void makeOlder() {
    age++;
  }

}
