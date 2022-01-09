package application;


import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Final_Report {

	 static Stage subStage; 
	 public void set_Final_Report() {
		subStage = new Stage();
        subStage.setTitle("Final Score");
        AnchorPane root = new AnchorPane();
        root.setPrefWidth(637);
        root.setPrefHeight(442);
        root.setStyle("-fx-background-color:#fff;");
        
        Label cong = new Label("Congratulations");
        cong.setStyle("-fx-text-fill:#eb3b3b; -fx-font-size:20; -fx-font-weight:bold;");
        cong.setLayoutX(224);
        cong.setLayoutY(27);
        
        Label success_lbl = new Label("You have successfully completed Java Quiz game");
        success_lbl.setLayoutX(130);
        success_lbl.setLayoutY(302);
        success_lbl.setStyle("-fx-font-size:18;");
        
        Label score_lbl = new Label("Your Score is");
        score_lbl.setLayoutX(197);
        score_lbl.setLayoutY(260);
        score_lbl.setStyle("-fx-font-size:20; -fx-font-weight:bold;");
        
        Label score = new Label("/30");
        score.setLayoutX(335);
        score.setLayoutY(260);
        score.setStyle("-fx-font-size:20; -fx-font-weight:bold;");
        
        Button go_home = new Button("Go To Home ");
        go_home.setLayoutX(228);
        go_home.setLayoutY(356);
        go_home.setPrefWidth(170);
        go_home.setPrefHeight(40);
        
        ImageView imgView = new ImageView();
        Image img = new Image("/icons/giphy-downsized.gif");
        imgView.setFitWidth(219);
        imgView.setFitHeight(200);
        imgView.setImage(img);
        imgView.setLayoutX(205);
        imgView.setLayoutY(57);
        
        int no = 0; 
        	
		no = JavaQuizController.calCorrectAnswer();
        score.setText(no+"/30");
        
        //set final report
        go_home.setOnAction(e ->{
        	
        	Final_Report.subStage.hide();
        	MainView mainV = new MainView();
    		mainV.setMainView();
        	
        });
        
        Scene scene = new Scene(root);
        root.getChildren().addAll(imgView,cong,success_lbl,go_home,score_lbl,score);
        scene.getStylesheets().add(getClass().getResource("/CSS/Main.css").toExternalForm());
        subStage.setScene(scene);
        subStage.show();
	}
	
}
