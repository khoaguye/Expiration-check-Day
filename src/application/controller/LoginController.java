package application.controller;



import application.Main;
import application.model.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    Button submit;
    
    @FXML 	
    Button register; 
    										
    @FXML
    PasswordField pass;

    @FXML
    TextField userName;
    @FXML
    Label message;
     
  

    @FXML
    public void handle(ActionEvent event) {
    	Account newUser = Account.loadData("data/"+userName.getText()+".csv");
    	String string = newUser.toString();
		 String part[] = string.split("bonjour");
		
		 if(userName.getText().equals(part[3]) && pass.getText().equals(part[4])) {
				try {

					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("../view/Recipe.fxml"));

					Scene scene = new Scene(loader.load());

					Main.stage.setScene(scene);
					Main.stage.show();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
		 }
		 else if(!userName.getText().equals(part[3])) {
			 message.setText("ERROR!! Your userName is inValid");
			 message.setStyle("-fx-text-fill: red");
		 }
		 else if(!pass.getText().equals(part[4])) {
			 message.setText("ERROR!! Incorrect Password");
			 message.setStyle("-fx-text-fill: red");
		 }
		
    }
    
    @FXML
    public void click(ActionEvent event) {
    	if(event.getSource().equals(register)) {
    		try {

    			FXMLLoader loader = new FXMLLoader();
    			loader.setLocation(getClass().getResource("../view/Register.fxml"));

    			Scene scene = new Scene(loader.load());

    			Main.stage.setScene(scene);
    			Main.stage.show();
    			
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    	}

    }


}
