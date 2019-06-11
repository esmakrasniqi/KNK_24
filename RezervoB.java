package projekti;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
 
public class RezervoB extends Application {
    public static void main(String[] args) {
        launch(args);
    }

     Button button = new Button ("");
     TextField emri = new TextField("");
     TextField mbiemri = new TextField("");
     TextField nrBiletave = new TextField("");
     TextField cmimi = new TextField("");


  
    
    @Override public void start(Stage stage) {
        stage.setTitle("RezervoBilet");
        Scene scene = new Scene(new Group(), 650, 500);
       

        
      
        
        ComboBox ngaComboBox = new ComboBox();
        ngaComboBox.getItems().addAll(
            "Peje",
            "Deqan",
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
                  "Deqan",
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
       Button button = new Button("Rezervo Bileten");
      
    
        DatePicker nisja = new DatePicker();
         DatePicker kthimi = new DatePicker();
      
        

        
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color:PINK");
        grid.setVgap(7);
        grid.setHgap(10);
     
        grid.setPadding(new Insets(70, 70, 70, 40));
         grid.add(new Label("REZERVO"), 2, 0);
        
        
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

      
       
       
        grid.add(button, 3, 25);
        button.setStyle("-fx-background-color:SILVER");
        
       
       
      

        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }    
}
