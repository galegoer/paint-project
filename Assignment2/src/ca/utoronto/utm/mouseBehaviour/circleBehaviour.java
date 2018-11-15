package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Circle;
import ca.utoronto.utm.paint.Commands;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import javafx.scene.input.MouseEvent;

/**
 * circleBehaviour is a concrete shapeBehaviour strategy for the circle object. circleBehaviour knows
 * what a mouse input would do given that the mode selected is a circle.
 * 
 * @author TheCentipedeBoys
 *
 */
public class circleBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;

	static Circle circle;
	int thick;
	
	/**
	 * Creates a new circleBehaviour strategy
	 * @param s An arrayList of strings representing the current mode(s)
	 * @param model the PaintModel 
	 * @param color	the color associated with the circle
	 * @param thick thickness of the circle
	 */
	public circleBehaviour(ArrayList<String> s, PaintModel model, String color, int thick) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
	}

	@Override
	/**
	 * Calculates the radius of the circle as the mouse is dragged and updates the radius of the current circle on
	 * the canvas allowing the user to see the circle as they draw
	 */
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

		int radius = (int) Math.sqrt(Math.pow((int) circle.getCentre().getX() - (int) e.getX(), 2)
				+ Math.pow((int) circle.getCentre().getY() - (int) e.getY(), 2));
		circle.setRadius(radius);
		this.model.acceptCommand(new Commands(circle));
		this.model.deleteCommands();
	}

	@Override
	/**
	 * Creates a new circle object as the mouse is pressed and and adds the command to draw this new circle to 
	 * the commandQueue
	 */
	public void mousePressed(MouseEvent e) {
		Point centre = new Point((int) e.getX(), (int) e.getY());
		int radius = 0;
		int style = 0;
		
		Circle circle2 = new Circle(centre, radius, color, style, this.thick);
		
		if (this.modes.get(1) == "Fill") {
			circle2.setStyleC(1);
		}
		circle = circle2;
		this.model.acceptCommand(new Commands(circle));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	/**
	 * Calculate the final radius of the circle as it is released and adds the final circle to the command stack.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		if (circle != null) {
			int radius = (int) Math.sqrt(Math.pow((int) circle.getCentre().getX() - (int) e.getX(), 2)
					+ Math.pow((int) circle.getCentre().getY() - (int) e.getY(), 2));
			circle.setRadius(radius);
			this.model.acceptCommand(new Commands(circle));
			this.model.deleteCommands();
			circle = null;
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}


}
