package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.RegexVerification;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class SignUpController implements Initializable {

	@FXML
	private Button buttonSignUp;
	@FXML
	private TextField usernameField, emailField;
	@FXML
	private PasswordField passwordField;
	@FXML Label usernameLabel, emailLabel, passwordLabel;
	@FXML
	private BorderPane paneBackground;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void signUp(ActionEvent event) {
		System.out.println(RegexVerification.validateUsername(usernameField.getText()));
		System.out.println(RegexVerification.validateEmail(emailField.getText()));
		System.out.println(RegexVerification.validatePassword(passwordField.getText()));
		if(RegexVerification.validateUsername(usernameField.getText()) == RegexVerification.state.VALID)
			if(RegexVerification.validateEmail(emailField.getText()) == RegexVerification.state.VALID)
					
		{
		FadeTransition ft = new FadeTransition();
		  ft.setNode(paneBackground); ft.setDuration(Duration.millis(1000));
		  ft.setFromValue(1); ft.setToValue(0); ft.setOnFinished((ActionEvent eventt)
		  -> { System.out.println(1);
		  SceneController.changeScene("/controllers/CheckingScene.fxml"); });
		  ft.play();
		  System.out.println("Signed up!");
		}
		
	}

	
}
