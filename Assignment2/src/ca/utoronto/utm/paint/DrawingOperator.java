package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

public class DrawingOperator {
	ArrayList<ShapeCommand> commandQueue;
	
	public DrawingOperator(){
		commandQueue = new ArrayList<ShapeCommand>();
	}
	
	public void acceptCommand(ShapeCommand command) {
		System.out.print("maybe 1");
		this.commandQueue.add(command);
	}
	void operateAll(GraphicsContext g) {
		for (ShapeCommand command: this.commandQueue) {
			// need to change it probably
			System.out.print("maybe 2");
			command.execute(g);
		}
		commandQueue.clear();
	}

}
