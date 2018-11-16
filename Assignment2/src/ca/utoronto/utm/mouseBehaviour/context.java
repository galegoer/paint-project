package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.polyBehaviour;
import javafx.scene.input.MouseEvent;

/**
 * A context object contains a shapeBehaviour strategy that is created given the specified mode.
 * The context object understands how a mouse input will effect the shape. The context object also knows about
 * the corresponding mode, style, color, etc so that it may be forwarded to the shapeBehaviour strategy.
 * @author TheCentipedeBoys
 *
 */
public class context {
	shapeBehaviour behaviour;
	ArrayList<String> modes;
	String color;
	PaintModel model;
	int thick;
	View view;
	String lineStyle;
	
	/**
	 * Creates a new context object
	 */
	public context() {
		return;
	}

	
	/**
	 * Sets the context model to the given paint model
	 * @param s the given paint model
	 */
	public void setModel(PaintModel s) {
		this.model = s;
	}
	/**
	 * sets the context color to the given color
	 * @param s the given color
	 */
	public void setColor(String s) {
		this.color = s;
	}
	/**
	 * sets the context thickness to the given thickness	
	 * @param s the given thickness
	 */
	public void setThick(int s) {
		this.thick = s;
	}
	/**
	 * sets the modes to an arraylist containing the current mode
	 * @param s the arraylist modes should be set to
	 */
	public void setModes(ArrayList<String> s) {
		this.modes = s;
	}
	
	/**
	 * Creates the correct shapebehaviour strategy corresponding to the given mode, represented by the string s.
	 * @param s the mode that the user is currently on
	 */
	public void setBehaviour(String s) {
		if (s == "Circle") 
			this.behaviour = new circleBehaviour(this.modes, this.model, this.color, this.thick);
		else if (s == "Rectangle") 
			this.behaviour = new rectangleBehaviour(this.modes, this.model, this.color, this.thick);
		else if (s == "RoundedRectangle") 
			this.behaviour = new roundedRectBehaviour(this.modes, this.model, this.color, this.thick);
		else if (s == "Square") 
			this.behaviour = new squareBehaviour(this.modes, this.model, this.color, this.thick, 0);
		else if (s == "RoundedSquare") 
			this.behaviour = new squareBehaviour(this.modes, this.model, this.color, this.thick, 1);
		else if (s == "Squiggle") 
			this.behaviour = new squiggleBehaviour(this.modes, this.model, this.color, this.thick);
		else if (s == "PolyLine") 
			this.behaviour = new polyBehaviour(this.modes, this.model, this.color, this.thick, this.view);
		else if (s == "Line") 
			this.behaviour = new lineBehaviour(this.modes, this.model, this.color, this.lineStyle, this.thick);
	}
	
	/**
	 * Returns the shapeBehaviour strategy that is currently associated with the context object
	 * @return the current shapebehaviour strategy installed in the context object
	 */
	public shapeBehaviour getBehaviour() {
		return behaviour;
	}
	
	/**
	 * given the mouse event, "event", move will change the shape accordlingly by calling the methods associated
	 * to the current shapeBehaviour strategy installed
	 * @param event mouse input by user
	 */
	public void move(MouseEvent event) {
		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			this.behaviour.mouseDragged(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			this.behaviour.mousePressed(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
			this.behaviour.mouseMoved(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			this.behaviour.mouseClicked(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			this.behaviour.mouseReleased(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
			this.behaviour.mouseEntered(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
			this.behaviour.mouseExited(event);
		}
	}
	
	/**
	 * sets the view of the context object to the given view
	 * @param view2 the given view
	 */
	public void setView(View view2) {
		this.view = view2;
		
	}

}
