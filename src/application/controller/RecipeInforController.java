package application.controller;


import application.Main;
import application.model.RecipeInfor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button; 
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Font;

public class RecipeInforController {

    @FXML
     Button summary;

    @FXML
    Button instruction;

    @FXML
   Label infor, titles;
    

    @FXML
    Button back;  
    @FXML
   ScrollPane scroll;
    

    @FXML
    public void handle(ActionEvent event) {
    	RecipeInfor.fetchRecipeInfor();
    	RecipeInfor  recipeInformation = new RecipeInfor();
    	if(event.getSource().equals(summary)) {
    		
    		//infor.setText(RemoveHTMLTags(recipeInformation.getSummary()));
    		Label summaryText = new Label(RemoveHTMLTags(recipeInformation.getSummary()));
    		summaryText.setPrefWidth(559);
    		summaryText.setWrapText(true);
    		summaryText.setFont(Font.font("regular",18));
    		summaryText.setLineSpacing(2.0);
    		scroll.setContent(summaryText);
    		
    		scroll.setFitToWidth(true);
    		//scroll.setFitToHeight(false);
    		//scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    	}
    	else if (event.getSource().equals(instruction)) {
    		//infor.setText(recipeInformation.getInstruction());
    		Label instructionText = new Label(removeExtraSpace(recipeInformation.getInstruction()));
    		instructionText.setPrefWidth(559);
    		instructionText.setWrapText(true);
    		instructionText.setFont(Font.font("regular",18));
    		instructionText.setLineSpacing(2.0);
    		scroll.setContent(instructionText);
    		
    		scroll.setFitToWidth(true);
    	}
    }
    
     @FXML
   public void click(ActionEvent event) {
 		try {

 			FXMLLoader loader = new FXMLLoader();
 			loader.setLocation(getClass().getResource("../view/Recipe.fxml"));

 			Scene scene = new Scene(loader.load());

 			Main.stage.setScene(scene);
 			Main.stage.show();
 			
 		} catch(Exception e) {
 			e.printStackTrace();
 		
 		
 	}
//    	 titles.setText("idk");
    }
    
    public  String RemoveHTMLTags(String str)
    { 
        str = str.replaceAll("<[^>]*>", ""); 
        return str;
    }
    
    public String removeExtraSpace(String s) {
    	String str = s.replaceAll("\\s+", " ");
    	return str;
    }

}
