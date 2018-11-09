package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Line;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import javafx.scene.input.MouseEvent;

public class lineBehaviour implements shapeBehaviour {

	PaintModel model;
	ArrayList<String> modes;
	String color;

	static Line line;
	Integer thick;

	public lineBehaviour(ArrayList<String> s, PaintModel model, String color, Integer thick) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

		// Begin
		int x1 = line.getCentre().getX();
		int y1 = line.getCentre().getY();
		// mouse release or end
		int x2 = (int) e.getX();
		int y2 = (int) e.getY();
		Point end = new Point(x2, y2);
		line.setEnd(end);

		this.model.addLine(line);
		//this.model.removeline(this.model.getLines().size() - 1);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		Point centre = new Point((int) e.getX(), (int) e.getY());
		Line line2 = new Line(centre, this.color, thick);
		line= line2;


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		if (line!= null) {

			// Point centre = new Point((int) e.getX(), (int) e.getY());
			// Begin

			int x1 = line.getCentre().getX();
			int y1 = line.getCentre().getY();
			// mouse release or end
			int x2 = (int) e.getX();
			int y2 = (int) e.getY();
			Point end = new Point(x2, y2);
			line.setEnd(end);
			

			this.model.addLine(line);
			line= null;
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
