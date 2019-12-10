package com.sample.test.demo.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.test.demo.utils.BaseTest;
import com.sample.test.demo.utils.Order;
import com.sample.test.demo.utils.Pizza;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DemoTest extends BaseTest {

	Order[] order;

   @Test
    public void getMethodTest() throws JsonParseException, JsonMappingException, IOException {
    	 String url = "https://my-json-server.typicode.com/sa2225/demo/orders";
    	Response response=given().when().get(url);
    	response.then().statusCode(200);
    	//JsonPath json=response.jsonPath();
    	
    	String s=response.asString();
    	
    	ObjectMapper om=new ObjectMapper();
    	
    	order=om.readValue(s, Order[].class);
    	
    	System.out.println(order);
    	
    	for(int i=0;i<order.length;i++){
    		
    		Order o=order[i];
    		
    		System.out.println("Order Id : "+o.getId());
    		
    		List<Pizza> list=o.getItems();
    		
    		//System.out.println(list);
    		
    		for(Pizza p:list){
    			
    			System.out.println("Pizza Item : "+p.getItem());
    			System.out.println("Pizza Name : "+p.getPizza());
    			List<String> toppings=p.getToppings();
    			System.out.println("Toppings :"+toppings);
    			
    		}
    		
    	}
    	
    	
    	Assert.assertEquals(order[1].getItems().get(0).getPizza(), "Small 6 Slices - no toppings");

    
    } 
    
    
    @Test
    public void postMethodTest() throws JsonParseException, JsonMappingException, IOException {
    	String url = "https://my-json-server.typicode.com/sa2225/demo/orders";
    	String payload="{"+
    		    "\"items\": [ "+
    		     " {"+
    		        "\"item\": "+order[1].getItems().get(0).getItem()+","+
    		        "\"pizza\": \""+order[1].getItems().get(0).getPizza()+"\","+
    		        "\"toppings\": ["+
    		         "\"Mushrooms\","+
    		          "\"Extra cheese\""+
    		        "]"+
    		      "}";
    	
    	System.out.println(payload);
    	Response response=given().when().body(payload).post(url);
    System.out.println(response.getStatusCode());
    
    response.then().statusCode(201);
    
    System.out.println(response.asString());
    
    } 
    
    
    



}
