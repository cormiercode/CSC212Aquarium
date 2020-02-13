package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
//import java.util.ArrayList;
import me.jjfoley.gfx.GFX;
import java.util.Random;


//Citing: TA Hours 2/9/20
/**
 * Aquarium is a graphical "application" that uses some code I built and have
 * shared with you that takes care of opening a window and communicating with
 * the user in a simple way.
 * 
 * The method draw is called 50 times per second, so we make an animation by
 * drawing our fish in one place, and moving that place slightly. The next time
 * draw gets called, our fish looks like it moved!
 * 
 * @author jfoley
 *
 */
public class Aquarium extends GFX {
	
	// This is a static variable that tells us how wide the aquarium is.
	public static int WIDTH = 500;
	
	//This is a static variable that tells us how tall the aquarium is.
	public static int HEIGHT = 500;
	
	// Put a snail on the top of the tank.
	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top");
	
	//initializing random variable for later use
	Random random = new Random();
	
	//initializing bubble array
	BubbleMachine[] bubbles = new BubbleMachine[10];

	//Set up color change
	int R = 0;
	int G = 0;
	int B = 255;
	
	// the rates at which the screen will turn green
	int dG = 1;
	int dB = -1;
	
	/**
	 * This is a constructor, code that runs when we make a new Aquarium.
	 */

	public Aquarium() {
		// Here we ask GFX to make our window of size WIDTH and HEIGHT.
		// Don't change this here, edit the variables instead.
		super(WIDTH, HEIGHT);
		
		//for loop to create 10 bubbles 
		for(int i = 0; i < 10; i++) {
			int bubblex = random.nextInt(50) + 400;
			int bubbley = random.nextInt(500);
			int bubblewidth = random.nextInt(5)+ 10;
			
			//adding bubbles to array
			bubbles[i] = new BubbleMachine(Color.CYAN, bubblex, bubbley, bubblewidth, bubblewidth);
		}
	}

	// testing out fish class
	Fish nemo = new Fish(Color.GREEN, 250, 250, true, false);
	Fish marlin = new Fish(Color.orange, 100, 100, false, false);
	Fish JJ = new Fish(Color.LIGHT_GRAY, 150, 150, false, true);
	 

	@Override
	//Our method for drawing all of our objects in the window
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
		//Color changing code from TA hours 
		if(G + dG > 255) {
			dG = -1;
		}
		if(G + dG < 0) {
			dG = 1;
		}
		if(B + dB > 255) {
			dB = -1;
		}
		if(B + dB < 0) {
			dB = 1;
		}
		G += dG;
		B += dB;
		Color background = new Color(R,G,B);	
		g.setColor(background);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		//draw fish
		nemo.draw(g);
		marlin.draw(g);
		JJ.draw(g);

		//draw bubbles
		for(int i = 0; i < 10; i++) {
			bubbles[i].draw(g);
		}
		
		// Draw our snail!
		algorithm.draw(g);
		
		//draw treasure chest
		g.setColor(Color.YELLOW);
		g.fillRect(380, 465, 115, 50);
		
		g.setColor(Color.black);
		g.fillRect(405, 475, 60, 40);

		g.setColor(Color.yellow);
		g.fillRect(415, 480, 40, 20);
		
		//create seaweed
		g.setColor(Color.green.darker());
		g.drawString("~", 40, 30);
		
		
	}

	public static void main(String[] args) {
		// Uncomment this to make it go slower!
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many
		// print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}
}
