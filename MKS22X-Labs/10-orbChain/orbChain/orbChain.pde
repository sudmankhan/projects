final static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
final static int MODE = SPRING;
static float GRAVITY = 0.35;
OrbList orbs;
static int CLICK_MODE = 0;

void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  if (CLICK_MODE == 0) {
    orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
  }
  else if (CLICK_MODE == 1) {
    orbs.add(mouseX,new OrbNode(mouseX, mouseY, 0, 0, 30));
  }
  else if (CLICK_MODE == 2) {
    orbs.delete(orbs.getNodeAt(mouseX, mouseY));
  }
}

void keyPressed() {
  char num = key;
  switch(num) {
  case ' ':
    if (CLICK_MODE == 2) {
      CLICK_MODE = 0;
    }
    else {
      CLICK_MODE++;
    }
    break;
  case '1':
    SPRING_CONSTANT *= 1.05;
    break;
  case '2':
    SPRING_CONSTANT *= .95;
    break;
  case '3':
    if (SPRING_DAMPEN * 1.05 >= 1.0) {
      SPRING_DAMPEN = 1.0;
    }
    else {
      SPRING_DAMPEN *= 1.05;
    }
    break;
  case '4':
    SPRING_DAMPEN *= .95;
    break;
  case '5':
    SPRING_LENGTH *= 1.05;
    break;
  case '6':
    SPRING_LENGTH *= .95;
    break;
  case '7':
    GRAVITY *= 1.05;
    break;
  case '8':
    GRAVITY *= .95;
    break;
  }
}

void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
  text("SPRING CONSTANT: " + SPRING_CONSTANT, 10, 20);
  text("SPRING DAMPEN: " + SPRING_DAMPEN, 10, 40);
  text("SPRING LENGTH: " + SPRING_LENGTH, 10, 60);
  text("GRAVITY: " + GRAVITY, 10, 80);
  if (CLICK_MODE == 0) {
    text("CLICK MODE: ADD", 10, 100);
  }
  if (CLICK_MODE == 1) {
    text("CLICK MODE: INSERT", 10, 100);
  }
  if (CLICK_MODE == 2) {
    text("CLICK MODE: DELETE", 10, 100);
  }
}
