package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController{

    @FXML
     Button submit;

    @FXML
     Button signIn;
    @FXML
    TextField fname;

    @FXML
    TextField lname;
    @FXML
    TextField userName;


    @FXML
    PasswordField pass;

    @FXML
    TextField email;



    @FXML
    public void handle(ActionEvent event) {
    	
    	File newUserFile = new File("data/" + userName.getText() + ".csv");
    	//File newUserFile = new File("data/login.csv");
    
		try {
			PrintWriter pw = new PrintWriter(newUserFile);
			StringBuilder sb=new StringBuilder();
			sb.append("First Name");
			sb.append(",");
			sb.append("Last Name");
			sb.append(",");
			sb.append("Email");
			sb.append(",");
			sb.append("Username");
			sb.append(",");
			sb.append("PassWord");
			sb.append("\n");
			
			sb.append(fname.getText());
			sb.append(",");
			sb.append(lname.getText());
			sb.append(",");
			sb.append(email.getText());
			sb.append(",");
			sb.append(userName.getText());
			sb.append(",");
			sb.append(pass.getText());
			
			pw.write(sb.toString());
			pw.close();
		}
		catch (FileNotFoundException e) {    
			// TODO Auto-generated catch block
			System.out.print("Something went wrong.");
			e.printStackTrace();
		} 
    
    
	 
   }




@FXML
public void Click(ActionEvent event) {
	if(event.getSource().equals(signIn)) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/Login.fxml"));

			Scene scene = new Scene(loader.load());

			Main.stage.setScene(scene);
			Main.stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
}
	




 