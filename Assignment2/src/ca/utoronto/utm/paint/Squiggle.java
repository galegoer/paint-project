package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Squiggle {
	private Point start;
	private String stringcolor;
	private int thickness;
	
	public Squiggle(Point start, String color, int thickness) {
		this.start = start;
		this.stringcolor = color;
		this.thickness = thickness;
		//this.end = points.get(points.size()-1);
	}

	public void setStart(Point start) {
		this.start = start;
	}
	
	public Point getStart() {
		return this.start;
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
