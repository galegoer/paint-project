package ManipulatorStrategies;

import ca.utoronto.utm.mouseBehaviour.context;
import javafx.scene.input.MouseEvent;

public class CircleManipulatorStrategy implements ShapeManipulatorStrategies {
	
	private context c = new context();
	@Override
	public void createShape() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shapeBehaviour(MouseEvent e) {
		// TODO Auto-generated method stub
		
		c.setModel(this.model);
		c.setColor(this.color);
		c.setModes(this.modes);
		c.setThick(this.thick);
		c.setView(this.view);
		c.setBehaviour(this.modes.get(0));
		c.move(event);
	}
	
	public void setContext(context context) {
		this.c = context;
	}
	}

}
