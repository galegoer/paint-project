package ca.utoronto.utm.paint;


import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;



public class Circle{
	
	private Point centre;
	private int radius;
	private String stringcolor;
	
	public Circle(Point centre, int radius, String color) {
		this.centre = centre;
		this.radius = radius;
		this.stringcolor = color;
	}
	
	
	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
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
