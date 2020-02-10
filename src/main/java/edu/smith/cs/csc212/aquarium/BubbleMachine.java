package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class BubbleMachine {
	//Every bubble has a color, x and y starting points, 
	// a width and a height
	Color color;
	int xs;
	int ys;
	int w;
	int h;
	
public BubbleMachine(Color c, int startX, int startY, 
		int width, int height) {
	this.color = c;
	this.xs = startX;
	this.ys = startY;
	this.w = width; 
	this.h = height; 
}

public void draw(Graphics2D g) {
	Shape bubble = new Ellipse2D.Double(this.xs, this.ys, this.w, this.h);
	
	g.setColor(Color.CYAN);
	g.fill(bubble);
	g.draw(bubble);
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
}