package ca.utoronto.utm.paint;
import javafx.scene.shape.Shape;

/**
 * Model a square. The square object is associated with a starting point, side length, color, style
 * thickness, and arc length
 * @author William
 *
 */
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
	
	/**
	 * Returns starting point of square object
	 * @return starting point
	 */
	public Point getCentre() {
		return centre;
	}
	
	/**
	 * Sets starting point of square to new point
	 * @param centre the new point
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	/**
	 * Return the side length of the square
	 * @return side length of square
	 */
	public int getSideLength() {
		return side;
	}
	
	/**
	 * Sets the side length of square to a new length
	 * @param side the new side length
	 */
	public void setSideLength(int side) {
		this.side = side;
	}
	
	/**
	 * Returns the current thickness value of the square
	 * @return squares thickness
	 */
	public int getThick() {
		return thickness;
	}
	
	/**
	 * Sets the thickness to a new thickness value
	 * @param thickness the new thickness value
	 */
	public void setThick(int thickness) {
		this.thickness = thickness;
	}
	
	/**
	 * Returns the scenario number for square
	 * @return scenario number
	 */
	public int getScenario() {
		return scenario;
	}
	
	/**
	 * Sets scenario number of square to specified value
	 * @param s new scenario number
	 */
	public void setScenario(int s) {
		scenario = s;
	}
	
	/**
	 * Returns square color
	 * @return color of square
	 */
	public String getColorS() {
		return sqcolor;
	}
	/**
	 * Returns style of the square
	 * @return square style
	 */
	public int getStyleS() {
		return style;
	}
	/**
	 * Sets the style of square to a new style
	 * @param style new style
	 */
	public void setStyleS(int style) {
		this.style = style;
	}
	
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

