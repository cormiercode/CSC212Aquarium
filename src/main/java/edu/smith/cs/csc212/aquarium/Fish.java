package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {
	// Every fish has a x which is an int.
	int x; 
	int y; 
	Color color; 
	boolean isLittle;
	boolean isLeft;
	// every fish has a destination: (x,y)
	int destX;
	int destY;
	
	// Create a random number generator:
	Random rand = new Random();
	
	// Configure the difficulty of game by changing LOW and HIGH
	int HIGH = 450;
	int LOW = 0;

			
	public Fish(Color c, int startX, int startY, 
			boolean isLittle, boolean isLeft ) {
		this.color = c;
		this.x = startX; 
		this.y = startY; 
		this.isLittle = isLittle;
		this.isLeft = isLeft;
		
		//Choose a random destination 
		this.destX = rand.nextInt(HIGH - LOW) + LOW;
		this.destY = rand.nextInt(HIGH - LOW) + LOW;	
		
	}
	
	public void swim() {
		// trying to make the boolean true or false so that 
		//the fish will be drawn facing toward the destination.
		if( this.y < this.destY) {
			this.y += 1;
		}
		if( this.x < this.destX ) {
			this.x += 1;
			this.isLeft = false;
		}
		if( this.x > this.destX ) {
			this.x += 1;
			this.isLeft = true;
		}
		if( this.x = this.destX ) {
			this.destX = rand.nextInt(HIGH - LOW) + LOW;
			this.destY = rand.nextInt(HIGH - LOW) + LOW;
		}
		
	}
	

	public void draw(Graphics2D g) {
		this.swim();
		//fish face left and are small
		//smallFacingRight, facingLeft, and facingRight
		if (isLittle && isLeft) {
			DrawFish.smallFacingLeft(g,this.color, this.x, this.y);
		}
		else if (isLittle && !isLeft) {
			DrawFish.smallFacingRight(g,this.color, this.x, this.y);
		}
		else if (!isLittle && isLeft) {
			DrawFish.facingLeft(g,this.color, this.x, this.y);
		}
		else if (!isLittle && !isLeft) {
			DrawFish.facingRight(g,this.color, this.x, this.y);
		}
	}
}
