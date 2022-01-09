package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
		
	@Override
	public void start(Stage primaryStage) {
		
		MainView mainV = new MainView();
		mainV.setMainView(); //call MainView
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
