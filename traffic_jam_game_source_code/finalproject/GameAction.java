package finalproject;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.effect.Bloom;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class GameAction {
	
	public static void pressActionTrue(ImageView car,FadeTransition fade){
		Bloom bloom = new Bloom();
		car.setEffect(bloom);
		fade.setFromValue(1.0);
        fade.setToValue(0.5);
        fade.setFromValue(0.5);
        fade.setToValue(1.0);
        fade.setCycleCount(Timeline.INDEFINITE);
        fade.play();
	}
	public static void pressActionFalse(ImageView car,FadeTransition fade){
		car.setEffect(null);
		PauseTransition pause = new PauseTransition(Duration.seconds(0));
		SequentialTransition seq = new SequentialTransition(fade, pause);
		fade.setFromValue(1.0);
        fade.setToValue(1.0);
		seq.setCycleCount(Timeline.INDEFINITE);
		seq.play();
	}
}
