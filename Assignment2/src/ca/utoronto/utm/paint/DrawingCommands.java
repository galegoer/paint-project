package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.Observable;

public class DrawingCommands extends Observable implements DrawInterface{

	private Object obj;

	public DrawingCommands(Object obj) {
		this.obj = obj;
	}


	@Override
	public void execute(GraphicsContext g) {
		// TODO Auto-generated method stub

	}

}
