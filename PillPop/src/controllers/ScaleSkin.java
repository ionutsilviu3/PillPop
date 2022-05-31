package controllers;

import com.sun.javafx.scene.control.skin.ButtonSkin;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;

@SuppressWarnings("restriction")
public class ScaleSkin extends ButtonSkin {

	public ScaleSkin(Button b) {
		super(b);

		final ScaleTransition stUp = new ScaleTransition(Duration.millis(100));
		stUp.setInterpolator(Interpolator.LINEAR);
		stUp.setNode(b);
		stUp.setFromX(1);
		stUp.setFromY(1);
		stUp.setToX(1.1);
		stUp.setToY(1.1);

		b.setOnMouseEntered(e -> stUp.playFromStart());

		final ScaleTransition stDown = new ScaleTransition(Duration.millis(100));
		stDown.setInterpolator(Interpolator.LINEAR);
		stDown.setNode(b);
		stDown.setFromX(1.1);
		stDown.setFromY(1.1);
		stDown.setToX(1);
		stDown.setToY(1);
		b.setOnMouseExited(e -> stDown.playFromStart());
	}
}
