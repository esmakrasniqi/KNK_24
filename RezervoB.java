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

    final Button button = new Button ("Rezervo-Bileten");
    final Label notification = new Label ();
    final TextField emri = new TextField("");
    final TextField mbiemri = new TextField("");
    final TextField nrBiletave = new TextField("");
    final TextField cmimi = new TextField("");


  
    
    @Override public void start(Stage stage) {
        stage.setTitle("RezervoBilet");
        Scene scene = new Scene(new Group(), 500, 400);
       

        
      
        
        final ComboBox ngaComboBox = new ComboBox();
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
     
        
        final ComboBox neComboBox = new ComboBox();
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

        

        
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("REZERVO"), 2, 0);
        grid.add(new Label("Nga: "), 0, 1);
        grid.add(ngaComboBox, 1, 1);
        grid.add(new Label("Ne: "), 2, 1);
        grid.add(neComboBox, 3, 1);
        grid.add(new Label("Emri: "), 0, 2);
        grid.add(emri, 1, 2, 3, 2);
        grid.add(new Label("Mbiemri: "), 0, 5);
        grid.add(mbiemri, 1, 4, 3, 3); 
        grid.add(new Label("NrBiletave: "), 0, 8);
        grid.add(nrBiletave, 1, 6, 3, 6);
        grid.add(new Label("Cmimi: "), 0, 12);
        grid.add(cmimi, 1, 9, 3, 9);
        grid.add(button, 3, 20);
        grid.add (notification, 8, 20, 5, 20);
       
      

        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }    
}