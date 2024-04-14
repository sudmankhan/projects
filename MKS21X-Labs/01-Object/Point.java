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

}
