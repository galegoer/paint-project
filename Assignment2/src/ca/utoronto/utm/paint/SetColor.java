package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public class SetColor implements DrawInterface{
	private ShapeColor color;
	private static String a;

	public SetColor(Line c , GraphicsContext g) {
		this.color = color;
		// TODO Auto-generated constructor stub
		a = c.getColor();
	}

	@Override
	public void execute(GraphicsContext g) {
		// TODO Auto-generated method stub
		Color b = color.setPaint(a);
		g.setStroke(b);

	}

}
