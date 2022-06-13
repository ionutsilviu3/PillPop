package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.RegexVerification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
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
	private ImageView imgViewUserExclamation, imgViewEmailExclamation, imgViewPasswordExclamation;
	@FXML
	Label usernameLabel, emailLabel, passwordLabel;
	@FXML
	private BorderPane paneBackground;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		imgViewUserExclamation.setVisible(false);
		imgViewEmailExclamation.setVisible(false);
		imgViewPasswordExclamation.setVisible(false);
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
		if (RegexVerification.validateUsername(usernameField.getText()) == RegexVerification.state.VALID
			
			&& RegexVerification.validateEmail(emailField.getText()) == RegexVerification.state.VALID
				
				&& RegexVerification.validatePassword(passwordField.getText()) == RegexVerification.state.VALID) {
					
					PatientService patientService = new PatientService();
					Patient patient = new Patient();
					patient.setPatientName(usernameField.getText());
					patient.setEmail(emailField.getText());
					patient.setPassword(passwordField.getText());
					patientService.addPatient(patient);

					SceneController.fadeSceneOut("/controllers/TypeCheckScene.fxml", paneBackground);
					System.out.println("Signed up!");
				} 
		if(RegexVerification.validateUsername(usernameField.getText()) != RegexVerification.state.VALID)
			imgViewUserExclamation.setVisible(true);
		else
			imgViewUserExclamation.setVisible(false);
		if(RegexVerification.validateEmail(emailField.getText()) != RegexVerification.state.VALID)
			imgViewEmailExclamation.setVisible(true);
		else
			imgViewEmailExclamation.setVisible(false);
		if(RegexVerification.validatePassword(passwordField.getText()) != RegexVerification.state.VALID)
			imgViewPasswordExclamation.setVisible(true);
		else
			imgViewPasswordExclamation.setVisible(false);
	}

}
