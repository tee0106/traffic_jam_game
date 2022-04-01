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
import javafx.scene.control.Label;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class LittleWindow {
	static Stage GameplayStageLW;
    public static void setgameplayStageLW(Stage stage){
    	GameplayStageLW = stage;
    }
    
	@FXML
	private Button okbutton;
	@FXML
	private Label label1;
	@FXML
	private Label label2;
	@FXML
	private ImageView star;
	
	@FXML
	private void initialize(){
		if(SelectDiff.stagediff==1 && StageD1.win==0){
			label1.setText("這是第一關");
			label2.setText("沒有再上一關了");
		}
		else if( (SelectDiff.stagediff==1 && StageD1.win==1) || (SelectDiff.stagediff==2 && StageD2.win==1) || (SelectDiff.stagediff==3 && StageD3.win==1)){
			MediaPlayer winbgm = new MediaPlayer( new Media (new File("sound/Victory.mp3").toURI().toString()));
			winbgm.setVolume(0.8);
	    	winbgm.setCycleCount(1);
	    	winbgm.play();
			label1.setText("CLEAR !");
			if(SelectDiff.stagediff==1){
				label2.setText("move: " + StageD1.move);
				if(StageD1.move>=0 && StageD1.move<=20){
					star.setImage(ImageStore.star3);
				}
				else if(StageD1.move>20 && StageD1.move<=30){
					star.setImage(ImageStore.star2);
				}
				else if(StageD1.move>30){
					star.setImage(ImageStore.star1);
				}
			}
			else if(SelectDiff.stagediff==2){
				label2.setText("move: " + StageD2.move);
				if(StageD2.move>=0 && StageD2.move<=25){
					star.setImage(ImageStore.star3);
				}
				else if(StageD2.move>25 && StageD2.move<=40){
					star.setImage(ImageStore.star2);
				}
				else if(StageD2.move>40){
					star.setImage(ImageStore.star1);
				}
			}
			else if(SelectDiff.stagediff==3){
				label2.setText("move: " + StageD3.move);
				if(StageD3.move>=0 && StageD3.move<=50){
					star.setImage(ImageStore.star3);
				}
				else if(StageD3.move>50 && StageD3.move<=70){
					star.setImage(ImageStore.star2);
				}
				else if(StageD3.move>70){
					star.setImage(ImageStore.star1);
				}
			}
		}
		else if(SelectDiff.stagediff==3 && StageD3.win==0){
			label1.setText("這是最後一關");
			label2.setText("沒有再下一關了");
		}
	}
	
	public void handleok(ActionEvent event) throws IOException{
		if( StageD1.win==1 || StageD2.win==1 || StageD3.win==1){
			MediaPlayer mediaPlayerchange = new MediaPlayer( new Media (new File("sound/se34.wav").toURI().toString()));
	    	mediaPlayerchange.setCycleCount(1);
	    	mediaPlayerchange.play();
	    	StageD1.bgm.stop();
	    	StageD2.bgm.stop();
	    	StageD3.bgm.stop();
	    	StageD1.win=0;
	    	StageD2.win=0;
	    	StageD3.win=0;
	    	Stage littlewindow = (Stage) okbutton.getScene().getWindow();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("diff.fxml"));
			SelectDiff selectdiff = new SelectDiff();
			fxmlLoader.setController(selectdiff);
		    Parent root = fxmlLoader.load();
		    Scene scene = new Scene ( root, 600, 700 );
	        GameplayStageLW.setScene(scene);
			littlewindow.close();
		}
		else{
			Stage littlewindow = (Stage) okbutton.getScene().getWindow();
			littlewindow.close();
		}
	}
}
