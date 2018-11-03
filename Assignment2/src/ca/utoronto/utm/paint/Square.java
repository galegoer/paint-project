package ca.utoronto.utm.paint;
import javafx.scene.shape.Shape;
public class Square extends Shape{
	
	private Point centre;
	private int side;
	

	public Square(Point centre, int side) {
		this.centre = centre;
		this.side = side;
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	public int getSideLength() {
		return side;
	}

	public void setSideLength(int side) {
		this.side = side;
	}

	@Override
	public com.sun.javafx.geom.Shape impl_configShape() {
		// TODO Auto-generated method stub
		return null;
	}

}

