package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

public class Line {
	private Point centre;
	private Point end;
	private String lineColor;
	private int thickness;
	private String style;
	
	public Line() {
	}
	public Line(Point centre, String lineColor, String style, int thickness) {
		this.centre = centre;
		this.thickness = thickness;
		this.style = style;
		this.lineColor = lineColor;
	}
	
	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	public void setEnd(Point end) {
		this.end = end;
	}
	public String getColor() {
		return lineColor;
	}
	public void setColor(String color) {
		this.lineColor = color;
	}
	public void setThick(int thick) {
		this.thickness = thick;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	public String getStyle() {
		return this.style;
	}


	public Point getEnd() {
		// TODO Auto-generated method stub
		return end;
	}

	public int getThick() {
		// TODO Auto-generated method stub
		return thickness;
	}
}

