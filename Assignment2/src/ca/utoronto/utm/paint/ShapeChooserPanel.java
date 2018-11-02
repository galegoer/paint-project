package ca.utoronto.utm.paint;

import java.io.File;
import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.image.*;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;

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
		
		Rectangle r = new Rectangle();
		r.setHeight(20.0f);
		r.setWidth(35.0f);
		
		Rectangle t = new Rectangle();
		t.setHeight(20.0f);
		t.setWidth(20.0f);
		
		SVGPath svg = new SVGPath();
		
		
		Shape[] shapes = {c, r, t};
		
			
		int row = 0;
		for (Shape s : shapes) {
			Button button = new Button();
			button.setGraphic(s);
			button.setMinWidth(100);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
		}
		
		System.out.println(new File(".").getAbsolutePath());
		FileInputStream inputstream = new FileInputStream("C:\\Users\\William\\repo_a2_TheCentipedeBoys\\Assignment2\\images\\squiggle.png");
		//Image image = new Image("images/squiggle.png", 50, 50, true, true);
		//ImageView i = new ImageView(image);
		//i.setX(100);
		//i.setY(100);

		//Button button = new Button();
//		button.setGraphic(new ImageView(image));
//		button.setMinWidth(100);
//		this.add(button, 0, row);
	}

	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getText();
		this.view.getPaintPanel().setMode(command);
		System.out.println(command);
	}
}
