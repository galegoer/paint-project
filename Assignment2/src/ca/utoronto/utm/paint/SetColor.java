package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public class SetColor implements ShapeCommand{
//	private ShapeColor color;
	private static String a;
	private GraphicsContext b;

	public SetColor(Line c , GraphicsContext g) {
		// TODO Auto-generated constructor stub
		a = c.getColor();
		b =  g;
	}

	@Override
	public void execute(GraphicsContext g) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
//		Color b = color.setPaint(this.a);
		System.out.print("maybe");
		b.setStroke(ShapeColor.setPaint(a));
		
	}

}
