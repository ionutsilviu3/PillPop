package controllers;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.Ishiharaplate;
import service.IshiharaPlateService;

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
	private int answeredCounter = 0;

	private Random rand = new Random();

	private IshiharaPlateService ishiharaPlateService;
	List<Ishiharaplate> allishiharaPlates;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		SceneController.fadeSceneIn(paneBackground);

		ishiharaPlateService = new IshiharaPlateService();
		allishiharaPlates = ishiharaPlateService.getAllIshiharaPlates();
		Collections.shuffle(allishiharaPlates);
		for (Ishiharaplate plate : allishiharaPlates) {
			System.out.println(plate.getCorrectAns() + " - " + plate.getWrongAns());
		}

	}

	@FXML
	private void correctAnswer(ActionEvent event) {
		correctAnswersCounter++;
		System.out.println("Correct: "+ correctAnswersCounter);
		changePlate();
	}

	@FXML
	private void wrongAnswer(ActionEvent event) {
		if (wrongAnswersCounter < 7 && correctAnswersCounter >= 0) {
			wrongAnswersCounter++;
			System.out.println("Wrong: "+ wrongAnswersCounter);
			changePlate();
		} else if (wrongAnswersCounter > 7 && correctAnswersCounter > 0) {
			SceneController.fadeSceneOut("/controllers/DiseaseResultScene.fxml", paneBackground);
			System.out.println("u kinda colorblind bro");
		} else if (wrongAnswersCounter > 7 && correctAnswersCounter < 0) {
			SceneController.fadeSceneOut("/controllers/DiseaseResultScene.fxml", paneBackground);
			System.out.println("u colorblind colorblind");
		}

	}

	@FXML
	private void noneAnswer(ActionEvent event) {
		if (noneAnswersCounter < 3) {
			noneAnswersCounter++;
			System.out.println("None: "+ noneAnswersCounter);
			changePlate();
			}
		 else {
			SceneController.fadeSceneOut("/controllers/DiseaseResultScene.fxml", paneBackground);
			System.out.println("u colorblind colorblind");
		}
	}

	private void changePlate() {

		if (answeredCounter < allishiharaPlates.size()) {
			
			int correct = allishiharaPlates.get(answeredCounter).getCorrectAns();
			int wrong = allishiharaPlates.get(answeredCounter).getWrongAns();
			Image tempImg = new Image("/resources/images/"+correct + "_" + wrong + ".png");
			imageIshihara.setImage(tempImg);

			buttonCorrect.setText(((Integer) correct).toString());
			buttonWrong.setText(((Integer) wrong).toString());

			int random = rand.nextInt(allishiharaPlates.size());
			if (random % 2 == 0)
				moveButtons();
			
			answeredCounter++;
		} else
			SceneController.fadeSceneOut("/controllers/DiseaseResultScene.fxml", paneBackground);
	}

	private void moveButtons() {
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
