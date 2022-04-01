package finalproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StageD3 {
	public static MediaPlayer bgm = new MediaPlayer( new Media (new File("sound/Swordland.mp3").toURI().toString()));
	boolean CarEffectH[] = new boolean[6];
	boolean CarEffectV[] = new boolean[6];
	public static int win=0;
	int CarSelect = 0;
	int moved = 0;
	public static int move = 0;
	public static int movediff = 0;
	private AnimationTimer Animation;
    private double SpeedX = 0 ; 
    private double SpeedY = 0 ;
    private long lastUpdateTime = 0;
    private double XX = 0;
	private double YY = 0;
	private ArrayList<ImageView> Object = new ArrayList<>();
	static Stage StageD;
    public static void setprevStageD(Stage stage){
         StageD = stage;
    }
    
    @FXML
    private ImageView redcar;
    @FXML
    private ImageView shorth1;
    @FXML
    private ImageView shorth2;
    @FXML
    private ImageView shorth3;
    @FXML
    private ImageView shorth4;
    @FXML
    private ImageView shortv1;
    @FXML
    private ImageView shortv2;
    @FXML
    private ImageView shortv3;
    @FXML
    private ImageView shortv4;
    @FXML
    private ImageView longv1;
    @FXML
    private ImageView longv2;
    @FXML
    private ImageView longh1;
    @FXML
    private ImageView wallL;
    @FXML
    private ImageView wallR;
    @FXML
    private ImageView wallU;
    @FXML
    private ImageView wallD;
    @FXML
    private ImageView refresh;
    @FXML
    private ImageView gamebg;
    @FXML
    private Button setting;
    @FXML
    private Label moves;
    
    @FXML
    private void initialize(){
    	bgm.setCycleCount(100);
    	bgm.setVolume(0.5);
    	bgm.play();
    	redcar.setImage(ImageStore.redcar);
    	longh1.setImage(ImageStore.longh2);
    	shorth1.setImage(ImageStore.shorth4);
    	shorth2.setImage(ImageStore.shorth1);
    	shorth3.setImage(ImageStore.shorth3);
    	shorth4.setImage(ImageStore.shorth2);
    	longv1.setImage(ImageStore.longv2);
    	longv2.setImage(ImageStore.longv1);
    	shortv1.setImage(ImageStore.shortv4);
    	shortv2.setImage(ImageStore.shortv3);
    	shortv3.setImage(ImageStore.shortv1);
    	shortv4.setImage(ImageStore.shortv2);
    	gamebg.setImage(ImageStore.gamebg3);
    	wallL.setImage(ImageStore.wallL);
    	wallR.setImage(ImageStore.wallR);
    	wallU.setImage(ImageStore.wallU);
    	wallD.setImage(ImageStore.wallD);
    	refresh.setImage(ImageStore.refresh);
    	setting.setEffect(new ImageInput(ImageStore.setting));
    	move=0;
    	moves.setText("move: " + move +"	Best move: " + movediff);
    	
    	Object.add(redcar);
    	Object.add(longh1);
    	Object.add(shorth1);
    	Object.add(shorth2);
    	Object.add(shorth3);
    	Object.add(shorth4);
    	Object.add(longv1);
    	Object.add(longv2);
    	Object.add(shortv1);
    	Object.add(shortv2);
    	Object.add(shortv3);
    	Object.add(shortv4);
    	Object.add(wallL);
    	Object.add(wallR);
    	Object.add(wallU);
    	Object.add(wallD);
    	
    	for(int i=0; i<6; i++){
    		CarEffectH[i]=true;
    		CarEffectV[i]=true;
    	}
    	
    	redcar.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				FadeTransition fade = new FadeTransition(Duration.millis(1000),redcar);
				if(CarEffectH[0]==true && CarSelect==0){
					GameAction.pressActionTrue(redcar, fade);
					CarEffectH[0]=!CarEffectH[0];
					CarSelect=1;
				}
				else if(CarEffectH[0]==false && CarSelect==1){
					GameAction.pressActionFalse(redcar, fade);
					CarEffectH[0]=!CarEffectH[0];
					CarSelect=0;
					if(moved==1){move++; moved=0;}
				}
			}
    	});
    	longh1.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				FadeTransition fade = new FadeTransition(Duration.millis(1000),longh1);
				if(CarEffectH[1]==true && CarSelect==0){
					GameAction.pressActionTrue(longh1, fade);
					CarEffectH[1]=!CarEffectH[1];
					CarSelect=1;
				}
				else if(CarEffectH[1]==false && CarSelect==1){
					GameAction.pressActionFalse(longh1, fade);
					CarEffectH[1]=!CarEffectH[1];
					CarSelect=0;
					if(moved==1){move++; moved=0;}
				}
			}
    	});
    	shorth1.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				FadeTransition fade = new FadeTransition(Duration.millis(1000),shorth1);
				if(CarEffectH[2]==true && CarSelect==0){
					GameAction.pressActionTrue(shorth1, fade);
					CarEffectH[2]=!CarEffectH[2];
					CarSelect=1;
				}
				else if(CarEffectH[2]==false && CarSelect==1){
					GameAction.pressActionFalse(shorth1, fade);
					CarEffectH[2]=!CarEffectH[2];
					CarSelect=0;
					if(moved==1){move++; moved=0;}
				}
			}
    	});
    	shorth2.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				FadeTransition fade = new FadeTransition(Duration.millis(1000),shorth2);
				if(CarEffectH[3]==true && CarSelect==0){
					GameAction.pressActionTrue(shorth2, fade);
					CarEffectH[3]=!CarEffectH[3];
					CarSelect=1;
				}
				else if(CarEffectH[3]==false && CarSelect==1){
					GameAction.pressActionFalse(shorth2, fade);
					CarEffectH[3]=!CarEffectH[3];
					CarSelect=0;
					if(moved==1){move++; moved=0;}
				}
			}
    	});
    	shorth3.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				FadeTransition fade = new FadeTransition(Duration.millis(1000),shorth3);
				if(CarEffectH[4]==true && CarSelect==0){
					GameAction.pressActionTrue(shorth3, fade);
					CarEffectH[4]=!CarEffectH[4];
					CarSelect=1;
				}
				else if(CarEffectH[4]==false && CarSelect==1){
					GameAction.pressActionFalse(shorth3, fade);
					CarEffectH[4]=!CarEffectH[4];
					CarSelect=0;
					if(moved==1){move++; moved=0;}
				}
			}
    	});
    	shorth4.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				FadeTransition fade = new FadeTransition(Duration.millis(1000),shorth4);
				if(CarEffectH[5]==true && CarSelect==0){
					GameAction.pressActionTrue(shorth4, fade);
					CarEffectH[5]=!CarEffectH[5];
					CarSelect=1;
				}
				else if(CarEffectH[5]==false && CarSelect==1){
					GameAction.pressActionFalse(shorth4, fade);
					CarEffectH[5]=!CarEffectH[5];
					CarSelect=0;
					if(moved==1){move++; moved=0;}
				}
			}
    	});
    	longv1.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				FadeTransition fade = new FadeTransition(Duration.millis(1000),longv1);
				if(CarEffectV[0]==true && CarSelect==0){
					GameAction.pressActionTrue(longv1, fade);
					CarEffectV[0]=!CarEffectV[0];
					CarSelect=1;
				}
				else if(CarEffectV[0]==false && CarSelect==1){
					GameAction.pressActionFalse(longv1, fade);
					CarEffectV[0]=!CarEffectV[0];
					CarSelect=0;
					if(moved==1){move++; moved=0;}
				}
			}
    	});
    	longv2.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				FadeTransition fade = new FadeTransition(Duration.millis(1000),longv2);
				if(CarEffectV[1]==true && CarSelect==0){
					GameAction.pressActionTrue(longv2, fade);
					CarEffectV[1]=!CarEffectV[1];
					CarSelect=1;
				}
				else if(CarEffectV[1]==false && CarSelect==1){
					GameAction.pressActionFalse(longv2, fade);
					CarEffectV[1]=!CarEffectV[1];
					CarSelect=0;
					if(moved==1){move++; moved=0;}
				}
			}
    	});
    	shortv1.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				FadeTransition fade = new FadeTransition(Duration.millis(1000),shortv1);
				if(CarEffectV[2]==true && CarSelect==0){
					GameAction.pressActionTrue(shortv1, fade);
					CarEffectV[2]=!CarEffectV[2];
					CarSelect=1;
				}
				else if(CarEffectV[2]==false && CarSelect==1){
					GameAction.pressActionFalse(shortv1, fade);
					CarEffectV[2]=!CarEffectV[2];
					CarSelect=0;
					if(moved==1){move++; moved=0;}
				}
			}
    	});
    	shortv2.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				FadeTransition fade = new FadeTransition(Duration.millis(1000),shortv2);
				if(CarEffectV[3]==true && CarSelect==0){
					GameAction.pressActionTrue(shortv2, fade);
					CarEffectV[3]=!CarEffectV[3];
					CarSelect=1;
				}
				else if(CarEffectV[3]==false && CarSelect==1){
					GameAction.pressActionFalse(shortv2, fade);
					CarEffectV[3]=!CarEffectV[3];
					CarSelect=0;
					if(moved==1){move++; moved=0;}
				}
			}
    	});
    	shortv3.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				FadeTransition fade = new FadeTransition(Duration.millis(1000),shortv3);
				if(CarEffectV[4]==true && CarSelect==0){
					GameAction.pressActionTrue(shortv3, fade);
					CarEffectV[4]=!CarEffectV[4];
					CarSelect=1;
				}
				else if(CarEffectV[4]==false && CarSelect==1){
					GameAction.pressActionFalse(shortv3, fade);
					CarEffectV[4]=!CarEffectV[4];
					CarSelect=0;
					if(moved==1){move++; moved=0;}
				}
			}
    	});
    	shortv4.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				FadeTransition fade = new FadeTransition(Duration.millis(1000),shortv4);
				if(CarEffectV[5]==true && CarSelect==0){
					GameAction.pressActionTrue(shortv4, fade);
					CarEffectV[5]=!CarEffectV[5];
					CarSelect=1;
				}
				else if(CarEffectV[5]==false && CarSelect==1){
					GameAction.pressActionFalse(shortv4, fade);
					CarEffectV[5]=!CarEffectV[5];
					CarSelect=0;
					if(moved==1){move++; moved=0;}
				}
			}
    	});
    	refresh.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				refresh.setTranslateY(-2);
			}			
		});
    	refresh.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				refresh.setTranslateY(2);
			}
		});
    	refresh.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
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
		        StageD.setScene(scene);
			}
    	});
    	setting.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
		    	setting.setTranslateY(-2);
			}			
		});
    	setting.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				setting.setTranslateY(2);
			}
		});
    	
    	Animation = new AnimationTimer(){
			@Override
			public void handle(long timestamp) {
				int pickH = 0;
				int pickV = 6;
				moves.setText("move: " + move +"	Best move: " + movediff);
				for(int i=0; i<6; i++){
					if(CarEffectH[i]==false) {
						pickH=i;
						for(int a=0; a<16; a++){
							if(checkIntersect(Object.get(pickH),Object.get(a))==true && pickH!=0 && a!=pickH  && pickH!=a){
								if(SpeedX>0){
									Object.get(pickH).setTranslateX(XX-5);
								}
								else if(SpeedX<0){
									Object.get(pickH).setTranslateX(XX+5);
								}
							}
							else if(checkIntersect(Object.get(0),Object.get(a))==true && a!=0 && a!=13){
								if(SpeedX>0){
									Object.get(pickH).setTranslateX(XX-5);
								}
								else if(SpeedX<0){
									Object.get(pickH).setTranslateX(XX+5);
								}
							}
							else if(lastUpdateTime>0){
								final double elapsedSeconds = (timestamp - lastUpdateTime) / 1_000_000_000.0 ;
			                    final double deltaX = elapsedSeconds * SpeedX;
			                    double X = Object.get(pickH).getTranslateX();
			                    double Xn = X + deltaX;
			                    XX = Xn;
			                    Object.get(pickH).setTranslateX( Xn );
							}
							lastUpdateTime=timestamp;
						}
					}
					else if(CarEffectV[i]==false) {
						pickV+=i;
						for(int a=0; a<16; a++){
							if(checkIntersect(Object.get(pickV),Object.get(a))==true && a!=pickV  && pickV!=a){
								if(SpeedY>0){
									Object.get(pickV).setTranslateY(YY-5);
								}
								else if(SpeedY<0){
									Object.get(pickV).setTranslateY(YY+5);
								}
							}
							else if(lastUpdateTime>0){
								final double elapsedSeconds = (timestamp - lastUpdateTime) / 1_000_000_000.0 ;
			                    final double deltaY = elapsedSeconds * SpeedY;
			                    double Y = Object.get(pickV).getTranslateY();
			                    double Yn = Y + deltaY;
			                    YY = Yn;
			                    Object.get(pickV).setTranslateY( Yn );
							}
							lastUpdateTime=timestamp;
						}
					}
				}
			}
    	};
    	Animation.start();
    }
    
    public void setScene(Scene scene){
    	scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode()==KeyCode.RIGHT) {
					SpeedX = 150;
					for(int i=0; i<6; i++){ if(CarSelect==1 && CarEffectH[i]==false){moved=1;} }
					if(checkIntersect(Object.get(0),Object.get(13))==true){
						win=1;
						SpeedX = 0;
						moves.setText("move: " + move++);
						if(move<=movediff || movediff==0){
							movediff=move;
						}
						Stage notic =new Stage();
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("little.fxml"));
						LittleWindow littlewindow = new LittleWindow();
				        fxmlLoader.setController(littlewindow);
						Parent root = null;
						try {
							root = fxmlLoader.load();
						} catch (IOException e) {
							e.printStackTrace();
						}
					    Scene scene = new Scene ( root, 250, 200 );
					    notic.setTitle("You Win");
					    notic.setScene(scene);
					    notic.initModality(Modality.APPLICATION_MODAL);
					    notic.initOwner(setting.getScene().getWindow());
					    notic.showAndWait();
				    }
	            }
	            else if(event.getCode()==KeyCode.LEFT){
					SpeedX = -150;
					for(int i=0; i<6; i++){ if(CarSelect==1 && CarEffectH[i]==false){moved=1;} }
	            }
	            else if(event.getCode()==KeyCode.UP){
					SpeedY = -150;
					for(int i=0; i<6; i++){ if(CarSelect==1 && CarEffectV[i]==false){moved=1;} }
	            }
	            else if(event.getCode()==KeyCode.DOWN){
					SpeedY = 150;
					for(int i=0; i<6; i++){ if(CarSelect==1 && CarEffectV[i]==false){moved=1;} }
	            }
			}
    	});
    	scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode()==KeyCode.RIGHT) {
					SpeedX = 0;
	            }
	            else if(event.getCode()==KeyCode.LEFT){
	            	SpeedX = 0;
	            }
	            else if(event.getCode()==KeyCode.UP){
					SpeedY = 0;
	            }
	            else if(event.getCode()==KeyCode.DOWN){
					SpeedY = 0;
	            }
			}
    	});
    }
    
    private boolean checkIntersect(ImageView block,ImageView block2){
    	return block.getBoundsInParent().intersects(block2.getBoundsInParent());
    }
    
    public void handlesetting(ActionEvent event) throws IOException{
    	bgm.pause();
    	Stage GameStage =new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("setting.fxml"));
		SettingControl settingcontrol = new SettingControl();
        fxmlLoader.setController(settingcontrol);
		Parent root = fxmlLoader.load();
	    Scene scene = new Scene ( root, 300, 350 );
	    settingcontrol.setgameplayStage(StageD);
	    GameStage.setTitle("Setting");
	    GameStage.setScene(scene);
	    GameStage.initModality(Modality.APPLICATION_MODAL);
	    GameStage.initOwner(setting.getScene().getWindow());
	    GameStage.showAndWait();
	}
}
