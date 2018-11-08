package ca.utoronto.utm.mouseBehaviour;

import ca.utoronto.utm.paint.PaintModel;
import javafx.scene.input.MouseEvent;

public class context {
	mouseBehaviour behaviour;
	String style, mode;
	PaintModel model; //temporary? used to give mouseMaster a model so that it can run our code, however this will change depending on a better implication of model
	//MouseEvent event;
	
	public context() {
		//this.style = style ;
		//this.mode = mode;
		//this.behaviour = new mouseMaster(mode, style, model);
		
	}
	
	
	public void setBehaviour(mouseMaster mouseMaster)
	{
		this.behaviour = mouseMaster;
			
	}

	public mouseBehaviour getBehaviour()
	{
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
