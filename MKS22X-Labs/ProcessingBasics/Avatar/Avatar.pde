void avatar(int x, int y){
  fill(235, 189, 52);
  circle(x, y, 100);
  triangle(x-60, y-60, x-20, y-46, x-40, y-30);
  triangle(x+60, y-60, x+20, y-46, x+40, y-30);
  fill(0);
  ellipse(x-20, y, 20, 15); 
  ellipse(x+20, y, 20, 15); 
  noFill();
}

int x,y;
int MODE;
  void setup(){
     size(800,800);
     MODE = 3;
     x = width/2;
     y = height/2;
  }
  void draw(){
     background(255);
     x = change(x);
     y = change(y);
     avatar(x,y);
     avatar(mouseX,mouseY);
  }
  
  int change(int value){
    /**
     mode 1: return a random location on the screen.
     mode 2: change value by +1, 0, or -1 randomly
     mode 3: change value by +1 , but if it goes past the end of the screen ,
           wrap back around to the other end of the screen.
    */

    switch(MODE){
     case 1:
       return (int) random(height);
     case 2:
       return value + (int) random(-2, 2);
     case 3:
       if (value == height) {
         return 0;
       }
       return value + 1;
     default:
       return width/2;
    }
  }
  
  void mouseClicked() {
    if(MODE == 3) {
      MODE = 1;
    }
    else {
      MODE++;
    }
  }
