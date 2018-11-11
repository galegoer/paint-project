package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;


import ca.utoronto.utm.paint.Commands;
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
	String style;

	public lineBehaviour(ArrayList<String> s, PaintModel model, String color, String style, int thick) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
		this.style = style;

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x2 = (int) e.getX();
		int y2 = (int) e.getY();
		Point end = new Point(x2, y2);
		line.setEnd(end);
		
		this.model.acceptCommand(new Commands(line));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		Point centre = new Point((int) e.getX(), (int) e.getY());

		Line line2 = new Line(centre, this.color,this.style, this.thick);
		line = line2;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		if (line!= null) {

			int x2 = (int) e.getX();
			int y2 = (int) e.getY();
			Point end = new Point(x2, y2);
			line.setEnd(end);
			
			this.model.acceptCommand(new Commands(line));
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
