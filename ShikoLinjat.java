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
	   private TextField LidTxt = new TextField();
	private TextField Vendi_nisjestxt = new TextField();
	private TextField Destinacionitxt = new TextField();
	private TextField Oranisjestxt = new TextField();
	private TextField Oraarritjestxt = new TextField();
	private TextField Cmimitxt = new TextField();
	private TextField EmriKompanistxt = new TextField();
	private TextField Verifikimitxt = new TextField();

	
//	// Buttons
//	
	private Button updateBtn = new Button("Update");
	private Button deleteBtn = new Button("Delete");
//	

	       // Text scenetitle = new Text("Linjat e Autobuseve");
	       // scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
	        
	        
	        
	      		GridPane boxpane1 = new GridPane();
		
//		boxpane1.addRow(0, new Label("ID: "), LidTxt);
		boxpane1.addRow(1, new Label("VendiNis: "), Vendi_nisjestxt);
		boxpane1.setAlignment(Pos.BOTTOM_LEFT);
		boxpane1.addRow(2, new Label("Desti: "), Destinacionitxt);
		boxpane1.addRow(3, new Label("OraN: "), Oranisjestxt);
		
		GridPane boxpane2 = new GridPane();
		boxpane2.setAlignment(Pos.BOTTOM_CENTER);
     	boxpane2.addRow(1, new Label("OraA: "), Oraarritjestxt);
    	boxpane2.addRow(2, new Label("Cmimi: "), Cmimitxt);
    	boxpane2.addRow(3, new Label("EmriK: "), EmriKompanistxt);
    	
    	GridPane boxpane3 = new GridPane();
    	boxpane2.setAlignment(Pos.BOTTOM_RIGHT);
    	boxpane2.addRow(1, new Label("Verifikimi"), Verifikimitxt);
    	boxpane2.addRow(2, new Label(""), deleteBtn);
    	boxpane2.addRow(3, new Label(" "), updateBtn);
		
		boxpane2.setHgap(10);
		boxpane2.setVgap(10);
		boxpane3.setHgap(10);
		boxpane3.setVgap(10);
		boxpane1.setHgap(10);
		boxpane1.setVgap(10);
		
		updateBtn.setOnAction(e->{
			//Linjattable.updateLinjattable(0, null, null, null, null, 0, null, false);
		});

		
		HBox downPane = new HBox(15);
	
		downPane.getChildren().addAll(boxpane1,boxpane2,boxpane3);
		
	
		TableColumn<String, Linjattable> Linjac = new TableColumn<>("ID");
		Linjac.setCellValueFactory(new PropertyValueFactory("Lid"));
		Linjac.setPrefWidth(10);
		
		TableColumn<String, Linjattable> Vendinisjesc = new TableColumn<>("VendiNisjes");
		 Vendinisjesc.setCellValueFactory(new PropertyValueFactory("Vendi_nisjes"));
		 Vendinisjesc.setPrefWidth(65);
		
		TableColumn<String, Linjattable> Destinacionic = new TableColumn<>("Destinacioni");
		 Destinacionic.setCellValueFactory(new PropertyValueFactory("Destinacioni"));
		 Destinacionic.setPrefWidth(65);
		
		TableColumn<String, Linjattable> Oranisjesc = new TableColumn<>("OraNisjes");
		Oranisjesc.setCellValueFactory(new PropertyValueFactory("Oranisjes"));
		Oranisjesc.setPrefWidth(70);
		
		TableColumn<String, Linjattable> OraArritjesc = new TableColumn<>("OraArritjes");
		OraArritjesc.setCellValueFactory(new PropertyValueFactory("OraArritjes"));
		OraArritjesc.setPrefWidth(70);
		
		TableColumn<String, Linjattable> Cmimic = new TableColumn<>("Cmimi");
		Cmimic.setCellValueFactory(new PropertyValueFactory("Cmimi"));
		Cmimic.setPrefWidth(55);
		
		TableColumn<String, Linjattable> EmriKompanisc= new TableColumn<>("EmriKompanis");
		EmriKompanisc.setCellValueFactory(new PropertyValueFactory("EmriKompanis"));
		EmriKompanisc.setPrefWidth(100);
		
		TableColumn<String, Linjattable> Verifikmic = new TableColumn<>("Verifikimi");
		Verifikmic.setCellValueFactory(new PropertyValueFactory("Verifikimi"));
		Verifikmic.setPrefWidth(70);
		
		LinjattablesTable.getColumns().add(Linjac);
		LinjattablesTable.getColumns().add(Vendinisjesc);
		LinjattablesTable.getColumns().add(Destinacionic);
		LinjattablesTable.getColumns().add(Oranisjesc);
		LinjattablesTable.getColumns().add(	OraArritjesc);
		LinjattablesTable.getColumns().add(Cmimic);
		LinjattablesTable.getColumns().add(EmriKompanisc);
		LinjattablesTable.getColumns().add(Verifikmic);
	
		
		LinjattablesTable.setPrefWidth(650);
		LinjattablesTable.setPrefHeight(200);
		
		// Main Pane
		VBox mainPane = new VBox(10);
		
		mainPane.getChildren().addAll(txtlinjat,LinjattablesTable,downPane);
		
		mainPane.setPadding(new Insets(15, 15, 15 ,15));
		
		
		Scene scene = new Scene(mainPane,550, 400);
		
		primaryStage.setTitle("Library");
		primaryStage.setScene(scene);
		
		showLinjattables();
		
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void showLinjattables() {
		List<Linjattable> Linjattables = Linjattable.getLinjattables();
		
		ObservableList<Linjattable> LinjattableList = FXCollections.observableArrayList();
		
		for(int i = 0; i < Linjattables.size(); i++) {
			LinjattableList.add(Linjattables.get(i));
		}
		
		LinjattablesTable.setItems(LinjattableList);
	}
	
	}
	
