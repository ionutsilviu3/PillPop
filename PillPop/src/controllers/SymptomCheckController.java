package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class SymptomCheckController implements Initializable {

	@FXML
	private BorderPane paneBackground;

	@FXML
	private Button buttonCorrect, buttonWrong, buttonNone;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		
		 
		 

	}
	
	@FXML
	private void correctAnswer(ActionEvent event) {
	
	}
	
	@FXML
	private void wrongAnswer(ActionEvent event) {
	
	}
	
	@FXML
	private void noneAnswer(ActionEvent event) {
		moveButtons();
	}
	
	private void moveButtons()
	{
		double xc = buttonCorrect.getLayoutX();
		double yc = buttonCorrect.getLayoutY();
		
		double xw = buttonWrong.getLayoutX();
		double yw = buttonWrong.getLayoutY();
		
		buttonCorrect.setLayoutX(xw);
		buttonCorrect.setLayoutY(yw);
		
		buttonWrong.setLayoutX(xc);
		buttonWrong.setLayoutY(yc);
	}
}
