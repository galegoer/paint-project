package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.canvas.GraphicsContext;

public class PaintModel extends Observable {

	ArrayList<Commands> commandQueue;
	ArrayList<Commands> redoQueue;
	polyBehaviour p;

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
		Commands x = commandQueue.get(commandQueue.size() - 1);
		//checks if last command was a polyline
		//new polybehaviour created so i can use the class
		//first gets the polyline object from x, then sets polyline again cuz i set it to null when u end a polyline
		//gets point from polyline list, stores it in a variable, "point"
		//removes the point
		//adds the point as a command to redoqueue (see stylechoose panel for broken redo code)
		//ALSO THERES A BUG WHERE IF U PRESS UNDO AND MOVE UR MOUSE BACK INTO THE CANVAS, THE INDICATOR WILL SHOW UP AGAIN
		//THIS IS BECAUSE THE INDICATOR ALWAYS SHOWS UP IN THE POLYLINE ISNT NULL AND I HAD TO SET THE POLY TO NOT NULL 
		//SO THAT THE CODE BELOW COULD WORK. this is only the case if you dont "end" polyline.
		if (x.getObj() instanceof PolyLine) {
			p = new polyBehaviour(null, null, null, 0, null);
			p.setPolyLine(x.getObj());
			Point point = p.getPolyLine().getList().get(p.getPolyLine().getList().size()-1);
			p.getPolyLine().getList().remove(p.getPolyLine().getList().size() - 1);
			this.redoQueue.add(new Commands(point));
		//-------------------------------------------------------------------------------------
		} else {
			this.commandQueue.remove(commandQueue.size() - 1);
			this.redoQueue.add(x);
		}
		
		this.setChanged();
		this.notifyObservers();
	}

	public void deleteCommands() {
		this.commandQueue.remove(commandQueue.size() - 2);
	}

	public void delQCommand() {
		this.commandQueue.remove(commandQueue.size() - 1);
	}

	/**
	 * Deletes last redo command
	 */
	public void delRCommand() {
		this.redoQueue.remove(redoQueue.size() - 1);
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

	public ArrayList<Commands> getQueue() {
		return this.commandQueue;
	}

}
