package application.controller;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import application.Main;
import application.model.Recipe;
import application.model.RecipeInfor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class RecipeController implements Initializable{

   
	 @FXML
	 Label header;
    @FXML
    Label title_0;
    
    @FXML
    Label carbs_0;

    @FXML
    Label protein_0;

    @FXML
    Label fat_0;

    @FXML
    Label calories_0; 
    @FXML
    Label title_1;
    
    @FXML
    Label carbs_1;

    @FXML
    Label protein_1;

    @FXML
    Label fat_1;

    @FXML
    Label calories_1;
    
    @FXML
    Label title_2;
    
    @FXML
    Label carbs_2;

    @FXML
    Label protein_2;

    @FXML
    Label fat_2;

    @FXML
    Label calories_2;
    
    @FXML
    Label title_3;
    
    @FXML
    Label carbs_3;

    @FXML
    Label protein_3;

    @FXML
    Label fat_3;

    @FXML
    Label calories_3;
    
    @FXML
    Label title_4;
    
    @FXML
    Label carbs_4;

    @FXML
    Label protein_4;

    @FXML
    Label fat_4;

    @FXML
    Label calories_4;
    
    @FXML
    Label title_5;
    
    @FXML
    Label carbs_5;

    @FXML
    Label protein_5;

    @FXML
    Label fat_5;

    @FXML
    Label calories_5;
    @FXML
	Label[] titleArray;
    @FXML
	Label[] ProteinArray;
    @FXML
   	Label[] fatArray;
    @FXML
   	Label[] caloriesArray;
    @FXML
   	Label[] carbArray;
   
    @FXML
     AnchorPane pane_0;

    @FXML
    AnchorPane pane_2;

    @FXML
    AnchorPane pane_1;

    @FXML
    AnchorPane pane_4;

    @FXML
    AnchorPane pane_3;

    @FXML
    AnchorPane pane_5;
    @FXML
    AnchorPane[] paneArray = new AnchorPane[]{pane_0,pane_1,pane_2,pane_3,pane_4,pane_5};

    @FXML
    ImageView img_0, img_1, img_2, img_3, img_4, img_5 ;
    ImageView[] imgArray;
    
    @FXML
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5;
    Button[] btnArray;
    @FXML
    Button test;
    ArrayList <String> ids = new ArrayList<String>();

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
    AnchorPane informationPane;
    
    public void initialize(URL location, ResourceBundle resources) {
    	informationPane.setVisible(false);
        titleArray = new Label[] {title_0,title_1,title_2,title_3,title_4,title_5};
    	ProteinArray = new Label[] {protein_0,protein_1,protein_2,protein_3,protein_4,protein_5};
    	fatArray = new Label[] {fat_0,fat_1,fat_2,fat_3,fat_4,fat_5};
    	caloriesArray = new Label[] {calories_0,calories_1,calories_2,calories_3,calories_4,calories_5};
    	carbArray = new Label[] {carbs_0,carbs_1,carbs_2,carbs_3,carbs_4,carbs_5};
    	imgArray = new ImageView[] {img_0, img_1, img_2, img_3, img_4, img_5};
    	btnArray = new Button[] {btn_0,btn_1,btn_2,btn_3,btn_4,btn_5};
    	int count = 0;
    	
    	//newRecipe.fetchRecipe();
    	
    	 Recipe.fetchRecipe();
    	 System.out.println("main arr "+ Main.recipeArray.size());
    	for(Recipe newRec : Main.recipeArray) {
    		
    		titleArray[count].setText(newRec.getTitle());
    		caloriesArray[count].setText("Calories: "+ String.valueOf(newRec.getCalories()));
    		ProteinArray[count].setText("Protein: " +newRec.getProtetin());
    		fatArray[count].setText("Fat: "+ newRec.getFat());
    		carbArray[count].setText("Carb: " + newRec.getCarbs());	
    		//Image newImg = new Image
    
    		//imgArray[count].setImage(image);
    		ids.add(newRec.getId());
    		 System.out.println(newRec.getImgURL());
    		count++;
    	};
    	//https://i.pcmag.com/imagery/reviews/04M2NmPEIp3j1uqUihrHKKV-9..v1569477104.png
    	
//    	Image newImg = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Google_2015_logo.svg/1200px-Google_2015_logo.svg.png");
//    	img_0.setImage(newImg);
//    	System.out.println(ids);
    
    }
 
	@FXML
    public void handle(MouseEvent event) {
    	if(event.getSource() == btn_0 || event.getSource() == btn_1 || event.getSource() == btn_2 || event.getSource() == btn_3
    			|| event.getSource() == btn_4 || event.getSource() == btn_5) {
    		String id_btn = ((Button) event.getSource()).getId(); 
    				
    			if(id_btn.equals("btn_0")) {
    				Main.idQuery = ids.get(0);
    			}
    			else if(id_btn.equals("btn_1")) {
    				Main.idQuery = ids.get(1);
    			}
    			else if(id_btn.equals("btn_2")) {
    				Main.idQuery = ids.get(2);
    			}
    			else if(id_btn.equals("btn_3")) {
    				Main.idQuery = ids.get(3);
    			}
    			else if(id_btn.equals("btn_4")) {
    				Main.idQuery = ids.get(4);
    			}
    			else if(id_btn.equals("btn_5")) {
    				Main.idQuery = ids.get(5);
    			}
    			
    			System.out.println("id_btn: "+ id_btn);
    			System.out.println("id from controller: " +Main.idQuery);
    			
    			header.setVisible(false);
    			pane_0.setVisible(false);
    			pane_1.setVisible(false);
    			pane_2.setVisible(false);
    			pane_3.setVisible(false);
    			pane_4.setVisible(false);
    			pane_5.setVisible(false);
    			informationPane.setVisible(true);
    			
    }
    

    }
    @FXML
  public void click(ActionEvent event) {

    	header.setVisible(true);
		pane_0.setVisible(true);
		pane_1.setVisible(true);
		pane_2.setVisible(true);
		pane_3.setVisible(true);
		pane_4.setVisible(true);
		pane_5.setVisible(true);
		
		informationPane.setVisible(false);
		scroll.setContent(null);
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
    
    @FXML
    public void select(ActionEvent event) {
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

}
