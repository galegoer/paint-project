package ca.utoronto.utm.paint;
import javafx.scene.shape.Shape;
public class Square extends Shape{
	
	private Point centre;
	private int side;
	private int scenario;
	public String sqcolor;
	

	public Square(Point centre, int side, int scenario, String color) {
		this.centre = centre;
		this.side = side;
		this.scenario = scenario;
		this.sqcolor = color;
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	public int getSideLength() {
		return side;
	}

	public void setSideLength(int side) {
		this.side = side;
	}
	
	public int getScenario() {
		return scenario;
	}
	//Set the scenario number
	
	public void setScenario(int s) {
		scenario = s;
	}

	@Override
	public com.sun.javafx.geom.Shape impl_configShape() {
		// TODO Auto-generated method stub
		return null;
	}

}

