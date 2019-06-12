package Stacioni;


import java.sql.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class frmMain extends Application{
	
	
	private static TextField NisjaTxt = new TextField();
	private static TextField DestinacioniTxt = new TextField();
    private static TextField Emri=new TextField();
    private static TextField Komenti= new TextField();
	private static Text resultLabel;
	
	private static TextField VendinisjesTxt = new TextField();
	private static TextField LDestinacioniTxt = new TextField();
	private  static TextField OranisjesTxt = new TextField();
	private static  TextField OraArritjesTxt = new TextField();
	private static TextField CmimiTxt = new TextField();
	private static  TextField EmriKompanistxt = new TextField();
	private  static CheckBox verifikimicheck = new CheckBox("E verifikuar ?");
	private static Button shtoLinje = new Button("Shto _Linjen");
	
	private static    Stage mainstage = new Stage();
	
	  public static void main(String[] args) {
	      Application.launch(args);
	    }
	
	    public void start(Stage Mainstage) {
	    	
		
		   DbConnection.getConnection();
			Text shtotxt = new Text("Kerko udhetimin:");
			shtotxt.setFont(Font.font("Arial", FontWeight.LIGHT, 18));
			
			
			   MenuBar menuBar = new MenuBar();
		        // Krijo menute
		        Menu mainMenu = new Menu("Kryefaqja");
		        mainMenu.setStyle("-fx-background-color: #fcfae8" + 
		        		"; -fx-text-fill: black;");
		        
		        Menu Linjatmenu = new Menu("Linjat");
		        MenuItem shtoLinje = new MenuItem("Shto Linje");  
			     MenuItem shikoLinjat = new MenuItem("Shiko Linjat"); 
			     Linjatmenu.getItems().add(shtoLinje); 
			     Linjatmenu.getItems().add(shikoLinjat); 
			     
			     
			     shtoLinje.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
				 shtoLinje.setOnAction(e->{
					 
					 Shtolinjenmenu();
					
					
				 });
			   
			     shikoLinjat.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN));
			     shikoLinjat.setOnAction(e->{
			       	 ShikoLinjat.showLinjattables();
				    	
			    	
			    	 
			     });
			     
			      Menu reserveMenubar = new Menu("Rezervoni");
			        
			        MenuItem reserveMenu = new MenuItem("Rezervo Bileten"); 
			        reserveMenu.setAccelerator(new KeyCodeCombination(KeyCode.B, KeyCombination.CONTROL_DOWN));
			        
			        reserveMenubar.getItems().add(reserveMenu); 
			        reserveMenu.setOnAction(e->{
			        	
			        	RezervoB.Rezervomenu();
			        });
		        

		        Menu laMenu = new Menu("Gjuha");
		        Menu aboutMenu = new Menu("Ndihme");
		        MenuItem aboutHelpItem = new MenuItem("Rreth nesh"); 
		        aboutMenu.getItems().add(aboutHelpItem); 
		        
		        aboutHelpItem.setOnAction(e -> {
		        	About.about();
		        });
		        
		        
		        


		      Image openIcon = new Image(getClass().getResourceAsStream("foto/1.png"));
		      ImageView exitview = new ImageView(openIcon);
		      exitview.setFitWidth(15);
		      exitview.setFitHeight(15);
		        Menu logMenu = new Menu();
		        MenuItem exitMenuItem = new MenuItem("Dil"); 
		        logMenu.setGraphic(exitview);
			      logMenu.getItems().add(exitMenuItem); 
		        
		        exitMenuItem.setOnAction(e -> {
		        	Platform.exit();
		        });


		        
		        // Krijo MenuItems
		        MenuItem aItem = new MenuItem("Shqip");
		        MenuItem eItem = new MenuItem("Anglisht");
		        Image alIcon = new Image(getClass().getResourceAsStream("foto/ALFlag.png"));
			      ImageView alview = new ImageView(alIcon);
			      alview.setFitWidth(20);
			     alview.setFitHeight(20);
			      aItem.setGraphic(alview);
			      Image eIcon = new Image(getClass().getResourceAsStream("foto/UKFlag.png"));
			      ImageView eview = new ImageView(eIcon);
			      eview.setFitWidth(20);
			     eview.setFitHeight(20);
			      eItem.setGraphic(eview);
		        aItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
		        eItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
		  
		        // shtoj menuItems te Menute
		        laMenu.getItems().addAll(aItem, eItem);
		   
		        // Shtoje menute ne menubar
		        menuBar.getMenus().addAll(mainMenu, Linjatmenu,reserveMenubar,laMenu, aboutMenu,logMenu);
		        BorderPane root = new BorderPane();
		        root.setTop(menuBar);
			
			
			
	        GridPane pane = new GridPane();
		    Button Kerko = new Button("Kerko");
		// Kerko.setStyle("-fx-background-color: grey; -fx-text-fill: white;"); 
		     Image sIcon = new Image(getClass().getResourceAsStream("foto/search.png"));
		      ImageView sview = new ImageView(sIcon);
		      sview.setFitWidth(20);
		     sview.setFitHeight(20);
		      Kerko.setGraphic(sview);
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
			Dergo.setStyle("-fx-background-color: green; -fx-text-fill: white;"); 
			
			Button Fshij = new Button("Fshij");
			Fshij.setStyle("-fx-background-color: red; -fx-text-fill: white;"); 
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
		//	vbox.setStyle("-fx-background-color:#FFD662; ");
			vbox.setAlignment(Pos.TOP_LEFT);
			Scene scene= new Scene(vbox,500,400); 

	 
			   if (scene.focusOwnerProperty().get() instanceof TextArea) {
			        TextArea focusedTextArea = (TextArea) scene.focusOwnerProperty().get();
			    }
	        mainstage.setScene(scene);
	        mainstage.setTitle("Stacioni i Autobuseve - Prishtine ");
	        mainstage.show();
	   }
	  
	
	

		
		private static void Kerko() { 
			try {
				
		   	String query = "SELECT FROM Linjat WHERE Vendi_nisjes=?, Destinacioni =?";
				
				PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
				
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

	    private static void Dergo() { 
	     	String query = "INSERT INTO Komentet(Kemri, Komenti) VALUES (?, ?)";
			try {
				
		  
				
				PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
				
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
	    private static void Shtolinjenmenu() {
			
	    	Button btnkthehu = new Button("Kthehu");
	    	btnkthehu.setOnAction(e->{
	    		
	    		mainstage.show();
	    	});
	    	
			Text shtotxt = new Text("Shto Linje te re");
			shtotxt.setFont(Font.font("Arial Black", FontWeight.MEDIUM, 14));
			
			
			
	         GridPane shtoPane = new GridPane();
	     	shtoPane.addRow(0, shtotxt);
			shtoPane.addRow(1, new Label("Vendi Nisjes :"),VendinisjesTxt);
			shtoPane.addRow(2, new Label ("Destinacioni :"),LDestinacioniTxt);
			shtoPane.addRow(3, new Label("Ora nisjes"),OranisjesTxt);
			shtoPane.addRow(4, new Label ("Ora Arritjes"),OraArritjesTxt);
			shtoPane.addRow(5, new Label("Cmimi :"), CmimiTxt);
			shtoPane.addRow(6, new Label("Emri Kompanise"), EmriKompanistxt);
			shtoPane.addRow(7, verifikimicheck);
			shtoPane.addRow(8, shtoLinje);
			shtoPane.addRow(9, btnkthehu);
		
			shtoPane.setHgap(10); 
			shtoPane.setVgap(10); 
			
			shtoPane.setAlignment(Pos.CENTER);
			
			HBox buttonspane = new HBox();
			buttonspane.getChildren().addAll(shtoLinje) ;
			buttonspane.setMinHeight(15);
			buttonspane.setAlignment(Pos.CENTER);
			 shtoLinje.setStyle("-fx-background-color: green; -fx-text-fill: white;"); 
			shtoLinje.setOnAction(e->{
				ShtoLinjequery();
				
			});
			VBox shtobox = new VBox();
			shtobox.getChildren().addAll(shtoPane , buttonspane);
			shtobox.setAlignment(Pos.CENTER);
			
			 Scene shtolinjensc= new Scene(shtobox,500,400);
			
			 mainstage.setScene(shtolinjensc);
			 mainstage.show();
		
		}
		
		private static void ShtoLinjequery() { 
			DbConnection.getConnection();
			try {
				
				String query = "INSERT INTO Linjat(Vendi_nisjes,Destinacioni,Oranisjes, OraArritjes,Cmimi,EmriKompanis,Verifikmi) VALUES (?, ?, ? , ?,?, ?,?)";
				
				PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
				
				preparedStatement.setString(1, VendinisjesTxt.getText());
				preparedStatement.setString(2, LDestinacioniTxt.getText());
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
					OranisjesTxt.clear();
					OraArritjesTxt.clear();
					CmimiTxt.clear();
					EmriKompanistxt.clear();
					verifikimicheck.setSelected(false);
					
				
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
	    

