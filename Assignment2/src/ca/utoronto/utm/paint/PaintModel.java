package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.canvas.GraphicsContext;

public class PaintModel extends Observable {

	ArrayList<Commands> commandQueue;
	ArrayList<Commands> redoQueue;

	public PaintModel() {
		commandQueue = new ArrayList<Commands>();
		redoQueue = new ArrayList<Commands>();
	}

	public void acceptCommand(Commands command) {
		this.commandQueue.add(command);
		this.setChanged();
		this.notifyObservers();
	}

	// FOR REMOVING LAST MOVE (UNDO) STILL IN PROGRESS
	public void deleteCommand() {
		Commands x = commandQueue.get(commandQueue.size()-1);
		this.commandQueue.remove(commandQueue.size() - 1);
		this.redoQueue.add(x);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void deleteCommands() {
		this.commandQueue.remove(commandQueue.size()-2);
	}
	
	/**
	 * Deletes last redo command
	 */
	public void delRCommand() {
		this.redoQueue.remove(redoQueue.size()-1);
	}
	
	public int getSize() {
		return this.commandQueue.size();
	}

	void operateAll(GraphicsContext g) {
		for (Commands command : this.commandQueue) {
			command.execute(g);
		}
	}

	public void reset() {
		this.commandQueue.clear();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void resetR() {
		this.redoQueue.clear();
	}

}
