package ca.utoronto.utm.mouseBehaviour;

import javafx.scene.input.MouseEvent;

/**
 * The shapeBehaviour the main strategy that should be implemented by the concrete shapeBehaviour strategies 
 * which are circleBehaviour, squareBehaviour, rectangleBehaviour etc.
 * Methods to be implemented include how the shape should be altered when a mouse input is given
 * @author TheCentipedeBoys
 *
 */
public interface shapeBehaviour {
	public void mouseDragged (MouseEvent e);
	public void mousePressed (MouseEvent e);
	public void mouseClicked (MouseEvent e);
	public void mouseReleased (MouseEvent e);
	public void mouseMoved (MouseEvent e);
	public void mouseExited (MouseEvent e);
	public void mouseEntered (MouseEvent e);

}
