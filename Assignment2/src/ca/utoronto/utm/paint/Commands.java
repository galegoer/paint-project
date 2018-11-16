package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.canvas.GraphicsContext;

/**
 * This class is used to implement the commands to draw the shapes
 * asked for by a mouse event.
 * @author TheCentipedeBoys
 *
 */

public class Commands extends Observable implements ShapeCommand {
	private Object obj;
	
	/**
	 * Constructs a Commands that takes in an object
	 * @param obj
	 */
	public Commands(Object obj) {
		this.obj = obj;
	}


	/**
	 * Executes the command to create the object
	 * @param g graphics context to use when creating object
	 */
	@Override

	public void execute(GraphicsContext g) {
		if (obj instanceof Point) {
			//this.createPoint((Point) obj, g);
		} else if (obj instanceof Circle) {
			this.createCircle((Circle) obj, g);
		} else if (obj instanceof Rectangle) {
			this.createRect((Rectangle) obj, g);
		} else if (obj instanceof Square) {
			this.createSquare((Square) obj, g);
		} else if (obj instanceof Line) {
			this.createLine((Line) obj, g);
		} else if(obj instanceof Squiggle) {
			this.createSquig((Squiggle) obj, g);
		} else if (obj instanceof PolyLine) {
			this.createPolyLine((PolyLine) obj, g);
		} else if (obj instanceof RoundedRectangle) {
			this.createRoundedRect((RoundedRectangle) obj, g);
		}
	}
	
	/**
	 * 
	 * @return the object assigned to Commands
	 */
	
	public Object getObj() {
		return this.obj;
	}

	/**
	 * Strokes a Line given the Line object and graphics
	 * context
	 * @param c Line object to be drawn
	 * @param g Graphics context to stroke the object
	 */
	
