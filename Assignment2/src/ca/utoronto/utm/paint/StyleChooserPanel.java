package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * A class that when constructed implements a Panel at the bottom left of the canvas 
 * with Undo, Redo, Fill, Outline, and Clear buttons.
 * @author TheCentipedeBoys
 */

public class StyleChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view
	private int size;

	/**
	 * Constructs a StyleChooserPanel that contains the Undo,
	 * Redo, Fill, Outline, and Clear buttons with View view
	 * @param view View object to apply changes to
	 */
	
	public StyleChooserPanel(View view) {

		this.view = view;

		String[] buttonLabels = { "Undo", "Redo", "Fill", "Outline", "Clear" };

		int row = 0;
		for (String label : buttonLabels) {
			Button button = new Button(label);
			button.setMinWidth(100);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
		}
	}

	/**
	 * Handles an event to either set the Fill Mode or Undo, 
	 * Redo, or Clear the canvas.
	 */
	
	@Override
	public void handle(ActionEvent event) {
		ArrayList<Commands> redosQueue = this.view.getPaintModel().redoQueue;
		ArrayList<Commands> commandsQueue = this.view.getPaintModel().commandQueue;
		String command = ((Button) event.getSource()).getText();
		if (command == "Fill" || command == "Outline") {
			this.view.getPaintPanel().setMode(1, command);
			System.out.println(command);
		} else if ((command == "Undo") && (!(commandsQueue.isEmpty()))) {
			if (commandsQueue.size() > 1 && commandsQueue.get(commandsQueue.size() - 2).getObj() instanceof PolyLine) {
				polyBehaviour p = new polyBehaviour(null, this.view.getPaintModel(), "", 0, this.view);
				Object x = commandsQueue.get(commandsQueue.size() - 1).getObj();
				if (x instanceof Line && ((Line) x).getStyle() == "Dotted")
					p.polyReset();
			}

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


		}

		System.out.println(command);

	}
}