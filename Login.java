package Stacioni;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import java.sql.*;

public class Login extends Application {
	

	//login
	private TextField UsernameTxt = new TextField();
	private PasswordField PasswordTxt = new PasswordField();
	private  Label lblerror = new Label();
	static Stage loginStage;

	//Regjistorhu
	private TextField REmriTxt = new TextField();
	private TextField RMbremriTxt = new TextField();
	private TextField REmailTxt = new TextField();
	private TextField RUsernameTxt = new TextField();
	private RadioButton Mrbtn= new RadioButton();
	private RadioButton Frbtn= new RadioButton();
	private String radiobuttonlbl;
	 private static ProgressBar shiritistatusit = new ProgressBar(0);
	 double i = 0 ;
	private PasswordField RPasswordTxt = new PasswordField();

	
	

	public void start(Stage primaryStage) {
		
		loginStage = primaryStage;
		
		DbConnection.getConnection();
		
	  FlowPane firstpane = new FlowPane();
		
		
		firstpane.setAlignment(Pos.CENTER);
		firstpane.setHgap(15);
		firstpane.setVgap(15);
		firstpane.setPadding(new Insets(28, 28, 28, 28));
		
		Text stacioni = new Text("APPLIKACIONI STACIONI NGA GRUPI 24");
		stacioni.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
		Text scenetitle = new Text("Mire se erdhet ne Applikacionin tone, Deshironi te lidheni apo te regjistroheni");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
		
		
	    firstpane.setAlignment(Pos.BASELINE_CENTER);
		
	    
		Button lidhubtn = new Button("_Lidhu");
		Button RegjistrohuBtn = new Button("_Regjistrohu");
		HBox hbBtn = new HBox(30);
		//hbBtn.setAlignment(Pos.CENTER);
		hbBtn.getChildren().addAll(lidhubtn,RegjistrohuBtn);
		lidhubtn.setStyle("-fx-background-color: green; -fx-text-fill: white;"); 
		lidhubtn.setMaxSize(120, 130);
		lidhubtn.setOnAction(e -> {	
			
			lidhuscene();
			
		
		});
		RegjistrohuBtn.setStyle("-fx-background-color: green; -fx-text-fill: white;"); 
		RegjistrohuBtn.setMaxSize(120, 130);
		RegjistrohuBtn.setOnAction(e -> {		

			Regjistrohuscene();
		
		});
		
		
		Image imageb = new Image("ee.png");
		
		ImageView busimg = new ImageView();
	     
		busimg.setImage(imageb);
		busimg.setFitWidth(299);
		busimg.setPreserveRatio(true);
		busimg.setSmooth(true);
		busimg.setCache(true);
		
		firstpane.getChildren().addAll(stacioni,scenetitle,hbBtn,busimg);
		Scene welcomescene = new Scene(firstpane,510,500);
		
		loginStage.setTitle("Login");
		loginStage.setScene(welcomescene);
		loginStage.show();
		
	}
	
