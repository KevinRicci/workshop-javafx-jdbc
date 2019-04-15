package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Scene enterScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/EnterView.fxml"));
			AnchorPane anchorPane = loader.load();
			
			enterScene = new Scene(anchorPane);
			
			primaryStage.setScene(enterScene);
			primaryStage.setTitle("Sample JavaFX application");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getEnterViewScene() {
		return enterScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
