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

class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {

	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private String mode; // modifies how we interpret input (could be better?)
	private Circle circle; // the circle we are building
	private Rectangle rectangle;

	private Canvas canvas;

	public PaintPanel(PaintModel model, View view) {

		this.canvas = new Canvas(300, 300);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: blue");

		this.addEventHandler(MouseEvent.ANY, this);

		//this.mode = "Circle"; // bad code here?
		this.mode = "Rectangle";

		this.model = model;
		this.model.addObserver(this);

		this.view = view;
	}

	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();

		// Clear the canvas
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		g.setStroke(Color.WHITE);
		g.strokeText("i=" + i, 50, 75);
		i = i + 1;

		// Draw Lines
		ArrayList<Point> points = this.model.getPoints();
		for (int i = 0; i < points.size() - 1; i++) {
			Point p1 = points.get(i);
			Point p2 = points.get(i + 1);
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}

		// Draw Circles
		ArrayList<Circle> circles = this.model.getCircles();
		for (Circle c : circles) {
			int x = c.getCentre().getX();
			int y = c.getCentre().getY();
			int radius = c.getRadius();
			g.strokeOval(x-radius, y-radius, 2*radius, 2*radius);
		}

		// Draw Rectangles
		ArrayList<Rectangle> rectangles = this.model.getRectangles();
		for (Rectangle r : rectangles) {
			int a = r.getCentre().getX();
			int b = r.getCentre().getY();
			int height = r.getHeight();
			int width = r.getWidth();
			g.strokeRect(a, b , width, height);
		}
	}

	@Override
	public void update(Observable o, Object arg) {

		// Not exactly how MVC works, but similar.
		this.repaint();
	}

	/**
	 * Controller aspect of this
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public void handle(MouseEvent event) {

		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			mouseDragged(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			mousePressed(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
			mouseMoved(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			mouseClicked(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			mouseReleased(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
			mouseEntered(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
			mouseExited(event);
		}
	}

	private void mouseMoved(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		}
	}

	private void mouseDragged(MouseEvent e) {
		if (this.mode == "Squiggle") {
			this.model.addPoint(new Point((int) e.getX(), (int) e.getY()));
		} else if (this.mode == "Circle") {
			//System.out.println("Dragged");
			int radius = (int) Math.sqrt(Math.pow((int) this.circle.getCentre().getX() - (int) e.getX(), 2) + 
					Math.pow((int) this.circle.getCentre().getY() - (int) e.getY(), 2));
			this.circle.setRadius(radius);
			this.model.addCircle(this.circle);
			this.model.removeCircle(this.model.getCircles().size()-1);
		}else if (this.mode == "Rectangle") {
			// here code for height and width is needed.

			this.model.addRectangle(this.rectangle);
			this.model.removeRectangle(this.model.getRectangles().size()-1);

		}
	}

	private void mouseClicked(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		}
	}

	private void mousePressed(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {
			// Problematic notion of radius and centre!!
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int radius = 0;
			this.circle = new Circle(centre, radius);
		} else if (this.mode == "Rectangle") {
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int height = 0;
			int width = 0;
			this.rectangle = new Rectangle(centre, width, height);
		}
	}

	private void mouseReleased(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {
			if (this.circle != null) {
				// Problematic notion of radius and centre!!
				int radius = (int) Math.sqrt(Math.pow((int) this.circle.getCentre().getX() - (int) e.getX(), 2) + 
						Math.pow((int) this.circle.getCentre().getY() - (int) e.getY(), 2));
				this.circle.setRadius(radius);
				this.model.addCircle(this.circle);
				this.circle = null;
			}
		} else if (this.mode == "Rectangle"){

			if (this.rectangle != null) {
				// Ratio x and y is the ratio of width to height
				int ratio_x = 21;
				int ratio_y = 9;
				// Diagnol of the rectangle
				/**
				int x1 = this.rectangle.getCentre().getX();
				int x2 = (int) e.getX();
				int y1 = this.rectangle.getCentre().getY();
				int y2 = (int) e.getY();
				int diagnol = (int)Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
				 **/
				int diagnol = (int) Math.sqrt(Math.pow((int) this.rectangle.getCentre().getX() - (int) e.getX(), 2) + 
						Math.pow((int) this.rectangle.getCentre().getY() - (int) e.getY(), 2)) ;
				// formula for height using rectangle and ration 16:9 (diagnol*ratio_y)/(ratio_x^2 + ratio_y^2)^1/2) 
				int height = (int)((diagnol*ratio_y)/Math.sqrt(Math.pow(ratio_x, 2)+Math.pow(ratio_y, 2)));
				//System.out.println(height);
				int width = (int)((int)(ratio_x/ratio_y)* height);
				//System.out.println(width);

				this.rectangle.setWidth(width);
				this.rectangle.setHeight(height);
				this.model.addRectangle(this.rectangle);
				this.rectangle = null;

			}
		}

	}

	private void mouseEntered(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		}
	}

	private void mouseExited(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		}
	}
}
