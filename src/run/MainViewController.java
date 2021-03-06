package run;

import java.io.File;
import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import reader.ReadJsonFile;
import writer.CreateJsonFile;

public class MainViewController {
	
	@FXML
    private Button chooseFileButton; //Value injected by FXMLLoader
	
	@FXML
	private Button outputButton;
	
	@FXML
	private Label displayLoc;
	
	@FXML
	private TextField outputFileName;
	
	@FXML
	private Button run;
	
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
    	if (jsonFile != null) {
    		displayLoc.setText(jsonFile.getPath());
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Ooops, file is missing!");
	        alert.setHeaderText(null);
	        alert.setContentText("Please provide the input json file");

	        alert.showAndWait();
		}
    	
	}
    
    @FXML
	public void handleOutputFile() {

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
    	java.util.Date date= new java.util.Date();
    	fileChooser.setInitialFileName(String.valueOf(date.getTime()));
    	File jsonFile = fileChooser.showSaveDialog(stage);
    	if (jsonFile != null) {
    		outputFileName.setText(jsonFile.getPath());
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Ooops, file is missing!");
	        alert.setHeaderText(null);
	        alert.setContentText("Please provide the name for output");

	        alert.showAndWait();
		}
    	
	}
    
    @FXML
    public void handleRun(){
    	disableButtons();
    	if(displayLoc.getText().isEmpty()){
    		Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Ooops, file is missing!");
	        alert.setHeaderText(null);
	        alert.setContentText("Please provide the input json file");

	        alert.showAndWait();
	        unDisableButtons();
    	} else if (outputFileName.getText().isEmpty()){
    		Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Ooops, output file name is missing!");
	        alert.setHeaderText(null);
	        alert.setContentText("Please provide the output file name");

	        alert.showAndWait();
	        unDisableButtons();
    	} else {
    		//reading the json file 
    		ReadJsonFile readJsonFile = new ReadJsonFile();
    		readJsonFile.parseJsonFile(new File(displayLoc.getText()));
    		
    		//getting the hashmap that is created using json objects
    		HashMap<Long, HashMap<String, Object>> data = readJsonFile.getFinalHashMap();
    		System.out.println(data.size());
    		
    		//writing json object to the file
    		CreateJsonFile.writeJsonData(new File(outputFileName.getText()), data);
    		unDisableButtons();
    	}
    }

	private void unDisableButtons() {
		chooseFileButton.setDisable(false);
		outputButton.setDisable(false);
		outputFileName.setDisable(false);
		
	}

	private void disableButtons() {
		chooseFileButton.setDisable(true);
		outputButton.setDisable(true);
		outputFileName.setDisable(true);
	}

}
