package ca.utoronto.utm.paint;
import javafx.scene.shape.Shape;
public class Circle extends Shape{
	
	private Point centre;
	private int radius;
	private int style;

	public Circle(Point centre, int radius, int style) {
		this.centre = centre;
		this.radius = radius;
		this.style = style;
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int getStyleC() {
		return style;
	}
	
	public void setStyleC(int style) {
		this.style = style;
	}

	@Override
	public com.sun.javafx.geom.Shape impl_configShape() {
		// TODO Auto-generated method stub
		return null;
	}

}
