public class SuperArray {
  private String[] data;
  private int size;

  public SuperArray() {
    data = new String[10];
    size = 0;
  }

  public SuperArray(int initialCapacity) {
    if (initialCapacity < 0){
      throw new IllegalArgumentException("index out of range");
    }
    size = 0;
    data = new String[initialCapacity];
  }

  public int size() {
    return size;
  }

  public boolean add(String x) {
    if (size == data.length-1) {
      resize();
    }
    data[size] = x;
    size++;
    return true;
  }

  public String toString() {
    String result = "[";
    for (int i = 0; i < size; i++) {
      result += data[i];
      if (i < size-1) {
        result += ", ";
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

  public String get(int index) {
    if ((index >= 0) && index < this.size) {
      return data[index];
    }
    else {
      throw new IndexOutOfBoundsException("index out of range");
    }
  }

  public String set(int index, String element) {
    String original = "";
    if ((index >= 0) && index < this.size) {
      original = data[index];
      data[index] = element;
    }
    else {
      throw new IndexOutOfBoundsException("index out of range");
    }
    return original;
  }

  private void resize() {
    String[] data1 = new String[2 * data.length + 1];
    for (int i = 0; i < size; i++) {
        data1[i] = data[i];
    }
    data = data1;
  }

  public int indexOf(String target) {
    for (int i = 0; i < size; i++) {
      if (data[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(String target) {
    for (int i = size - 1; i > 0; i--) {
      if (data[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public void add(int index,String value) {
    if (size == data.length) {
      resize();
    }
    if (index >= 0 && index <= size()) {
      for (int i = size(); i > index; i--) {
        data[i] = data[i-1];
      }
      data[index] = value;
      size++;
    }
    else {
      throw new IndexOutOfBoundsException("index out of range");
    }
  }

  public String remove(int index) {
    String original = data[index];
    for (int i = index; i < size; i++){
      data[i] = data[i + 1];
    }
    data[size] = null;
    this.size--;
    return original;
  }

  public boolean remove(String target) {
    int index = indexOf(target);
    for (int i = index; i < size; i++){
      data[i] = data[i + 1];
    }
    data[size] = null;
    this.size--;
    if (index == -1) {
      return false;
    } else {
      return true;
    }
  }

}
