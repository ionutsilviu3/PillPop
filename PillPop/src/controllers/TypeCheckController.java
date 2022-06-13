package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import service.PatientService;

public class TypeCheckController implements Initializable {

	@FXML
	private Button buttonMan, buttonChild, buttonWoman;
	@FXML
	private Pane backgroundPane;

	private PatientService patientService;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		patientService = new PatientService();
		SceneController.fadeSceneIn(backgroundPane);
	}

	@FXML
	private void man(ActionEvent event)
	{

		buttonWoman.setDisable(true);
		buttonChild.setDisable(true);
		System.out.println("You're a man!");
		try {
			patientService.updateType("m",LoginController.loggedID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SceneController.fadeSceneOut("/controllers/SymptomCheckScene.fxml", backgroundPane);
	}
	
	@FXML
	private void child(ActionEvent event)
	{

		buttonWoman.setDisable(true);
		buttonMan.setDisable(true);
		System.out.println("You're a child!");
		try {
			patientService.updateType("c",LoginController.loggedID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SceneController.fadeSceneOut("/controllers/SymptomCheckScene.fxml", backgroundPane);

	}
	
	@FXML
	private void woman(ActionEvent event)
	{

		buttonMan.setDisable(true);
		buttonChild.setDisable(true);
		System.out.println("You're a woman!");
		try {
			patientService.updateType("w",LoginController.loggedID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SceneController.fadeSceneOut("/controllers/SymptomCheckScene.fxml", backgroundPane);
	}
	
	
}
