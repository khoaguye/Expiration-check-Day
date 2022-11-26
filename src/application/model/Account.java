package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Account{
	private String fName;
	private String lName;
	private String email;
	private String password;
	private String userName;
	
	public Account(String fName, String lName, String email, String password, String userName) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.userName = userName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String toString() {
		String str = "";
		str += this.fName ;
		str += "bonjour" + this.lName ;
		str += "bonjour" + this.email ;
		str += "bonjour" + this.userName ;
		str += "bonjour" + this.password;
		return str;
	}
	
	public Account(String fileName) {
		try {
        	
			File inputFile = new File(fileName);
			Scanner scan = new Scanner(inputFile);   
			while(scan.hasNext() ){
	
					String line = scan.nextLine();
					String [] splitWord = line.split(","); 
			if(!splitWord[0].equals("First Name")){
					this.fName = splitWord[0];
					this.lName  = splitWord[1];
					this.email  = splitWord[2];
					this.userName  = splitWord[3];
					this.password  = splitWord[4];
					break;
					}
			 
	
     	 }
			scan.close();						   
		} catch (FileNotFoundException e) {    
			// TODO Auto-generated catch block
			System.out.print("Something wend wrong.");
			e.printStackTrace();
		} 
    }
	   public static Account loadData(String fileName) {
			Account newUser = new Account(fileName);
			return newUser;
		}
	  
}
	
