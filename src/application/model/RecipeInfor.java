package application.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import application.Main;

public class RecipeInfor{
	//private String id;
	private String instruction;
	private String summary;
	
	public RecipeInfor(String instruction, String summary) {
	
		this.instruction = instruction;
		this.summary = summary;
	}

	public String getInstruction() {
		return instruction;
	}


	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
	public RecipeInfor(){
		// Host url
	      //String host = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com";
	      //String charset = "UTF-8";
	      // Headers for a request
	      String x_rapidapi_host = "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com";
	      String x_rapidapi_key = "d5e529c26cmshc5a77b8cc4f62a2p12a602jsne7dc75366267";//Type here your key
	 
	  
	      String res = Main.idQuery;
	      
	      HttpResponse<JsonNode> response2;
	      System.out.println("id from model " +res);
		try {
			response2 = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/"+res+"/information")
						.header("X-RapidAPI-Key", x_rapidapi_key)
						.header("X-RapidAPI-Host", x_rapidapi_host)
						.asJson();
		
	    			//.asString();
//	    	    System.out.println(response2.getStatus());
//	    	      System.out.println(response2.getHeaders().get("Content-Type"));
	    	      
	    	      Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
	    	      JsonParser jp2 = new JsonParser();
	    	      JsonElement je2 = jp2.parse(response2.getBody().toString());
	    	      //System.out.print(je2);
	    	  
	    	      JsonObject jo2 = je2.getAsJsonObject();
	    	      System.out.println(jo2);
	    	      //System.out.println(jo2.get("id"));
	    	      System.out.println(jo2.get("instructions"));
	    	      this.instruction = jo2.get("instructions").getAsString();
	    	      this.summary = jo2.get("summary").getAsString();
	    	      Main.recipeInforArray.add(new RecipeInfor(this.instruction, this.summary));
	    	      
	  // Format query for preventing encoding problems
	     
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	
	}
	public static RecipeInfor fetchRecipeInfor() {
		RecipeInfor newRecipeInfor = new RecipeInfor();
		return newRecipeInfor;
	}










}