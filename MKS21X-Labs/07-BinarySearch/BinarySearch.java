import java.util.Arrays;
public class BinarySearch {
  public static void main(String[] args) {
    int result;
    result = binarySearch(new int[]{0,0,0,0,0,0,0},0);
    System.out.println(result); //should be 3
    result = binarySearch(new int[]{0,0,0,0,0,0,0},1);
    System.out.println(result); //should be -1
    result = binarySearch(new int[]{0,1,2,3,4,5,6},0);
    System.out.println(result);//should be 0
    //...
    result = binarySearch(new int[]{0,1,2,3,4,5,6},6);
    System.out.println(result);//should be 6
    result = binarySearch(new int[]{7,10,18,21,35,45,48,50},45);
    System.out.println(result);//should be 6
    int[] arr = randomArray(10,1,5);
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(binarySearch(arr, 5));
  }

  public static int binarySearch(int[] data, int target) {
    int start = 0;
    int end = data.length - 1;
    int mid = (start + end) / 2;
    // System.out.println(start);
    // System.out.println(end);
    // System.out.println(mid);
    while (start <= end) {
      mid = (start + end) / 2;
      if (target > data[mid]) {
        start = mid + 1;
      } else if (target < data[mid]) {
        end = mid - 1;
      } else if (target == data[mid]) {
        return mid;
      }
      mid = (start + end) / 2;
    }
    return -1;
  }

  public static int[] randomArray(int size, int min, int max) {
      int[] ran = new int[size];
      for (int i = 0; i < ran.length; i++) {
        ran[i] = (int) (Math.random() * (max - min + 1) + min);
      }
      return ran;
  }

}
