package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class StyleChooserPanel extends GridPane implements EventHandler<ActionEvent> {

		private View view; // So we can talk to our parent or other components of the view

		public StyleChooserPanel(View view) {

			this.view = view;

			String[] buttonLabels = { "Fill", "Outline", "Clear" };

			int row = 0;
			for (String label : buttonLabels) {
				Button button = new Button(label);
				button.setMinWidth(100);
				this.add(button, 5, row);
				row++;
				button.setOnAction(this);
			}
		}

		@Override
		public void handle(ActionEvent event) {
			String command = ((Button) event.getSource()).getText();
			if (command != "Clear") {
			this.view.getPaintPanel().setMode(1, command);
			System.out.println(command);
			}
			else {
				this.view.getPaintModel().reset();
				System.out.println(command);
				
			}
		}
	}

