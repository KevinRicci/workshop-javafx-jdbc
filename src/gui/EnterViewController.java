package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.entities.User;
import model.sevices.UserService;

public class EnterViewController implements Initializable{
	
	private static Scene mainViewScene;
	
	private UserService service = new UserService();

	@FXML
	private TextField txtUser;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Button btEnter;
	
	@FXML
	private Label labelError;
	
	@FXML
	public void onBtEnterAction() {
		User user = new User();
		user.setUserName(txtUser.getText());
		user.setPassword(passwordField.getText());
		boolean result = service.userValidation(user);
		
		if(result == true) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
				ScrollPane scrollPane = loader.load();
				scrollPane.setFitToHeight(true);
				scrollPane.setFitToWidth(true);
				
				mainViewScene = new Scene(scrollPane);

				Stage stage = new Stage();
				stage.setScene(mainViewScene);
				stage.setTitle("JavaFX 2.0");
				stage.show();
				Alerts.showAlert("Welcome", null, "Happy to see you again " + txtUser.getText() + "!", AlertType.INFORMATION);
				Stage enterStage = (Stage) Main.getEnterViewScene().getWindow();
				enterStage.close();
				
			} catch (IOException e) {
				throw new DbException(e.getMessage());
			}
		}
		else {
			Alerts.showAlert("Invalid user", null, "Try again", AlertType.ERROR);
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldMaxLength(passwordField, 40, x -> {labelError.setText("Max limit in field password");});
		Constraints.setTextFieldMaxLength(txtUser, 40, x -> {labelError.setText("Max limit in field user");});
	}
	
	public static Scene getMainViewScene() {
		return mainViewScene;
	}
}
