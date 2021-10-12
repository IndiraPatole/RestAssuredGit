package wAPI;



import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherPuneAPI {
	 @Test( description="Getting weather information of specific city")
	  public void getWeather() {
		  RestAssured.given()		// Some Pre-condition like Authentication
		  .when()					// Performs some steps
		  .get("https://api.openweathermap.org/data/2.5/weather?q=Pune&appid=d95be9c86b693a9134660777a36db2ec")	         
	             .then()
	             .log()
	             .body()
	             .statusCode(200);
  }
  
	 @Test(enabled=false,description="Getting weather information of specific city")
	  public void getWeather2() {
		Response res=  RestAssured.given()		// Some Pre-condition like Authentication
		  .when()					// Performs some steps
		  .get("https://api.openweathermap.org/data/2.5/weather?q=Pune&appid=d95be9c86b693a9134660777a36db2ec");	         
  System.out.println(res.prettyPrint());
  System.out.println(res.getTime());
  System.out.println(res.getStatusCode());
  System.out.println(res.getContentType());
  
  Assert.assertEquals(res.getStatusCode(),200 ) ; //TestNG
  }
  
  @Test (enabled=true,description ="Getting weather information of a specific city" )
  public void getWeather3() {
	  RestAssured.given() //Some Precondition for authentication
	             .queryParam("q", "Pune")
	             .queryParam("appid", "d95be9c86b693a9134660777a36db2ec")
	  
	              .when()
                     .get("https://api.openweathermap.org/data/2.5/weather?q=Pune&appid=d95be9c86b693a9134660777a36db2ec")	         
	             .then()
	             .log()
	             .body()
	             .statusCode(200);
  
}
  
  @Test (enabled=true,description ="Getting weather information of a specific city" )
  public void getWeather4() {
	  Map<String,String> param = new HashMap<String, String>();
	  param.put("q", "Mumbai");
	  param.put("appid", "d95be9c86b693a9134660777a36db2ec");
  
	  RestAssured.given() //Some Precondition for authentication
	             .queryParam("q", "Mumbai")
	             .queryParam("appid", "d95be9c86b693a9134660777a36db2ec")
	  
	              .when()
                     .get("https://api.openweathermap.org/data/2.5/weather?q=Pune&appid=d95be9c86b693a9134660777a36db2ec")	         
	             .then()
	             .log()
	             .body()
	             .statusCode(200);
  
}
  
}

