package com.sample.test.demo.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sample.test.demo.utils.BaseTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DemoTest extends BaseTest {

     

   // @Test
    public void getMethodTest() throws JsonParseException, JsonMappingException, IOException {
    	 String url = "https://my-json-server.typicode.com/sa2225/demo/orders";
    	Response response=given().when().get(url);
    	response.then().statusCode(200);
    	JsonPath json=response.jsonPath();
    	
    	String idList=json.getString("id");
    	System.out.println(idList);
    	List<Object> pizzaList=json.getList("items");
    	System.out.println(pizzaList);
    
    } 
    
    
    @Test
    public void postMethodTest() throws JsonParseException, JsonMappingException, IOException {
    	String url = "https://my-json-server.typicode.com/sa2225/demo/orders";
    	String payload="{"+
    		    "\"items\": [ "+
    		     " {"+
    		        "\"item\": 1,"+
    		        "\"pizza\": \"Medium 8 Slices - 2 toppings\","+
    		        "\"toppings\": ["+
    		         "\"Mushrooms\","+
    		          "\"Extra cheese\""+
    		        "]"+
    		      "}";
    	Response response=given().when().body(payload).post(url);
    System.out.println(response.getStatusCode());
    
    response.then().statusCode(201);
    
    System.out.println(response.asString());
    
    } 
    
    
    



}
