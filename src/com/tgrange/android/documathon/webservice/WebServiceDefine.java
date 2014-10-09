package com.tgrange.android.documathon.webservice;


public class WebServiceDefine {
	private static String API_URL = "http://api.documathon.tgrange.com/";
	private static String ROUTE_ALL_PROJECTS = "projects/";
	
	public static String getAllProjects(){
		return API_URL + ROUTE_ALL_PROJECTS;
	}
}
