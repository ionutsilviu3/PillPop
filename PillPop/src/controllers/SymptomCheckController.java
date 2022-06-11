package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class SymptomCheckController implements Initializable {

	@FXML
	private BorderPane paneBackground;
	
	@FXML
	private ImageView imageIshihara;

	@FXML
	private Button buttonCorrect, buttonWrong, buttonNone;
	
	private int correctAnswersCounter = 0;
	private int wrongAnswersCounter = 0;
	private int noneAnswersCounter = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		 changeImage(imageIshihara,"/resources/images/5_2.png");
		 

	}
	
	@FXML
	private void correctAnswer(ActionEvent event) {
		changeImage(imageIshihara,"/resources/images/74_21.png");
	}
	
	@FXML
	private void wrongAnswer(ActionEvent event) {
		changeImage(imageIshihara,"/resources/images/45_48.png");
	}
	
	@FXML
	private void noneAnswer(ActionEvent event) {
		if(noneAnswersCounter < 3) {
		noneAnswersCounter++;
		moveButtons();
		}
		else
		{
			FadeTransition ft = new FadeTransition();
			ft.setNode(paneBackground);
			ft.setDuration(Duration.millis(1000));
			ft.setFromValue(1);
			ft.setToValue(0);
			ft.setOnFinished((ActionEvent eventt) -> {
				System.out.println(1);
				SceneController.changeScene("/controllers/DiseaseResultScene.fxml");
				});
			ft.play(); 
		}
	}
	
	private void changeImage(ImageView imgView,String adress)
	{
		Image tempImg = new Image(adress);
		imgView.setImage(tempImg);
		
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
