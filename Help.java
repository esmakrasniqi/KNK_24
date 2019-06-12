package Stacioni;



import javafx.geometry.Insets;
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;  



public class Help {

		public static void help() {

			Stage helpAboutStage = new Stage();
			
			WebView browser = new WebView();

			WebEngine webEngine = browser.getEngine();

			String url = About.class.getResource("help.html").toExternalForm();

			System.out.println("Local URL: " + url);
			
			webEngine.load(url);

			Scene sc = new Scene(browser, 2000, 800);

			helpAboutStage.setTitle("Manuali i perdorimit");
			helpAboutStage.setScene(sc);

			helpAboutStage.show();
		}

	}
	