	private void createLine(Line c, GraphicsContext g) {
		int x = c.getCentre().getX();
		int y = c.getCentre().getY();
		int x2 = c.getEnd().getX();
		int y2 = c.getEnd().getY();
		g.setStroke(Circle.setPaint(c.getColor()));
		g.setLineWidth(c.getThick());
		if (c.getStyle() == "Dotted") {
			g.setLineDashes(10d);
			g.strokeLine(x, y, x2, y2);
			g.setLineDashes(null);
		} else {
			g.strokeLine(x, y, x2, y2);
		}

	}
	/**
	 * Strokes a Polyline object
	 * @param p Polyline object to be drawn
	 * @param g Graphics context to stroke the object
	 */
	private void createPolyLine (PolyLine p, GraphicsContext g) {
		ArrayList<Point> polyLinePoints = p.getList();
		for (int i = 0; i < polyLinePoints.size() - 1; i++) {
			Point p1 = polyLinePoints.get(i);
			Point p2 = polyLinePoints.get(i + 1);
			g.setStroke(Circle.setPaint(p.getColor()));
			g.setLineWidth(p.getThick());
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}

	/**
	 * Strokes a Squiggle object
	 * @param squig Squiggle object to be drawn
	 * @param g Graphics context to draw the object
	 */
	
	public void createSquig(Squiggle squig, GraphicsContext g) {
		g.setStroke(Circle.setPaint(squig.getString())); //GETS COLOR
		g.setLineWidth(squig.getThick());
		for(int i=0; i<squig.getPoints()-1; i++)
			g.strokeLine(squig.getPoint(i).getX(), squig.getPoint(i).getY(), squig.getPoint(i+1).getX(), squig.getPoint(i+1).getY());
	}

	/**
	 * Strokes a Circle object
	 * @param c Circle object to be drawn
	 * @param g Graphics context to draw the object
	 */

	public void createCircle(Circle c, GraphicsContext g) {
		int x = c.getCentre().getX();
		int y = c.getCentre().getY();
		int radius = c.getRadius();
		g.setLineWidth(c.getThick());
		if (c.getStyleC() == 1) {
			g.setFill(Circle.setPaint(c.getString())); // FIX WITH WHAT COLOR IS SET
			g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
		}else{
			g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
		}
		g.setStroke(Circle.setPaint(c.getString()));
		g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
		g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}

	/**
	 * Strokes a Rectangle object
	 * @param r Rectangle object to be drawn
	 * @param g Graphics context to draw the object
	 */
	
	public void createRect(Rectangle r, GraphicsContext g) {
		int a = r.getTopLeft().getX();
		int b = r.getTopLeft().getY();
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
		}else{
			g.setStroke(Circle.setPaint(r.getColorR()));
			if (r.getScenario() == 1) {
				g.strokeRect(a, b, width, height);
				g.strokeRect(a, b, width, height);
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

	/**
	 * Strokes a rounded Square object or Square object
	 * @param r Square to be drawn
	 * @param g Graphics context to draw the object
	 */
	public void createSquare(Square r, GraphicsContext g) {
		int a = r.getCentre().getX();
		int b = r.getCentre().getY();
		int side = r.getSideLength();
		int arch= r.getArcHeight();
		int arcw = r.getArcWidth();
		g.setLineWidth(r.getThick());
		if (r.getStyleS() == 1) {
			g.setFill(Circle.setPaint(r.getColorS()));
			if (r.getScenario() == 1) {
				g.fillRoundRect(a, b, side, side, arch ,arcw);
			} else if (r.getScenario() == 2) {
				g.fillRoundRect(a - side, b - side, side, side, arch ,arcw);
			} else if (r.getScenario() == 3) {
				g.fillRoundRect(a - side, b, side, side, arch ,arcw);
			} else if (r.getScenario() == 4) {
				g.fillRoundRect(a, b - side, side, side, arch ,arcw);
			}
		}else {
			g.setStroke(Circle.setPaint(r.getColorS()));
			if (r.getScenario() == 1) {
				g.strokeRoundRect(a, b, side, side, arch ,arcw);
			} else if (r.getScenario() == 2) {
				g.strokeRoundRect(a - side, b - side, side, side, arch ,arcw);
			} else if (r.getScenario() == 3) {
				g.strokeRoundRect(a - side, b, side, side, arch ,arcw);
			} else if (r.getScenario() == 4) {
				g.strokeRoundRect(a, b - side, side, side, arch ,arcw);
			}
		}
	}
	
	/**
	 * Strokes a rounded Rectangle
	 * @param p Rounded Rectangle object to be drawn
	 * @param g Graphics context  to draw the object
	 */
	
	public void createRoundedRect(RoundedRectangle p, GraphicsContext g) {	
		int a = p.getTopLeft().getX();
		int b = p.getTopLeft().getY();
		int height = p.getHeight();
		int width = p.getWidth();
		int arch = p.getArcHeight();
		int arcw = p.getArcWidth();
		g.setLineWidth(p.getThick());
		if(p.getStyleR() == 1) {
			g.setFill(Circle.setPaint(p.getColorR()));
			if(p.getScenario() == 1) {
				g.fillRoundRect(a, b, width, height, arch, arcw);
			}else if(p.getScenario() == 2) {
				g.fillRoundRect(a-width, b-height , width, height, arch, arcw);
			}else if(p.getScenario() == 3) {
				g.fillRoundRect(a-width, b, width, height, arch, arcw);
			}else if(p.getScenario() == 4) {
				g.fillRoundRect(a, b-height , width, height, arch, arcw);
			}
		}else{
			g.setStroke(Circle.setPaint(p.getColorR()));
			if (p.getScenario() == 1) {
				g.strokeRoundRect(a, b, width, height, arch, arcw);
			} else if (p.getScenario() == 2) {
				g.strokeRoundRect(a - width, b - height, width, height, arch, arcw);
			} else if (p.getScenario() == 3) {
				g.strokeRoundRect(a - width, b, width, height, arch, arcw);
			} else if (p.getScenario() == 4) {
				g.strokeRoundRect(a, b - height, width, height, arch, arcw);
			}
		}
	}	
}