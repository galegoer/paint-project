package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class ColorChooserPanel extends GridPane implements EventHandler<ActionEvent> {
	
	private View view;
	
	public ColorChooserPanel(View view) {
		final ToggleGroup group = new ToggleGroup();
		this.view = view;
		
		String [] buttonLabels = {"Red", "Green", "Blue", "Black"};
	
		int row = 0;
	
		for (String label : buttonLabels) {
			ToggleButton button = new ToggleButton();
			button.setToggleGroup(group);
			button.setAccessibleText(label);
			button.setMinWidth(30);
			button.setStyle("-fx-base: " + label + ";");
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
		}
	}
	@Override
	public void handle(ActionEvent event) {
		String command = ((ToggleButton) event.getSource()).getAccessibleText();
		this.view.getPaintPanel().setColor(command);
		System.out.println(command);
	}
	
	
	
	
	
	
}
