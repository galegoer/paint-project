package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

public class SetThickness implements ShapeCommand{
	private Shape shape;
	private int amount = 0;
	private GraphicsContext b;


	public SetThickness(Line c ,  GraphicsContext g) {
		// TODO Auto-generated constructor stub
		b = g;
	}

	@Override
	public void execute(GraphicsContext g) {
		// TODO Auto-generated method stub
		b.setLineWidth(amount);

	}

}
