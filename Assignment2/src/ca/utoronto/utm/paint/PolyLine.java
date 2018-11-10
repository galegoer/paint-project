package ca.utoronto.utm.paint;

import java.util.ArrayList;

public class PolyLine {
	private Point centre;
	private Point end;
	
	private ArrayList<Point> points = new ArrayList<Point>();
	private String lineColor;
	private int thickness;
	
	public PolyLine(String lineColor, int thickness) {
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
	public void updateThick(int thick) {
		// TODO Auto-generated method stub
		thickness =  thick;
	}
	
	//for polyline points list
	public ArrayList<Point> getList(){
		return this.points;
	}
	public void addPoint(Point p){
		this.points.add(p);
	}





}

