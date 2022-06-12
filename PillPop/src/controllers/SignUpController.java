package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.RegexVerification;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import model.Patient;
import service.PatientService;

public class SignUpController implements Initializable {

	@FXML
	private Button buttonSignUp;
	@FXML
	private TextField usernameField, emailField;
	@FXML
	private PasswordField passwordField;
	@FXML
	Label usernameLabel, emailLabel, passwordLabel;
	@FXML
	private BorderPane paneBackground;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		SceneController.fadeSceneIn(paneBackground);
	}


	@FXML
	private void goBackToLogin(ActionEvent event) {
		SceneController.fadeSceneOut("/controllers/LoginScene.fxml", paneBackground);
	}

	@FXML
	private void signUp(ActionEvent event) {
		System.out.println(RegexVerification.validateUsername(usernameField.getText()));
		System.out.println(RegexVerification.validateEmail(emailField.getText()));
		System.out.println(RegexVerification.validatePassword(passwordField.getText()));
		if (RegexVerification.validateUsername(usernameField.getText()) == RegexVerification.state.VALID)
			if (RegexVerification.validateEmail(emailField.getText()) == RegexVerification.state.VALID)

			{
				PatientService patientService = new PatientService();
				Patient patient = new Patient();
				patient.setPatientName(usernameField.getText());
				patient.setEmail(emailField.getText());
				patient.setPassword(passwordField.getText());
				patientService.addPatient(patient);

				SceneController.fadeSceneOut("/controllers/TypeCheckScene.fxml", paneBackground);
				System.out.println("Signed up!");
			}

	}

}
