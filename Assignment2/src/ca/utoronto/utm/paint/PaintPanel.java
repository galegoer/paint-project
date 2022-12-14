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

	private int thick = 1;

	public PaintPanel(PaintModel model, View view) {

		this.canvas = new Canvas(500, 500);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: white");

		this.addEventHandler(MouseEvent.ANY, this);

		this.modes.add(0, "Circle"); // This code sets the default (WILL BE AN OUTLINED CIRCLE)
		this.modes.add(1, "Outline"); // This code sets the default

		this.model = model;
		this.model.addObserver(this);

		this.view = view;

	}

	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();

		// Clear the canvas
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		g.setStroke(Color.BLACK);

		// The position of seWidth line here makes sure that the i value shown on canvas
		// remains readable.
		g.setLineWidth(1);
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
	 * Sets the mode for the PaintPanel.
	 * 
	 * @param index an integer identifying the mode (0 being shape,
	 * 1 being fill or outline)
	 * @param mode a string representing the modes name
	 */
	public void setMode(int index, String mode) {
		this.modes.set(index, mode);
	}
	

	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * Sets the thickness of this.thick
	 * @param thick	current thickness
	 */
	public void setThick(int thick) {
		this.thick = thick;
	}

	@Override
	public void handle(MouseEvent event) {
		c.setModel(this.model);
		c.setColor(this.color);
		c.setModes(this.modes);
		c.setThick(this.thick);
		c.setView(this.view);
		c.setBehaviour(this.modes.get(0));
		c.move(event);
	}

	/**
	 * Gets the current value of slider and assigns it to thick.
	 * @param slider_num	current slider value.
	 */
	public void setstrokethickness(int slider_num) {
		thick = slider_num;
	}
}