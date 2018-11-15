package ca.utoronto.utm.paint;


import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.image.*;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;

/**
 * The ShapeChoosePanel allows the user to specify the shape that they wish to draw on the canvas.
 * Pressing a button on this panel will modify the mode (shape) and allow different shapeBehvaiours to be
 * installed through the context object located in paint panel.
 * @author TheCentipedeBoys
 *
 */
public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view

	/**
	 * Adds toggle buttons with pictures of shapes to the view and adds a slider to modify the thickness
	 * @param view the view to add new buttons and sliders to
	 */
	public ShapeChooserPanel(View view) {

		final ToggleGroup group = new ToggleGroup();
		this.view = view;

		Circle c = new Circle();
		c.setRadius(10.0f);

		Rectangle r = new Rectangle();
		r.setHeight(20.0f);
		r.setWidth(35.0f);

		Rectangle t = new Rectangle();
		t.setHeight(20.0f);
		t.setWidth(20.0f);
		
		Line l = new Line();
		l.setStartX(0.0f);
		l.setEndX(30.0f);
		
		Rectangle o = new Rectangle();
		o.setHeight(15.0f);
		o.setWidth(25.0f);
		o.setArcHeight(10.0f);
		o.setArcWidth(20.0f);
		
		Rectangle n = new Rectangle();
		n.setHeight(20.0f);
		n.setWidth(20.0f);
		n.setArcHeight(10.0f);
		n.setArcWidth(10.0f);

		// Adding a Slider
		final Slider slider = new Slider(1, 10, 1);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(1f);
		slider.setBlockIncrement(0.1f);
		
		this.add(slider, 0 , 20);

		// Implementing a slider so that it can communicate
		slider.valueProperty().addListener(sl -> { 
			int slider_num = slider.valueProperty().intValue();
			this.view.getPaintPanel().setstrokethickness(slider_num);
		});


		String[] names = {"Circle", "Rectangle", "Square", "Line", "RoundedRectangle", "RoundedSquare", "Squiggle", "PolyLine"};
		Shape[] shapes = {c,r,t,l,o,n};

		int row = 0;
		for (int i =0; i < shapes.length; i++) {
			ToggleButton button = new ToggleButton();
			button.setAccessibleText(names[i]);
			button.setOnAction(this);
			button.setGraphic(shapes[i]);
			button.setMinWidth(100);
			button.setToggleGroup(group);
			this.add(button, 0, row);
			row++;
		}

		try {
			String[] files = new String[2];
			files[0] = ("images/squiggle.png");
			files[1] = ("images/polyline.png");
			int i = 6;
			for (String s: files) {
				Image image = new Image(new FileInputStream(s));
				ImageView imageView = new ImageView(image);
				imageView.setFitHeight(20);
				imageView.setFitWidth(50);
				ToggleButton button = new ToggleButton();
				button.setAccessibleText(names[i]);
				button.setOnAction(this);
				button.setGraphic(imageView);
				button.setMinWidth(100);
				button.setToggleGroup(group);
				this.add(button, 0, row);
				i++;
				row++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	/**
	 * Changes the mode (shape) to be drawn when the user presses a button. Also, if the user doesn't end the polyline
	 * object then changing modes will end it for them.
	 * This function will retrieve the specified shape as a text and forward it to paint panel
	 */
	public void handle(ActionEvent event) {
		String command = ((ToggleButton) event.getSource()).getAccessibleText();
		this.view.getPaintPanel().setMode(0, command);
		
		polyBehaviour p = new polyBehaviour(null, this.view.getPaintModel(), "", 0, this.view);
		if (polyBehaviour.polyLine != null)
			p.polyReset();
	}

}
