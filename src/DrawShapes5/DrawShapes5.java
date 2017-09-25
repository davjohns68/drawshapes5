// Example of interface implementation.
// From BJP text DrawShpaes2
// modified by David Johnson, September 21, 2017
// for CS211 course, Bellevue College
package DrawShapes5;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class DrawShapes5 extends JFrame 
        implements MouseListener, KeyListener, MouseMotionListener, WindowFocusListener {
    // Fields for the app
    private Color colorific;
    private Font fontific;
    
    // Default constructor
    public DrawShapes5() {
        setSize(800,400);
        setTitle("DrawShapes5 - Implementing interfaces since 2017!");
        setVisible(true);
        addMouseListener(this);
        addWindowFocusListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
    }

    // Sets the color of a box in the JFrame based on whether the mouse
    // is onver the window or not
    public void processMouseOver() {
        Graphics g = this.getGraphics();
        
        fontific = new Font("ComicSans", Font.PLAIN, 30);
        g.setColor(colorific);
        g.fillRect(50, 100, 310, 100);
        g.setColor(Color.BLACK);
        g.drawRect(50, 100, 310, 100);
        g.setFont(fontific);
        g.drawString("Move the mouse.  Press some keys.  Right-Click to Exit", 2, 50);
       g.drawString("Mouse over window?", 55, 160);
    }
    
    // Sets the color of a box in the JFrame based on whether the window
    // has focus or not
    public void processFocusShift() {
        Graphics g = this.getGraphics();
        
        fontific = new Font("ComicSans", Font.PLAIN, 30);
        g.setColor(colorific);
        g.fillRect(450,100,300,100);
        g.setColor(Color.BLACK);
        g.drawRect(450,100,300,100);
        g.setFont(fontific);
        g.drawString("Window Focus", 500, 160);
    }
    
    // Was that a mouse moving?  
    // If so, set a box in the JFrame with a random color
    // Color chosen in the event itself
    public void processMouseMoved() {
        Graphics g = this.getGraphics();
        
        fontific = new Font("ComicSans", Font.PLAIN, 30);
        g.setColor(colorific);
        g.fillRect(0, 300, 800, 100);
        g.setColor(Color.BLACK);
        g.setFont(fontific);
        g.drawString("Pretty trippy, huh?", 250, 350);
        g.drawRect(0, 300, 800, 100);
    }
    
    // Did someone press a key?
    // This method will display it in the JFrame
    public void processKeyPress(char key) {
        Graphics g = this.getGraphics();
        
        g.setColor(getBackground());
        g.fillRect(375, 200, 75, 75);
        g.setColor(Color.BLACK);
        g.setFont(fontific);
        g.drawString(String.valueOf(key) , 385, 250);
    }

    // Implemented interface method
    // Exits application if right-click
    @Override
    public void mouseClicked(MouseEvent click) {
        if (click.getButton()==MouseEvent.BUTTON3) {
            System.exit(0);
        }
    }

    // Implemented interface method
    // Sets box to green if mouse enters JFrame area
    @Override
    public void mouseEntered(MouseEvent mouse) {
        colorific = Color.GREEN;
        processMouseOver();
    }

    // Implemented interface method
    // Sets box to red if mouse leaves JFrame area
    @Override
    public void mouseExited(MouseEvent mouse) {
        colorific = Color.RED;
        processMouseOver();
    }

    // 1. Implemented interface method
    // Displays key pressed in JFrame
    @Override
    public void keyTyped(KeyEvent key) {
        fontific = new Font("ComicSans", Font.BOLD, 45);
        processKeyPress(key.getKeyChar());
    }

    // 2. Implemented interface method
    // Sets a random color in JFrame on mouse motion
    @Override
    public void mouseMoved(MouseEvent mouse) {
 	Random temp = new Random();
	int red = temp.nextInt(256);
	int green = temp.nextInt(256);
	int blue = temp.nextInt(256);
	colorific = new Color(red,green,blue);
        processMouseMoved();
    }

    // 3. Implemented interface method
    // Sets a box to green when app has focus
    @Override
    public void windowGainedFocus(WindowEvent window) {
        colorific = Color.GREEN;
        processFocusShift();
    }

    // 3. Implemented interface method
    // Sets a box to red when app loses focus
    @Override
    public void windowLostFocus(WindowEvent window) {
        colorific = Color.RED;
        processFocusShift();
    }

    // Following methods intentionally not implemented
    // Here to satisfy interface requirements
    @Override
    public void mousePressed(MouseEvent mouse) {}

    @Override
    public void mouseReleased(MouseEvent mouse) {}

    @Override
    public void keyPressed(KeyEvent key) {}

    @Override
    public void keyReleased(KeyEvent key) {}

    @Override
    public void mouseDragged(MouseEvent mouse) {}

    public static void main(String[] args) {
        new DrawShapes5(); // Instantiates the class
    }
    
}
