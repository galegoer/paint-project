package ca.utoronto.utm.paint;
import javafx.scene.shape.Shape;
public class Square extends Shape{

	private Point centre;
	private int side;
	private int scenario;
	private String sqcolor;
	private int style;
	private int thickness;
	private int arcH;
	private int arcW;
	private int arcHeight;
	private int arcWidth;


	public Square(Point centre, int side, int scenario, String color, int style, int thickness, int arcHeight, int arcWidth) {
		this.centre = centre;
		this.side = side;
		this.scenario = scenario;
		this.sqcolor = color;
		this.style = style;
		this.thickness = thickness;
		this.arcHeight = arcH;
		this.arcWidth = arcW;
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

	// Method to set square thickness.
	public int getThick() {
		return thickness;
	}
	public void setThick(int thickness) {
		this.thickness = thickness;
	}
	//


	public int getScenario() {
		return scenario;
	}
	//Set the scenario number

	public void setScenario(int s) {
		scenario = s;
	}

	public String getColorS() {
		return sqcolor;
	}

	public int getStyleS() {
		return style;
	}

	public void setStyleS(int style) {
		this.style = style;
	}
	// Methods for rounded rectangle 
	// copy of rectangle class methods end here.

	/**
	 * Set the width of the arc of the rounded rectangle , tell our observer that we have changed
	 * @param w  the desired width
	 * @return nothing
	 */
	public void setArcWidth(int w) {
		if (w > 0)
			this.arcWidth = w;
	}

	/**
	 * Set the height of the arc of the rounded rectangle, tell our observer that we have changed
	 * @param h   the desired height
	 * @return nothing
	 */
	public void setArcHeight(int h) {
		if (h > 0)
			this.arcHeight = h;
	}

	/**
	 * @return the width of arc
	 */
	public int getArcWidth() {
		return this.arcWidth;
	}

	/**
	 * @return the height of arc
	 */
	public int getArcHeight() {
		return this.arcHeight;
	}


	@Override
	public com.sun.javafx.geom.Shape impl_configShape() {
		// TODO Auto-generated method stub
		return null;
	}

}

