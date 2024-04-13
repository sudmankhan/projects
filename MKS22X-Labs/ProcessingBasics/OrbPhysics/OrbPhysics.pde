ArrayList<Orb> orbList;
Orb center;
boolean gravOn = true;
boolean backOn = true;
final int GRAVITY = 0;
final int ORBIT = 1;
final int SPRING = 2;
int MODE = GRAVITY;
final int SPRING_LENGTH = 150;
final float SPRING_DAMPEN = 0.995;
final float SPRING_CONSTANT = 0.005;


void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2, height/2, 0, 0, 5);
  background(255);
}

void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  //float xSpeed = random(-3.0,3.0);
  //float ySpeed = random(-3.0,3.0);
  //float radius = random(20.0,70.0);
  float xSpeed = 5.0;
  float ySpeed = 0.0;
  float radius = 20.0;
  Orb orb = new Orb(mouseX, mouseY, xSpeed, ySpeed, radius); 
  orbList.add(orb);
}

void keyPressed() {
  if (keyCode == BACKSPACE) {
    orbList.clear();
  }
  if (keyCode == ' ') {
    if (MODE == GRAVITY) {
      MODE = ORBIT;
    } else if (MODE == ORBIT) {
      MODE = SPRING;
    } else if (MODE == SPRING) {
      MODE = GRAVITY;
    }
  }
  if (key == 'g') {
    gravOn = !gravOn;
  }
  if (key == 'b') {
    backOn = !backOn;
  }
}

void draw() {
  if (backOn) {
    background(255);
  }
  center.display();
  for (Orb o : orbList) {
    o.move();
    o.display();
    if (MODE == ORBIT) {
      o.attract(center);
    }
    if (MODE == SPRING) {
      o.attractSpring(center);
    }
  }
  if (!backOn) {
    fill(255);
    noStroke();
    rect(0, 0, 140, 100, 0, 0, 20, 0);
  }
  fill(0);
  stroke(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  if (MODE == GRAVITY) {
    text("GRAVITY", 20, 60);
  } else if (MODE == ORBIT) {
    text("ORBIT", 20, 60);
  } else {
    text("SPRING", 20, 60);
  }
  if (gravOn) {
    text("GRAVITY ON", 20, 80);
  } else {
    text("GRAVITY OFF", 20, 80);
  }
}
