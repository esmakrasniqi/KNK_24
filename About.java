package Stacioni;


import java.awt.Toolkit;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;  



public class About extends Application {

	static Stage stage = new Stage();


	   @Override
	   public void start(Stage stage) {
 {
	  MenuBar menuBar = new MenuBar();
      // Krijo menute
      Menu mainMenu = new Menu("Kryefaqja");
     
      
      Menu Linjatmenu = new Menu("Linjat");
      MenuItem shtoLinje = new MenuItem("Shto Linje");  
	     MenuItem shikoLinjat = new MenuItem("Shiko Linjat"); 
	     Linjatmenu.getItems().add(shtoLinje); 
	     Linjatmenu.getItems().add(shikoLinjat); 
	     
	     
	     shtoLinje.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
		 shtoLinje.setOnAction(e->{
			 
			 //Shtolinjenmenu();
			
			
		 });
	   
	     shikoLinjat.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN));
	     shikoLinjat.setOnAction(e->{
	       	 ShikoLinjat.showLinjattables();
		    	
	    	
	    	 
	     });
      
      Menu reserveMenu = new Menu("Rezervoni");
		 reserveMenu.setOnAction(e->{
			 
			// RezervoB();
			
			
		 });
	
      Menu laMenu = new Menu("Gjuha");
      Menu aboutMenu = new Menu("Rreth nesh");
      aboutMenu.setStyle("-fx-background-color: #fcfae8" + 
        		"; -fx-text-fill: white;");
      Menu logMenu = new Menu("Dil");
      
      logMenu.setOnAction(e->{
      	
      	 System.exit(0);
      });
      
      // Krijo MenuItems
      MenuItem aItem = new MenuItem("Shqip");
      MenuItem eItem = new MenuItem("Anglisht");

      // shtoj menuItems te Menute
      laMenu.getItems().addAll(aItem, eItem);
 
      // Shtoje menute ne menubar
      menuBar.getMenus().addAll(mainMenu, Linjatmenu,reserveMenu,laMenu, aboutMenu,logMenu);
      BorderPane root1 = new BorderPane();
      root1.setTop(menuBar);
	 
	    Pane pane= new HBox(100);
	    pane.setPadding(new Insets(40, 10, 10, 10)); 
	 final Image image = new Image(getClass().getResource("fiek.png").toExternalForm(), 150, 150, true, true);
	pane.getChildren().add(new ImageView(image));
	 
	 Text text = new Text();  
     
	    text.setX(180);  
	    text.setY(60);  
	    text.setFont(Font.font("Liberation Serif",15));  
	    text.setText("FIEK 2019");   

	 Text text1=new Text();  
	    text1.setX(180);  
	    text1.setY(100);  
	    text1.setText("Te drejtat autoriale i takojne grupit 25!");  
	    text1.setFont(Font.font("Liberation Serif",15));  
	    text1.setUnderline(true);  
	    
		HBox pane1=new HBox(10);
		pane1.setPadding(new Insets(140,100,100,180));
		MenuButton ekipibtn= new MenuButton("Kliko per te pare anetaret e grupit");

		
	
		 ekipibtn.getItems().addAll(new MenuItem("Esma Krasniqi"), new MenuItem("Veton Shala"),new MenuItem("Fatbardh Podvorica"),
				 new MenuItem("Valmira Lokaj"),new MenuItem("Elsa Vitija"));
			pane1.getChildren().add(ekipibtn);
	    



			        
	    Group root = new Group();  
	    Scene scene = new Scene(root,500,400);  


	    root.getChildren().addAll(root1,pane,text,text1, pane1); 
	    root.setStyle("-fx-background-color: #ffaadd; ");
		//vbox.setAlignment(Pos.TOP_LEFT);
	
	    stage.setScene(scene);  
	    stage.setTitle("Rreth nesh - Stacioni i autobuseve");  
	   stage.show();  
			        
			}}
	   
	   
	   public static void main(String[] args) {
			        launch(args);
	   }

				
			    
		}