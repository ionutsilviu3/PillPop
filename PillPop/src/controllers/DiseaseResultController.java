package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import service.PatientService;

public class DiseaseResultController implements Initializable {
	
	@FXML
	private BorderPane paneBackground;
	@FXML
	private Label labelName;
	@FXML
	private TextArea descriptionArea;
	@FXML
	private Button tryAgainButton, finishButton;
	
	private PatientService patientService;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		patientService = new PatientService();
		SceneController.fadeSceneIn(paneBackground);
		try {
			labelName.setText(patientService.findPatientID("1").getPatientName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void finish(ActionEvent event) {
		javafx.application.Platform.exit();
	}
	
	@FXML
	private void tryAgain(ActionEvent event) {
		
		SceneController.fadeSceneOut("/controllers/SymptomCheck.fxml", paneBackground);

	}
	
}
