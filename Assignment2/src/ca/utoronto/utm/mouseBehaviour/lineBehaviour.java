package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;


import ca.utoronto.utm.paint.Commands;
import ca.utoronto.utm.paint.Line;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import javafx.scene.input.MouseEvent;

/**
 * lineBehaviour is a concrete lineBehaviour strategy for the line object. lineBehaviour knows
 * what a mouse input would do given that the mode selected is a line.
 * 
 * @author TheCentipedeBoys
 *
 */
public class lineBehaviour implements shapeBehaviour {

	PaintModel model;
	ArrayList<String> modes;
	String color;

	static Line line;
	Integer thick;
	String style;

	/**
	 * Creates a new lineBehaviour strategy
	 * @param s An arrayList of strings representing the current mode(s)
	 * @param model the PaintModel 
	 * @param color	the color associated with the line
	 * @param thick thickness of the line
	 */
	public lineBehaviour(ArrayList<String> s, PaintModel model, String color, String style, int thick) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
		this.style = style;

	}

	@Override
	/**
	 * Updates the end of the line object (represented by a point) as the mouse is dragged
	 * Allows for line feedback
	 */
	public void mouseDragged(MouseEvent e) {
		int x2 = (int) e.getX();
		int y2 = (int) e.getY();
		Point end = new Point(x2, y2);
		line.setEnd(end);
		this.model.acceptCommand(new Commands(line));
		this.model.deleteCommands();
	}

	@Override
	/**
	 * Creates a new Command to draw a line object as the mouse is pressed
	 */
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		Point centre = new Point((int) e.getX(), (int) e.getY());
		Line line2 = new Line(centre, this.color,this.style, this.thick);
		line2.setEnd(centre);
		line = line2;
		this.model.acceptCommand(new Commands(line));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	/**
	 * Calculate the end point of the line and add it into the command stack while removing older line commands 
	 * made from mouse dragged
	 */
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		if (line!= null) {

			int x2 = (int) e.getX();
			int y2 = (int) e.getY();
			Point end = new Point(x2, y2);
			line.setEnd(end);
			
			this.model.acceptCommand(new Commands(line));
			this.model.deleteCommands();
			line= null;
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
