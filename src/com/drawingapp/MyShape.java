package com.drawingapp;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Represents a generic geometric shape. 
 * This abstract class serves as the base for all drawable shapes in the application. 
 */
public abstract class MyShape {
     private int x1;
     private int y1;
     private int x2;
     private int y2;
     private Color color;
     private boolean filled;
     
     public MyShape(int x1,int y1,int x2,int y2,Color color,boolean filled) {
    	 this.x1=x1;
    	 this.y1=y1;
    	 this.x2=x2;
    	 this.y2=y2;
    	 this.color=color;
    	 this.filled = filled;
     }
     public int getX1() {
    	 return x1;
     }
     public int getY1() {
    	 return y1;
     }
     public int getX2() {
    	 return x2;
     }
     public int getY2() {
    	 return y2;
     }
     public Color getColor() {
    	 return color;
     }
     public boolean isFilled() { 
    	 return filled;
     }
     public void setX1(int x1) {
    	 this.x1=x1;
     }
     public void setY1(int y1) {
    	 this.y1=y1;
     }
     public void setX2(int x2) {
    	 this.x2=x2;
     }
     public void setY2(int y2) {
    	 this.y2=y2;
     }
     public void setColor(Color color) {
    	 this.color=color;
     }
     public void setFilled(boolean filled) { 
    	 this.filled = filled;
     }
     /**
      * Draws the shape on the given Graphics context. 
      * This method must be implemented by all subclasses. 
      * @param g the Graphics object used for drawing
      */
     public abstract void draw(Graphics g);
}
