package com.CucumberCraft.API;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import java.util.List;



public class ServicesCalls {
public static void main(String[] args) {

	
		RestAssured.baseURI="https://loyalty.qa.esoa.qcorpaa.aa.com";
		RestAssured.useRelaxedHTTPSValidation();
		ResponseBody response=given().
		queryParam("q", "PST:code").
		queryParam("project","apt").
		queryParam("format","json").
		auth().basic("S1013168","ADEA*Q5uAYJYS").
		when().get("/api/ewcm/v1/$").
		then().assertThat().body("results.assets.metadata.Promotionid.",equalTo("RVGLD")).and().statusCode(200).and().extract().response();
	
	    
		 
		 
		
	}


}
