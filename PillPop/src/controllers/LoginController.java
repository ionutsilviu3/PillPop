package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.Patient;
import service.PatientService;

public class LoginController implements Initializable {

	@FXML
	private Button buttonLogin, buttonSignUp;

	@FXML
	private TextField fieldUsername;
	@FXML
	private PasswordField fieldPassword;

	@FXML
	private BorderPane paneBackground;

	@FXML
	private ImageView imgViewExclamation;
	
	public static int loggedID;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		imgViewExclamation.setVisible(false);
		SceneController.fadeSceneIn(paneBackground);
	}

	@FXML
	private void login(ActionEvent event) {

		PatientService patientService = new PatientService();
		Patient p = new Patient();

		try {
			p = patientService.findPatient(fieldUsername.getText(), fieldPassword.getText());
			if (p != null) {
				loggedID = p.getPatientID();
				imgViewExclamation.setVisible(false);
				SceneController.fadeSceneOut("/controllers/SymptomCheckScene.fxml", paneBackground);
				System.out.println("Logging in..");

			}
		} catch (Exception e) {
			imgViewExclamation.setVisible(true);
			e.printStackTrace();
		}

	}

	@FXML
	private void signUp(ActionEvent event) {

		SceneController.fadeSceneOut("/controllers/SignUpScene.fxml", paneBackground);
	}
}
