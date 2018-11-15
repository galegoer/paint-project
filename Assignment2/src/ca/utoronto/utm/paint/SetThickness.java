package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

public class SetThickness implements DrawInterface{
	private Shape shape;
	private int amount = 0;
	
//	public SetThickness(Shape shape, int amount) {
//		this.shape = shape;
//		this.amount = amount;
//		
//	}
	public SetThickness(Line c ,  GraphicsContext g) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute(GraphicsContext g) {
		// TODO Auto-generated method stub
		g.setLineWidth(amount);
		
	}

}
