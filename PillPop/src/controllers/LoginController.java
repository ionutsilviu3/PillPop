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
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import model.Patient;
import service.PatientService;

public class LoginController implements Initializable {

	@FXML
	private Button buttonLogin, buttonSignUp;
	
	@FXML
	private BorderPane paneBackground;
	
	@FXML
	public ListView<Patient> patientListView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
			

	}

	@FXML
	private void login(ActionEvent event) {
		
		PatientService patientService = new PatientService();
		List<Patient> allPatients = patientService.getAllPatients();

		System.out.println(allPatients);
		patientListView.setItems(FXCollections.observableArrayList(new ArrayList<Patient>(allPatients)));
		
		try {
			System.out.println(patientService.findPatient("test", "1234").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
