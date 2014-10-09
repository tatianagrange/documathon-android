package com.tgrange.android.documathon.webservice;

import org.json.JSONObject;

public interface WebServiceEvent {
	public void onResult(JSONObject obj, String url);
}
