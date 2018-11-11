package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;


import javafx.scene.canvas.GraphicsContext;


public class PaintModel extends Observable {

	
	ArrayList<Commands> commandQueue;
	
	public PaintModel() {
		commandQueue = new ArrayList<Commands>();
	}
	
	public void acceptCommand(Commands command) {
		this.setChanged();
		this.notifyObservers();
		this.commandQueue.add(command);
	}
	
	//FOR REMOVING LAST MOVE (UNDO) STILL IN PROGRESS
	public void deleteCommand() {
		this.commandQueue.remove(commandQueue.size()-1);
	}
	
	void operateAll(GraphicsContext g) {
		for (Commands command: this.commandQueue) {
			command.execute(g);
		}
	}
	public void reset() {
		this.commandQueue.clear();
		this.setChanged();
		this.notifyObservers();
	}

	
	
}
