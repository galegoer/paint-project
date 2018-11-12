package ca.utoronto.utm.paint;



import java.util.ArrayList;

public class PolyLine {
	private Point centre;
	
	private ArrayList<Point> points = new ArrayList<Point>();
	private String lineColor;
	private int thickness;
	
	public PolyLine(String lineColor, int thickness) {
		ArrayList<Point> empty = new ArrayList<Point>();
		this.points = empty;
		this.thickness = thickness;
		this.lineColor = lineColor;

	}
	
	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	
	
	public String getColor() {
		return lineColor;
	}

	

	public int getThick() {
		// TODO Auto-generated method stub
		return thickness;
	}
	public void updateThick(int thick) {
		// TODO Auto-generated method stub
		thickness =  thick;
	}
	public void updateColor(String color) {
		// TODO Auto-generated method stub
		this.lineColor =  color;
	}
	
	//for polyline points list
	public ArrayList<Point> getList(){
		return this.points;
	}
	public void addPoint(Point p){
		this.points.add(p);
	}





}


