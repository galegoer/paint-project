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
		
		try {
			Image image = new Image(new FileInputStream("C:\\Users\\William\\repo_a2_TheCentipedeBoys\\Assignment2\\squiggle.png"));
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(20);
			imageView.setFitWidth(50);
			Button button5 = new Button();
			button5.setGraphic(imageView);
			button5.setMinWidth(100);
			this.add(button5, 0, row);
			
			row++;
			Image image2 = new Image(new FileInputStream("C:\\Users\\William\\repo_a2_TheCentipedeBoys\\Assignment2\\polyline.png"));
			ImageView imageView2 = new ImageView(image2);
			imageView2.setFitHeight(20);
			imageView2.setFitWidth(50);
			Button button6 = new Button();
			button6.setGraphic(imageView2);
			button6.setMinWidth(100);
			this.add(button6, 0, row);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//File a = new File("");
		//System.out.println("abc");
		//System.out.println(a.getAbsolutePath());
		//FileInputStream inputstream = new FileInputStream(); 
		//Image image = new Image(inputstream); 
		//i.setX(100);	
		//i.setY(100);

//		Image imageDecline = new Image(getClass().getResourceAsStream("squiggle.png"));
		//Button button5 = new Button();
		///button5.setGraphic(imageView);
		//button5.setMinWidth(100);
		//this.add(button5, 0, row);
	}

	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getText();
		this.view.getPaintPanel().setMode(command);
		System.out.println(command);
	}
}
