package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.awt.FlowLayout;  
import java.awt.Panel;  
import javax.swing.JComboBox;  
import javax.swing.JFrame;  
import javax.swing.JSplitPane;  

public class View implements EventHandler<ActionEvent> {

	private PaintModel model;
	
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private StyleChooserPanel styleChooserPanel;
	//ColorChooserPanel
	private ColorChooserPanel colorChooserPanel;

	public View(PaintModel model, Stage stage) {

		this.model = model;
		initUI(stage);
		
	}

	private void initUI(Stage stage) {

		this.paintPanel = new PaintPanel(this.model, this);
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		this.styleChooserPanel = new StyleChooserPanel(this);

		this.colorChooserPanel = new ColorChooserPanel(this);
		
		//splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.shapeChooserPanel, this.colorChooserPanel);
		
		BorderPane root = new BorderPane();
		root.setTop(createMenuBar());
		root.setCenter(this.paintPanel);
		root.setLeft(this.shapeChooserPanel);
		root.setBottom(this.styleChooserPanel);
		root.setRight(this.colorChooserPanel);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Paint");
		stage.show();
	}
	
	public PaintPanel getPaintPanel() {
		return paintPanel;
	}
	
	public PaintModel getPaintModel() {
		return model;
	}
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}
	
	public ColorChooserPanel getColorchooserPanel() {
		return colorChooserPanel;
	}

	private MenuBar createMenuBar() {

		MenuBar menuBar = new MenuBar();
		Menu menu;
		MenuItem menuItem;

		// A menu for File

		menu = new Menu("File");

		menuItem = new MenuItem("New");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Open");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Save");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Exit");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		// Another menu for Edit

		menu = new Menu("Edit");

		menuItem = new MenuItem("Cut");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Copy");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Paste");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Undo");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Redo");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		return menuBar;
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println(((MenuItem)event.getSource()).getText());
	}
}
