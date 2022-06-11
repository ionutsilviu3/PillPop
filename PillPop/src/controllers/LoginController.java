package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
			

	}

	@FXML
	private void login(ActionEvent event) {
		
		PatientService patientService = new PatientService();
		
		
		try {
			if(patientService.findPatient(fieldUsername.getText(), fieldPassword.getText()) != null)
			{
			FadeTransition ft = new FadeTransition();
			ft.setNode(paneBackground);
			ft.setDuration(Duration.millis(1000));
			ft.setFromValue(1);
			ft.setToValue(0);
			ft.setOnFinished((ActionEvent eventt) -> {
				System.out.println(1);
				SceneController.changeScene("/controllers/SymptomCheckScene.fxml");
			});
			ft.play();
			System.out.println("Logging in..");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@FXML
	private void signUp(ActionEvent event) {
		
		FadeTransition ft = new FadeTransition();
		ft.setNode(paneBackground);
		ft.setDuration(Duration.millis(1000));
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setOnFinished((ActionEvent eventt) -> {
			System.out.println(1);
			SceneController.changeScene("/controllers/SignUpScene.fxml");
		});
		ft.play();
	}
}
