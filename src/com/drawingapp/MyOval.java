package com.drawingapp;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Represents a Oval shape. 
 * Inherits coordinates and color from MyShape and implements the draw method. 
 */
public class MyOval extends MyShape {
    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color, filled);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        int x = Math.min(getX1(), getX2());
        int y = Math.min(getY1(), getY2());
        int width = Math.abs(getX1() - getX2());
        int height = Math.abs(getY1() - getY2());

        if (isFilled()) { 
            g.fillOval(x, y, width, height);
        } else {
            g.drawOval(x, y, width, height);
        }
    }
}