package ca.utoronto.utm.paint;

public class Rectangle{

	private Point topLeft;
	private int width;
	private int height;
	private int scenario;
	private int style;
	private String rectangleColor;
	private int thickness;

	/**
	 * Sets the attributes of the rectangle class to be able to draw a rectangle.
	 * @param topLeft Topleft point of a rectangle
	 * @param width		Width of a rectangle 
	 * @param height	Height of rectangle
	 * @param scenario	Scenerio of rectangle
	 * @param recColor	color of rectangle 
	 * @param style		Style of rectangle(outline or fill)
	 * @param thickness	Thickness of rectangle
	 */
	public Rectangle(Point topLeft, int width, int height, int scenario, String recColor, int style, int thickness) {
		this.topLeft = topLeft;
		this.width = width;
		this.height = height;
		this.scenario = scenario;
		this.style = style;
		this.rectangleColor = recColor;
		this.thickness = thickness;
	}
	/**
	 * Gets the topLeft point of a rectangle.
	 * @return topLeft point of a rectangle.
	 */
	public Point getTopLeft() {
		return topLeft;
	}
	/**
	 * Sets the topLeft point of a rectangle.
	 * @param centre TopLeft point of the rectangle
	 */
	public void setTopLeft(Point centre) {
		this.topLeft = centre;
	}

	/**
	 * Gets the thickness of the rectangle.
	 * @return thickness of rectangle
	 */
	public int getThick() {
		return thickness;
	}
	/**
	 * Sets the thickness of rectangle.
	 * @param thickness thickness of rectangle.
	 */
	public void setThick(int thickness) {
		this.thickness = thickness;
	}
	//

	/**
	 * Set the width of this, tell our observer that we have changed
	 * @param w  the desired width
	 * @return nothing
	 */
	public void setWidth(int w) {
		if (w > 0)
			this.width = w;
	}

	/**
	 * Set the height of this, tell our observer that we have changed
	 * @param h   the desired height
	 * @return nothing
	 */
	public void setHeight(int h) {
		if (h > 0)
			height = h;
	}

	/**
	 *  gets the width of rectangle.
	 * @return the width of this
	 */
	public int getWidth() {
		return width;
	}

	/** 
	 * gets the height of the rectangle.
	 * @return the height of this
	 */
	public int getHeight() {
		return height;
	}
	/**
	 *  Gets the scenario number of the rectangle(1, 2, 3 or 4).
	 * @return Scenario number
	 */
	public int getScenario() {
		return scenario;
	}

	/**
	 * Sets the scenario number.
	 * @param s scenario of rectangle.
	 */
	public void setScenario(int s) {
		scenario = s;
	}
	/**
	 * gets the style of rectangle(fill or outline).
	 * @return style type of rectangle.
	 */
	public int getStyleR() {
		return style;
	}
	/**
	 * sets the style type of rectangle(fill or outline).
	 * @param style style type of rectangle.
	 */
	public void setStyleR(int style) {
		this.style = style;
	}
	/**
	 * gets the color of the rectangle 
	 * @return	color of the rectangle.
	 */
	public String getColorR() {
		return rectangleColor;
	}

}
