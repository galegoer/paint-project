package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

public class Line {
	private Point centre;
	private Point end;
	
	
	private String lineColor;
	private int thickness;
	
	public Line(Point centre, String lineColor, int thickness) {
		this.centre = centre;
		this.thickness = thickness;

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

	public Point getEnd() {
		// TODO Auto-generated method stub
		return end;
	}

	public int getThick() {
		// TODO Auto-generated method stub
		return thickness;
	}




}
