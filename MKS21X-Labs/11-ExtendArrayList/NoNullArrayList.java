import java.util.*;

public class NoNullArrayList<T> extends ArrayList<T> {

  public NoNullArrayList() {
    super();
  }

  public NoNullArrayList(int initialCapacity) {
    super();
  }

  public T set(int index, T arg) {
    if (arg == null) {
      throw new IllegalArgumentException("no null allowed");
    } else {
      super.set(index, arg);
    }
    return arg;
  }

  public boolean add(T arg) {
    if (arg == null) {
      throw new IllegalArgumentException("no null allowed");
    } else {
      super.add(arg);
    }
    return true;
  }

  public void add(int index, T arg) {
    if (arg == null) {
      throw new IllegalArgumentException("no null allowed");
    } else {
      super.add(index, arg);
    }
  }

  // public static void main(String[] args) {
  //   NoNullArrayList<String> x = new NoNullArrayList<String>();
  //   x.add("a");
  //   System.out.println(x);
  //   x.set(0, "b");
  //   System.out.println(x);
  //   x.set(0, null);
  // }

}
