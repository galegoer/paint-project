package ca.utoronto.utm.paint;

import java.util.ArrayList;

import ca.utoronto.utm.mouseBehaviour.polyBehaviour;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class StyleChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view
	private int size;

	public StyleChooserPanel(View view) {

		this.view = view;

		String[] buttonLabels = { "Undo", "Redo", "Fill", "Outline", "Clear" };

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
		ArrayList<Commands> redosQueue = this.view.getPaintModel().redoQueue;
		ArrayList<Commands> commandsQueue = this.view.getPaintModel().commandQueue;
		String command = ((Button) event.getSource()).getText();
		if (command == "Fill" || command == "Outline") {
			this.view.getPaintPanel().setMode(1, command);
			System.out.println(command);
		} else if ((command == "Undo") && (!(commandsQueue.isEmpty()))) {
			this.view.getPaintModel().deleteCommand();
			size = this.view.getPaintModel().getSize();
		} else if ((command == "Redo") && (!(redosQueue.isEmpty()))) {
			if (size == this.view.getPaintModel().getSize()) {
				Commands x = redosQueue.get(redosQueue.size() - 1);
				this.view.getPaintModel().delRCommand();
				this.view.getPaintModel().acceptCommand(x);
				size = this.view.getPaintModel().getSize();
			} else {
				this.view.getPaintModel().resetR();
			}

		} else if (command == "Clear") {
			this.view.getPaintModel().reset();
			polyBehaviour p = new polyBehaviour(null, null, "", 0);
			p.polyReset();

		}

		System.out.println(command);

	}
}