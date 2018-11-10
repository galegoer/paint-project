package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Circle;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.Rectangle;
import javafx.scene.input.MouseEvent;

public class rectangleBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;

	Rectangle rectangle;
	int thick;

	public rectangleBehaviour(ArrayList<String> s, PaintModel model, String color, int thick) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

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
		this.model.addRectangle(rectangle);
		this.model.removeRectangle(this.model.getRectangles().size() - 1);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		Point centre = new Point((int) e.getX(), (int) e.getY());
		int height = 0;
		int width = 0;
		int scenario = 0;
		int style = 0;
		int thick1 = thick;
		Rectangle rectangle2 = new Rectangle(centre, width, height, scenario, this.color, style, thick);
		if (this.modes.get(1) == "Fill") {
			rectangle2.setStyleR(1);
		}
		rectangle = rectangle2;


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		if (rectangle != null) {

			// Point centre = new Point((int) e.getX(), (int) e.getY());
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

			this.model.addRectangle(rectangle);
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
	public void setstrokethickness(int slider_num) {
		thick = slider_num;

	}

}
