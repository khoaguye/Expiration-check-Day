package application.model;


/*
 * 1: pull from master branch 
 * 2: integrate my current into local master branch
 * 3: push to different branch
 * 
 * */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import application.Main;

public class Recipe{
	private String title;
	private int calories;
	private String protetin;
	private String carbs;
	private String id;
	private String fat;
	private String imgURL;
	
	public Recipe(String title, int calories, String protetin, String carbs, String fat, String id, String imgURL) {
		super();
		this.title = title;
		this.calories = calories;
		this.protetin = protetin;
		this.carbs = carbs;
		this.fat = fat;
		this.id = id;
		this.imgURL= imgURL;
	}


	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getProtetin() {
		return protetin;
	}
	public void setProtetin(String protetin) {
		this.protetin = protetin;
	}
	public String getCarbs() {
		return carbs;
	}
	public void setCarbs(String carbs) {
		this.carbs = carbs;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFat() {
		return fat;
	}
	public void setFat(String fat) {
		this.fat = fat;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public  Recipe() {
		  String host = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com";
		  //String charset = "UTF-8";
	      // Headers for a request
	      String x_rapidapi_host = "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com";
	      String x_rapidapi_key = "d5e529c26cmshc5a77b8cc4f62a2p12a602jsne7dc75366267";//Type here your key
	      // Params
	      String s = "Beef";
	
	      
	     
	     
		try {

			 HttpResponse<JsonNode> response;
			response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/searchComplex?limitLicense=false&offset=0&number=6&minCalories=150&maxProtein=100&minCarbs=5&query="+s+"&maxCalories=1500&maxCarbs=100&maxFat=100&minCopper=0")
						.header("X-RapidAPI-Key", x_rapidapi_key)
						.header("X-RapidAPI-Host", x_rapidapi_host)
						.asJson();
			  System.out.println(response.getStatus());
    	      System.out.println(response.getHeaders().get("Content-Type"));
    	      
    	      Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	      JsonParser jp = new JsonParser();
    	      JsonElement je = jp.parse(response.getBody().toString());
    	      JsonObject jo = je.getAsJsonObject();
    	      JsonArray arr = jo.getAsJsonArray("results");
    	    System.out.println(arr.size());
    	      for( int i=0; i< arr.size(); i++) {
 
    	      jo = arr.get(i).getAsJsonObject();
    	      this.title= jo.get("title").getAsString();
    	      this.fat  =jo.get("fat").getAsString();
    	      this.calories= Integer.parseInt(jo.get("calories").getAsString());
    	      this.carbs = jo.get("carbs").getAsString();
    	      this.id = jo.get("id").getAsString();
    	      this.protetin = jo.get("protein").getAsString();
    	      this.imgURL = jo.get("image").getAsString()
;    	      Main.recipeArray.add(new Recipe(this.title, this.calories, this.protetin, this.fat, this.carbs, this.id,this.imgURL));
    	     
    	      }
    	      System.out.println(arr);
    	     
  	        
    	     
		}
		catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Recipe fetchRecipe() {
		Recipe newRecipe = new Recipe();
		return newRecipe;
	}


	public String getImgURL() {
		return imgURL;
	}


	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	
	
}