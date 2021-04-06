package com.CucumberCraft.API;

import java.net.URI;

public class LscsService {

	private static String baseURI;
	private static String resourcePath;

	public static String getBaseURI() {
		return baseURI;
	}

	public static void setBaseURI(String baseURI) {
		LscsService.baseURI = baseURI;
	}

	public static String getResourcePath() {
		return resourcePath;
	}

	public static void setResourcePath(String resourcePath) {
		LscsService.resourcePath = resourcePath;
	}

	
}
