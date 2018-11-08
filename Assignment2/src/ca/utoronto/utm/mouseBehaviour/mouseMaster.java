package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Circle;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.Rectangle;
import ca.utoronto.utm.paint.Square;
import javafx.scene.input.MouseEvent;

public class mouseMaster implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;

	static Circle circle;
	static Rectangle rectangle;
	static Square square;

	public mouseMaster(ArrayList<String> s, PaintModel model, String color) {
		this.modes = s;
		this.model = model;
		this.color = color;
	}

	public void mouseDragged(MouseEvent e) {
		if (this.modes.get(0) == "Squiggle") {
			this.model.addPoint(new Point((int) e.getX(), (int) e.getY()));
		}  
		else if (this.modes.get(0) == "Square") {

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
			this.model.removeSquare(this.model.getSquares().size() - 1);
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (this.modes.get(0) == "Squiggle") {

		}  else if (this.modes.get(0) == "Square") {
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

		}  
		 else if (this.modes.get(0) == "Square") {

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
