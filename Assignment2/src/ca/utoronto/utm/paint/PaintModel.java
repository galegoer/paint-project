package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	
	//Line one pls fix airic
	private ArrayList<Line> lines = new ArrayList<Line>();
	
	public void addLine(Line c) {
		this.lines.add(c);
		this.setChanged();
		this.notifyObservers();
	}
	
	private ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	// This one created for rectangle
	private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
	//Square list
	private ArrayList<Square> squares = new ArrayList<Square>();

	public void addPoint(Point p) {
		this.points.add(p);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Line> getLines() {
		return lines;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public void addCircle(Circle c) {
		this.circles.add(c);
		this.setChanged();
		this.notifyObservers();
	}
	public void removeCircle(int i) {
		this.circles.remove(i);
	}
	public void removeAllCircles() {
		this.circles = new ArrayList<Circle>();
	}
	public void removeAllSquares() {
		this.squares = new ArrayList<Square>();
	}
	public void removeAllPoints() {
		this.points = new ArrayList<Point>();
	}
	public void removeAllRectangles() {
		this.rectangles = new ArrayList<Rectangle>();
	}
	
	public ArrayList<Circle> getCircles() {
		return circles;
	}
	
	
	// Code below this line is for Rectangle
	public void addRectangle(Rectangle r) {
		this.rectangles.add(r);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void removeRectangle(int i) {
		this.rectangles.remove(i);
	}
	
	public void addSquare(Square square) {
		this.squares.add(square);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void removeSquare(int i) {
		this.squares.remove(i);
	}

	public ArrayList<Rectangle> getRectangles() {
		return rectangles;
	}
	public ArrayList<Square> getSquares() {
		return squares;
	}

}
