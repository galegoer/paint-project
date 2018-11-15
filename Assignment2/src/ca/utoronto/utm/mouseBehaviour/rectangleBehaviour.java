package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Commands;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.Rectangle;
import javafx.scene.input.MouseEvent;

/**
 * rectangleBehaviour is a concrete shapeBehaviour strategy for the rectangle object. rectangleBehaviour knows
 * what a mouse input would do given that the mode selected is a rectangle.
 * 
 * @author TheCentipedeBoys
 *
 */
public class rectangleBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;

	static Rectangle rectangle;
	int thick;

	/**
	 * Creates a new rectangleBehaviour strategy
	 * @param s An arrayList of strings representing the current mode(s)
	 * @param model the PaintModel 
	 * @param color	the color associated with the rectangle
	 * @param thick thickness of the rectangle
	 */
	public rectangleBehaviour(ArrayList<String> s, PaintModel model, String color, int thick) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
	}

	@Override
	/**
	 *Updates the rectangle width and height as the mouse is dragged and adds a command to draw the 
	 *rectangle to the command stack
	 *Allows for rectangle feedback
	 */
	public void mouseDragged(MouseEvent e) {

		// Begin
		int x1 = rectangle.getCentre().getX();
		int y1 = rectangle.getCentre().getY();
		// mouse release or end
		int x2 = (int) e.getX();
		int y2 = (int) e.getY();

		if (x2 > x1 && y2 > y1) {
			rectangle.setScenario(1);
			Point centre = new Point(x1, y1);
			rectangle.setHeight(y2 - y1);
			rectangle.setWidth(x2 - x1);
			rectangle.setCentre(centre);
		}
		// Scenario 2
		else if (x1 > x2 && y2 < y1) {
			rectangle.setScenario(2);
			rectangle.setHeight(y1 - y2);
			rectangle.setWidth(x1 - x2);
		}
		// Scenario 3
		else if (x1 > x2 && y1 < y2) {
			rectangle.setScenario(3);
			rectangle.setHeight(y2 - y1);
			rectangle.setWidth(x1 - x2);
		}
		// Scenario 4
		else if (x2 > x1 && y2 < y1) {
			rectangle.setScenario(4);
			rectangle.setHeight(y1 - y2);
			rectangle.setWidth(x2 - x1);
		}
		this.model.acceptCommand(new Commands(rectangle));
		this.model.deleteCommands();
	}

	@Override
	/**
	 * Creates a new rectangle and adds it as a command to the command stack as the mouse is pressed
	 */
	public void mousePressed(MouseEvent e) {
		Point centre = new Point((int) e.getX(), (int) e.getY());
		int height = 0;
		int width = 0;
		int scenario = 0;
		int style = 0;
		Rectangle rectangle2 = new Rectangle(centre, width, height, scenario, this.color, style, this.thick);
		if (this.modes.get(1) == "Fill") {
			rectangle2.setStyleR(1);
		}
		rectangle = rectangle2;
		this.model.acceptCommand(new Commands(rectangle));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	/**
	 * Updates the height and width of the rectangle upon mouse release and adds a command to draw the rectangle object
	 * while deleting older commands made from feedback
	 */
	public void mouseReleased(MouseEvent e) {
		if (rectangle != null) {
			// Begin

			int x1 = rectangle.getCentre().getX();
			int y1 = rectangle.getCentre().getY();
			// mouse release or end
			int x2 = (int) e.getX();
			int y2 = (int) e.getY();

			// Scenario 1
			if (x2 > x1 && y2 > y1) {
				rectangle.setScenario(1);
				rectangle.setHeight(y2 - y1);
				rectangle.setWidth(x2 - x1);
			}
			// Scenario 2
			else if (x1 > x2 && y2 < y1) {
				rectangle.setScenario(2);
				rectangle.setHeight(y1 - y2);
				rectangle.setWidth(x1 - x2);
			}
			// Scenario 3
			else if (x1 > x2 && y1 < y2) {
				rectangle.setScenario(3);
				rectangle.setHeight(y2 - y1);
				rectangle.setWidth(x1 - x2);
			}
			// Scenario 4
			else if (x2 > x1 && y2 < y1) {
				rectangle.setScenario(4);
				rectangle.setHeight(y1 - y2);
				rectangle.setWidth(x2 - x1);
			}

			this.model.acceptCommand(new Commands(rectangle));
			this.model.deleteCommands();
			rectangle = null;
		}
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
