package ca.utoronto.utm.paint;

public class RoundedRectangle {
	private Point centre;
	private int width;
	private int height;
	private int scenario;
	private int style;
	private String rectangleColor;
	private int thickness;
	private int arcH;
	private int arcW;
	private int arcHeight;
	private int arcWidth;
	

	public RoundedRectangle(Point centre, int width, int height, int scenario, String recColor, int style,
			int thickness, int arcHeight, int arcWidth) {
		this.centre = centre;
		this.width = width;
		this.height = height;
		this.scenario = scenario;
		this.style = style;
		this.rectangleColor = recColor;
		this.thickness = thickness;
		this.arcHeight = arcH;
		this.arcWidth = arcW;
	}
	
	
	// Copy of methods from rectangle class begins here 
	
	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	// Method to set rectangle thickness.
	public int getThick() {
		return thickness;
	}
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
	 * @return the width of this
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height of this
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * 
	 * @return Scenario number
	 */
	public int getScenario() {
		return scenario;
	}

	/**
	 * Set the scenario number
	 */
	public void setScenario(int s) {
		scenario = s;
	}

	public int getStyleR() {
		return style;
	}

	public void setStyleR(int style) {
		this.style = style;
	}

	public String getColorR() {
		return rectangleColor;
	}

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

}
