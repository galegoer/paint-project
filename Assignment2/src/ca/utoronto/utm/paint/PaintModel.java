package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.canvas.GraphicsContext;

/**
 * A Paint Model consists of the two queues to represent 
 * what the PaintPanel should paint.
 * @author TheCentipedeBoys
 *
 */

public class PaintModel extends Observable {

	ArrayList<Commands> commandQueue;
	ArrayList<Commands> redoQueue;
	polyBehaviour p;

	/**
	 * Creates a Paint Model that has commandQueue and redoQueue.
	 */
	public PaintModel() {
		commandQueue = new ArrayList<Commands>();
		redoQueue = new ArrayList<Commands>();
	}
	
	/**
	 * Adds a new command to the command queue to later
	 * be executed. Then sets changed and notifies observers.
	 * @param command a Commands object to be accepted
	 */
	public void acceptCommand(Commands command) {
		this.commandQueue.add(command);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Removes last command in command queue. Adds it 
	 * to the redo queue. Sets changed
	 * and notifies observers.
	 */
	public void deleteCommand() {
		Commands x = commandQueue.get(commandQueue.size() - 1);
		this.commandQueue.remove(commandQueue.size() - 1);
		this.redoQueue.add(x);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Deletes the second last command from
	 * the command queue.
	 */
	public void deleteCommands() {
		this.commandQueue.remove(commandQueue.size() - 2);
	}
	
	/**
	 * Deletes the last command from the command 
	 * queue.
	 */

	public void delQCommand() {
		this.commandQueue.remove(commandQueue.size() - 1);
	}

	/**
	 * Deletes last redo command from the redo queue.
	 */
	public void delRCommand() {
		this.redoQueue.remove(redoQueue.size() - 1);
	}

	/**
	 * Returns size of the command queue.
	 * @return size of the command queue.
	 */
	
	public int getSize() {
		return this.commandQueue.size();
	}
	
	/**
	 * Executes all commands in the command queue.
	 * @param g graphics context 
	 */

	void operateAll(GraphicsContext g) {
		for (Commands command : this.commandQueue) {
			command.execute(g);
		}
	}

	/**
	 * Clears the command queue, set changed and
	 * notify observers.
	 */
	
	public void reset() {
		this.commandQueue.clear();
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Clears the redo queue.
	 */
	
	public void resetR() {
		this.redoQueue.clear();
	}

	/**
	 * Returns the command queue.
	 * @return the command queue.
	 */
	
	public ArrayList<Commands> getQueue() {
		return this.commandQueue;
	}

}