	public void lidhuscene() {
		
		Text logintitle= new Text("Login");
		logintitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
		
		GridPane gridPane = new GridPane();
		
		gridPane.add(logintitle, 0, 0, 2, 1);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));
		
		Label userName = new Label("User Name:");
		gridPane.add(userName, 0, 1);

		gridPane.add(UsernameTxt, 1, 1);

		Label paswordlbl = new Label("Password:");
		gridPane.add(paswordlbl, 0, 2);

		
		gridPane.add(PasswordTxt, 1, 2);
		
		
		Button lidhubtn = new Button("_Lidhu");
		Button RegjistrohuBtn = new Button("_Regjistrohu");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().addAll(lidhubtn,RegjistrohuBtn);
		gridPane.add(hbBtn, 1, 4);
		
		gridPane.add(lblerror, 1, 6);
		lidhubtn.setStyle("-fx-background-color: green; -fx-text-fill: white;"); 
		lidhubtn.setMaxSize(120, 130);
		lidhubtn.setOnAction(e -> {
			Lidhuquery();
			
		
		});
		RegjistrohuBtn.setStyle("-fx-background-color: green; -fx-text-fill: white;"); 
		RegjistrohuBtn.setMaxSize(120, 130);
		RegjistrohuBtn.setOnAction(e -> {		
			
			
			Regjistrohuscene();
		
		});
		Scene loginscene = new Scene(gridPane,500,500);
		loginStage.setScene(loginscene);

	}

 private void Regjistrohuscene()
 {
	
	Text scenetitle = new Text("Regjistrohu");
	scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	

	GridPane gridPane = new GridPane();
	
	gridPane.add(scenetitle, 0, 0, 2, 1);
	gridPane.setAlignment(Pos.CENTER);
	gridPane.setHgap(10);
	gridPane.setVgap(10);
	gridPane.setPadding(new Insets(25, 25, 25, 25));
	
	Label Emrilbl = new Label("Emri:");
	gridPane.add(Emrilbl, 0, 1);

	gridPane.add(REmriTxt, 1, 1);

	Label Rmbiemrilbl = new Label("Mbiemri:");
	gridPane.add(Rmbiemrilbl, 0, 2);

	
	gridPane.add(RMbremriTxt, 1, 2);
	
	Label REmaillbl = new Label("Email:");
	gridPane.add(REmaillbl, 0, 3);

	
	gridPane.add(REmailTxt, 1, 3);
	
	Label Rusernamelbl = new Label("Username:");
	gridPane.add(Rusernamelbl, 0, 4);

	
	gridPane.add(RUsernameTxt, 1, 4);
	
	Label RPasslbl = new Label("Password:");
	gridPane.add(RPasslbl, 0, 5);

	
	gridPane.add(RPasswordTxt, 1, 5);
	 
	//Radio buttonat per gjinin
	ToggleGroup gjinia = new ToggleGroup();
	Mrbtn = new RadioButton("Mashkull");
	Mrbtn.setToggleGroup(gjinia);
	Mrbtn.setOnAction(e->{
		radiobuttonlbl=Mrbtn.getText();
	});
	Frbtn = new RadioButton("Femer");
	Frbtn.setToggleGroup(gjinia);
	Frbtn.setOnAction(e->{
		radiobuttonlbl=Frbtn.getText();
	});
	
	 HBox radiobox = new HBox(20, Mrbtn,Frbtn);
	 gridPane.add(radiobox,1,6);
	 gridPane.add(shiritistatusit,1,8);
	
	Button lidhubtn = new Button("_Lidhu");
	Button RegjistrohuBtn = new Button("_Regjistrohu");
	HBox hbBtn = new HBox(10);
	hbBtn.setAlignment(Pos.CENTER);
	hbBtn.getChildren().addAll(lidhubtn,RegjistrohuBtn);
	gridPane.add(hbBtn, 1, 7);

	lidhubtn.setStyle("-fx-background-color: green; -fx-text-fill: white;"); 
	lidhubtn.setMaxSize(120, 130);
	lidhubtn.setOnAction(e -> {
		
		lidhuscene();

	});
	
	RegjistrohuBtn.setStyle("-fx-background-color: green; -fx-text-fill: white;"); 
	RegjistrohuBtn.setMaxSize(120, 130);
	RegjistrohuBtn.setOnAction(e -> {	
		
	     for(i=0;i<1.0;i+=0.0001)
	        {
	        	   shiritistatusit.setProgress(i);
	        }
	
		Regjistrohuquery();
		
	  
	});
	
	Scene sceneregjistrohu = new Scene(gridPane,500,500);
	
	loginStage.setScene(sceneregjistrohu);

	

 }
 
	private void Regjistrohuquery() { 
		DbConnection.getConnection();
		try {
			
			String query = "INSERT INTO Regjistrohu(Emri,Mbiemri,Email,Username,Password,Gjinia) VALUES (?, ?, ? , ?,?,?)";
			
			PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, REmriTxt.getText());
			preparedStatement.setString(2, RMbremriTxt.getText());
			preparedStatement.setString(3, REmailTxt.getText());
			preparedStatement.setString(4, RUsernameTxt.getText());
			preparedStatement.setString(5, RPasswordTxt.getText());
			preparedStatement.setString(6, radiobuttonlbl);     
			
	
		
             	if(preparedStatement.executeUpdate() > 0) {
             		
             	
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Stacioni");
				alert.setHeaderText(null);
				alert.setContentText("Jeni Regjistruar me Sukes!");
				alert.showAndWait();
				 REmailTxt.clear();
				 RUsernameTxt.clear();
				 RPasswordTxt.clear();
				
			
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Stacioni");
				alert.setHeaderText(null);
				alert.setContentText("Username dhe Password nuk jane te plotesuara");
				alert.showAndWait();
								
			}
			

	
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	

	
	
}

 
	
	private void Lidhuquery() {
		String query = "Select * from Regjistrohu where Username = ? AND Password = ?";
		
		try {
			PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, UsernameTxt.getText());
			preparedStatement.setString(2, PasswordTxt.getText());

			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				
				loginStage.hide();
				frmMain.Mainstage();
				
			  
				
			} else {
				
				lblerror.setTextFill(Color.FIREBRICK);
		        lblerror.setText("Keni Shtypur Gabim");
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	

	
}


