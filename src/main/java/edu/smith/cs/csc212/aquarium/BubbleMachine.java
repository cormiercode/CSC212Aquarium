package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
//import java.util.Random;

public class BubbleMachine {
	//Every bubble has a color, x and y starting points, 
	// a width and a height
	Color color;
	int x;
	int y;
	int wiggle;
	int w;
	int h;
//	int destX; 
//	int destY;
//	int speedX; 
//	int speedY;
//	int width;
//	int height;
	
	
	//Top and bottom of the screen for swim function
	int TOP = 500;
	int BOTTOM = 0;
	
public BubbleMachine(Color c, int startX, int startY, 
		int width, int height) {
	this.color = c;
	// Making random locations for bubbles 
	this.x = startX;
	this.y = startY;
	this.wiggle = 0;
	this.w = width; 
	this.h = height; 
//	this.destX = 100;
//	this.destY = 100;
//	this.speedX = 4;
//	this.speedY = 2;
	
	
}

//Draw method for BubbleMachine
public void draw(Graphics2D g) {
	//Again, not sure why swim is here?
//	Shape bubble = new Ellipse2D.Double(this.x + this.wiggle, this.y, this.w, this.h);
//	
	
//	Font f = g.getFont();
//	g.setFont(f.deriveFont(50.0f));
	g.setColor(Color.CYAN);
//	g.drawString("o", this.x + this.wiggle, this.y);
	g.fillOval(this.x + this.wiggle, this.y, this.w, this.h);
	
	animate();
	}

private void animate() {
	this.y -= 2;
	if( this.y < -100) {
		this.y = 550;
	}
	
	//(int) tells Java we don't care about the fraction
	this.wiggle = (int) (30.0 * Math.sin(this.y/60.0));
	// TODO Auto-generated method stub
	
}

//swim method for BubbleMachine
//public void swim( ) {
//	if( this.y > 0 ) {
//		this.y -= 1;
//}
//	if( this.y < 0 ) {
//		this.y = 500;
//	}
//}




}
	
//new addition,may need to comment out
	/*public void swim() {
		// trying to make the boolean true or false so that 
		//the fish will be drawn facing toward the destination.
		if( this.y < this.destY) {
			this.y += 1;
		}
		if( this.y > this.destY) {
			this.y -= 1;
		}
		if( this.x < this.destX ) {
			this.x += 1;
			this.isLeft = false;
		}
		if( this.x > this.destX ) {
			this.x -= 1;
			this.isLeft = true;
		}
		if( this.x == this.destX && this.y == this.destY) { this.destX =
		rand.nextInt(HIGH - LOW) + LOW; this.destY = rand.nextInt(HIGH - LOW) + LOW;
		}
}*/
