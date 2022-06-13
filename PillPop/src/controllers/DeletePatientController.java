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
import javafx.scene.layout.AnchorPane;
import model.Patient;
import service.PatientService;

public class DeletePatientController implements Initializable {

	@FXML
	private AnchorPane paneBackground;

	@FXML
	private ImageView imgViewExclamation;
	@FXML
	private TextField fieldUsername;
	@FXML
	private PasswordField fieldPassword;
	@FXML
	private Button buttonDelete;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		imgViewExclamation.setVisible(false);
		SceneController.fadeSceneIn(paneBackground);
	}

	@FXML
	private void goBackToLogin(ActionEvent event) {

		System.out.println("back to login");
		//SceneController.fadeSceneOut("/controllers/SignupScene.fxml", paneBackground);

	}

	@FXML
	public void deletePatient(ActionEvent event) {
		PatientService patientService = new PatientService();
		Patient p = new Patient();
		try {
			p = patientService.findPatient(fieldUsername.getText(), fieldPassword.getText());
			if (p != null) {
				imgViewExclamation.setVisible(false);
				patientService.deletePatient(p);
				SceneController.fadeSceneOut("/controllers/LoginScene.fxml", paneBackground);
			}
		} catch (Exception e) {
			imgViewExclamation.setVisible(true);
			e.printStackTrace();
		}
	}

}
