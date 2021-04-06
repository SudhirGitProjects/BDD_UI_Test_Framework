package com.CucumberCraft.ExcelReadWrite;

import org.apache.commons.validator.routines.UrlValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DataSourceDecider {

	static Logger log;
	static String obtainedUrl;
	static String obtainedData;

	static {
		log = LogManager.getLogger(DataSourceDecider.class);
	}

	public static String dataFinder(String data) throws Exception {
		
		
		 if(!(data.startsWith("#") || data.startsWith("$")))
		 {
		 return data;
			}

		else if(data.startsWith("#")){
		
				String s=data.substring(1);
			
			obtainedData= ExcelReadWrite.getdata(s);
			
			} 
		else if(data.startsWith("$")){
			String s=data.substring(1);
			obtainedData=DbReadWrite.getdata(s);
			
		}
		return obtainedData;
		
		
	}


	public static String urlFinder(String url) throws Exception {
	
	
		String s=url.substring(1);
		if(!(url.startsWith("#") || url.startsWith("$")) )
		{
		return urlChecker(url); //check url is valid else throws an exception
		}
		else if(url.startsWith("#")){
			
			obtainedUrl= ExcelReadWrite.getdata(s);
			return urlChecker(obtainedUrl);
			} 
		else if(url.startsWith("$")){
			obtainedUrl=DbReadWrite.getdata(s);
			return urlChecker(obtainedUrl);
		}
		throw new UnsupportedOperationException("This url: "+"\""+obtainedUrl+"\""+ " is in invalid format");
	}

	
	//check url is valid else throws an exception
	private static String urlChecker(String url) {
		UrlValidator urlValidator = new UrlValidator();
	    if (urlValidator.isValid(url)) 
	    {
	    	log.debug("Valid url....");
	    	return url;
	    } 
	    else {
	       throw new UnsupportedOperationException("This url: "+"\""+url+"\""+ " is in invalid format");
	    }
	}

}

