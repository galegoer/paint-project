package ca.utoronto.utm.paint;

import java.util.ArrayList;

import ca.utoronto.utm.mouseBehaviour.shapeBehaviour;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class polyBehaviour implements shapeBehaviour {
	PaintModel model;
	ArrayList<String> modes;
	String color;
	View view;
	
	static PolyLine polyLine;
	int thick;
	static Line l = new Line();

	public polyBehaviour(ArrayList<String> s, PaintModel model, String color, int thick, View view) {
		this.modes = s;
		this.model = model;
		this.color = color;
		this.thick = thick;
		this.view = view;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (polyLine == null) {

			PolyLine polyLine2 = new PolyLine(this.color, this.thick);

			Point center = new Point((int) e.getX(), (int) e.getY());

			polyLine = polyLine2;
			polyLine.updateThick(this.thick);
			polyLine.updateColor(this.color);
			polyLine.addPoint(center);
			polyLine.setCentre(center);
			this.model.acceptCommand(new Commands(polyLine));


		} else if (e.getButton() == MouseButton.SECONDARY) {
			
			this.model.delQCommand();
			//if (polyLine.getList().size() != 1)
				//this.model.deleteCommands();
			polyLine = null;
			this.view.getPaintPanel().repaint();

		} else {
			polyLine.updateThick(this.thick);
			polyLine.updateColor(this.color);
			Point point = new Point((int) e.getX(), (int) e.getY());
			polyLine.addPoint(point);
			
			polyLine.setCentre(point);
			this.view.getPaintPanel().repaint();
			//removed, might need if we want to undo in stages
			//this.model.acceptCommand(new Commands(polyLine));
			
			//this.model.deleteCommands();
			//if (polyLine.getList().size() != 2)
				//this.model.deleteCommands();
		
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if (polyLine != null) {
			l.setCentre(polyLine.getCentre());
			l.setColor(this.color);
			l.setThick(this.thick);
			l.setStyle("Dotted");
			Point p = new Point((int) e.getX(), (int) e.getY());
			l.setEnd(p);
			this.model.acceptCommand(new Commands(l));
			if (!(this.model.getQueue().get(this.model.getSize() - 2).getObj() instanceof PolyLine))
				this.model.deleteCommands();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	public void polyReset() {
		this.model.delQCommand();
		//had this code here when i was adding polyLine objects
		//if (polyLine.getList().size() != 1)
			//this.model.deleteCommands();
		polyLine = null;
		this.view.getPaintPanel().repaint();
		}

	public PolyLine getPolyLine() {
		return polyLine;
	}

	public void setPolyLine(Object a) {
		polyLine = (PolyLine) a;
	}
}
