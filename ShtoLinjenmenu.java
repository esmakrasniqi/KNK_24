package Stacioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ShtoLinjenmenu extends MainStacioni{
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	private TextField VendinisjesTxt = new TextField();
	private TextField DestinacioniTxt = new TextField();
	private TextField OranisjesTxt = new TextField();
	private TextField OraArritjesTxt = new TextField();
	private TextField CmimiTxt = new TextField();
	private TextField EmriKompanistxt = new TextField();
	private CheckBox verifikimicheck = new CheckBox("E verifikuar ?");
	private Button shtoLinje = new Button("Shto Linjen");

	
	private static Connection dbConnection;

	public void start(Stage primaryStage) {
		
		DbConnection.getConnection();
		Text shtotxt = new Text("Shto Linje te re");
		shtotxt.setFont(Font.font("Arial Black", FontWeight.MEDIUM, 14));
		
		
		
         GridPane shtoPane = new GridPane();
     	shtoPane.addRow(0, shtotxt);
		shtoPane.addRow(1, new Label("Vendi Nisjes :"),VendinisjesTxt);
		shtoPane.addRow(2, new Label ("Destinacioni :"),DestinacioniTxt);
		shtoPane.addRow(3, new Label("Ora nisjes"),OranisjesTxt);
		shtoPane.addRow(4, new Label ("Ora Arritjes"),OraArritjesTxt);
		shtoPane.addRow(5, new Label("Cmimi :"), CmimiTxt);
		shtoPane.addRow(6, new Label("Emri Kompanise"), EmriKompanistxt);
		shtoPane.addRow(7, verifikimicheck);
		shtoPane.addRow(8, shtoLinje);
	
		
		
	
		shtoPane.setHgap(10); 
		shtoPane.setVgap(10); 
		
		shtoPane.setAlignment(Pos.CENTER);
		
		HBox buttonspane = new HBox();
		buttonspane.getChildren().addAll(shtoLinje) ;
		buttonspane.setMinHeight(15);
		buttonspane.setAlignment(Pos.CENTER);
	
		shtoLinje.setOnAction(e->{
			
			ShtoLinje();
		});
		VBox shtobox = new VBox();
		shtobox.getChildren().addAll(shtoPane , buttonspane);
		shtobox.setAlignment(Pos.CENTER);
		Scene scene= new Scene(shtobox,400,400);
		
		primaryStage.setTitle("Menagjo Linjat");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void ShtoLinje() { 
		try {
			
			String query = "INSERT INTO Linjat(Vendi_nisjes,Destinacioni,Oranisjes, OraArritjes,Cmimi,EmriKompanis,Verifikmi) VALUES (?, ?, ? , ?,?, ?,?)";
			
			PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, VendinisjesTxt.getText());
			preparedStatement.setString(2, DestinacioniTxt.getText());
			preparedStatement.setString(3, OranisjesTxt.getText());
			preparedStatement.setString(4, OraArritjesTxt.getText());
			preparedStatement.setString(5, CmimiTxt.getText());
			preparedStatement.setString(6, EmriKompanistxt.getText());
			preparedStatement.setBoolean(7,verifikimicheck.isSelected());     
			
			if(preparedStatement.executeUpdate() > 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Menaxhimi i Linjave");
				alert.setHeaderText(null);
				alert.setContentText("Linja u shtua me sukses !");
				alert.showAndWait();
				
			
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Menaxhimi i Linjave");
				alert.setHeaderText(null);
				alert.setContentText("Linja nuk u shtua");
				alert.showAndWait();				
			}
			
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	

}
		

