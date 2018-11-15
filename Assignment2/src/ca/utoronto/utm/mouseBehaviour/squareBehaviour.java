package ca.utoronto.utm.mouseBehaviour;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Commands;
import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.Square;
import javafx.scene.input.MouseEvent;
/**
 * squareBehaviour is a concrete shapeBehaviour strategy for the square object. squareBehaviour knows
 * what a mouse input would do given that the mode selected is a square.
 * 
 * @author TheCentipedeBoys
 *
 */
public class squareBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;

	static Square square;
	int thick;
	private int version;
	
	/**
	 * Creates a new squareBehaviour strategy
	 * @param s An arrayList of strings representing the current mode(s)
	 * @param model the PaintModel 
	 * @param color	the color associated with the square
	 * @param thick thickness of the square
	 */
	public squareBehaviour(ArrayList<String> s, PaintModel model, String color, int thick, int version) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
		this.version = version;
	}

	@Override
	/**
	 *Updates the square width and height as the mouse is dragged and adds a command to draw the 
	 *square to the command stack
	 *Allows for square feedback
	 *
	 */
	public void mouseDragged(MouseEvent e) {
		int a;

		int x1 = square.getCentre().getX();
		int y1 = square.getCentre().getY();
		int x2 = (int) e.getX();
		int y2 = (int) e.getY();
		if (x2 > x1 && y2 > y1) {
			if ((x2 - x1) > (y2 - y1)) {
				a = (x2-x1);
				square.setSideLength(x2 - x1);
			}else {
				a = (y2 - y1);
				square.setSideLength(y2 - y1);	
			}

			if (this.version == 0) {
				square.setArcHeight(0);
				square.setArcWidth(0);
			} else if(this.version == 1) {
				square.setArcHeight((int)((a)* (double)(0.2)));
				square.setArcWidth((int)((a)* (double)(0.2)));
			}
			square.setScenario(1);
			Point centre = new Point(x1, y1);
			square.setCentre(centre);
		}
		// Scenario 2
		else if (x1 > x2 && y2 < y1) {
			if ((x1 - x2) > (y1 - y2)) {
				a = (x1 - x2);
				square.setSideLength(x1 - x2);
			}else {
				a = (y1 - y2);
				square.setSideLength(y1 - y2);
			}

			if (this.version == 0) {
				square.setArcHeight(0);
				square.setArcWidth(0);
			} else if(this.version == 1) {
				square.setArcHeight((int)((a)* (double)(0.2)));
				square.setArcWidth((int)((a)* (double)(0.2)));
			}
			square.setScenario(2);

		}
		// Scenario 3
		else if (x1 > x2 && y1 < y2) {
			if ((x1 - x2) > (y2 - y1)) {
				a = (x1 - x2);
				square.setSideLength(x1 - x2);
			}else {
				a = (y2 - y1);
				square.setSideLength(y2 - y1);
			}

			if (this.version == 0) {
				square.setArcHeight(0);
				square.setArcWidth(0);
			} else if(this.version == 1) {
				square.setArcHeight((int)((a)* (double)(0.2)));
				square.setArcWidth((int)((a)* (double)(0.2)));
			}
			square.setScenario(3);
		}
		// Scenario 4
		else if (x2 > x1 && y2 < y1) {
			if ((x2 - x1) > (y1 - y2)) {
				a = (x2 - x1);
				square.setSideLength(x2 - x1);
			}else {
				a = (y1 - y2);
				square.setSideLength(y1 - y2);
			}

			if (this.version == 0) {
				square.setArcHeight(0);
				square.setArcWidth(0);
			} else if(this.version == 1) {
				square.setArcHeight((int)((a)* (double)(0.2)));
				square.setArcWidth((int)((a)* (double)(0.2)));
			}
			square.setScenario(4);
		}

		this.model.acceptCommand(new Commands(square));
		this.model.deleteCommands();
	}

	@Override
	/**
	 * Creates a new square and adds it as a command to the command stack as the mouse is pressed
	 */
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		Point centre = new Point((int) e.getX(), (int) e.getY());
		int side = 0;
		int scenario = 0;
		int style = 0;
		int arch = 0;
		int arcw = 0;
		Square square2 = new Square(centre, side, scenario, this.color, style,this.thick, arch, arcw);
		if (this.modes.get(1) == "Fill") {
			square2.setStyleS(1);
		}
		square = square2;
		this.model.acceptCommand(new Commands(square));

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	/**
	 * Updates the height and width of the square upon mouse release and adds a command to draw the 
	 * square object while deleting older commands made from feedback
	 */
	public void mouseReleased(MouseEvent e) {
		int a;

		if (square != null) {
			int x1 = square.getCentre().getX();
			int y1 = square.getCentre().getY();
			int x2 = (int) e.getX();
			int y2 = (int) e.getY();

			if (x2 > x1 && y2 > y1) {
				if ((x2 - x1) > (y2 - y1)) {
					a = (x2-x1);
					square.setSideLength(x2 - x1);
				}else {
					a = (y2 - y1);
					square.setSideLength(y2 - y1);	
				}

				if (this.version == 0) {
					square.setArcHeight(0);
					square.setArcWidth(0);
				} else if(this.version == 1) {
					square.setArcHeight((int)((a)* (double)(0.2)));
					square.setArcWidth((int)((a)* (double)(0.2)));
				}
				square.setScenario(1);
				Point centre = new Point(x1, y1);
				square.setCentre(centre);
			}
			// Scenario 2
			else if (x1 > x2 && y2 < y1) {
				if ((x1 - x2) > (y1 - y2)) {
					a = (x1 - x2);
					square.setSideLength(x1 - x2);
				}else {
					a = (y1 - y2);
					square.setSideLength(y1 - y2);
				}

				if (this.version == 0) {
					square.setArcHeight(0);
					square.setArcWidth(0);
				} else if(this.version == 1) {
					square.setArcHeight((int)((a)* (double)(0.2)));
					square.setArcWidth((int)((a)* (double)(0.2)));
				}
				square.setScenario(2);

			}
			// Scenario 3
			else if (x1 > x2 && y1 < y2) {
				if ((x1 - x2) > (y2 - y1)) {
					a = (x1 - x2);
					square.setSideLength(x1 - x2);
				}else {
					a = (y2 - y1);
					square.setSideLength(y2 - y1);
				}

				if (this.version == 0) {
					square.setArcHeight(0);
					square.setArcWidth(0);
				} else if(this.version == 1) {
					square.setArcHeight((int)((a)* (double)(0.2)));
					square.setArcWidth((int)((a)* (double)(0.2)));
				}
				square.setScenario(3);
			}
			// Scenario 4
			else if (x2 > x1 && y2 < y1) {
				if ((x2 - x1) > (y1 - y2)) {
					a = (x2 - x1);
					square.setSideLength(x2 - x1);
				}else {
					a = (y1 - y2);
					square.setSideLength(y1 - y2);
				}

				if (this.version == 0) {
					square.setArcHeight(0);
					square.setArcWidth(0);
				} else if(this.version == 1) {
					square.setArcHeight((int)((a)* (double)(0.2)));
					square.setArcWidth((int)((a)* (double)(0.2)));
				}
				square.setScenario(4);
			}

			this.model.acceptCommand(new Commands(square));
			this.model.deleteCommands();
			square = null;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	

}
