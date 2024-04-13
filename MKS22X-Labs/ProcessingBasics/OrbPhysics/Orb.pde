
public class Orb {
  float x, y;
  float xSpeed, ySpeed;
  float radius;
  color c;

  public Orb(float x_, float y_, float xSpeed_, float ySpeed_, float radius_ ) {
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    //random color... why not.
    c = color(random(255), random(255), random(255), 150);
  }


  void display() {
    //Part 1:
    //draw a ellipse at the x,y position, with the correct radius.
    //make sure it is the correct color
    //make sure you read the parameters of ellipse, so that you have the correct size.
    //radius is NOT one of the parameters of ellipse by default.
    noStroke();
    fill(c);
    circle(x, y, radius*2);
    stroke(0);
    line(x, y, x+5*xSpeed, y+5*ySpeed);
  }

  void move() {
    //PART 2
    //change the x based on the xSpeed
    //change the y based on the ySpeed
    x += xSpeed;
    y += ySpeed;
    //PART 3
    //Change the speed when you collide with the end of the screen (all 4 sides)

    if (MODE == GRAVITY) {
      bounce();
    }

    //Part 4
    //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
    //You don't need a variable for this if every object experiences the same
    //gravitational constant (find the value that looks nice experimentally, 9.8 will not work well).
    if (gravOn) {
      if (y + radius <= height) {
        ySpeed += 0.15;
      }
    }
  }

  void bounce() {
    if (x - radius <= 0) {
      xSpeed = -xSpeed;
    }
    if (x + radius >= width) {
      xSpeed = -xSpeed;
    }
    if (y + radius >= height) {
      ySpeed = -ySpeed;
    }
    if (y - radius <= 0) {
      ySpeed = -ySpeed;
    }
  }

  void attract(Orb other) {
    float d = dist(x, y, other.x, other.y);
    xSpeed += 20*((other.x - x)/ (d*d));
    ySpeed += 20*((other.y - y)/ (d*d));
  }
  
  void attractSpring(Orb other) {
    float d = dist(x, y, other.x, other.y);
    float force = (d - SPRING_LENGTH) * SPRING_CONSTANT;
    xSpeed += force * (other.x - x) / d;
    xSpeed *= SPRING_DAMPEN;
    ySpeed += force * (other.y - y) / d;
    ySpeed *= SPRING_DAMPEN;
  }
}
