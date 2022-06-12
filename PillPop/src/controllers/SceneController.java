package controllers;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.util.Duration;

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
	
	public static void fadeSceneOut(String fxml, Node node)
	{
		FadeTransition ft = new FadeTransition();
		ft.setNode(node);
		ft.setDuration(Duration.millis(1000));
		ft.setInterpolator(Interpolator.EASE_OUT);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setOnFinished((ActionEvent eventt) -> {
			node.setVisible(false);
			SceneController.changeScene(fxml);
		});
		ft.play();
	}
	
	public static void fadeSceneIn(Node node)
	{
		node.setVisible(false);
		FadeTransition qft = new FadeTransition();
		qft.setNode(node);
		qft.setDuration(Duration.millis(1000));
		qft.setFromValue(0);
		qft.setToValue(0.1);
		FadeTransition ft = new FadeTransition();
		ft.setNode(node);
		ft.setDuration(Duration.millis(1000));
		ft.setFromValue(0.1);
		ft.setToValue(1);
		ft.setInterpolator(Interpolator.EASE_IN);
		qft.setOnFinished((ActionEvent ev) ->
		{
			node.setVisible(true);
			ft.play();
		});
		qft.play();
	}
	
}
