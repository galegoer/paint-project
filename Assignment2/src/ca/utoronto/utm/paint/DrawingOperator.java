package ca.utoronto.utm.paint;

import java.util.ArrayList;

public class DrawingOperator {
	ArrayList<DrawInterface> commandQueue;
	
	public DrawingOperator(){
		commandQueue = new ArrayList<DrawInterface>();
	}
	
	public void acceptCommand(DrawInterface command) {
		this.commandQueue.add(command);
	}
	void operateAll() {
		for (DrawInterface command: this.commandQueue) {
			// need to change it probably
			command.execute(null);
		}
		commandQueue.clear();
	}

}
