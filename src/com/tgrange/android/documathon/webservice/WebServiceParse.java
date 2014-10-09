package com.tgrange.android.documathon.webservice;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.tgrange.android.documathon.model.Project;

public class WebServiceParse {
	private JSONObject obj;

	public WebServiceParse(JSONObject obj) throws WebServiceException {
		super();
		this.obj = obj;
		try {
			if(obj.getBoolean("error"))
				throw new WebServiceException(obj.getInt("status"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void parseForAllProjects(){
		Log.i("Test",obj.toString());
	}

	public ArrayList<Project> getAllProjects() {
		ArrayList<Project> list = new ArrayList<Project>();
		try {
			JSONArray datas = obj.getJSONArray("datas");
			for (int i = 0 ; i < datas.length() ; i++) {
			    JSONObject jsonProject = datas.getJSONObject(i);
			    Project project = new Project(jsonProject.getInt("id"), 
			    		jsonProject.getString("name"), 
			    		jsonProject.getLong("start"), 
			    		jsonProject.getLong("date"), 
			    		jsonProject.getString("lang"));
			    list.add(project);
			}
			return list;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
