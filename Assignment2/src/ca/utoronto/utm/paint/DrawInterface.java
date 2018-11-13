package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
//This interface is for to implement command design pattern for colors and thickness.


public interface DrawInterface {
	public void execute(GraphicsContext g);


}
