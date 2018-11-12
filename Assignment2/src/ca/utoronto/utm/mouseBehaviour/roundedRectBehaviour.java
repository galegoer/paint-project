package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Commands;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.RoundedRectangle;
import javafx.scene.input.MouseEvent;

public class roundedRectBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;

	static RoundedRectangle roundedrectangle;
	Integer thick;

	public roundedRectBehaviour(ArrayList<String> s, PaintModel model, String color, Integer thick) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// Begin
		int x1 = roundedrectangle.getCentre().getX();
		int y1 = roundedrectangle.getCentre().getY();
		// mouse release or end
		int x2 = (int) e.getX();
		int y2 = (int) e.getY();
		//(int) (p.getHeight() * (double)(0.07));
		//(int) (p.getWidth() * (double)(0.07));

		if (x2 > x1 && y2 > y1) {
			roundedrectangle.setScenario(1);
			Point centre = new Point(x1, y1);
			roundedrectangle.setHeight(y2 - y1);
			roundedrectangle.setWidth(x2 - x1);
			roundedrectangle.setCentre(centre);
			roundedrectangle.setArcHeight((int)((y2 - y1)* (double)(0.2)));
			roundedrectangle.setArcWidth((int)((x2 - x1)* (double)(0.2)));
		}
		// Scenario 2
		else if (x1 > x2 && y2 < y1) {
			roundedrectangle.setScenario(2);
			roundedrectangle.setHeight(y1 - y2);
			roundedrectangle.setWidth(x1 - x2);
			roundedrectangle.setArcHeight((int)((y1 - y2)* (double)(0.2)));
			roundedrectangle.setArcWidth((int)((x1 - x2)* (double)(0.2)));
		}
		// Scenario 3
		else if (x1 > x2 && y1 < y2) {
			roundedrectangle.setScenario(3);
			roundedrectangle.setHeight(y2 - y1);
			roundedrectangle.setWidth(x1 - x2);
			roundedrectangle.setArcHeight((int)((y2 - y1)* (double)(0.2)));
			roundedrectangle.setArcWidth((int)((x1 - x2)* (double)(0.2)));
		}
		// Scenario 4
		else if (x2 > x1 && y2 < y1) {
			roundedrectangle.setScenario(4);
			roundedrectangle.setHeight(y1 - y2);
			roundedrectangle.setWidth(x2 - x1);
			roundedrectangle.setArcHeight((int)((y1 - y2)* (double)(0.2)));
			roundedrectangle.setArcWidth((int)((x2 - x1)* (double)(0.2)));
		}
		this.model.acceptCommand(new Commands(roundedrectangle));
		this.model.deleteCommands();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point centre = new Point((int) e.getX(), (int) e.getY());
		int height = 0;
		int width = 0;
		int scenario = 0;
		int style = 0;
		int arch = 0;
		int arcw = 0;
		RoundedRectangle rectangle3 = new RoundedRectangle(centre, width, height, scenario, this.color, style, thick, arch, arcw);
		if (this.modes.get(1) == "Fill") {
			rectangle3.setStyleR(1);
		}
		roundedrectangle = rectangle3;
		this.model.acceptCommand(new Commands(roundedrectangle));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (roundedrectangle != null) {

			// EDIT THIS BLOCK OF CODE TO SET ARC HEIGHT AND WIDTH.
			int x1 = roundedrectangle.getCentre().getX();
			int y1 = roundedrectangle.getCentre().getY();
			// mouse release or end
			int x2 = (int) e.getX();
			int y2 = (int) e.getY();
			// Scenario 1
			System.out.print("hi");
			if (x2 > x1 && y2 > y1) {
				roundedrectangle.setScenario(1);
				roundedrectangle.setHeight(y2 - y1);
				roundedrectangle.setWidth(x2 - x1);
				roundedrectangle.setArcHeight((int)((y2 - y1)* (double)(0.2)));
				roundedrectangle.setArcWidth((int)((x2 - x1)* (double)(0.2)));
			}
			// Scenario 2
			else if (x1 > x2 && y2 < y1) {
				roundedrectangle.setScenario(2);
				roundedrectangle.setHeight(y1 - y2);
				roundedrectangle.setWidth(x1 - x2);
				roundedrectangle.setArcHeight((int)((y1 - y2)* (double)(0.2)));
				roundedrectangle.setArcWidth((int)((x1 - x2)* (double)(0.2)));
			}
			// Scenario 3
			else if (x1 > x2 && y1 < y2) {
				roundedrectangle.setScenario(3);
				roundedrectangle.setHeight(y2 - y1);
				roundedrectangle.setWidth(x1 - x2);
				roundedrectangle.setArcHeight((int)((y2 - y1)* (double)(0.2)));
				roundedrectangle.setArcWidth((int)((x1 - x2)* (double)(0.2)));
			}
			// Scenario 4
			else if (x2 > x1 && y2 < y1) {
				roundedrectangle.setScenario(4);
				roundedrectangle.setHeight(y1 - y2);
				roundedrectangle.setWidth(x2 - x1);
				roundedrectangle.setArcHeight((int)((y1 - y2)* (double)(0.2)));
				roundedrectangle.setArcWidth((int)((x2 - x1)* (double)(0.2)));
			}
			this.model.acceptCommand(new Commands(roundedrectangle));
			this.model.deleteCommands();
			roundedrectangle = null;
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
