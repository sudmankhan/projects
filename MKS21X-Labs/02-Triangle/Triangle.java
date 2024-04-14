public class Triangle {
  private Point v1,v2,v3;

  public Triangle(Point a, Point b, Point c){
    v1 = a;
    v2 = b;
    v3 = c;
  }

  public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
    v1 = new Point(x1,y1);
    v2 = new Point(x2,y2);
    v3 = new Point(x3,y3);
  }

  public Point getVertex(int x) {
    if (x == 1) {
      return v1;
    }
    else if (x == 2) {
      return v2;
    }
    else if (x == 3) {
      return v3;
    }
    return v1;
  }

  public void setVertex(int x, Point y) {
    if (x == 1) {
      v1 = y;
    }
    else if (x == 2) {
      v2 = y;
    }
    else if (x == 3) {
      v3 = y;
    }
  }

  public String toString() {
    return "{" + v1.toString() + ", " + v2.toString() + ", " + v1.toString() + "}";
  }

  public double getPerimeter() {
    return Point.distance(v1, v2) + Point.distance(v1, v3) + Point.distance(v3, v2);
  }

  public static boolean closeEnough(double a, double b){
    return Math.abs(a - b) >= 0.00001;
  }

  public boolean equals(Triangle other){
    if (other == null) {
      return false;
    }
    return (other.getVertex(1)).equals(v1) && (other.getVertex(2)).equals(v2) && (other.getVertex(3)).equals(v3);
  }

  public String classify(){
    if(closeEnough(Point.distance(v1, v2), Point.distance(v1, v3)) && closeEnough(Point.distance(v1, v2), Point.distance(v2, v3))) {
      return "equilateral";
    } else if (closeEnough(Point.distance(v1, v2), Point.distance(v1, v3)) || closeEnough(Point.distance(v1, v2), Point.distance(v2, v3)) || closeEnough(Point.distance(v2, v3), Point.distance(v1, v3))) {
      return "isosceles";
    } else {
      return "scalene";
    }
  }

  public double area(){
    double a = Point.distance(v1, v2);
    double b = Point.distance(v1, v3);
    double c = Point.distance(v3, v2);
    double s = (a + b + c) / 2;
    return Math.sqrt((s*(s-a)*(s-b)*(s-c)));
  }

}
