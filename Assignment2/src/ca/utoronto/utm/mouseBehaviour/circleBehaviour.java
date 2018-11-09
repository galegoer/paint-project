package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Circle;
import ca.utoronto.utm.paint.Commands;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.Rectangle;
import ca.utoronto.utm.paint.Square;
import javafx.scene.input.MouseEvent;

public class circleBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;

	static Circle circle;
	Integer thick;

	public circleBehaviour(ArrayList<String> s, PaintModel model, String color, Integer thick) {
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
		//this.model.removeCircle(this.model.getCircles().size() - 1);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		// Problematic notion of radius and centre!!
		Point centre = new Point((int) e.getX(), (int) e.getY());
		int radius = 0;
		int style = 0;
		int thick1 = this.thick;
		Circle circle2 = new Circle(centre, radius, color, style, thick1);
		if (this.modes.get(1) == "Fill") {
			circle2.setStyleC(1);
		}
		circle = circle2;
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
