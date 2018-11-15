package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

public interface DrawCommand {
	public abstract void execute(GraphicsContext g);
}

