
package ca.utoronto.utm.paint;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Paint extends Application {

	PaintModel model; // Model
	View view; // View + Controller
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		
		this.model = new PaintModel();
		
		// View + Controller
		this.view = new View(model, stage);
		
		
		
	}
}
