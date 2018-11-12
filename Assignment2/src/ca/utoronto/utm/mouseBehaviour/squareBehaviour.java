package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Commands;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.Square;
import javafx.scene.input.MouseEvent;

public class squareBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;

	static Square square;
	int thick;

	public squareBehaviour(ArrayList<String> s, PaintModel model, String color, int thick) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

		int x1 = square.getCentre().getX();
		int y1 = square.getCentre().getY();
		int x2 = (int) e.getX();
		int y2 = (int) e.getY();
		if (x2 > x1 && y2 > y1) {
			if ((x2 - x1) > (y2 - y1))
				square.setSideLength(x2 - x1);
			else
				square.setSideLength(y2 - y1);
			square.setScenario(1);
			Point centre = new Point(x1, y1);
			square.setCentre(centre);
		}
		// Scenario 2
		else if (x1 > x2 && y2 < y1) {
			if ((x1 - x2) > (y1 - y2))
				square.setSideLength(x1 - x2);
			else
				square.setSideLength(y1 - y2);
			square.setScenario(2);

		}
		// Scenario 3
		else if (x1 > x2 && y1 < y2) {
			if ((x1 - x2) > (y2 - y1))
				square.setSideLength(x1 - x2);
			else
				square.setSideLength(y2 - y1);
			square.setScenario(3);
		}
		// Scenario 4
		else if (x2 > x1 && y2 < y1) {
			if ((x2 - x1) > (y1 - y2))
				square.setSideLength(x2 - x1);
			else
				square.setSideLength(y1 - y2);
			square.setScenario(4);
		}

		this.model.acceptCommand(new Commands(square));
		this.model.deleteCommands();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		Point centre = new Point((int) e.getX(), (int) e.getY());
		int side = 0;
		int scenario = 0;
		int style = 0;
		Square square2 = new Square(centre, side, scenario, this.color, style,this.thick);
		if (this.modes.get(1) == "Fill") {
			square2.setStyleS(1);
		}
		square = square2;
		this.model.acceptCommand(new Commands(square));

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (square != null) {
			int x1 = square.getCentre().getX();
			int y1 = square.getCentre().getY();
			int x2 = (int) e.getX();
			int y2 = (int) e.getY();

			if (x2 > x1 && y2 > y1) {
				if ((x2 - x1) > (y2 - y1))
					square.setSideLength(x2 - x1);
				else
					square.setSideLength(y2 - y1);
				square.setScenario(1);
				Point centre = new Point(x1, y1);
				square.setCentre(centre);
			}
			// Scenario 2
			else if (x1 > x2 && y2 < y1) {
				if ((x1 - x2) > (y1 - y2))
					square.setSideLength(x1 - x2);
				else
					square.setSideLength(y1 - y2);
				square.setScenario(2);

			}
			// Scenario 3
			else if (x1 > x2 && y1 < y2) {
				if ((x1 - x2) > (y2 - y1))
					square.setSideLength(x1 - x2);
				else
					square.setSideLength(y2 - y1);
				square.setScenario(3);
			}
			// Scenario 4
			else if (x2 > x1 && y2 < y1) {
				if ((x2 - x1) > (y1 - y2))
					square.setSideLength(x2 - x1);
				else
					square.setSideLength(y1 - y2);
				square.setScenario(4);
			}

			this.model.acceptCommand(new Commands(square));
			this.model.deleteCommands();
			square = null;
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
