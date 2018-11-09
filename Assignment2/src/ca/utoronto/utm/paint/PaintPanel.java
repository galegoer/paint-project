package ca.utoronto.utm.paint;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import ca.utoronto.utm.mouseBehaviour.context;

class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {

	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private ArrayList<String> modes = new ArrayList<String>(); // modifies how we interpret input (could be better?)
	private String color;
	
	private Canvas canvas;

	context c = new context();

	private String style;
	private int thick;
	
	public PaintPanel(PaintModel model, View view) {

		this.canvas = new Canvas(300, 300);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: white");

		this.addEventHandler(MouseEvent.ANY, this);

		this.modes.add(0, "Circle"); // CHANGED MIGHT BE BAD CODE STILL??
		this.modes.add(1, "Outline");

		this.model = model;
		this.model.addObserver(this);

		this.view = view;

	}

	public void reset() {
		this.model.removeAllCircles();
		this.model.removeAllRectangles();
		this.model.removeAllSquares();
		this.model.removeAllPoints();
		repaint();
	}

	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();

		// Clear the canvas
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		g.setStroke(Color.BLACK);
		
		// The position of seWidth line here makes sure that the i value shown on canvas remains readable. 
		g.setLineWidth(1);
		g.strokeText("i=" + i, 50, 75);
		i = i + 1;
		

		// Draw Lines
		ArrayList<Point> points = this.model.getPoints();
		for (int i = 0; i < points.size() - 1; i++) {
			Point p1 = points.get(i);
			Point p2 = points.get(i + 1);
			g.setStroke(Circle.setPaint(this.color));
			//g.setLineWidth(setB(thick));
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}

		// Draw Circles
		//System.out.println("Hilol");
		ArrayList<Circle> circles = this.model.getCircles();
		for (Circle c : circles) {
			int x = c.getCentre().getX();
			int y = c.getCentre().getY();
			int radius = c.getRadius();
			// Sets the thickness of circle.
			g.setLineWidth(c.getThick());
			if (c.getStyleC() == 1) {
				g.setFill(Circle.setPaint(c.getString())); // FIX WITH WHAT COLOR IS SET
				g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
			} else {
				g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
			}
			
			g.setStroke(Circle.setPaint(c.getString()));
			g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
			g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
			

		}

		// Draw Rectangles
		ArrayList<Rectangle> rectangles = this.model.getRectangles();
		for (Rectangle r : rectangles) {
			int a = r.getCentre().getX();
			int b = r.getCentre().getY();
			int height = r.getHeight();
			int width = r.getWidth();
			g.setLineWidth(r.getThick());
			if (r.getStyleR() == 1) {
				g.setFill(Circle.setPaint(r.getColorR()));
				if (r.getScenario() == 1) {
					g.fillRect(a, b, width, height);
				} else if (r.getScenario() == 2) {
					g.fillRect(a - width, b - height, width, height);
				} else if (r.getScenario() == 3) {
					g.fillRect(a - width, b, width, height);
				} else if (r.getScenario() == 4) {
					g.fillRect(a, b - height, width, height);
				}
			} else {
				g.setStroke(Circle.setPaint(r.getColorR()));
				if (r.getScenario() == 1) {
					g.strokeRect(a, b, width, height);
				} else if (r.getScenario() == 2) {
					g.strokeRect(a - width, b - height, width, height);
				} else if (r.getScenario() == 3) {
					g.strokeRect(a - width, b, width, height);
				} else if (r.getScenario() == 4) {
					g.strokeRect(a, b - height, width, height);
				}
			}
		}
		// Draw Squares
		ArrayList<Square> squares = this.model.getSquares();
		for (Square r : squares) {
			int a = r.getCentre().getX();
			int b = r.getCentre().getY();
			int side = r.getSideLength();
			g.setLineWidth(r.getThick());
			if (r.getStyleS() == 1) {
				g.setFill(Circle.setPaint(r.getColorS()));
				System.out.println("hi");
				if (r.getScenario() == 1) {
					g.fillRect(a, b, side, side);
				} else if (r.getScenario() == 2) {
					g.fillRect(a - side, b - side, side, side);
				} else if (r.getScenario() == 3) {
					g.fillRect(a - side, b, side, side);
				} else if (r.getScenario() == 4) {
					g.fillRect(a, b - side, side, side);
				}
			} else {
				g.setStroke(Circle.setPaint(r.getColorS()));
				if (r.getScenario() == 1) {
					g.strokeRect(a, b, side, side);
				} else if (r.getScenario() == 2) {
					g.strokeRect(a - side, b - side, side, side);
				} else if (r.getScenario() == 3) {
					g.strokeRect(a - side, b, side, side);
				} else if (r.getScenario() == 4) {
					g.strokeRect(a, b - side, side, side);
				}
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {

		// Not exactly how MVC works, but similar.
		this.repaint();
	}

	/**
	 * CHANGED THIS Now refers to index as first input and mode you want as second
	 */
	public void setMode(int index, String mode) {
		this.modes.set(index, mode);
	}

	public void setColor(String color) {
		this.color = color;

	}
	public void setThick(int thick) {
		this.thick = thick;
	}
	
	@Override
	public void handle(MouseEvent event) {
		c.setModel(this.model);
		c.setColor(this.color);
		c.setModes(this.modes);
		c.setThick(this.thick);
		c.setBehaviour(this.modes.get(0));
		c.move(event);
	}
	
	
	
	
	private void mouseMoved(MouseEvent e) {
		if (modes.get(0) == "Squiggle") {

		} else if (modes.get(0) == "Circle") {

		}
	}

	private void mouseEntered(MouseEvent e) {
		if (this.modes.get(0) == "Squiggle") {

		} else if (this.modes.get(0) == "Circle") {

		}
	}

	private void mouseExited(MouseEvent e) {
		if (this.modes.get(0) == "Squiggle") {

		} else if (this.modes.get(0) == "Circle") {

		}
	}
	// might need to remove
	public void setstrokethickness(int slider_num) {
		thick = slider_num;
	}
}
