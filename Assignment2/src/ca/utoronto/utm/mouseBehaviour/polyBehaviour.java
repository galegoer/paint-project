package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Line;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.PolyLine;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class polyBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;

	static PolyLine polyLine;
	int thick;
	static Line l = new Line();

	public polyBehaviour(ArrayList<String> s, PaintModel model, String color, int thick) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	// Current bug with Polyline: you can change the final thickness of the polyline
	// by moving the slider before hitting right click.
	// Bug in general, the first shape changes thickness as well when u apply a
	// polyline object!
	// New USerstory poly feedback.
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (polyLine == null) {

			PolyLine polyLine2 = new PolyLine(this.color, this.thick);

			Point center = new Point((int) e.getX(), (int) e.getY());

			polyLine = polyLine2;
			polyLine.updateThick(this.thick);
			polyLine.updateColor(this.color);
			polyLine.addPoint(center);
			polyLine.setCentre(center);
			this.model.addPolyLine(polyLine);
			// this.model.addPolyPoint(center);

		} else if (e.getButton() == MouseButton.SECONDARY) {
			// this.model.getPolyPoints().clear();
			// polyLine.updateThick(this.thick);
			// this.model.addPolyLine(polyLine);
			polyLine = null;
			// REMOVE PREVIOUS LINE BUG!!! NEED TO REMOVE LAST COMMAND ON DRAWING LINE FROM
			// STACK
		} else {
			polyLine.updateThick(this.thick);
			polyLine.updateColor(this.color);
			Point point = new Point((int) e.getX(), (int) e.getY());
			polyLine.addPoint(point);
			polyLine.setCentre(point);
			this.model.addPolyLine(polyLine);
			// this.model.addPolyPoint(point);
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if (polyLine != null) {
			l.setCentre(polyLine.getCentre());
			l.setColor(this.color);
			l.setThick(this.thick);
			l.setStyle("Dotted");
			Point p = new Point((int) e.getX(), (int) e.getY());
			l.setEnd(p);
			this.model.addLine(l);

		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}
}
