package application;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaQuizView {

	static Stage subStage;
	
	 JavaQuizView()
	{
		
	subStage = new Stage();
        subStage.setTitle("Java Quiz Game");
                      
        AnchorPane root = new AnchorPane();
        root.setPrefWidth(760);
        root.setPrefHeight(343);
        
        Pane pane = new Pane();
        pane.setPrefWidth(760);
        pane.setPrefHeight(372);
        pane.setStyle("-fx-border-color:#000; -fx-background-color:#fff;");
        
        Text qNo = new Text("Q.1 |");
        qNo.setLayoutX(31);
        qNo.setLayoutY(56);
        qNo.setStyle("-fx-font-size:20;");
        
        Text questions = new Text("questions");
        questions.setLayoutX(85);
        questions.setLayoutY(56);
        questions.setStyle("-fx-font-size:19;");
        
        RadioButton b1 = new RadioButton("A )");
        b1.setLayoutX(50);
        b1.setLayoutY(112);
        b1.setStyle("-fx-font-size:16;");
        
        RadioButton b2 = new RadioButton("B )");
        b2.setLayoutX(50);
        b2.setLayoutY(151);
        b2.setStyle("-fx-font-size:16;");
        
        RadioButton b3 = new RadioButton("C )");
        b3.setLayoutX(50);
        b3.setLayoutY(191);
        b3.setStyle("-fx-font-size:16;");
        
        RadioButton b4 = new RadioButton("D )");
        b4.setLayoutX(50);
        b4.setLayoutY(231);
        b4.setStyle("-fx-font-size:16;");
        
        Button save_cont = new Button("Save & Continue");
        save_cont.setLayoutX(57);
        save_cont.setLayoutY(299);
        save_cont.setPrefWidth(157);
        save_cont.setPrefHeight(34);
       
        
        Button finish = new Button("Finish attempt");
        finish.setLayoutX(256);
        finish.setLayoutY(299);
        finish.setPrefWidth(157);
        finish.setPrefHeight(34);
        
        pane.getChildren().addAll(qNo,questions,b1,b2,b3,b4,save_cont,finish);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/CSS/Main.css").toExternalForm());
        root.getChildren().add(pane);
        
        JavaQuizController quiz = new JavaQuizController();
        quiz.setJavaQuizController(b1,b2,b3,b4,qNo,questions,save_cont,finish);
        save_cont.setOnAction(e -> {try {
			
        	quiz.btnNext();
		   
          } catch (IOException e1) {
			
			e1.printStackTrace();
		} });
        
        finish.setOnAction(e ->{
        	
        	try {
				quiz.setDialogBox();
				subStage.hide();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
        });
        
        subStage.setScene(scene);
        subStage.show();
	}
	 
	 public static void setStage_hide()
	 {
	    JavaQuizView.subStage.hide();		
	
	 } 
		  
}
