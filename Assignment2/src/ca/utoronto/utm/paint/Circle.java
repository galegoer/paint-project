package ca.utoronto.utm.paint;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

/**
 * Model of a circle and its properties: radius, centre, color,
 * style, and thickness.
 * @author TheCentipedeBoys
 *
 */

public class Circle extends Shape{
	
	private Point centre;
	private int radius;
	private String stringcolor;
	private int style;
	private int thickness;
	
	/**
	 * Constructs a circle with centre, radius, color, style,
	 * and thickness.
	 * @param centre Point in middle of circle
	 * @param radius integer of the radius length
	 * @param color string representing color
	 * @param style integer representing outline or fill (0 or 1)
	 * @param thickness integer representing thickness
	 */
	public Circle(Point centre, int radius, String color, int style, int thickness) {
		this.centre = centre;
		this.radius = radius;
		this.stringcolor = color;
		this.style = style;
		this.thickness = thickness;
	}
	
	/**
	 * Returns centre Point
	 * @return Point centre of circle
	 */
	
	public Point getCentre() {
		return centre;
	}

	/**
	 * Sets centre of circle
	 * @param centre
	 */
	
	public void setCentre(Point centre) {
		this.centre = centre;
	}

	/**
	 * 
	 * @return integer representing radius
	 */
	
	public int getRadius() {
		return radius;
	}

	/**
	 * Sets the radius of the circle
	 * @param radius integer of radius to be set 
	 */
	
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
	
	/**
	 * 
	 * @return shape color 
	 */
	
	public String getString() {
		return this.stringcolor;
	}
	public static Color setPaint(String stringcolor) {
		if (stringcolor == "Red"){
				return Color.RED;
		}
		if (stringcolor == "Green"){
			return Color.GREEN;
		}
		if (stringcolor == "Blue"){
			return Color.BLUE;
		}
		if (stringcolor == "Pink"){
			return Color.PINK;
		}
		if (stringcolor == "Orange"){
			return Color.ORANGE;
		}
		if (stringcolor == "Yellow"){
			return Color.YELLOW;
		}
		if (stringcolor == "Brown"){
			return Color.BROWN;
		}
		else {
			return Color.BLACK;
		}
	}

	@Override
	public com.sun.javafx.geom.Shape impl_configShape() {
		// TODO Auto-generated method stub
		return null;
	}

}
