/* Josue Arana - Artistic Pattern: Tri-Waves */

//variables to use
float a, b, va, vb;
float x,y;


void setup() {
  size(1000, 600, P2D);
  x  = random(width);
  y  = random(height/2);
}
void draw() {
  background(255);
  fill(#0B2052,60);  //fill shape, dark blue color
  
  /*The double for loop allows to create a 3D perception of the 2D plane. 
   We do one loop in x and other one in y and rotate the triangles in the process.*/
  for(y = 0; y <= height; y+=40){
    for(x = 0; x <= width; x+=20){
    
      pushMatrix();
        translate(x,y);
        if (keyPressed != true){
          rotate(radians(frameCount+(x*0.25)+(y*0.5)));
        } else {
          //this rotation gives the wave look
          rotate(noise(radians(2*frameCount+(x*0.25)+(y*0.5))));
        }
        //shape characteristics
        strokeWeight(.5);  
        triangle(mouseX, mouseY, 58, 20, mouseY, 75);
      popMatrix();
    } //end x loop
  } //end y loop
  
}

void keyPressed(){
  if (key == TAB){
     rotate(noise(2*frameCount+(x*0.25)+(y*0.5)));
  }
}