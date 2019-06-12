package Stacioni;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text; 
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Font;


import java.sql.*;

 

public class RezervoB extends Application  {
  
    private   Button button = new Button("");
    private static  TextField emri = new TextField("");
    private  static TextField mbiemri = new TextField("");
    static ComboBox<String> ngaComboBox = new ComboBox<String>();
    static ComboBox<String> neComboBox = new ComboBox<String>();
    static TextField nrBiletave = new TextField();
    private static TextField cmimi = new TextField("");
    static DatePicker nisja = new DatePicker();
    static DatePicker kthimi = new DatePicker();
    private static RadioButton dybtn= new RadioButton();
	private static RadioButton njebtn= new RadioButton();
	private static String radiobuttonlbl;
	static Stage stage = new Stage();
	
	
	
	
   @Override public void start(Stage stage) {
	 
	   
        stage.setTitle("RezervoBilet");
        
        
        Scene scene = new Scene(new Group(), 550, 430);
       
        Text text = new Text();  
        text.setText("Rezervo Bilete");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        text.setFill(Color.BLACK);  
 
        
        
       
      
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


    
   
        
        ToggleGroup lloji = new ToggleGroup();
    	njebtn = new RadioButton("Nje Drejtimshe");
    	njebtn.setToggleGroup(lloji);
    	njebtn.setOnAction(e->{
    		radiobuttonlbl=njebtn.getText();
    	});
    	dybtn = new RadioButton("Dy Drejtimshe");
    	dybtn.setToggleGroup(lloji);
    	dybtn.setOnAction(e->{
    		radiobuttonlbl=dybtn.getText();
    	});
        
        Button button = new Button("Rezervo Bilete");
      
    
      
        
        GridPane grid = new GridPane();
       grid.setStyle("-fx-background-color: #FFFFFF;");
        grid.setVgap(7);
        grid.setHgap(7);
        grid.setPadding(new Insets(25,25, 25, 25));
        grid.setAlignment(Pos.CENTER);
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
        grid.add(nrBiletave, 1, 6, 2, 4);
        
        grid.add(new Label("Cmimi: "), 0, 11);
        grid.add(cmimi, 1, 8, 2, 7);
        
        grid.add(new Label("Nisja: "), 0, 14);
        grid.add(nisja, 1, 14);
        
        grid.add(new Label("Kthimi: "), 2, 14);
        grid.add(kthimi, 3, 14);

       grid.add(new RadioButton(), 0, 17);
       grid.add(njebtn, 0, 17);
       
       grid.add(new RadioButton(), 0, 17);
       grid.add(dybtn, 1, 17);
       
   
        grid.add(button, 3, 22);
        button.setStyle("-fx-background-color:aqua;");
        
       button.setOnAction(e->{
    	   Rezervoquery();
       });
       
      

        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
      
        stage.setScene(scene);
        stage.show();
        

}

    public static void Rezervoquery() {
    	
 
	DbConnection.getConnection();
	try {
		
		String query = "INSERT INTO Biletat(vendinis,destinacioni,Bemri,Bmbiemri ,NrBiletav,Cmimi,Nisja,Kthimi,lloji) VALUES (?, ?, ? , ?,?, ?,?,?,?)";
		
		PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
	
		preparedStatement.setString(1,  ((TextField)ngaComboBox.getEditor()).getText());
		preparedStatement.setString(2,  ((TextField)neComboBox.getEditor()).getText());
		preparedStatement.setString(3, emri.getText());
		preparedStatement.setString(4, mbiemri.getText());
		preparedStatement.setString(5, nrBiletave.getText());
		preparedStatement.setString(6, cmimi.getText());
		preparedStatement.setString(7, ((TextField)nisja.getEditor()).getText());
		preparedStatement.setString(8, ((TextField)kthimi.getEditor()).getText());
		preparedStatement.setString(9,radiobuttonlbl);    
		  
		
		if(preparedStatement.executeUpdate() > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Menaxhimi i Linjave");
			alert.setHeaderText(null);
			alert.setContentText("Bileta eshte rezeruar me sukses !");
			alert.showAndWait();
		    emri.clear();
			mbiemri.clear();
			cmimi.clear();
			
			
		
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Menaxhimi i Linjave");
			alert.setHeaderText(null);
			alert.setContentText("Bileta nuk u rezervua,Keni gabime ne shtypje");
			alert.showAndWait();				
		}
		
		
	} catch(SQLException ex) {
		ex.printStackTrace();
	}
    }
	public static void main(String[] args) {
		Application.launch(args);
	    

	
		// TODO Auto-generated method stub
		
	}}

