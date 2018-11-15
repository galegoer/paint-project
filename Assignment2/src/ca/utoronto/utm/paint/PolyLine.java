package ca.utoronto.utm.paint;



import java.util.ArrayList;

/**
 * Model a polyLine object. The polyline has an associated color, thickness and a list of points that make
 * up the polyline object
 * @author TheCentipedeBoys
 *
 */
public class PolyLine {
	private Point centre;
	
	private ArrayList<Point> points = new ArrayList<Point>();
	private String lineColor;
	private int thickness;
	
	/**
	 * Initialize an empty polyLine object
	 */
	public PolyLine() {
		return;
	}
	
	/**
	 * Create a polyline object with the given color and thickness, and a initalize a new list of points for the polyline
	 * @param lineColor the given color
	 * @param thickness the given thickness
	 */
	public PolyLine(String lineColor, int thickness) {
		ArrayList<Point> empty = new ArrayList<Point>();
		this.points = empty;
		this.thickness = thickness;
		this.lineColor = lineColor;

	}
	
	/**
	 * returns starting point of polyLine
	 * @return starting point
	 */
	public Point getCentre() {
		return centre;
	}
	
	/**
	 * Sets starting point of polyline to specified point
	 * @param newPoint the new point 
	 */
	public void setCentre(Point newPoint) {
		this.centre = newPoint;
	}
	
	/**
	 * Returns color associated to whole polyline object
	 * @return color of polyline
	 */
	public String getColor() {
		return lineColor;
	}

	/**
	 * Returns thickness associated to polyline object
	 * @return thickness value of polyline
	 */
	public int getThick() {
		return thickness;
	}
	
	/**
	 * Sets the thickness of polyline object to a new thickness value
	 * @param thick the new thickness value
	 */
	public void updateThick(int thick) {
		thickness =  thick;
	}
	
	/**
	 * Sets the color of the polyline object to a new color
	 * @param color the new color
	 */
	public void updateColor(String color) {
		this.lineColor =  color;
	}
	
	/**
	 * Returns the list of points that make up the polyline object
	 * @return the list of points
	 */
	public ArrayList<Point> getList(){
		return this.points;
	}
	/**
	 * Add a point to the list of points that make up the polyline object
	 * @param p the point to be added
	 */
	public void addPoint(Point p){
		this.points.add(p);
	}





}


