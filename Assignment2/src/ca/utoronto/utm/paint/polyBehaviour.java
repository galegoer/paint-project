package ca.utoronto.utm.paint;

import java.util.ArrayList;

import ca.utoronto.utm.mouseBehaviour.shapeBehaviour;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * polyBehaviour is a concrete shapeBehaviour strategy for the polyLine object. polyBehaviour knows
 * what a mouse input would do given that the mode selected is a polyLine. The polyline object can be
 * ended by a right click.
 * 
 * @author TheCentipedeBoys
 *
 */
public class polyBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;
	View view;
	
	static PolyLine polyLine;
	int thick;
	static Line l = new Line();
	
	/**
	 * Creates a new polyLineBehaviour strategy
	 * @param s An arrayList of strings representing the current mode(s)
	 * @param model the PaintModel 
	 * @param color	the color associated with the polyLine
	 * @param thick thickness of the polyLine
	 */
	public polyBehaviour(ArrayList<String> s, PaintModel model, String color, int thick, View view) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
		this.view = view;
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
	/**
	 * Create a new polyLine object and add it into the Command stack if the polyline does not exist.
	 * If the input is a RIGHT CLICK, the polyLine object will end and the user can now create a new polyLine object
	 * Any other clicks after the initializing of the object will add points to the list associated to the polyLine object
	 */
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
			this.model.acceptCommand(new Commands(polyLine));


		} else if (e.getButton() == MouseButton.SECONDARY) {
			
			this.model.delQCommand();
			polyLine = null;
			this.view.getPaintPanel().repaint();

		} else {
			polyLine.updateThick(this.thick);
			polyLine.updateColor(this.color);
			Point point = new Point((int) e.getX(), (int) e.getY());
			polyLine.addPoint(point);
			polyLine.setCentre(point);
			this.view.getPaintPanel().repaint();
		
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	/**
	 * As the mouse is moved, the static line variable is modified and given end point equivalent to the current
	 * mouse location. It is then added to the command stack. This allows the user to see polyLine feedback.
	 */
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
			this.model.acceptCommand(new Commands(l));
			if (!(this.model.getQueue().get(this.model.getSize() - 2).getObj() instanceof PolyLine))
				this.model.deleteCommands();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	/**
	 * Deletes the previous command in the command stack (which will be the feedback dotted line) so that the line
	 * disappears when the mode changes.
	 */
	public void polyReset() {
		this.model.delQCommand();
		polyLine = null;
		this.view.getPaintPanel().repaint();
		}
	
	/**
	 * Returns the static polyLine object associated with this behavior strategy
	 * @return polyline object associated with class
	 */
	public PolyLine getPolyLine() {
		return polyLine;
	}
	
}
