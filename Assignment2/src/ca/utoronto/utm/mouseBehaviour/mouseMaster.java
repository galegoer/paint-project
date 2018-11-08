package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Circle;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.Rectangle;
import ca.utoronto.utm.paint.Square;
import javafx.scene.input.MouseEvent;

public class mouseMaster implements mouseBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;
	
	Circle circle;
	Rectangle rectangle;
	Square square;

	public mouseMaster(ArrayList<String> s, PaintModel model, String color) {
		this.modes = s;
		this.model = model;
		this.color = color;
	}

	public void mouseDragged(MouseEvent e) {
		return;
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (this.modes.get(0) == "Squiggle") {

		} else if (this.modes.get(0) == "Circle") {
			// Problematic notion of radius and centre!!
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int radius = 0;
			int style = 0;
			Circle circle = new Circle(centre, radius, color, style);
			if (this.modes.get(1) == "Fill") {
				circle.setStyleC(1);
			}
			this.circle = circle;
		
		} else if (this.modes.get(0) == "Rectangle") {
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int height = 0;
			int width = 0;
			int scenario = 0;
			int style = 0;
			Rectangle rectangle = new Rectangle(centre, width, height, scenario, this.color, style);
			if (this.modes.get(1) == "Fill") {
				rectangle.setStyleR(1);
			}
			this.rectangle = rectangle;

		} else if (this.modes.get(0) == "Square") {
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int side = 0;
			int scenario = 0;
			int style = 0;
			Square square = new Square(centre, side, scenario, this.color, style);
			if (this.modes.get(1) == "Fill") {
				square.setStyleS(1);
			}
			this.square = square;
		}
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (this.modes.get(0) == "Squiggle") {

		} else if (this.modes.get(0) == "Circle") {
			if (this.circle != null) {
				// Problematic notion of radius and centre!!
				int radius = (int) Math.sqrt(Math.pow((int) this.circle.getCentre().getX() - (int) e.getX(), 2)
						+ Math.pow((int) this.circle.getCentre().getY() - (int) e.getY(), 2));
				this.circle.setRadius(radius);
				this.model.addCircle(this.circle);
				this.circle = null;
			}

		} else if (this.modes.get(0) == "Rectangle") {

			if (this.rectangle != null) {

				// Point centre = new Point((int) e.getX(), (int) e.getY());
				// Begin

				int x1 = this.rectangle.getCentre().getX();
				int y1 = this.rectangle.getCentre().getY();
				// mouse release or end
				int x2 = (int) e.getX();
				int y2 = (int) e.getY();

				// Scenario 1
				if (x2 > x1 && y2 > y1) {
					this.rectangle.setScenario(1);
					this.rectangle.setHeight(y2 - y1);
					this.rectangle.setWidth(x2 - x1);
				}
				// Scenario 2
				else if (x1 > x2 && y2 < y1) {
					this.rectangle.setScenario(2);
					this.rectangle.setHeight(y1 - y2);
					this.rectangle.setWidth(x1 - x2);
				}
				// Scenario 3
				else if (x1 > x2 && y1 < y2) {
					this.rectangle.setScenario(3);
					this.rectangle.setHeight(y2 - y1);
					this.rectangle.setWidth(x1 - x2);
				}
				// Scenario 4
				else if (x2 > x1 && y2 < y1) {
					this.rectangle.setScenario(4);
					this.rectangle.setHeight(y1 - y2);
					this.rectangle.setWidth(x2 - x1);
				}

				this.model.addRectangle(this.rectangle);
				this.rectangle = null;
			}
		} else if (this.modes.get(0) == "Square") {

			if (this.square != null) {
				int x1 = this.square.getCentre().getX();
				int y1 = this.square.getCentre().getY();
				int x2 = (int) e.getX();
				int y2 = (int) e.getY();

				if (x2 > x1 && y2 > y1) {
					if ((x2 - x1) > (y2 - y1))
						this.square.setSideLength(x2 - x1);
					else
						this.square.setSideLength(y2 - y1);
					this.square.setScenario(1);
					Point centre = new Point(x1, y1);
					this.square.setCentre(centre);
				}
				// Scenario 2
				else if (x1 > x2 && y2 < y1) {
					if ((x1 - x2) > (y1 - y2))
						this.square.setSideLength(x1 - x2);
					else
						this.square.setSideLength(y1 - y2);
					this.square.setScenario(2);

				}
				// Scenario 3
				else if (x1 > x2 && y1 < y2) {
					if ((x1 - x2) > (y2 - y1))
						this.square.setSideLength(x1 - x2);
					else
						this.square.setSideLength(y2 - y1);
					this.square.setScenario(3);
				}
				// Scenario 4
				else if (x2 > x1 && y2 < y1) {
					if ((x2 - x1) > (y1 - y2))
						this.square.setSideLength(x2 - x1);
					else
						this.square.setSideLength(y1 - y2);
					this.square.setScenario(4);
				}

				this.model.addSquare(this.square);
				this.rectangle = null;
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		return;
	}

	// -----------------------------------------------------------------------------------------
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		return;
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		return;
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		return;
	}

}
