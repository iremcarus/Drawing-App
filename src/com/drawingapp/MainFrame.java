package com.drawingapp;

import javax.swing.*;
import java.awt.*;

/**
 * The main frame of the application. 
 * Combines UI components and the drawing canvas.
 */
public class MainFrame extends JFrame {
    private DrawingPanel drawingPanel;
    private JLabel statusBar;

    public MainFrame() {
        setTitle("Simple Drawing Application - OOP");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        statusBar = new JLabel(" Tool: Line | Coordinates: (0, 0)");

        drawingPanel = new DrawingPanel(statusBar);
        add(drawingPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controlPanel.setBackground(new Color(230, 230, 230));

        String[] shapes = { "Line", "Rectangle", "Oval" };
        JComboBox<String> shapeChooser = new JComboBox<>(shapes);
        shapeChooser.addActionListener(e -> drawingPanel.setShapeType((String) shapeChooser.getSelectedItem()));

        JButton colorButton = new JButton("Color");
        colorButton.addActionListener(e -> {
            Color c = JColorChooser.showDialog(this, "Select Color", Color.BLACK);
            if (c != null) drawingPanel.setCurrentColor(c);
        });

        JCheckBox fillCheckBox = new JCheckBox("Filled");
        fillCheckBox.addActionListener(e -> drawingPanel.setFillMode(fillCheckBox.isSelected()));

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(e -> drawingPanel.undoLastShape());

        JButton clearButton = new JButton("Clear All");
        clearButton.addActionListener(e -> drawingPanel.clearShapes());

        controlPanel.add(new JLabel("Shape: "));
        controlPanel.add(shapeChooser);
        controlPanel.add(colorButton);
        controlPanel.add(fillCheckBox);
        controlPanel.add(undoButton);
        controlPanel.add(clearButton);

        add(controlPanel, BorderLayout.NORTH);
        add(statusBar, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
    }

    /**
     * Application entry point.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}