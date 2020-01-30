package com.assurity.apis;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Method;
import io.restassured.response.Response;

/**
* Categories class is the middle layer between the testcase and the API.
*/
public class Categories {
	
	/**
	* Calls the GET API with query parameters and returns the response.
	*
	* @param  qParams   Query parameters to the API
	* @return           Response from the API
	*/
	public Response getCategoryDetails(Map<String, String> qParams){
		RestAssured.baseURI = "https://api.tmsandbox.co.nz/v1";
		RequestSpecification connection = RestAssured.given();
		connection.queryParams(qParams);
		return connection.request(Method.GET, "/Categories/6327/Details.json");
	}
}
