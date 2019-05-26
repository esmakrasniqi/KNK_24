package Stacioni;

import java.sql.*;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class frmMain extends Application {
	private TextField NisjaTxt = new TextField();
	private TextField DestinacioniTxt = new TextField();
    private TextField Emri=new TextField();
    private TextField Komenti= new TextField();


	private Label resultLabel;
	private Connection dbConnection;
	   @Override
	    public void start(Stage primaryStage) {
			setConnection();
			Text shtotxt = new Text("Kerko udhetimin:");
			shtotxt.setFont(Font.font("Arial", FontWeight.LIGHT, 18));
			
			
			   MenuBar menuBar = new MenuBar();
		        // Krijo menute
		        Menu mainMenu = new Menu("Kryefaqja");
		        Menu Menu1 = new Menu("Linjat");
		        Menu reserveMenu = new Menu("Rezervoni");
		        Menu laMenu = new Menu("Gjuha");
		        Menu helpMenu = new Menu("Ndihme");
		        Menu logMenu = new Menu("Kycuni");
		        // Krijo MenuItems
		        MenuItem aItem = new MenuItem("Shqip");
		        MenuItem eItem = new MenuItem("Anglisht");
		        MenuItem cItem = new MenuItem("Lidhu");
		        MenuItem rItem = new MenuItem("Regjistrohu");
		        // shtoj menuItems te Menute
		        laMenu.getItems().addAll(aItem, eItem);
		        logMenu.getItems().addAll(cItem, rItem);
		        // Shtoje menute ne menubar
		        menuBar.getMenus().addAll(mainMenu, Menu1,reserveMenu,laMenu, helpMenu,logMenu);
		        BorderPane root = new BorderPane();
		        root.setTop(menuBar);
			
			
			
	        GridPane pane = new GridPane();
		    Button Kerko = new Button("Kerko");
		    pane.setPadding(new Insets(10, 10, 10, 10)); 
	     	pane.addRow(0, shtotxt);
			pane.addRow(1, new Label("Nisja: "), NisjaTxt);
			pane.addRow(2, new Label ("Destinacioni :"),DestinacioniTxt);
			pane.addRow(3, Kerko);
			pane.setHgap(0); 
			pane.setVgap(10); 
			pane.setAlignment(Pos.CENTER_LEFT);
			HBox box = new HBox();
			box.getChildren().addAll(Kerko) ;
			box.setMinHeight(15);
	        box.setAlignment(Pos.CENTER);
		    box.setPadding(new Insets(0, 0, 70, 0)); 
		
			Kerko.setOnAction(e->{
				Kerko();
			});	


	        GridPane pane1 = new GridPane();
			Text txt1 = new Text("Komente,sygjerime,ankesa:");
		    txt1.setFont(Font.font("Arial", FontWeight.LIGHT, 11));
		    pane1.addRow(1,txt1);
			pane1.addRow(2,new Label("Emri:"), Emri);
			pane1.addRow(3,new Label("Komenti:"), Komenti);
			Komenti.setPrefWidth(300);
			pane1.setAlignment(Pos.CENTER_LEFT);
			pane1.setHgap(0); 
			pane1.setVgap(10); 
			Button Dergo = new Button("Dergo");
			Button Fshij = new Button("Fshij");
			pane1.addRow(4,Dergo);
			pane1.addRow(5,Fshij);	
		    pane1.setPadding(new Insets(10, 10, 10, 10)); 
			HBox box1 = new HBox(5);
			box1.getChildren().addAll(Dergo) ;
			box1.getChildren().addAll(Fshij) ;
			box1.setMinHeight(15);
	        box1.setAlignment(Pos.CENTER);
	    	Dergo.setOnAction(e->{
				Dergo();
			});		
	        
			Fshij.setOnAction(e->{
				Komenti.clear();
			});				
			

			VBox vbox = new VBox();
			vbox.getChildren().addAll(root,pane , box, pane1, box1);
			vbox.setAlignment(Pos.TOP_LEFT);
			Scene scene= new Scene(vbox,500,400); 

	 
			primaryStage.setTitle("Stacioni i autobuseve"); 
	        primaryStage.setScene(scene);
	        primaryStage.show();
	   }
	    public static void main(String[] args) {
	        launch(args);
	    }
		private void setConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/Stacioni",  "root", "0000");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	    
	
		
	    private void Kerko() { 
			try {
				
		   	String query = "SELECT FROM Linjat WHERE Vendi_nisjes, Destinacioni LIKE ?% ";
				
				PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
				
				preparedStatement.setString(1, NisjaTxt.getText());
				preparedStatement.setString(2, DestinacioniTxt.getText());
				
				
				if(preparedStatement.executeUpdate() > 0) {
					resultLabel.setText("Kerkimi perfundoi");
				} else {
					resultLabel.setText("Nuk ka te dhena!");
				}
				
				
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

	    private void Dergo() { 
			try {
				
		   	String query = "INSERT INTO Komentet(Kemri, Komenti) VALUES (?, ?)";
				
				PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
				
				preparedStatement.setString(1, Emri.getText());
				preparedStatement.setString(2, Komenti.getText());
				
				
				if(preparedStatement.executeUpdate() > 0) {
					resultLabel.setText("Komenti u dergua. Faleminderit per sygjerimin.");
				} else {
					resultLabel.setText("Gabim gjate dergimit!");
				}
				
				
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	    
	}

