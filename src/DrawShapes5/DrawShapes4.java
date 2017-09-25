// Draws and fills several shapes.
// From BJP text DrawShpaes2
// modified by W.P. Iverson, September 2017
// for CS211 course, Bellevue College

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class DrawShapes4 extends JFrame implements MouseListener {
	
	// FIELDS for app.
	private int clickCount; // allows something different alternate
	private int oldX; // the last position needs to be remembered
	private int oldY;
	private Color vibe;

	// Default constructor
	public DrawShapes4() {
		clickCount = 0;
		oldX = 0;       oldY = 0;
		addMouseListener(this);		
		setSize(800,400);
		setTitle("Draw Shapes on every other (even numbered) clicks\n"
				+ "       RIGHT-CLICK to EXIT");
		setVisible(true);
		vibe = Color.BLACK;
		// parameters set now, CANNOT draw anything until
		// constructor completes through last closing brace:
	}

	// method called for every mouse click
	public void mouseClicked(MouseEvent click) { 
		// 1. implemented interface method
		// The MouseEvent Class provides properties of the click
		if (click.getButton()==MouseEvent.BUTTON3) 
			System.exit(0);
		else
			doDrawShapes2(click);
	}
	
	// this method is kind of like the example in the BJP text
	private void doDrawShapes2(MouseEvent event) {
		// MouseEvents have lots of information:
		int x = event.getX();
		int y = event.getY();
		oldX = x; // remember these
		oldY = y; // for later use
		
		Graphics g = this.getGraphics();
		if (clickCount == 0) { // do this just once at the start
			g.setColor(Color.BLACK);
			g.drawString("Move mouse outside window to generate a random color"
				+ " then CLICK someplace to see it", 100, 100);
		}
		clickCount++; // count clicks on this window
		g.setColor(vibe);
		if (clickCount % 2 != 0) {
			// what we did in DrawShapes2, offset by JPanel
			g.fillRect(25, 50, 20, 20);
			g.fillOval(150, 50, 80, 40);
		} else {
			eraseOldShapes(g);
			// draw a new set of shapes with random RGB Color
			g.setColor(vibe);
			g.fillRect(25+x, 50+y, 20, 20);
			g.fillOval(150+x, 50+y, 80, 40);
		}
	}
	
	// private helper method, used only by this class
	private void eraseOldShapes(Graphics g) {
		// erase the old shapes
		g.setColor(getBackground());
		g.fillRect(25+oldX, 50+oldY, 20, 20);
		g.fillOval(150+oldX, 50+oldY, 80, 40);
	}
	
	// 2. implemented interface method	
	// When mouse leaves the application window:
	public void mouseExited(MouseEvent arg0) {
		JOptionPane.showMessageDialog(this,"Right-Click inside JFrame,"
				+ " to exit this application!");
	}

	// 3. implemented interface method
	// make a random color when mouse comes back into window
	public void mouseEntered(MouseEvent arg0) {
		Random temp = new Random();
		int red = temp.nextInt(256);
		int green = temp.nextInt(256);
		int blue = temp.nextInt(256);
		vibe = new Color(red,green,blue);
		if (clickCount == 0) vibe = Color.BLACK;
	} 
	
	// following intentionally not implemented at present
	// only here to satisfy Interface	
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
    public static void main(String[] args) {
    	new DrawShapes4(); // launches Class from console application
    }
}
