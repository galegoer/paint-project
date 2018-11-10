package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Squiggle {
	private Point start;
	private Point end;
	private String stringcolor;
	private int thickness;
	private ArrayList<Point> points;
	
	public Squiggle(Point start, ArrayList<Point> points, String color, int thickness) {
		this.start = start;
		this.points = points;
		this.stringcolor = color;
		this.thickness = thickness;
		System.out.println("hh?");
		this.end = points.get(points.size()-1);
	}
	
	public void addPoint(Point nextPoint) {
		this.points.add(nextPoint);
	}
	
	public Point getPoint() {
		return points.get(points.size()-1);
	}

	public void setStart(Point start) {
		this.start = start;
	}
	
	public void setEnd(Point end) {
		this.end = end;
	}
	
	public Point getStart() {
		return start;
	}
	public Point getEnd() {
		return end;
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
