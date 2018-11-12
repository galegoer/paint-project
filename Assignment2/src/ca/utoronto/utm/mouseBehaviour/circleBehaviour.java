package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Circle;
import ca.utoronto.utm.paint.Commands;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import javafx.scene.input.MouseEvent;

public class circleBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;

	static Circle circle;
	int thick;

	public circleBehaviour(ArrayList<String> s, PaintModel model, String color, int thick) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

		int radius = (int) Math.sqrt(Math.pow((int) circle.getCentre().getX() - (int) e.getX(), 2)
				+ Math.pow((int) circle.getCentre().getY() - (int) e.getY(), 2));
		circle.setRadius(radius);
		this.model.acceptCommand(new Commands(circle));
		this.model.deleteCommands();
	}

	@Override
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
		// TODO Auto-generated method stub

	}

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
//	public static void setstrokethickness(int slider_num) {
//		circleBehaviour.setstrokethickness(slider_num);
//		rectangleBehaviour.setstrokethickness(slider_num);
//		squareBehaviour.setstrokethickness(slider_num);
//	
//	}

}
