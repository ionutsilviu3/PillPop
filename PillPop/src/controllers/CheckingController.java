package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class CheckingController implements Initializable {

	@FXML
	private Label questionLabel;
	@FXML
	private Label knowPhaseLabel;
	@FXML
	private Button buttonMan, buttonChild, buttonWoman;
	@FXML
	private Pane backgroundPane;
	
	public char gender;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		try {
			final Font poppinsRegular = Font
					.loadFont(new FileInputStream(new File("./resources/fonts/Poppins-Regular.ttf")), 18);
			final Font poppinsMedium = Font
					.loadFont(new FileInputStream(new File("./resources/fonts/Poppins-Medium.ttf")), 30);
			knowPhaseLabel.setFont(poppinsRegular);
			questionLabel.setFont(poppinsMedium);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		questionLabel.setText("What are you ?");
	}

	@FXML
	private void man(ActionEvent event)
	{
		gender = 'm';
		buttonWoman.setDisable(true);
		buttonChild.setDisable(true);
		System.out.println("You're a man!");
		changeSceneToSymptomCheck();
	}
	
	@FXML
	private void child(ActionEvent event)
	{
		gender = 'c';
		buttonWoman.setDisable(true);
		buttonMan.setDisable(true);
		System.out.println("You're a child!");
	}
	
	@FXML
	private void woman(ActionEvent event)
	{
		gender = 'f';
		buttonMan.setDisable(true);
		buttonChild.setDisable(true);
		System.out.println("You're a woman!");
	}
	
	private void changeSceneToSymptomCheck()
	{
		FadeTransition ft = new FadeTransition();
		ft.setNode(backgroundPane);
		ft.setDuration(Duration.millis(1000));
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setOnFinished((ActionEvent eventt) -> {
			System.out.println(1);
			SceneController.changeScene("/controllers/SymptomCheckScene.fxml");
			});
		ft.play(); 
	}
	
}
