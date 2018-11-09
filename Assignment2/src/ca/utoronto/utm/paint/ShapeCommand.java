package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

public interface ShapeCommand {
	public abstract void execute(GraphicsContext g);
}
