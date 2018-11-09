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
	private Commands commands;
	
	private ArrayList<String> modes = new ArrayList<String>(); // modifies how we interpret input (could be better?)
	private Circle circle; // the circle we are building
	private Rectangle rectangle;
	private Point point;

	private String color;

	private Square square;

	private Canvas canvas;
	
	private String style;

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
		
		this.style = "";
	}
	
	public void reset() { //RESET ISNT WORKING
		//this.model.removeAllCircles();
		//this.model.removeAllRectangles();
		//this.model.removeAllSquares();
		//this.model.removeAllPoints();
		//repaint();
	}
	
	public void repaint() {
		
		GraphicsContext g = this.canvas.getGraphicsContext2D();

		// Clear the canvas
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		g.setStroke(Color.BLACK);

		g.strokeText("i=" + i, 50, 75);
		i = i + 1;

		
		model.operateAll(g);
		
	}

	@Override
	public void update(Observable o, Object arg) {

		// Not exactly how MVC works, but similar.
		this.repaint();
	}

	/**
	 * CHANGED THIS Now refers to index as first input
	 * and mode you want as second
	 */
	public void setMode(int index, String mode) {
		this.modes.set(index, mode);
	}

	public void setColor(String color) {
		this.color = color;
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
			//addPoint(new Point((int) e.getX(), (int) e.getY()));
			this.model.acceptCommand(new Commands(this.point));
		} else if (this.modes.get(0) == "Circle") {
			int radius = (int) Math.sqrt(Math.pow((int) this.circle.getCentre().getX() - (int) e.getX(), 2) + 
					Math.pow((int) this.circle.getCentre().getY() - (int) e.getY(), 2));
			this.circle.setRadius(radius);
			this.model.acceptCommand(new Commands(this.circle));
		} else if (this.modes.get(0) == "Rectangle") {
			// Begin
			int x1 = this.rectangle.getCentre().getX();
			int y1 = this.rectangle.getCentre().getY();
			// mouse release or end
			int x2 = (int) e.getX();
			int y2 = (int) e.getY();

			if (x2 > x1 && y2 > y1) {
				this.rectangle.setScenario(1);
				Point centre = new Point(x1, y1);
				this.rectangle.setHeight(y2 - y1);
				this.rectangle.setWidth(x2 - x1);
				this.rectangle.setCentre(centre);
			}
			// Scenario 2
			else if (x1 > x2 && y2 < y1) {
				this.rectangle.setScenario(2);
				this.rectangle.setHeight(y1 - y2);
				this.rectangle.setWidth(x1 - x2);
			}
			// Scenario 3
			else if (x1 > x2 && y1 < y2) {
				this.rectangle.setScenario(3);
				this.rectangle.setHeight(y2 - y1);
				this.rectangle.setWidth(x1 - x2);
			}
			// Scenario 4
			else if (x2 > x1 && y2 < y1) {
				this.rectangle.setScenario(4);
				this.rectangle.setHeight(y1 - y2);
				this.rectangle.setWidth(x2 - x1);
			}
			this.model.acceptCommand(new Commands(this.rectangle));
		}

		else if (this.modes.get(0) == "Square") {

			int x1 = this.square.getCentre().getX();
			int y1 = this.square.getCentre().getY();
			int x2 = (int) e.getX();
			int y2 = (int) e.getY();
			if (x2 > x1 && y2 > y1) {
				if ((x2 - x1) > (y2 - y1))
					this.square.setSideLength(x2 - x1);
				else
					this.square.setSideLength(y2 - y1);
				this.square.setScenario(1);
				Point centre = new Point(x1, y1);
				this.square.setCentre(centre);
			}
			// Scenario 2
			else if (x1 > x2 && y2 < y1) {
				if ((x1 - x2) > (y1 - y2))
					this.square.setSideLength(x1 - x2);
				else
					this.square.setSideLength(y1 - y2);
				this.square.setScenario(2);

			}
			// Scenario 3
			else if (x1 > x2 && y1 < y2) {
				if ((x1 - x2) > (y2 - y1))
					this.square.setSideLength(x1 - x2);
				else
					this.square.setSideLength(y2 - y1);
				this.square.setScenario(3);
			}
			// Scenario 4
			else if (x2 > x1 && y2 < y1) {
				if ((x2 - x1) > (y1 - y2))
					this.square.setSideLength(x2 - x1);
				else
					this.square.setSideLength(y1 - y2);
				this.square.setScenario(4);
			}
			this.model.acceptCommand(new Commands(this.square));
		}
	}

	private void mouseClicked(MouseEvent e) {
		if (this.modes.get(0) == "Squiggle") {

		} else if (this.modes.get(0) == "Circle") {

		}
	}

	private void mousePressed(MouseEvent e) {
		if (this.modes.get(0) == "Squiggle") {
			this.point = new Point((int) e.getX(), (int) e.getY());
			//this.point.setColor(this.color);
		} else if (this.modes.get(0) == "Circle") {
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int radius = 0;
			int style = 0;
			this.circle = new Circle(centre, radius, this.color, style);
			if(this.modes.get(1) == "Fill") {
				this.circle.setStyleC(1);
			}
		} else if (this.modes.get(0) == "Rectangle") {
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int height = 0;
			int width = 0;
			int scenario = 0;
			int style = 0;
			this.rectangle = new Rectangle(centre, width, height, scenario, this.color,style);
			if(this.modes.get(1) == "Fill") {
				this.rectangle.setStyleR(1);
			}
			
		} else if (this.modes.get(0) == "Square") {
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int side = 0;
			int scenario = 0;
			int style = 0;
			this.square = new Square(centre, side, scenario, this.color, style);
			if(this.modes.get(1) == "Fill") {
				this.square.setStyleS(1);
			}
		}
	}

	private void mouseReleased(MouseEvent e) {
		if (this.modes.get(0) == "Squiggle") {

		} else if (this.modes.get(0) == "Circle") {
			if (this.circle != null) {
				int radius = (int) Math.sqrt(Math.pow((int) this.circle.getCentre().getX() - (int) e.getX(), 2)
						+ Math.pow((int) this.circle.getCentre().getY() - (int) e.getY(), 2));
				this.circle.setRadius(radius);
				this.model.acceptCommand(new Commands(this.circle));
				this.circle = null;
			}

		} else if (this.modes.get(0) == "Rectangle"){

		}
			if (this.rectangle != null) {
				
				int x1 = this.rectangle.getCentre().getX();
				int y1 = this.rectangle.getCentre().getY();
				// mouse release or end
				int x2 = (int) e.getX();
				int y2 = (int) e.getY();

				// Scenario 1
				if (x2 > x1 && y2 > y1) {
					this.rectangle.setScenario(1);
					this.rectangle.setHeight(y2 - y1);
					this.rectangle.setWidth(x2 - x1);
				}
				// Scenario 2
				else if (x1 > x2 && y2 < y1) {
					this.rectangle.setScenario(2);
					this.rectangle.setHeight(y1 - y2);
					this.rectangle.setWidth(x1 - x2);
				}
				// Scenario 3
				else if (x1 > x2 && y1 < y2) {
					this.rectangle.setScenario(3);
					this.rectangle.setHeight(y2 - y1);
					this.rectangle.setWidth(x1 - x2);
				}
				// Scenario 4
				else if (x2 > x1 && y2 < y1) {
					this.rectangle.setScenario(4);
					this.rectangle.setHeight(y1 - y2);
					this.rectangle.setWidth(x2 - x1);
				}
				this.model.acceptCommand(new Commands(this.rectangle));
				this.rectangle = null;
			}
		else if (this.modes.get(0) == "Square") {

			if (this.square != null) {
				int x1 = this.square.getCentre().getX();
				int y1 = this.square.getCentre().getY();
				int x2 = (int) e.getX();
				int y2 = (int) e.getY();

				if (x2 > x1 && y2 > y1) {
					if ((x2 - x1) > (y2 - y1))
						this.square.setSideLength(x2 - x1);
					else
						this.square.setSideLength(y2 - y1);
					this.square.setScenario(1);
					Point centre = new Point(x1, y1);
					this.square.setCentre(centre);
				}
				// Scenario 2
				else if (x1 > x2 && y2 < y1) {
					if ((x1 - x2) > (y1 - y2))
						this.square.setSideLength(x1 - x2);
					else
						this.square.setSideLength(y1 - y2);
					this.square.setScenario(2);

				}
				// Scenario 3
				else if (x1 > x2 && y1 < y2) {
					if ((x1 - x2) > (y2 - y1))
						this.square.setSideLength(x1 - x2);
					else
						this.square.setSideLength(y2 - y1);
					this.square.setScenario(3);
				}
				// Scenario 4
				else if (x2 > x1 && y2 < y1) {
					if ((x2 - x1) > (y1 - y2))
						this.square.setSideLength(x2 - x1);
					else
						this.square.setSideLength(y1 - y2);
					this.square.setScenario(4);
				}
				this.model.acceptCommand(new Commands(this.square));
				this.rectangle = null;
			}
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
}
