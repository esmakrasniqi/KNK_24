package projekti;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class frmMain extends Application {

	@Override
	public void start(Stage primaryStage) {      
	GridPane pane = new GridPane();

		pane.setAlignment(Pos.TOP_LEFT);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(15);

		pane.add(new Label("Nisja:"), 0, 0);
		pane.add(new TextField(), 1, 0);
		pane.add(new Label("Destinacioni:"), 0, 1);
		pane.add(new TextField(), 1, 1);		
	    Button btnKerko = new Button("Kerko");

	pane.add(btnKerko, 1, 2);
	GridPane.setHalignment(btnKerko, HPos.RIGHT);

	pane.add(new Label("Komente, sygjerime, ankesa:"), 0, 5);
	pane.add(new Label("Emri:"), 0, 6);
	pane.add(new TextField(), 1, 6);
	
	
	
	Scene scene = new Scene(pane);
	primaryStage.setTitle("Stacioni i autobuseve"); 
	primaryStage.setScene(scene); 
	primaryStage.show(); 
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	
	
}