package ca.utoronto.utm.mouseBehaviour;

import javafx.scene.input.MouseEvent;

public interface mouseBehaviour {
	public void mouseDragged (MouseEvent e);
	public void mousePressed (MouseEvent e);
	public void mouseClicked (MouseEvent e);
	public void mouseReleased (MouseEvent e);
	public void mouseMoved (MouseEvent e);
	public void mouseExited (MouseEvent e);
	public void mouseEntered (MouseEvent e);

}
