import java.util.ArrayList;

public class ArrayListPractice {

  public static ArrayList<String> replaceEmpty( ArrayList<String> data){
    ArrayList<String> array = new ArrayList<String>(data.size());
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i) == "") {
        array.set(i, "Empty");
      } else {
        array.set(i, data.get(i));
      }
    }
    return array;
}

public static ArrayList<String> makeReversedList( ArrayList<String> data){
  //return a new ArrayList that is in the reversed order of the parameter.
  ArrayList<String> array = new ArrayList<String>(data.size());
  int x = 0;
  for (int i = data.size()-1; i >= 0; i--) {
    array.set(x, data.get(i));
    x++;
  }
  return array;
}

public static ArrayList<String> mixLists( ArrayList<String> a,  ArrayList<String> b){
  //return a new ArrayList that has all values of a and b in alternating order that is:
  //a[0], b[0], a[1], b[1]...
  //when one list is longer than the other, just append the remaining values to the end.
  ArrayList<String> array = new ArrayList<String>(a.size() + b.size());
  for (int i = 0; i < array.size(); i++) {
    array.set(i, a.get(i));
    i++;
    array.set(i, b.get(i));
  }
  return array;
}

public static void main(String[] args) {
  ArrayList<String> demo = new ArrayList<String>(20);
  System.out.println(demo);
  demo.add("yes");
  System.out.println(demo);
  demo.add("");
  System.out.println(demo);
}

}
