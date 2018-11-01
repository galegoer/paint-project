package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view

	public ShapeChooserPanel(View view) {

		this.view = view;
		
		//String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline" };
	
		//Point p = new Point(100,100);
		Circle c = new Circle();
		//c.setCenterX(100.0f);
		//c.setCenterY(100.0f);
		c.setRadius(10.0f);
		//Button button = new Button();
		//button.setGraphic(c);
		//button.setMinWidth(100);
		//this.add(button, 0, 0);
		
		Rectangle r = new Rectangle();
		r.setHeight(20.0f);
		r.setWidth(20.0f);
		//Button button2 = new Button();
		//button2.setGraphic(r);
		//button2.setMinWidth(100);
		//this.add(button2, 0, 0);
		
		Shape[] shapes = {c, r};
		
			
		int row = 0;
		for (Shape s : shapes) {
			Button button = new Button();
			button.setGraphic(s);
			button.setMinWidth(100);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
		}
	}

	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getText();
		this.view.getPaintPanel().setMode(command);
		System.out.println(command);
	}
}
