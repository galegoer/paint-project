
package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.paint.Color;

/**
 * Model of the Squiggle class and its properties: color, thickness, and
 * its series of points.
 * @author TheCentipedeBoys
 *
 */

public class Squiggle {
	private String stringcolor;
	private int thickness;
	private ArrayList<Point> points;
	
	/**
	 * Constructor for Squiggle object
	 * @param points ArrayList of Point objects representing the Squiggle
	 * @param color 
	 * @param thickness
	 */
	
	public Squiggle(ArrayList<Point> points, String color, int thickness) {
		this.points = points;
		this.stringcolor = color;
		this.thickness = thickness;
	}

	/**
	 * Adds point to points parameter
	 * @param point 
	 */
	
	public void addPoint(Point point) {
		this.points.add(point);
	}
	
	/**
	 * 
	 * @return integer number of points in points
	 */
	
	public int getPoints(){
		return this.points.size();
	}
	
	/**
	 * 
	 * @param i Index of point we want to get
	 * @return Point at index i
	 */
	public Point getPoint(int i){
		return this.points.get(i);
	}

	/**
	 * 
	 * @return Integer thickness of squiggle
	 */
	
	public int getThick() {
		return thickness;
	}
	
	/**
	 * Sets thickness of squiggle
	 * @param thickness
	 */
	
	public void setThick(int thickness) {
		this.thickness = thickness;
	}
	
	/**
	 * 
	 * @return String representation of color
	 */
	
	public String getString() {
		return this.stringcolor;
	}
	
	/**
	 * Returns color to be set given String stringcolor
	 * @param stringcolor String representation of color to be set
	 * @return Color to be set
	 */
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
		else {
			return Color.BLACK;
		}
	}
}
