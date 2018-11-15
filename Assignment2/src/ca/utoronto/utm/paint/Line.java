package ca.utoronto.utm.paint;

/**
 * Model a line object. The line has an associated color, style, thickness and starting point.
 * @author TheCentipedeBoys
 *
 */
public class Line {
	private Point centre;
	private Point end;
	private String lineColor;
	private int thickness;
	private String style;
	
	/**
	 * Initializing an empty line object
	 */
	public Line() {
		return;
	}
	
	/**
	 * Creates a line given the starting point, color, style and specified thickness
	 * @param centre the starting point
	 * @param lineColor the specified color
	 * @param style the specified style
	 * @param thickness the specified thickness
	 */
	public Line(Point centre, String lineColor, String style, int thickness) {
		this.centre = centre;
		this.thickness = thickness;
		this.style = style;
		this.lineColor = lineColor;
	}
	
	/**
	 * Returns the starting point of the line object
	 * @return line starting point
	 */
	public Point getCentre() {
		return centre;
	}
	
	/**
	 * Sets the starting point of the line to the specified point
	 * @param newPoint the new point
	 */
	public void setCentre(Point newPoint) {
		this.centre = newPoint;
	}
	
	/**
	 * Sets the end point of the line to the specified point
	 * @param end the new point that the line should end at
	 */
	public void setEnd(Point end) {
		this.end = end;
	}
	/**
	 * Returns the color associated with the line
	 * @return the line color
	 */
	public String getColor() {
		return lineColor;
	}
	/**
	 * Sets the color of the line to a specified color
	 * @param color the specified color
	 */
	public void setColor(String color) {
		this.lineColor = color;
	}
	/**
	 * Sets the thickness of the line to a specified thickness value
	 * @param thick the specific thickness
	 */
	public void setThick(int thick) {
		this.thickness = thick;
	}
	
	/**
	 * Sets the style of the line to the specified style
	 * @param style the specified style of the line
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	/**
	 * Returns the style associated to the line
	 * @return line style
	 */
	public String getStyle() {
		return this.style;
	}

	/**
	 * Returns the end point of the line
	 * @return end point 
	 */
	public Point getEnd() {
		// TODO Auto-generated method stub
		return end;
	}
	
	/**
	 * Returns the thickness of the line
	 * @return thickness value of line
	 */
	public int getThick() {
		// TODO Auto-generated method stub
		return thickness;
	}
}

