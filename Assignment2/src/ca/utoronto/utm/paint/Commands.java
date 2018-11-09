package ca.utoronto.utm.paint;

import java.util.Observable;

import javafx.scene.canvas.GraphicsContext;

public class Commands extends Observable implements ShapeCommand {
	private Object obj;
	
	public Commands(Object obj) {
		this.obj = obj;
	}
	
	
	//IDK IF U NEED g?
	@Override
	public void execute(GraphicsContext g) {
		if(obj instanceof Point) {
			this.createPoint((Point) obj, g);
		} else if(obj instanceof Circle) {
			this.createCircle((Circle) obj, g);
		} else if(obj instanceof Rectangle) {
			this.createRect((Rectangle) obj, g);
		} else if(obj instanceof Square) {
			this.createSquare((Square) obj, g);
		}
		
	}
	
	public void createPoint(Point p, GraphicsContext g) {
		//Point p1 = points.get(i);
		//Point p2 = points.get(i + 1);
		//g.setStroke(Circle.setPaint(this.color));
		//g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		//CURRENTLY NOT WORKING NEED TO FIX FOR SQUIGGLE
	}
	
	public void createCircle(Circle c, GraphicsContext g) {
		int x = c.getCentre().getX();
		int y = c.getCentre().getY();
		int radius = c.getRadius();
		if(c.getStyleC() == 1) {
			g.setFill(Circle.setPaint(c.getString())); //FIX WITH WHAT COLOR IS SET
			g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
		} else {
			g.strokeOval(x-radius, y-radius, 2*radius, 2*radius);
		}
		g.setStroke(Circle.setPaint(c.getString()));
		g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
		g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}

	public void createRect(Rectangle r, GraphicsContext g) {	
		int a = r.getCentre().getX();
		int b = r.getCentre().getY();
		int height = r.getHeight();
		int width = r.getWidth();
		if(r.getStyleR() == 1) {
			g.setFill(Circle.setPaint(r.getColorR()));
			if(r.getScenario() == 1) {
				g.fillRect(a, b, width, height);
			}else if(r.getScenario() == 2) {
				g.fillRect(a-width, b-height , width, height);
			}else if(r.getScenario() == 3) {
				g.fillRect(a-width, b, width, height);
			}else if(r.getScenario() == 4) {
				g.fillRect(a, b-height , width, height);
		}}else{
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
	//ArrayList<Square> squares = this.model.getSquares();
	//for (Square r : squares) {
	public void createSquare(Square r, GraphicsContext g) {
		int a = r.getCentre().getX();
		int b = r.getCentre().getY();
		int side = r.getSideLength();
		if(r.getStyleS() == 1) {
			g.setFill(Circle.setPaint(r.getColorS()));
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