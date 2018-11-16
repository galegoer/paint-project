
package ca.utoronto.utm.paint;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This class is used to launch a model and view which is later used by the view and the model. 
 */
public class Paint extends Application {

	PaintModel model; // Model
	View view; // View + Controller
	

	public static void main(String[] args) {
		launch(args);
	}
/**
 * Start initializes a new PaintModel and a new view
 * @param stage
 */
	@Override
	public void start(Stage stage) throws Exception {
		
		
		this.model = new PaintModel();
		
		// View + Controller
		this.view = new View(model, stage);
		
		
		
	}
}
