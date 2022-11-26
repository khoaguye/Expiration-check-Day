/**
 * Main is the file that able to load all and control the stage of different file
 * 
 * 
 * 
 * @author Khoa Nguyen (Wqv680)
 * UTSA CS 3443 - Lab 6
 * Fall 2022
 */

package application;
	


import java.util.ArrayList;


import application.model.Recipe;
import application.model.RecipeInfor;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {

  
	public static Stage stage;
	public static ArrayList<Recipe> recipeArray = new ArrayList<Recipe>(); 
	public static ArrayList<RecipeInfor> recipeInforArray = new ArrayList<RecipeInfor>(); 
	public static String idQuery;
	// Create the global arrayList to use in different file. 
	@Override   
	public void start(Stage primaryStage) {
		stage = primaryStage;
	   /**
	    * This function is used to set the stage of the app
	    * the FXMLLoader parse FXML content (as XML), build the Scene Graph 
	    * and initialize the Controller of a JavaFX View.
	    */
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("view/Recipe.fxml") );
			AnchorPane layout = (AnchorPane) loader.load();
			
			Scene scene = new Scene(layout);
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			 									           
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	public static void main(String[] args) {
		launch(args);
	}
}