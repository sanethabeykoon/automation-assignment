package com.assurity.testcases;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import com.assurity.apis.Categories;

/**
* AssureGetCategoryDetails class is the testcase to assure the API.
*/
public class AssureGetCategoryDetails {

	/**
	* Keeps the response converted into a JSON.
	*/
	private JsonPath responseJson;
	
	/**
	* Asserts the response from the API.
	*/
	@Test(priority=1)
	public void assertResponse(){
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("catalogue", "false");
		
		Response response = new Categories().getCategoryDetails(queryParams);
		
		Assert.assertEquals(response.getStatusCode(), 200, "Response is NOT success. Status Code : " + response.getStatusCode());
		
		responseJson = response.jsonPath();
	}	
	
	/**
	* Asserts 'Name' in the response.
	*/
	@Test(priority=2, dependsOnMethods = { "assertResponse" })
	public void assertName() {
		Assert.assertEquals(responseJson.get("Name"), "Carbon credits", "Name is NOT equal to 'Carbon credits'" + responseJson.get("Name"));
	}
	
	/**
	* Asserts 'CanRelist' in the response.
	*/
	@Test(priority=3, dependsOnMethods = { "assertResponse" })
	public void assertCanRelist() {
		Assert.assertEquals(responseJson.get("CanRelist"), true, "CanRelist is NOT equal to 'true'" + responseJson.get("CanRelist"));
	}
	
	/**
	* Asserts 'Description' in the response.
	*/
	@Test(priority=4, dependsOnMethods = { "assertResponse" })
	public void assertDescription() {
		ArrayList<Map<Object, Object>> promotions = new ArrayList<Map<Object, Object>>();
		promotions = responseJson.get("Promotions");
		
		String description = "";
		
		outerloop:
		for(int i=0;i<promotions.size();i++) {
			
			for(Map.Entry<Object, Object> entry : promotions.get(i).entrySet()){
				
				if(entry.getKey().toString().equals("Description")) {
					description = entry.getValue().toString();
				}
				
				if(entry.getKey().toString().equals("Name") && entry.getValue().toString().equals("Gallery")) {
					break outerloop;
				}
				
			}
			
		}
		
		Assert.assertEquals(description.contains("2x larger image"), true, "Description does NOT contain '2x larger image'. Description : " + description);
	}
}
