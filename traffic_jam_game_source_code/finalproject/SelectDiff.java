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
import javafx.scene.effect.Bloom;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class SelectDiff {
	MediaPlayer mediaPlayerbgm = new MediaPlayer( new Media (new File("sound/bgm2.mp3").toURI().toString()));
	public static int stagediff = 0;
	static Stage prevStage2;

    public static void setprevStage2(Stage stage){
         prevStage2 = stage;
    }
    
    @FXML
    private ImageView bg2;
    @FXML
    private ImageView titlediff;
    @FXML
    private ImageView bt1;
    @FXML
    private ImageView bt2;
    @FXML
    private ImageView bt3;
    @FXML
    private ImageView starS1;
    @FXML
    private ImageView starS2;
    @FXML
    private ImageView starS3;
    @FXML
    private Button returnback;
    
    @FXML
    private void initialize(){
    	mediaPlayerbgm.setCycleCount(100);
		mediaPlayerbgm.setVolume(0.6);
    	mediaPlayerbgm.play();
    	bg2.setImage(ImageStore.background2);
    	titlediff.setImage(ImageStore.titledif);
    	bt1.setImage(ImageStore.button1n1);
    	bt2.setImage(ImageStore.button1n2);
    	bt3.setImage(ImageStore.button1n3);
    	returnback.setEffect(new ImageInput(ImageStore.returnb));
    	
    	if(StageD1.movediff>0 && StageD1.movediff<=20){
			starS1.setImage(ImageStore.star3);
		}
		else if(StageD1.movediff>20 && StageD1.movediff<=30){
			starS1.setImage(ImageStore.star2b);
		}
		else if(StageD1.movediff>30){
			starS1.setImage(ImageStore.star1b);
		}
    	
    	if(StageD2.movediff>0 && StageD2.movediff<=25){
			starS2.setImage(ImageStore.star3);
		}
		else if(StageD2.movediff>25 && StageD2.movediff<=40){
			starS2.setImage(ImageStore.star2b);
		}
		else if(StageD2.movediff>40){
			starS2.setImage(ImageStore.star1b);
		}
    	
    	if(StageD3.movediff>0 && StageD3.movediff<=50){
			starS3.setImage(ImageStore.star3);
		}
		else if(StageD3.movediff>50 && StageD3.movediff<=70){
			starS3.setImage(ImageStore.star2b);
		}
		else if(StageD3.movediff>70){
			starS3.setImage(ImageStore.star1b);
		}
    	
    	Bloom bloom = new Bloom();
		starS1.setEffect(bloom);
		starS2.setEffect(bloom);
		starS3.setEffect(bloom);
		
    	bt1.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				bt1.setImage(ImageStore.button2n1);
				MediaPlayer mediaPlayer = new MediaPlayer( new Media (new File("sound/se8.wav").toURI().toString()));
				if(mediaPlayer.getStatus () == MediaPlayer.Status.PLAYING) {
		    		mediaPlayer.stop();
		    		mediaPlayer.play();
		    	}
		    	mediaPlayer.play();
			}
    	});
    	bt1.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				bt1.setImage(ImageStore.button1n1);
			}
    	});
    	bt1.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				bt1.setFitWidth(95);
				bt1.setFitHeight(95);
				bt1.setTranslateX(2);
				bt1.setTranslateY(2);
			}
    	});
    	bt1.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				mediaPlayerbgm.stop();
				MediaPlayer mediaPlayerchange = new MediaPlayer( new Media (new File("sound/se34.wav").toURI().toString()));
		    	mediaPlayerchange.setCycleCount(1);
		    	mediaPlayerchange.play();
				bt1.setFitWidth(100);
				bt1.setFitHeight(100);
				bt1.setTranslateX(-1);
				bt1.setTranslateY(-1);
				stagediff=1;
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stage1.fxml"));
				StageD1 staged1 = new StageD1();
		        fxmlLoader.setController(staged1);
				Parent root = null;
				try {
					root = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
			    Scene scene = new Scene ( root, 600, 700 );
			    staged1.setScene(scene);
		        prevStage2.setScene(scene);
			}
    	});
    	
    	bt2.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				bt2.setImage(ImageStore.button2n2);
				MediaPlayer mediaPlayer = new MediaPlayer( new Media (new File("sound/se8.wav").toURI().toString()));
				if(mediaPlayer.getStatus () == MediaPlayer.Status.PLAYING) {
		    		mediaPlayer.stop();
		    		mediaPlayer.play();
		    	}
		    	mediaPlayer.play();
			}
    	});
    	bt2.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				bt2.setImage(ImageStore.button1n2);
			}
    	});
    	bt2.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				bt2.setFitWidth(95);
				bt2.setFitHeight(95);
				bt2.setTranslateX(2);
				bt2.setTranslateY(2);
			}
    	});
    	bt2.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				mediaPlayerbgm.stop();
				MediaPlayer mediaPlayerchange = new MediaPlayer( new Media (new File("sound/se34.wav").toURI().toString()));
		    	mediaPlayerchange.setCycleCount(1);
		    	mediaPlayerchange.play();
				bt2.setFitWidth(100);
				bt2.setFitHeight(100);
				bt2.setTranslateX(-1);
				bt2.setTranslateY(-1);
				stagediff=2;
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stage2.fxml"));
				StageD2 staged2 = new StageD2();
		        fxmlLoader.setController(staged2);
				Parent root = null;
				try {
					root = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
			    Scene scene = new Scene ( root, 600, 700 );
			    staged2.setScene(scene);
		        prevStage2.setScene(scene);
			}
    	});
    	
    	bt3.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				bt3.setImage(ImageStore.button2n3);
				MediaPlayer mediaPlayer = new MediaPlayer( new Media (new File("sound/se8.wav").toURI().toString()));
				if(mediaPlayer.getStatus () == MediaPlayer.Status.PLAYING) {
		    		mediaPlayer.stop();
		    		mediaPlayer.play();
		    	}
		    	mediaPlayer.play();
			}
    	});
    	bt3.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				bt3.setImage(ImageStore.button1n3);
			}
    	});
    	bt3.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				bt3.setFitWidth(95);
				bt3.setFitHeight(95);
				bt3.setTranslateX(2);
				bt3.setTranslateY(2);
			}
    	});
    	bt3.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				mediaPlayerbgm.stop();
				MediaPlayer mediaPlayerchange = new MediaPlayer( new Media (new File("sound/se34.wav").toURI().toString()));
		    	mediaPlayerchange.setCycleCount(1);
		    	mediaPlayerchange.play();
				bt3.setFitWidth(100);
				bt3.setFitHeight(100);
				bt3.setTranslateX(-1);
				bt3.setTranslateY(-1);
				stagediff=3;
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stage3.fxml"));
				StageD3 staged3 = new StageD3();
		        fxmlLoader.setController(staged3);
				Parent root = null;
				try {
					root = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
			    Scene scene = new Scene ( root, 600, 700 );
			    staged3.setScene(scene);
		        prevStage2.setScene(scene);
			}
    	});
    	returnback.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				returnback.setTranslateY(-2);
			}			
		});
    	returnback.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				returnback.setTranslateY(2);
			}
		});
    }
    
    public void handlereturn(ActionEvent event) throws IOException{
    	mediaPlayerbgm.stop();
    	MediaPlayer mediaPlayerchange = new MediaPlayer( new Media (new File("sound/se34.wav").toURI().toString()));
    	mediaPlayerchange.setCycleCount(1);
    	mediaPlayerchange.play();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("final.fxml"));
		ChangeScene changescene = new ChangeScene ();
        fxmlLoader.setController(changescene);
		Parent root = fxmlLoader.load();
	    Scene scene = new Scene ( root, 600, 700 );
        prevStage2.setScene(scene);
	}
    
}
