public class Point{
  private double x,y;
  public Point(double X, double Y){
    x=X;
    y=Y;
  }
  public Point(Point p){
    x= p.x;
    y= p.y;
  }
  public double getX(){
    return x;
  }
  public double getY(){
    return y;
  }

  public static double distance(Point a, Point b) {
    return Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
  }

  public double distanceTo(Point b) {
    return Math.sqrt(Math.pow((b.getX() - x), 2) + Math.pow((b.getY() - y), 2));
  }

  /*Return a string in the format: (x, y)
*where x and y are the values from the Point.
*e.g.  "(0.0, 1.23)"  or  "(-1.02, 21.45)"
*/
  public String toString(){
    return "(" + x + ", " + y + ")";
  }

<<<<<<< HEAD
=======
  public static boolean closeEnough(double a, double b){
    if (a == 0.0 && b == 0.0) {
      return true;
    }
    return (Math.abs(a - b) / b) < 0.00001;
  }

  public boolean equals(Point other){
    if (other == null) {
      return false;
    }
    return (closeEnough(other.getX(), x)) && (closeEnough(other.getY(), y));
  }

>>>>>>> 52c9e0ca7ce1d4fd47cd6cb4ab1df35da0571345
}
