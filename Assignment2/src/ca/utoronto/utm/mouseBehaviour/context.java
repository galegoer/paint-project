package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.PaintModel;
import javafx.scene.input.MouseEvent;

public class context {
	shapeBehaviour behaviour;
	ArrayList<String> modes;
	String color;
	PaintModel model; // temporary? used to give mouseMaster a model so that it can run our code,
						// however this will change depending on a better implication of model
	// MouseEvent event;

	public context() {
		return;
	}

	public context(ArrayList<String> modes, PaintModel model, String color) {
		this.modes = modes;
		this.model = model;
		this.color = color;
		// this.behaviour = new mouseMaster(mode, style, model);

	}

	public void setModel(PaintModel s) {
		this.model = s;
	}

	public void setColor(String s) {
		this.color = s;
	}

	public void setModes(ArrayList<String> s) {
		this.modes = s;
	}

	public void setBehaviour(String s) {
		if (s == "Circle") 
			this.behaviour = new circleBehaviour(this.modes, this.model, this.color);
		else if (s == "Rectangle") 
			this.behaviour = new rectangleBehaviour(this.modes, this.model, this.color);
	}
	public shapeBehaviour getBehaviour() {
		return behaviour;
	}

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

}
