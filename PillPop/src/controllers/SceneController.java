package controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneController {
	private static Stage stage;
	public static void setStage(Stage stage)
	{
		SceneController.stage = stage;
	}
	public static void changeScene(String fxml)
	{
		Parent root = null;
		try {
			root = FXMLLoader.load(SceneController.class.getResource(fxml));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stage.getScene().setRoot(root);
	}
	
}
