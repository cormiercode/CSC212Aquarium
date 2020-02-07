package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

public class Fish {
	// Every fish has a x which is an int.
	int x; 
	int y; 
	Color color; 
	boolean isLittle;
	boolean isLeft;
	
	
	public Fish(Color c, int startX, int startY, 
			boolean isLittle, boolean isLeft ) {
		this.color = c;
		this.x = startX; 
		this.y = startY; 
		this.isLittle = isLittle;
		this.isLeft = isLeft;
		
	}
	
	public void swim() {
		this.y += 1; 
		
	}
	

	public void draw(Graphics2D g) {
		this.swim();
		//fish face left and are small
		//smallFacingRight, facingLeft, and facingRight
		if (isLittle && isLeft) {
			DrawFish.smallFacingLeft(g,this.color, this.x, this.y);
		}
	}
}
