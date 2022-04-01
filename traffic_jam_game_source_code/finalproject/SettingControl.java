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
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SettingControl {
	
	static Stage GameplayStage;
    public static void setgameplayStage(Stage stage){
    	GameplayStage = stage;
    }
	
	@FXML
    private ImageView settingbg;
	@FXML
	private Button selstage;
	@FXML
	private Button prestage;
	@FXML
	private Button nexstage;
	@FXML
	private Button goback;
	
	@FXML
	private void initialize(){
		MediaPlayer mediaPlayer = new MediaPlayer( new Media (new File("sound/se36.wav").toURI().toString()));
		if(mediaPlayer.getStatus () == MediaPlayer.Status.PLAYING) {
    		mediaPlayer.stop();
    		mediaPlayer.play();
    	}
    	mediaPlayer.play();
		settingbg.setImage(ImageStore.settingbg);
    	selstage.setEffect(new ImageInput(ImageStore.set1));
    	prestage.setEffect(new ImageInput(ImageStore.set2));
    	nexstage.setEffect(new ImageInput(ImageStore.set3));
    	goback.setEffect(new ImageInput(ImageStore.set4));
    	
    	selstage.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				selstage.setEffect(new ImageInput(ImageStore.set1b));
				MediaPlayer mediaPlayer = new MediaPlayer( new Media (new File("sound/se4.wav").toURI().toString()));
				if(mediaPlayer.getStatus () == MediaPlayer.Status.PLAYING) {
		    		mediaPlayer.stop();
		    		mediaPlayer.play();
		    	}
		    	mediaPlayer.play();
			}			
		});
    	selstage.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				selstage.setEffect(new ImageInput(ImageStore.set1));
			}			
		});
    	
    	prestage.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				prestage.setEffect(new ImageInput(ImageStore.set2b));
				MediaPlayer mediaPlayer = new MediaPlayer( new Media (new File("sound/se4.wav").toURI().toString()));
				if(mediaPlayer.getStatus () == MediaPlayer.Status.PLAYING) {
		    		mediaPlayer.stop();
		    		mediaPlayer.play();
		    	}
		    	mediaPlayer.play();
			}			
		});
    	prestage.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				prestage.setEffect(new ImageInput(ImageStore.set2));
			}			
		});
    	
    	nexstage.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				nexstage.setEffect(new ImageInput(ImageStore.set3b));
				MediaPlayer mediaPlayer = new MediaPlayer( new Media (new File("sound/se4.wav").toURI().toString()));
				if(mediaPlayer.getStatus () == MediaPlayer.Status.PLAYING) {
		    		mediaPlayer.stop();
		    		mediaPlayer.play();
		    	}
		    	mediaPlayer.play();
			}			
		});
    	nexstage.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				nexstage.setEffect(new ImageInput(ImageStore.set3));
			}			
		});
    	
    	goback.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				goback.setEffect(new ImageInput(ImageStore.set4b));
				MediaPlayer mediaPlayer = new MediaPlayer( new Media (new File("sound/se4.wav").toURI().toString()));
				if(mediaPlayer.getStatus () == MediaPlayer.Status.PLAYING) {
		    		mediaPlayer.stop();
		    		mediaPlayer.play();
		    	}
		    	mediaPlayer.play();
			}			
		});
    	goback.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				goback.setEffect(new ImageInput(ImageStore.set4));
			}			
		});
	}
	
	public void handlegodiff(ActionEvent event) throws IOException{
		MediaPlayer mediaPlayerchange = new MediaPlayer( new Media (new File("sound/se34.wav").toURI().toString()));
    	mediaPlayerchange.setCycleCount(1);
    	mediaPlayerchange.play();
    	StageD1.bgm.stop();
    	StageD2.bgm.stop();
    	StageD3.bgm.stop();
		Stage settingstage = (Stage) selstage.getScene().getWindow();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("diff.fxml"));
		SelectDiff selectdiff = new SelectDiff();
		fxmlLoader.setController(selectdiff);
	    Parent root = fxmlLoader.load();
	    Scene scene = new Scene ( root, 600, 700 );
        GameplayStage.setScene(scene);
        settingstage.close();
	}
	public void handleprestage(ActionEvent event) throws IOException{
		MediaPlayer mediaPlayerchange = new MediaPlayer( new Media (new File("sound/se34.wav").toURI().toString()));
    	mediaPlayerchange.setCycleCount(1);
    	mediaPlayerchange.play();
		Stage settingstage = (Stage) selstage.getScene().getWindow();
		if(SelectDiff.stagediff==1){
			Stage notic =new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("little.fxml"));
			LittleWindow littlewindow = new LittleWindow();
	        fxmlLoader.setController(littlewindow);
			Parent root = fxmlLoader.load();
		    Scene scene = new Scene ( root, 250, 200 );
		    notic.setTitle("Notice");
		    notic.setScene(scene);
		    notic.initModality(Modality.APPLICATION_MODAL);
		    notic.initOwner(prestage.getScene().getWindow());
		    notic.showAndWait();
		}
		else if(SelectDiff.stagediff==2){
			StageD2.bgm.stop();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stage1.fxml"));
			StageD1 staged1 = new StageD1();
	        fxmlLoader.setController(staged1);
		    Parent root = fxmlLoader.load();
		    Scene scene = new Scene ( root, 600, 700 );
		    staged1.setScene(scene);
	        GameplayStage.setScene(scene);
	        SelectDiff.stagediff=1;
	        settingstage.close();
		}
		else if(SelectDiff.stagediff==3){
			StageD3.bgm.stop();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stage2.fxml"));
			StageD2 staged2 = new StageD2();
	        fxmlLoader.setController(staged2);
		    Parent root = fxmlLoader.load();
		    Scene scene = new Scene ( root, 600, 700 );
		    staged2.setScene(scene);
	        GameplayStage.setScene(scene);
	        SelectDiff.stagediff=2;
	        settingstage.close();
		}
	}
	public void handlenexstage(ActionEvent event) throws IOException{
		MediaPlayer mediaPlayerchange = new MediaPlayer( new Media (new File("sound/se34.wav").toURI().toString()));
    	mediaPlayerchange.setCycleCount(1);
    	mediaPlayerchange.play();
		Stage settingstage = (Stage) selstage.getScene().getWindow();
		if(SelectDiff.stagediff==1){
			StageD1.bgm.stop();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stage2.fxml"));
			StageD2 staged2 = new StageD2();
	        fxmlLoader.setController(staged2);
		    Parent root = fxmlLoader.load();
		    Scene scene = new Scene ( root, 600, 700 );
		    staged2.setScene(scene);
	        GameplayStage.setScene(scene);
	        SelectDiff.stagediff=2;
	        settingstage.close();
		}
		else if(SelectDiff.stagediff==2){
			StageD2.bgm.stop();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stage3.fxml"));
			StageD3 staged3 = new StageD3();
	        fxmlLoader.setController(staged3);
		    Parent root = fxmlLoader.load();
		    Scene scene = new Scene ( root, 600, 700 );
		    staged3.setScene(scene);
	        GameplayStage.setScene(scene);
	        SelectDiff.stagediff=3;
	        settingstage.close();
		}
		else if(SelectDiff.stagediff==3){
			Stage notic =new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("little.fxml"));
			LittleWindow littlewindow = new LittleWindow();
	        fxmlLoader.setController(littlewindow);
			Parent root = fxmlLoader.load();
		    Scene scene = new Scene ( root, 250, 200 );
		    notic.setTitle("Notice");
		    notic.setScene(scene);
		    notic.initModality(Modality.APPLICATION_MODAL);
		    notic.initOwner(prestage.getScene().getWindow());
		    notic.showAndWait();
		}
	}
	public void handlegoback(ActionEvent event) throws IOException{
		MediaPlayer mediaPlayerchange = new MediaPlayer( new Media (new File("sound/se34.wav").toURI().toString()));
    	mediaPlayerchange.setCycleCount(1);
    	mediaPlayerchange.play();
    	if(SelectDiff.stagediff==1){
    		StageD1.bgm.play();
    	}
    	else if(SelectDiff.stagediff==2){
    		StageD2.bgm.play();
    	}
    	else if(SelectDiff.stagediff==3){
    		StageD3.bgm.play();
    	}
    	Stage settingstage = (Stage) goback.getScene().getWindow();
        settingstage.close();
	}
}
