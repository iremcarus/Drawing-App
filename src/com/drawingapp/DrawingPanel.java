package com.drawingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * A custom JPanel that serves as the drawing canvas. 
 * It manages the collection of shapes and handles mouse events.
 */
public class DrawingPanel extends JPanel {
    private ArrayList<MyShape> shapes = new ArrayList<>(); 
    private MyShape currentShape = null; 
    private Color currentColor = Color.BLACK; 
    private String shapeType = "Line"; 
    private boolean fillMode = false; 
    private JLabel statusLabel; 

    /**
     * Constructor for DrawingPanel.
     * @param statusLabel The label used to display mouse coordinates. 
     */
    public DrawingPanel(JLabel statusLabel) {
        this.statusLabel = statusLabel;
        setBackground(Color.WHITE); 
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler); 
        addMouseMotionListener(handler); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MyShape s : shapes) {
            s.draw(g);
        }
        if (currentShape != null) {
            currentShape.draw(g);
        }
    }

    public void setShapeType(String type) { this.shapeType = type; }
    public void setCurrentColor(Color color) { this.currentColor = color; }
    public void setFillMode(boolean fillMode) { this.fillMode = fillMode; }

    /**
     * Clears all shapes from the canvas.
     */
    public void clearShapes() {
        shapes.clear();
        repaint();
    }

    /**
     * Removes the last added shape from the list.
     */
    public void undoLastShape() {
        if (!shapes.isEmpty()) {
            shapes.remove(shapes.size() - 1);
            repaint();
        }
    }

    /**
     * Inner class to handle mouse interactions.
     */
    private class MouseHandler extends MouseAdapter {
        private void updateStatus(MouseEvent e) {
            if (statusLabel != null) {
                statusLabel.setText(" Tool: " + shapeType + " | Coordinates: (" + e.getX() + ", " + e.getY() + ")");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if (shapeType.equals("Line")) {
                currentShape = new MyLine(x, y, x, y, currentColor, fillMode);
            } else if (shapeType.equals("Rectangle")) {
                currentShape = new MyRectangle(x, y, x, y, currentColor, fillMode);
            } else if (shapeType.equals("Oval")) {
                currentShape = new MyOval(x, y, x, y, currentColor, fillMode);
            }
            updateStatus(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (currentShape != null) {
                currentShape.setX2(e.getX());
                currentShape.setY2(e.getY());
                repaint(); 
            }
            updateStatus(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            updateStatus(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (currentShape != null) {
                currentShape.setX2(e.getX());
                currentShape.setY2(e.getY());
                shapes.add(currentShape); 
                currentShape = null;
                repaint();
            }
        }
    }
}