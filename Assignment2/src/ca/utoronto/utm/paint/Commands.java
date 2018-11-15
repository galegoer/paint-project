package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.canvas.GraphicsContext;

public class Commands extends Observable implements ShapeCommand {
	private Object obj;
	DrawingOperator operator = new DrawingOperator();

	public Commands(Object obj) {
		this.obj = obj;
	}

	// IDK IF U NEED g?
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
			operator.acceptCommand(new SetColor((Line) obj, g));
			this.createLine((Line) obj, g);
			//operator.acceptCommand(new SetThickness((Line) obj, g));
		} else if(obj instanceof Squiggle) {
			this.createSquig((Squiggle) obj, g);
		} else if (obj instanceof PolyLine) {
			this.createPolyLine((PolyLine) obj, g);
		} else if (obj instanceof RoundedRectangle) {
			this.createRoundedRect((RoundedRectangle) obj, g);
		}
	}

	public Object getObj() {
		return this.obj;
	}

	private void createLine(Line c, GraphicsContext g) {
		int x = c.getCentre().getX();
		int y = c.getCentre().getY();
		int x2 = c.getEnd().getX();
		int y2 = c.getEnd().getY();
		operator.acceptCommand(new SetColor(c, g));
//		// experimental
//		operator.acceptCommand(new SetColor(c , g));
		//		operator.acceptCommand(new SetThickness(Line c , g));
		//g.setStroke(ShapeColor.setPaint(c.getColor()));
		g.setLineWidth(c.getThick());
		if (c.getStyle() == "Dotted") {
			g.setLineDashes(10d);
			g.strokeLine(x, y, x2, y2);
			g.setLineDashes(null);
		} else {
			g.strokeLine(x, y, x2, y2);
		}
	}

	private void createPolyLine (PolyLine p, GraphicsContext g) {
		ArrayList<Point> polyLinePoints = p.getList();
		for (int i = 0; i < polyLinePoints.size() - 1; i++) {
			Point p1 = polyLinePoints.get(i);
			Point p2 = polyLinePoints.get(i + 1);
			g.setStroke(ShapeColor.setPaint(p.getColor()));
			g.setLineWidth(p.getThick());
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}

	public void createSquig(Squiggle squig, GraphicsContext g) {
		g.setStroke(ShapeColor.setPaint(squig.getString())); //GETS COLOR
		g.setLineWidth(squig.getThick());
		for(int i=0; i<squig.getPoints()-1; i++)
			g.strokeLine(squig.getPoint(i).getX(), squig.getPoint(i).getY(), squig.getPoint(i+1).getX(), squig.getPoint(i+1).getY());
	}

	public void createCircle(Circle c, GraphicsContext g) {
		int x = c.getCentre().getX();
		int y = c.getCentre().getY();
		int radius = c.getRadius();
		g.setLineWidth(c.getThick());g.setStroke(ShapeColor.setPaint(c.getString()));
		if (c.getStyleC() == 1) {
			g.setFill(ShapeColor.setPaint(c.getString())); // FIX WITH WHAT COLOR IS SET
			g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
		}else{
			g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
		}
		
		//g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
		//g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}

	public void createRect(Rectangle r, GraphicsContext g) {
		int a = r.getCentre().getX();
		int b = r.getCentre().getY();
		int height = r.getHeight();
		int width = r.getWidth();
		g.setLineWidth(r.getThick());
		if (r.getStyleR() == 1) {
			g.setFill(ShapeColor.setPaint(r.getColorR()));
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
			g.setStroke(ShapeColor.setPaint(r.getColorR()));
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
	// ArrayList<Square> squares = this.model.getSquares();
	// for (Square r : squares) {
	public void createSquare(Square r, GraphicsContext g) {
		int a = r.getCentre().getX();
		int b = r.getCentre().getY();
		int side = r.getSideLength();
		int arch= r.getArcHeight();
		int arcw = r.getArcWidth();
		g.setLineWidth(r.getThick());
		if (r.getStyleS() == 1) {
			g.setFill(ShapeColor.setPaint(r.getColorS()));
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
			g.setStroke(ShapeColor.setPaint(r.getColorS()));
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
	public void createRoundedRect(RoundedRectangle p, GraphicsContext g) {	
		int a = p.getCentre().getX();
		int b = p.getCentre().getY();
		int height = p.getHeight();
		int width = p.getWidth();
		int arch = p.getArcHeight();
		int arcw = p.getArcWidth();
		g.setLineWidth(p.getThick());
		if(p.getStyleR() == 1) {
			g.setFill(ShapeColor.setPaint(p.getColorR()));
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
			g.setStroke(ShapeColor.setPaint(p.getColorR()));
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