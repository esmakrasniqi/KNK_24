package Stacioni;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text; 
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Font;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ComboBox;
import java.sql.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

 

public class RezervoB extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private   Button button = new Button("");
    private  TextField emri = new TextField("");
    private  TextField mbiemri = new TextField("");
    private  TextField cmimi = new TextField("");
   
       @Override public void start(Stage stage) {
        stage.setTitle("RezervoBilet");
        Scene scene = new Scene(new Group(), 780, 500);
       
        Text text = new Text();  
        text.setText("Rezervo Bilete");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        text.setFill(Color.WHITE);  
        text.setStrokeWidth(2); 
        text.setStroke(Color.BLACK);        
        
       
        
       ComboBox ngaComboBox = new ComboBox();
        ngaComboBox.getItems().addAll(
            "Peje",
            "Deçan",
            "Kline",
            "Gjakove",
            "Prizeren",
            "Podujeve",
            "Gjilan",
            "Ferizaj",
            "Mitrovice",
            "Vushtri",
            "Suhareke",
            "Lipjan",
            "Istog",
            "Fushe Kosove"   
        );
     
        
       ComboBox neComboBox = new ComboBox();
        neComboBox.getItems().addAll(
        	      "Peje",
                  "Deçan",
                  "Kline",
                  "Gjakove",
                  "Prizeren",
                  "Podujeve",
                  "Gjilan",
                  "Ferizaj",
                  "Mitrovice",
                  "Vushtri",
                  "Suhareke",
                  "Lipjan",
                  "Istog",
                  "Fushe Kosove"  
        );   

       ComboBox nrBiletaveComboBox = new ComboBox();
        nrBiletaveComboBox.getItems().addAll(
        	    "1",
        	    "2",
        	    "3",
        	    "4",
        	    "5",
        	    "6"
        ); 
    
    
        DatePicker nisja = new DatePicker();
        DatePicker kthimi = new DatePicker();
        
        RadioButton radioButton1 = new RadioButton("Njedrejtimshe");
        RadioButton radioButton2 = new RadioButton("Dydrejtimshe ");
        
        Button button = new Button("Rezervo Bilete");
      
    
      
        
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color:SANDYBROWN");
        grid.setVgap(7);
        grid.setHgap(7);
        grid.setPadding(new Insets(60, 60, 60, 60));

        grid.add(new Text(), 0, 0);
        grid.add(text, 1, 0);
        
        grid.add(new Label("Nga: "), 0, 1);
        grid.add(ngaComboBox, 1, 1);
        
        grid.add(new Label("Ne: "), 2, 1);
        grid.add(neComboBox, 3, 1);
        
        grid.add(new Label("Emri: "), 0, 2);
        grid.add(emri, 1, 2, 2, 2);
        
        grid.add(new Label("Mbiemri: "), 0, 5);
        grid.add(mbiemri, 1, 4, 2, 3); 
      
        grid.add(new Label("NrBiletave: "), 0, 8);
        grid.add(nrBiletaveComboBox, 1, 6, 3, 6);
        
        grid.add(new Label("Cmimi: "), 0, 12);
        grid.add(cmimi, 1, 9, 2, 9);
        
        grid.add(new Label("Nisja: "), 0, 18);
        grid.add(nisja, 1, 18);
        
        grid.add(new Label("Kthimi: "), 2, 18);
        grid.add(kthimi, 3, 18);

       grid.add(new RadioButton(), 0, 21);
       grid.add(radioButton1, 0, 21);
       
       grid.add(new RadioButton(), 0, 21);
       grid.add(radioButton2, 1, 21);
       
   
        grid.add(button, 3, 22);
        button.setStyle("-fx-border-color: BLACK; -fx-border-width: 5px; -fx-text-fill: BLACK ");
        
       
       
      

        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }    
}
