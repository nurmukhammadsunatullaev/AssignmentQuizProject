package application;

import java.io.IOException;
import java.util.*;
import JavaQuiz.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;


public class JavaQuizController {

	    //Varibales
	    private ToggleGroup tgGroup;

	    @FXML
	    private RadioButton b1;

	    @FXML
	    private RadioButton b4;

	    @FXML
	    private RadioButton b3;

	    @FXML
	    private RadioButton b2;

	    @FXML
	    private Button bbnxt;
		
	    @FXML
	    private Button sumbmit;
	    
	    @FXML
	    private Text qNo;
	   
	    @FXML
	    private Text questions;
		
	    @FXML
	    private Text scores;
		
	    static String s;
        String[][] qpa;
	    static String[][] qca;
        public static int qaid;
	    static HashMap<Integer, String> map;
        public static String chk;
       
        Final_Report submit = new Final_Report();
        public void setJavaQuizController(RadioButton b1,RadioButton b2,RadioButton b3,RadioButton b4,Text qNo,Text question,Button save_contn,Button finish)
     	{ 
        	qaid=0;
        	
        	this.b1 = b1;
        	this.b2 = b2;
        	this.b3 = b3;
        	this.b4 = b4;
        	
        	this.bbnxt=save_contn;
        	this.sumbmit = finish;
        	
        	this.qNo = qNo;
        	this.questions = question;
        	
        	
        	tgGroup = new ToggleGroup();
			b1.setToggleGroup(tgGroup);
			b2.setToggleGroup(tgGroup);
			b3.setToggleGroup(tgGroup);
			b4.setToggleGroup(tgGroup);
			
			
	         qpa=new String[10][5];
	         qca=new String[10][2];

	          int no = MainView.getRandomNo();
	         
	             if(no==0)
	            {
	               qpa = quiz.setQuiz0();
	               qca = answer.getAnswerqca();
                           
	            }
	            else if(no==1)
	            {
	                qpa = quiz.setQuiz1();
		            qca = answer.getAnswerqca1();
	                    	
	            }
	            else if(no==2)
	             {
	                 qpa = quiz.setQuiz2();
		             qca = answer.getAnswerqca2();
	                    	
	             }
	             
	          
	             map=new HashMap<Integer, String>();
	             readqa(qaid);
	                    	 
	           
	            
	            
    }
     	
    //read questions
    public void readqa(int i){
		        		       
	          questions.setText(qpa[i][0]);
	          b1.setText("A)  "+qpa[i][1]);
	          b2.setText("B)  "+qpa[i][2]);
	          b3.setText("C)  "+qpa[i][3]);
	          b4.setText("D)  "+qpa[i][4]);
	            
	          b1.getText().substring(4);  
	          b2.getText().substring(4);
	          b3.getText().substring(4); 
	          b4.getText().substring(4);
	         
	       
	          b1.setSelected(false);
	    	  b2.setSelected(false);
	    	  b3.setSelected(false);
	    	  b4.setSelected(false);
	  
	      	
    }	
		 
   
    public void setQid(int i)
		 {
			qaid =  i;
			
		 }
		
   
    public int getQid()
		 {
			 return qaid;
		 }
		
    
   
	
     public String getSelection()
		 {
	            
			 return chk;
         }
	
     public void setQuestionNO(int i)
		 {
			 int qN = i;
			 qN++;
			 qNo.setText("Q."+qN+" |");
			 
		 }
		 
    
         //action on radio button
	 public void groupAction() {
		      
		  if(b1.isSelected())
		  {
			  chk = b1.getText().substring(4);
		  }
		  else if(b2.isSelected())
		  {
			  chk = b2.getText().substring(4);		 
		  
		  }
		  else if(b3.isSelected())
		  {
			  chk = b3.getText().substring(4); 
		  }
		  else if(b4.isSelected())
		  {
			  chk = b4.getText().substring(4);
		  }
		 
		 		
		}

         
         //action on next button
	  public void btnNext() throws IOException
	  {
		  groupAction();
		  
		  if(qaid<10)
		  {
             
             map.put(qaid,getSelection());
            
             if(Objects.equals(qaid, 9))
             {   
                 setQuestionNO(qaid); 
                 readqa(qaid);
                 qaid++;
             }
             else
              {
            	 qaid++;
            	 chk = null;
                 setQuestionNO(qaid); 
                 readqa(qaid);
              }
               
             
           }
      
	  else {
		  
		     this.submit();    	  
         }
				 
      }
	 
    /**
     *
     * @throws IOException
     */
	 
    //set confirmation dialogbox      
    public void setDialogBox() throws IOException
	 {
		 Alert alert = new Alert(AlertType.CONFIRMATION);
		 alert.setTitle("Confirmation");
		 String s = " Do you want sumbit your Quiz test ?";
		 alert.setContentText(s);

		  Optional<javafx.scene.control.ButtonType> action = alert.showAndWait();

		  if ((action.isPresent()) && (action.get() ==javafx.scene.control.ButtonType.OK)) {

			  this.submit();
                 
		  }
		  else
		  {
			  qaid--;
		  }
		 
	 }
	  
   // calculate answer
    public static int calCorrectAnswer(){
         int qnum=10;
         int count=0;
         for(int qid=0;qid<qnum;qid++)
         if(qca[qid][1].equals(map.get(qid)))
          {
        	 count++;
        	 count++;
          }
        
        
         return count;
         
     }
	//sumbmit quiz 
	public void submit()
	{
	  submit.set_Final_Report();	
	  JavaQuizView.setStage_hide();
	}
    
    
}


