
package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Squiggle {
	private String stringcolor;
	private int thickness;
	private ArrayList<Point> points;
	
	public Squiggle(ArrayList<Point> points, String color, int thickness) {
		this.points = points;
		this.stringcolor = color;
		this.thickness = thickness;
	}

	public void addPoint(Point point) {
		this.points.add(point);
	}
	
	public int getPoints(){
		return this.points.size();
	}
	
	public Point getPoint(int i){
		return this.points.get(i);
	}

	public int getThick() {
		return thickness;
	}
	public void setThick(int thickness) {
		this.thickness = thickness;
		//this.setStrokeWidth(thickness);
	}
	
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
		else {
			return Color.BLACK;
		}
	}
}
