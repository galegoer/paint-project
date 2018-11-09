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
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view

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


		// Adding a Slider
		final Slider slider = new Slider(0, 10, 0.5);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(0.25f);
		slider.setBlockIncrement(0.1f);
		//slider.setText("Thickness");
		//slider.setOrientation(this);
		this.add(slider, 0 , 20);

		// Implementing a slider so that it can communicate
		slider.valueProperty().addListener(sl -> { 
			int slider_num = slider.valueProperty().intValue();
			this.view.getPaintPanel().setstrokethickness(slider_num);

		});


		String[] names = {"Circle", "Rectangle", "Square"};
		Shape[] shapes = {c,r,t};

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
			Image image = new Image(new FileInputStream("images/squiggle.png"));
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(20);
			imageView.setFitWidth(50);
			ToggleButton button5 = new ToggleButton();
			button5.setAccessibleText("Squiggle");
			button5.setOnAction(this);
			button5.setGraphic(imageView);
			button5.setMinWidth(100);
			button5.setToggleGroup(group);
			this.add(button5, 0, row);

			row++;
			Image image2 = new Image(new FileInputStream("images/polyline.png"));
			ImageView imageView2 = new ImageView(image2);
			imageView2.setFitHeight(20);
			imageView2.setFitWidth(50);
			ToggleButton button6 = new ToggleButton();
			button6.setAccessibleText("Polyline");
			button6.setOnAction(this);
			button6.setGraphic(imageView2);
			button6.setMinWidth(100);
			button6.setToggleGroup(group);
			this.add(button6, 0, row);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void handle(ActionEvent event) {
		String command = ((ToggleButton) event.getSource()).getAccessibleText();
		this.view.getPaintPanel().setMode(0, command);
		System.out.println(command);
	}

}
