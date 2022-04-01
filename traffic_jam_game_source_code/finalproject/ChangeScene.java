package finalproject;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ChangeScene {
	MediaPlayer mediaPlayerbg = new MediaPlayer( new Media (new File("sound/bgm1.mp3").toURI().toString()));
	static Stage prevStage;

    public static void setprevStage(Stage stage){
         prevStage = stage;
    }
	
	@FXML
	private ImageView bg;
	@FXML
	private ImageView theme;
	@FXML
	private Button startbutton;
	@FXML
	private Button exitbutton;
	
	@FXML
	private void initialize(){
		mediaPlayerbg.setCycleCount(100);
		mediaPlayerbg.setVolume(0.2);
		mediaPlayerbg.play();
		bg.setImage(ImageStore.background);
		theme.setImage(ImageStore.themepic);
		
		startbutton.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				startbutton.setStyle("-fx-color: #00ff15");	
				startbutton.setPrefSize(210, 55);
				startbutton.setTranslateX(-2);
				startbutton.setTranslateY(-2);
				MediaPlayer mediaPlayer = new MediaPlayer( new Media (new File("sound/se17.wav").toURI().toString()));
				if(mediaPlayer.getStatus () == MediaPlayer.Status.PLAYING) {
		    		mediaPlayer.stop();
		    		mediaPlayer.play();
		    	}
		    	mediaPlayer.play();
			}			
		});
		startbutton.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				startbutton.setStyle("-fx-color: #e7e7e7");
				startbutton.setPrefSize(200, 50);
				startbutton.setTranslateX(2);
				startbutton.setTranslateY(2);
			}
		});
		exitbutton.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				exitbutton.setStyle("-fx-color: #00ff15");
				exitbutton.setPrefSize(210, 55);
				exitbutton.setTranslateX(-2);
				exitbutton.setTranslateY(-2);
				MediaPlayer mediaPlayer = new MediaPlayer( new Media (new File("sound/se17.wav").toURI().toString()));
				if(mediaPlayer.getStatus () == MediaPlayer.Status.PLAYING) {
		    		mediaPlayer.stop();
		    		mediaPlayer.play();
		    	}
		    	mediaPlayer.play();
			}			
		});
		exitbutton.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				exitbutton.setStyle("-fx-color: #e7e7e7");
				exitbutton.setPrefSize(200, 50);
				exitbutton.setTranslateX(2);
				exitbutton.setTranslateY(2);
			}
		});
	}
	
	public void handleStart(ActionEvent event) throws IOException{
		mediaPlayerbg.stop();
		MediaPlayer mediaPlayerchange = new MediaPlayer( new Media (new File("sound/se34.wav").toURI().toString()));
    	mediaPlayerchange.setCycleCount(1);
    	mediaPlayerchange.play();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("diff.fxml"));
		SelectDiff selectdiff = new SelectDiff();
		fxmlLoader.setController(selectdiff);
	    Parent root = fxmlLoader.load();
	    Scene scene = new Scene ( root, 600, 700 );
        prevStage.setScene(scene);
	}
	
	public void handleExit(ActionEvent event) throws IOException{
		prevStage.close();
	}
	
}
