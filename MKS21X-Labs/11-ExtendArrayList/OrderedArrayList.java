public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T> {

  public OrderedArrayList() {
    super();
  }

  public OrderedArrayList(int initialCapacity) {
    super();
  }

  public T set(int index, T arg) {
    remove(index);
    add(arg);
    return arg;
  }

  public boolean add(T arg) {
    super.add(whereToPlace(arg), arg);
    return true;
  }

  public void add(int index, T arg) {
    add(arg);
  }

  private int whereToPlace(T value) {
    if(value == null) {
      return 0;
    }
    for (int i = 0; i < this.size(); i++) {
      if(value.compareTo(this.get(i)) <= 0) {
        return i;
      }
    }
    return this.size();
  }

  public static void main(String[] args) {
    OrderedArrayList<String> x = new OrderedArrayList<String>();
    x.add("a");
    x.add("b");
    x.add("d");
    x.add("c");

    System.out.println(x);
  }

}
