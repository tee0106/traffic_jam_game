package finalproject;

import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("final.fxml"));
        ChangeScene changescene = new ChangeScene ();
        SelectDiff selectdiff = new SelectDiff();
        LittleWindow littlewindow = new LittleWindow();
        StageD1 staged1 = new StageD1();
        StageD2 staged2 = new StageD2();
        StageD3 staged3 = new StageD3();
        fxmlLoader.setController(changescene);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Traffic Jam");
        Scene scene = new Scene ( root, 600, 700 );
        changescene.setprevStage(primaryStage);
        selectdiff.setprevStage2(primaryStage);
        staged1.setprevStageD(primaryStage);
        staged2.setprevStageD(primaryStage);
        staged3.setprevStageD(primaryStage);
        littlewindow.setgameplayStageLW(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
