package ca.utoronto.utm.paint;
import javafx.scene.shape.Shape;

public class Circle extends Shape{
	
	private Point centre;
	private int radius;
	private String stringcolor;
	private int style;
	private int thickness;
	
	
	public Circle(Point centre, int radius, String color, int style, int thickness) {
		this.centre = centre;
		this.radius = radius;
		this.stringcolor = color;
		this.style = style;
		this.thickness = thickness;
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
	
	// Method to set circle thickness.
	public int getThick() {
		return thickness;
	}
	public void setThick(int thickness) {
		this.thickness = thickness;
		//this.setStrokeWidth(thickness);
	}
	
	
	public int getStyleC() {
		return style;
	}
	
	public void setStyleC(int style) {
		this.style = style;
	}
	
	public String getString() {
		return this.stringcolor;
	}
	

	@Override
	public com.sun.javafx.geom.Shape impl_configShape() {
		// TODO Auto-generated method stub
		return null;
	}

}
