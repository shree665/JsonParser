package run;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainViewController {
	
	@FXML //  fx:id="chooseFileButton"
    private Button chooseFileButton; //Value injected by FXMLLoader
	
	@FXML
	private Label displayLoc;
	
	private Stage stage;
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded. This is the good place to load data to the 
     * view
     */
    @FXML
    private void initialize() {
    	//nothing to display
    }

    @FXML
	public void handleNewFile() {
    	
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Please Choose json File");
    	
    	//assigning the initial directory
    	fileChooser.setInitialDirectory(
           new File(System.getProperty("user.home"))
         );
    	
    	//file extensions
    	fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JSON", "*.json")
        );
    	
    	File jsonFile = fileChooser.showOpenDialog(stage);
    	displayLoc.setText(jsonFile.getPath());
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ooops");
        alert.setHeaderText("Alert box");
        alert.setContentText("File path is: "+jsonFile.getPath());

        alert.showAndWait();
        /*
		 assert chooseFileButton != null : "fx:id=\"chooseFileButton\" was not injected: check your FXML file 'simple.fxml'.";
		 
		 chooseFileButton.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent event) {
	            	Alert alert = new Alert(AlertType.INFORMATION);
	                alert.setTitle("Ooops");
	                alert.setHeaderText("Alert box");
	                alert.setContentText("Author: Vivek Subedi\nWebsite: http://vsubedi.com");

	                alert.showAndWait();
	            }
	        });

		*/
	}

}
