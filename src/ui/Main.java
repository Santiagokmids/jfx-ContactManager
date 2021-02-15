package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ContactManager;

public class Main extends Application{
	
	private ContactsGUI contactsGUI;
	private ContactManager contactsManager;
	
	public Main(){
		contactsManager = new ContactManager();
		contactsGUI = new ContactsGUI(contactsManager);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader (getClass().getResource("MenuBarFirst.fxml"));
		loader.setController(contactsGUI);
		
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Contact Manager");
		primaryStage.show();
	}
		
}


