package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ShapeColor {
	
	public static Color setPaint(String stringcolor) {
		if (stringcolor == "Red"){
				return Color.RED;
		}
		if (stringcolor == "Green"){
			return Color.GREEN;
		}
		if (stringcolor == "Blue"){
			return Color.BLUE;
		}
		else {
			return Color.BLACK;
		}
	}

}
