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

	private ArrayList<String> modes = new ArrayList<String>(); // modifies how we interpret input (could be better?)
	private Circle circle; // the circle we are building
	private Rectangle rectangle;

	private Canvas canvas;
	
	private String style;

	
	public PaintPanel(PaintModel model, View view) {

		this.canvas = new Canvas(300, 300);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: blue");

		this.addEventHandler(MouseEvent.ANY, this);

		this.modes.add(0, ""); // CHANGED MIGHT BE BAD CODE STILL??
		this.modes.add(1, "Outline");

		this.model = model;
		this.model.addObserver(this);

		this.view = view;
		
		this.style = "";
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
			if(c.getStyleC() == 1) {
				g.setFill(Color.WHITE);
				g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
			} else {
				g.strokeOval(x-radius, y-radius, 2*radius, 2*radius);
			}
		}

		// Draw Rectangles
		ArrayList<Rectangle> rectangles = this.model.getRectangles();
		for (Rectangle r : rectangles) {
			int a = r.getCentre().getX();
			int b = r.getCentre().getY();
			int height = r.getHeight();
			int width = r.getWidth();
			if(r.getStyleR() == 1) {
				g.setFill(Color.WHITE);
				if(r.getScenario() == 1) {
					g.fillRect(a, b, width, height);
				}else if(r.getScenario() == 2) {
					g.fillRect(a-width, b-height , width, height);
				}else if(r.getScenario() == 3) {
					g.fillRect(a-width, b, width, height);
				}else if(r.getScenario() == 4) {
					g.fillRect(a, b-height , width, height);
			}}else{
			if(r.getScenario() == 1) {
				g.strokeRect(a, b, width, height);
			} else if(r.getScenario() == 2) {
				g.strokeRect(a-width, b-height , width, height);
			} else if(r.getScenario() == 3) {
				g.strokeRect(a-width, b, width, height);
			} else if(r.getScenario() == 4) {
				g.strokeRect(a, b-height , width, height);
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
	 * CHANGED THIS Now referes to index as first input
	 * and mode you want as second
	 */
	public void setMode(int index, String mode) {
		this.modes.set(index, mode);
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
		if (modes.get(0) == "Squiggle") {

		} else if (modes.get(0) == "Circle") {

		}
	}

	private void mouseDragged(MouseEvent e) {
		if (this.modes.get(0) == "Squiggle") {
			this.model.addPoint(new Point((int) e.getX(), (int) e.getY()));
		} else if (this.modes.get(0) == "Circle") {
			int radius = (int) Math.sqrt(Math.pow((int) this.circle.getCentre().getX() - (int) e.getX(), 2) + 
					Math.pow((int) this.circle.getCentre().getY() - (int) e.getY(), 2));
			this.circle.setRadius(radius);
			this.model.addCircle(this.circle);
			this.model.removeCircle(this.model.getCircles().size()-1);
		} else if (this.modes.get(0) == "Rectangle") {
			// Begin
			int x1 = this.rectangle.getCentre().getX();
			int y1 = this.rectangle.getCentre().getY();
			// mouse release or end
			int x2 = (int) e.getX();
			int y2 = (int) e.getY();
			
			
			if (x2>x1 && y2>y1){
				this.rectangle.setScenario(1);
				Point centre = new Point(x1,y1);
				this.rectangle.setHeight(y2-y1);
				this.rectangle.setWidth(x2-x1);
				this.rectangle.setCentre(centre);	
			}
			//Scenario 2
			else if (x1>x2 && y2<y1){
				this.rectangle.setScenario(2);
				this.rectangle.setHeight(y1-y2);
				this.rectangle.setWidth(x1-x2);				
			}
			// Scenario 3
			else if (x1>x2 && y1<y2){
				this.rectangle.setScenario(3);
				this.rectangle.setHeight(y2-y1);
				this.rectangle.setWidth(x1-x2);
			}
			// Scenario 4
			else if (x2>x1 && y2<y1){
				this.rectangle.setScenario(4);
				this.rectangle.setHeight(y1-y2);
				this.rectangle.setWidth(x2-x1);
			}
			this.model.addRectangle(this.rectangle);
			this.model.removeRectangle(this.model.getRectangles().size()-1);
	}}

	private void mouseClicked(MouseEvent e) {
		if (this.modes.get(0) == "Squiggle") {

		} else if (this.modes.get(0) == "Circle") {

		}
	}

	private void mousePressed(MouseEvent e) {
		if (this.modes.get(0) == "Squiggle") {

		} else if (this.modes.get(0) == "Circle") {
			// Problematic notion of radius and centre!!
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int radius = 0;
			int style = 0;
			this.circle = new Circle(centre, radius, style);
			if(this.modes.get(1) == "Fill") {
				this.circle.setStyleC(1);
			}
		} else if (this.modes.get(0) == "Rectangle") {
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int height = 0;
			int width = 0;
			int scenario = 0;
			int style = 0;
			this.rectangle = new Rectangle(centre, width, height, scenario, style);
			if(this.modes.get(1) == "Fill") {
				this.rectangle.setStyleR(1);
			}
		}
	}

	private void mouseReleased(MouseEvent e) {
		if (this.modes.get(0) == "Squiggle") {

		} else if (this.modes.get(0) == "Circle") {
			if (this.circle != null) {
				// Problematic notion of radius and centre!!
				int radius = (int) Math.sqrt(Math.pow((int) this.circle.getCentre().getX() - (int) e.getX(), 2) + 
						Math.pow((int) this.circle.getCentre().getY() - (int) e.getY(), 2));
				this.circle.setRadius(radius);
				this.model.addCircle(this.circle);
				this.circle = null;
			}
		} else if (this.modes.get(0) == "Rectangle"){
			if (this.rectangle != null) {
				int x1 = this.rectangle.getCentre().getX();
				int y1 = this.rectangle.getCentre().getY();
				// mouse release or end
				int x2 = (int) e.getX();
				int y2 = (int) e.getY();
				//Scenario 1
				if (x2>x1 && y2>y1){
					this.rectangle.setScenario(1);
					this.rectangle.setHeight(y2-y1);
					this.rectangle.setWidth(x2-x1);	
				}
				//Scenario 2
				else if (x1>x2 && y2<y1){
					this.rectangle.setScenario(2);
					this.rectangle.setHeight(y1-y2);
					this.rectangle.setWidth(x1-x2);				
				}
				// Scenario 3
				else if (x1>x2 && y1<y2){
					this.rectangle.setScenario(3);
					this.rectangle.setHeight(y2-y1);
					this.rectangle.setWidth(x1-x2);
				}
				// Scenario 4
				else if (x2>x1 && y2<y1){
					this.rectangle.setScenario(4);
					this.rectangle.setHeight(y1-y2);
					this.rectangle.setWidth(x2-x1);
				}
				//this.rectangle.setWidth(width);
				//this.rectangle.setHeight(height);
				this.model.addRectangle(this.rectangle);
				this.rectangle = null;
		}
		}}
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
}
