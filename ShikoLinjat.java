package Stacioni;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShikoLinjat extends MainStacioni {
	public  void start(Stage linjat)
	{
	

	       // Text scenetitle = new Text("Linjat e Autobuseve");
	       // scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
	        
	        
	        
	        BorderPane title = new BorderPane();
	       
//	        title.setPadding(new Insets(10,10,10,10));
//			title.getChildren().add(scenetitle);
	
	
		TableView<String> TabelaLinjave = new TableView<>();
		
		
		 TableColumn<String,LinjatA>column1 = new TableColumn<>("Lid");
		column1.setCellValueFactory(new PropertyValueFactory<>("Lid"));
		column1.setPrefWidth(60);
		
		
		TableColumn<String , LinjatA>column2 = new TableColumn<>("Vendi Nisjes");
		column2.setCellValueFactory(new PropertyValueFactory<>("Vendi_nisjes"));
				column2.setPrefWidth(130);
		

		TableColumn<String ,LinjatA>column3 = new TableColumn<>("Destinacioni");
	     column3.setCellValueFactory(new PropertyValueFactory<>("Destinacioni"));
				column3.setPrefWidth(100);

		TableColumn<String , LinjatA>column4= new TableColumn<>("Ora Nisjes");
		column4.setCellValueFactory(new PropertyValueFactory<>("Oranisjes "));
				column4.setPrefWidth(100);

		TableColumn<String , LinjatA>column5 = new TableColumn<>("Ora Arritjes");
		column5.setCellValueFactory(new PropertyValueFactory<>("OraArritjes"));
				column5.setPrefWidth(100);
				
		TableColumn<String , LinjatA>column6 = new TableColumn<>("Cmimi");
		column6.setCellValueFactory(new PropertyValueFactory<>("Cmimi"));
						column6.setPrefWidth(100); 
						
		TableColumn<String , LinjatA>column7 = new TableColumn<>("Emri Kompanis ");
		column7.setCellValueFactory(new PropertyValueFactory<>("EmriKompanis"));
		column7.setPrefWidth(100);
								
		TableColumn<String , LinjatA>column8 = new TableColumn<>("Verifikimi");
		column8.setCellValueFactory(new PropertyValueFactory<>("Verifikimi"));
				column7.setPrefWidth(100);
							
						
								TabelaLinjave.getColumns().add(column1);
								TabelaLinjave.getColumns().add(column2);
								TabelaLinjave.getColumns().add(column3);
								TabelaLinjave.getColumns().add(column4);
								TabelaLinjave.getColumns().add(column5);
								TabelaLinjave.getColumns().add(column6);
								TabelaLinjave.getColumns().add(column7);
								TabelaLinjave.getColumns().add(column8);
		
		
								TabelaLinjave.setPrefWidth(650);
								TabelaLinjave.setPrefHeight(40);
		
	
		VBox linjatpane = new VBox();
		linjatpane.getChildren().addAll(title,TabelaLinjave);
		linjatpane.setPadding(new Insets(25,25,25,25)) ;
		
		
		Scene linjatscene = new Scene(linjatpane,700,500);
		linjat.setScene(linjatscene);
		linjat.show();
	    
	   
		
		
	}
	
	
	 public static List<LinjatA> getLinjatA() {
		 
		 DbConnection.getConnection();
		 
	    	List<LinjatA> ListaL = new ArrayList();
	    	
	    	String query ="Select * from Linjat";
	    	try {
	    		
	    		PreparedStatement prepareStatement = DbConnection.getConnection().prepareStatement(query);
	    		ResultSet resulset =prepareStatement.executeQuery();
	    		
	    		while(resulset.next())
	    		{
	    			LinjatA linjat = new LinjatA
	    				(   resulset.getInt(1) ,
	    					resulset.getString(2),
	    					resulset.getString(3),
	    					resulset.getTime(4),
	    					resulset.getTime(5),
	    					resulset.getFloat(6),
	    					resulset.getString(7),
	    					resulset.getBoolean(9));
	    			
	    			ListaL.add(linjat);
	    		}
	    			
	    		
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    		
	    	}
	    	
			return null;
			
	    }


	
}
