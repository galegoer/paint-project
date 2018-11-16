package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * ColorChooserPanel is a panel that allows the choice of colors. It initializes a variety of color choices and sets actions
 * for what color a new object will use.
 * @author TheCentipedeBoys
 *
 */

public class ColorChooserPanel extends GridPane implements EventHandler<ActionEvent> {
	
	private View view;
/**
 * Initializes the ColorChooserPanel, in the constructor. The view is created and the buttons
 * are added as a variety of choices, the string buttons are placed on the right side and the constructor references an actionevent.
 * @param view for the buttons.
 */
	public ColorChooserPanel(View view) {
		final ToggleGroup group = new ToggleGroup();
		this.view = view;
		
		String [] buttonLabels = {"Ghostwhite","Red", "Crimson", "Green", "Blue","Pink", "Orange", "Yellow", "Brown", "Purple", "Chocolate", "Cyan", "Darkblue", "Darkcyan",
				"Grey", "Black", };
	
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
/**
 * handles what the action of selecting a button does, which in this case sets the color
 */
	@Override
	public void handle(ActionEvent event) {
		String command = ((ToggleButton) event.getSource()).getAccessibleText();
		this.view.getPaintPanel().setColor(command);
		System.out.println(command);
	}
	
	
	
	
	
	
}
