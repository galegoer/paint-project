package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Commands;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.Squiggle;
import javafx.scene.input.MouseEvent;

/**
 * squiggleBehaviour is a concrete shapeBehaviour strategy for the squiggle object. squiggleBehaviour knows
 * what a mouse input would do given that the mode selected is a squiggle.
 * 
 * @author TheCentipedeBoys
 *
 */
public class squiggleBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;
	Integer thick;

	static Squiggle squiggle;
	
	/**
	 * Creates a new squiggleBehaviour strategy
	 * @param s An arrayList of strings representing the current mode(s)
	 * @param model the PaintModel 
	 * @param color	the color associated with the squiggle
	 * @param thick thickness of the squiggle
	 */
	public squiggleBehaviour(ArrayList<String> s, PaintModel model, String color, Integer thick) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
	}
	@Override
	/**
	 * adds points to the squiggle list associated to the squiggle object as the mouse is dragged
	 */
	public void mouseDragged(MouseEvent e) {
		Point point = new Point((int) e.getX(), (int) e.getY());
		squiggle.addPoint(point);
		this.model.acceptCommand(new Commands(squiggle));
		this.model.deleteCommands();
	}

	@Override
	/**
	 * Creates a new squiggle object and adds it into the command stack
	 */
	public void mousePressed(MouseEvent e) {
		Point start = new Point((int) e.getX(), (int) e.getY());		
		int thick1 = this.thick;
		ArrayList<Point> points = new ArrayList<>();
		Squiggle squig = new Squiggle(points, this.color, thick1);
		squig.addPoint(start);
		squiggle = squig;
		this.model.acceptCommand(new Commands(squiggle));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	/**
	 * Adds an new command to draw the final squiggle upon mouse release while deleting older commands from
	 * squiggle feedback
	 */
	public void mouseReleased(MouseEvent e) {
		this.model.acceptCommand(new Commands(squiggle));
		this.model.deleteCommands();
		squiggle = null;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
