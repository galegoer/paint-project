package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * Interface for executing command to draw shape(s)
 * @author TheCentipedeBoys
 *
 */

public interface ShapeCommand {
	public abstract void execute(GraphicsContext g);
}
