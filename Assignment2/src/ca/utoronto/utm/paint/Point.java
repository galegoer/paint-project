package ca.utoronto.utm.paint;
/**
 * 
 * @author TheCentipedeBoys
 *The point class is used by a number of different shape objects. Sets two points x and y.
 */
public class Point {
	int x, y;
/**
 * Constructor initializes two points
 * @param x
 * @param y
 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
/**
 * 
 * @return the value of x
 */
	public int getX() {
		return x;
	}
/**
 * Allows the program to set the value of x
 * @param x
 */
	public void setX(int x) {
		this.x = x;
	}
/**
 * 
 * @return the value of y
 */
	public int getY() {
		return y;
	}
/**
 * Allows the program to set the value of y
 *
 */
	public void setY(int y) {
		this.y = y;
	}

}
