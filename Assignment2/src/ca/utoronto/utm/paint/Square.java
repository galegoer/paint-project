package ca.utoronto.utm.paint;
import javafx.scene.shape.Shape;
public class Square extends Shape{
	
	private Point centre;
	private int side;
	private int scenario;
	private String sqcolor;
	private int style;
	

	public Square(Point centre, int side, int scenario, String color, int style) {
		this.centre = centre;
		this.side = side;
		this.scenario = scenario;
		this.sqcolor = color;
		this.style = style;
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
	
	public String getColorS() {
		return sqcolor;
	}
	
	public int getStyleS() {
		return style;
	}
	
	public void setStyleS(int style) {
		this.style = style;
	}

	@Override
	public com.sun.javafx.geom.Shape impl_configShape() {
		// TODO Auto-generated method stub
		return null;
	}

}

