import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[10];
    data = d;
    size = 0;
    start = data.length/2;
    end = data.length/2+1;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = data.length/2;
    end = data.length/2+1;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String result = "[";
    for (int i = start+1; i < data.length; i++){
      if (data[i] != null) {
        result += data[i] + ", ";
      }
    }
    for (int i = 0; i < end; i++) {
      if (data[i] != null && i != start) {
        result += data[i];
        if (i < end-1) {
          result += ", ";
        }
      }
    }
    result += "]";
    return result;
  }

  public String toStringDebug() {
    String result = "[";
    for (int i = 0; i < data.length; i++) {
      result += data[i];
      if (i < data.length-1) {
        result += ", ";
      }
    }
    result += "]";
    return result;
  }

// add to new array so that start goes to length of array and then it wraps around just like original array
  private void resize() {
    E[] d = (E[]) new Object[size*2+1];
    int num = data.length - start;
    int counter = data.length-1;
    for (int i = d.length-1; i > d.length - num; i--) {
      d[i] = data[counter];
      counter--;
      start = i - 1;
    }
    for (int i = 0; i < end; i++) {
      d[i] = data[i];
    }
    data = d;
  }

  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException("no null");
    }

    if (data[start] == null) {
      data[start] = element;
      start--;
      size++;
    }
    if (end == start+1) {
      resize();
    }
  }

  public void addLast(E element) throws NullPointerException{
    if (element == null) {
      throw new NullPointerException("no null");
    }

    if (data[end] == null) {
      data[end] = element;
      end++;
      size++;
      if (end == data.length) {
        end = 0;
      }
    }
    if (end == start+1) {
      resize();
    }
  }

  public E removeFirst() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException("empty deque");
    }
    E temp = data[start];
    data[start] = null;
    start++;
    size--;
    return temp;
  }

  public E removeLast() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException("empty deque");
    }
    E temp = data[end];
    data[end] = null;
    end--;
    size--;
    return temp;
  }

  public E getFirst() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException("empty deque");
    }
    return data[start];
  }

  public E getLast() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException("empty deque");
    }
    return data[end];
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

  public static void main(String[] args) {
    MyDeque x = new MyDeque();
    x.addFirst(1);
    x.addLast(1);
    x.addLast(2);
    x.addLast(3);
    x.addLast(4);
    x.addLast(5);
    x.addLast(6);
    x.addLast(7);
    x.addLast(8);
    x.addLast(9);
    x.addLast(10);
    x.addLast(10);
    //x.addLast(9);
    x.removeFirst();
    x.removeLast();
    // System.out.println(x.getStart());
    // System.out.println(x.getEnd());
    // System.out.println(x.toStringDebug());
    System.out.println(x);
  }
}
