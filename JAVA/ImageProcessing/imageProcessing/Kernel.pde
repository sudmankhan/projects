public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
   *This implementation only allows 3x3 kernels
   */
  public Kernel(float[][]init) {
    kernel = init;
  }

  /**If part of the kernel is off of the image, return black, Otherwise
   *Calculate the convolution of r/g/b separately, and return that color\
   *if the calculation for any of the r,g,b values is outside the range
   *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
   */
  color calcNewColor(PImage img, int x, int y) {
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    if (x <= 0 || y <= 0 || x >= img.width || y >= img.height) {
      return 0;
    }

    int red = 0;
    int blue = 0;
    int green = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        red += red(img.get(x+j-1, y+i)) * kernel[i][j];
        green += green(img.get(x+j, y+i)) * kernel[i][j];
        blue += blue(img.get(x+j, y+i)) * kernel[i][j];
      }
    }

    color c = color(red, green, blue);
    return c;
  }


  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for (int i = 0; i < source.width; i++) {
      for (int j = 0; j < source.height; j++) {
        destination.set(i, j, calcNewColor(source, i, j));
      }
    }
  }
}
