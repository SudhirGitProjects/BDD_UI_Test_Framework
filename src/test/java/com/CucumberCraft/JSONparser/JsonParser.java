package com.CucumberCraft.JSONparser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class JsonParser {
	static ArrayList<String> content = new ArrayList<String>();
	
//public static ArrayList<String> parsetJsonText(String jSONurl)
	public static ArrayList<String> parser(String Jsonpath)
		{
			//inline will store the JSON data streamed in string format
			String inline = "";
		
			try
			{
				URL url = new URL(Jsonpath);
				//Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				//Set the request to GET or POST as per the requirements
				conn.setRequestMethod("GET");
				//Use the connect method to create the connection bridge
				conn.connect();
				//Get the response status of the Rest API
				int responsecode = conn.getResponseCode();
				System.out.println("Response code is: " +responsecode);
				
				//Iterating condition to if response code is not 200 then throw a runtime exception
				//else continue the actual process of getting the JSON data
				if(responsecode != 200)
					throw new RuntimeException("HttpResponseCode: " +responsecode);
				else
				{
					//Scanner functionality will read the JSON data from the stream
					Scanner sc = new Scanner(url.openStream());
					while(sc.hasNext())
					{
						inline+=sc.nextLine();
					}
					System.out.println("\nJSON Response in String format"); 
					System.out.println(inline);
					//Close the stream when reading the data has been finished
					sc.close();
				}
				
				//JSONParser reads the data from string object and break each data into key value pairs
				//JSONParser parse = new JSONParser();
				//Type caste the parsed json data in json object
				//JSONObject jobj = (JSONObject)parse.parse(inline);
				//if(inline.contains("\"PromotionOrChallengeCode\"")) {
				//	int i=inline.lastIndexOf("PromotionOrChallengeCode");
				//	String s=inline.substring(i, 51);
				//	String promocode=s.replace("PromotionOrChallengeCode\": \"", "").replace("\"", "");
					//content.add(promocode);
					
				//}
				JSONObject jobj = (JSONObject) JSONValue.parseWithException(inline);
				System.out.println(jobj.get("Content"));
				JSONObject ContentJsonObject=(JSONObject) jobj.get("Content");
				
			
				
				//Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
				JSONArray mainContentArray = (JSONArray) ContentJsonObject.get("MainContent");
				JSONArray TermsAndConditionsArray = (JSONArray) ContentJsonObject.get("TermsAndConditions");
				JSONArray RewardsUponRegistrationArray = (JSONArray) ContentJsonObject.get("RewardsUponRegistration");
				JSONArray TrackerCardArray = (JSONArray) ContentJsonObject.get("TrackerCard");
				JSONArray CompletionMessageArray = (JSONArray) ContentJsonObject.get("CompletionMessage");
				
				System.out.println("MainContent");
				for(int i=0;i<mainContentArray.size();i++) {
					
					JSONObject mainContentJsonOject = (JSONObject)mainContentArray.get(i);
					
					Map<?,?> data = ((Map<?,?>)mainContentArray.get(i)); 
					if(data.containsKey("ListElements")) {
						JSONArray listElements= (JSONArray) mainContentJsonOject.get("ListElements");
						for(int j=0;j<listElements.size();j++) 
						{
							Map<?,?> data1= ((Map<?,?>)listElements.get(j)); 
						content.add(String.valueOf(data1.get("Value")));
						}
					 }
				
			        if(data.containsKey("Value"))
			        content.add(String.valueOf(data.get("Value")));
			        
			        if(data.containsKey("Paragraph")) {
			        content.add(String.valueOf(data.get("Paragraph")));
			        
			        }
			        if(data.containsKey("TextDisplay")) {
				    content.add(String.valueOf(data.get("TextDisplay")));
			        }
				
				}
				
				System.out.println("TermsAndConditions");
				for(int i=0;i<TermsAndConditionsArray.size();i++) {
					
					JSONObject termsAndConditionsOject = (JSONObject)TermsAndConditionsArray.get(i);
					
					Map<?,?> data = ((Map<?,?>)TermsAndConditionsArray.get(i)); 
					if(data.containsKey("ListElements")) {
						JSONArray listElements= (JSONArray) termsAndConditionsOject.get("ListElements");
						for(int j=0;j<listElements.size();j++) 
						{
							Map<?,?> data1= ((Map<?,?>)listElements.get(j)); 
						content.add(String.valueOf(data1.get("Value")));
						}
					 }
				
			        if(data.containsKey("Value"))
			        content.add(String.valueOf(data.get("Value")));
			        
			        if(data.containsKey("Paragraph")) {
			        content.add(String.valueOf(data.get("Paragraph")));
			        
			        }
			        if(data.containsKey("TextDisplay")) {
				    content.add(String.valueOf(data.get("TextDisplay")));
			        }
				
				}
					

				System.out.println("RewardsUponRegistration");
				for(int i=0;i<RewardsUponRegistrationArray.size();i++) {
					
					JSONObject RewardsUponRegistrationOject = (JSONObject)RewardsUponRegistrationArray.get(i);
					
					Map<?,?> data = ((Map<?,?>)RewardsUponRegistrationArray.get(i)); 
					if(data.containsKey("ListElements")) {
						JSONArray listElements= (JSONArray) RewardsUponRegistrationOject.get("ListElements");
						for(int j=0;j<listElements.size();j++) 
						{
							Map<?,?> data1= ((Map<?,?>)listElements.get(j)); 
						content.add(String.valueOf(data1.get("Value")));
						}
					 }
				
			        if(data.containsKey("Value"))
			        content.add(String.valueOf(data.get("Value")));
			        
			        if(data.containsKey("Paragraph")) {
			        content.add(String.valueOf(data.get("Paragraph")));
			        
			        }
			        if(data.containsKey("TextDisplay")) {
				    content.add(String.valueOf(data.get("TextDisplay")));
			        }
				
				}
				System.out.println("TrackerCard");
				for(int i=0;i<TrackerCardArray.size();i++) {
					
					JSONObject TrackerCardOject = (JSONObject)TrackerCardArray.get(i);
					
					Map<?,?> data = ((Map<?,?>)TrackerCardArray.get(i)); 
					if(data.containsKey("ListElements")) {
						JSONArray listElements= (JSONArray) TrackerCardOject.get("ListElements");
						for(int j=0;j<listElements.size();j++) 
						{
							Map<?,?> data1= ((Map<?,?>)listElements.get(j)); 
						content.add(String.valueOf(data1.get("Value")));
						}
					 }
				
			        if(data.containsKey("Value"))
			        content.add(String.valueOf(data.get("Value")));
			        
			        if(data.containsKey("Paragraph")) {
			        content.add(String.valueOf(data.get("Paragraph")));
			        
			        }
			        if(data.containsKey("TextDisplay")) {
				    content.add(String.valueOf(data.get("TextDisplay")));
			        }
				
				}
				
				System.out.println("CompletionMessage");
				for(int i=0;i<CompletionMessageArray.size();i++) {
					
					JSONObject CompletionMessageOject = (JSONObject)CompletionMessageArray.get(i);
					
					Map<?,?> data = ((Map<?,?>)CompletionMessageArray.get(i)); 
					if(data.containsKey("ListElements")) {
						JSONArray listElements= (JSONArray) CompletionMessageOject.get("ListElements");
						for(int j=0;j<listElements.size();j++) 
						{
							Map<?,?> data1= ((Map<?,?>)listElements.get(j)); 
						content.add(String.valueOf(data1.get("Value")));
						}
					 }
				
			        if(data.containsKey("Value"))
			        content.add(String.valueOf(data.get("Value")));
			        
			        if(data.containsKey("Paragraph")) {
			        content.add(String.valueOf(data.get("Paragraph")));
			        
			        }
			        if(data.containsKey("TextDisplay")) {
				    content.add(String.valueOf(data.get("TextDisplay")));
			        }
				
				}
				for(String con: content) {
				System.out.println(con);
				}		
				conn.disconnect();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			//return content;
			return content;
		}
}
