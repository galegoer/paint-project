package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Commands;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.Squiggle;
import javafx.scene.input.MouseEvent;

public class squiggleBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;
	Integer thick;

	static Squiggle squiggle;
	
	public squiggleBehaviour(ArrayList<String> s, PaintModel model, String color, Integer thick) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		//CHANGE TO JUST POINT PROB DONT NEED A SQUIGGLE CLASS
		Point point = new Point((int) e.getX(), (int) e.getY());
		int thickness = this.thick;
		Squiggle squig = new Squiggle(point, this.color, thickness);
		//squiggle.addPoint(point);
		this.model.acceptCommand(new Commands(squig));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point start = new Point((int) e.getX(), (int) e.getY());		
		int thickness = this.thick;
		//squiggle.setStart(start);
		//ArrayList<Point> points = new ArrayList<>();
		//points.add(start);
		Squiggle squig = new Squiggle(start, this.color, thickness);
		squiggle = squig;
		this.model.acceptCommand(new Commands(squiggle));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//squiggle.setEnd(new Point((int) e.getX(), (int) e.getY()));
		this.model.acceptCommand(new Commands(squiggle));
		squiggle = null;
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
