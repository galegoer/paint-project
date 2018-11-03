package ca.utoronto.utm.paint;

public class Rectangle {
	
	private Point centre;
	public int width;
	public int height;

	public Rectangle(Point centre, int width, int height) {
		this.centre = centre;
		this.width = width;
		this.height = height;
		//setWidth(width);
		//setHeight(height);
	}
	
	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
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

}
