package com.tgrange.android.documathon.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class WebServiceCall extends AsyncTask<String, String, Void> {
	private String url;
	private InputStream inputStream = null;
	private String result = ""; 
	private WebServiceEvent event;

	public WebServiceCall(String url,WebServiceEvent event) {
		super();
		this.url = url;
		this.event = event;
	}

	@Override
	protected Void doInBackground(String... params) {
		ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();

		try {
			// Set up HTTP post

			// HttpClient is more then less deprecated. Need to change to URLConnection
			HttpClient httpClient = new DefaultHttpClient();

			HttpGet httpGet = new HttpGet(url);
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();

			// Read content & Log
			inputStream = httpEntity.getContent();
		} catch (UnsupportedEncodingException e1) {
			Log.e("UnsupportedEncodingException", e1.toString());
			e1.printStackTrace();
		} catch (ClientProtocolException e2) {
			Log.e("ClientProtocolException", e2.toString());
			e2.printStackTrace();
		} catch (IllegalStateException e3) {
			Log.e("IllegalStateException", e3.toString());
			e3.printStackTrace();
		} catch (IOException e4) {
			Log.e("IOException", e4.toString());
			e4.printStackTrace();
		}
		// Convert response to string using String Builder
		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
			StringBuilder sBuilder = new StringBuilder();

			String line = null;
			while ((line = bReader.readLine()) != null) {
				sBuilder.append(line + "\n");
			}

			inputStream.close();
			result = sBuilder.toString();

		} catch (Exception e) {
			Log.e("StringBuilding & BufferedReader", "Error converting result " + e.toString());
		}
		return null;
	}

	protected void onPostExecute(Void v) {
		//parse JSON data
		try {
			JSONObject obj = new JSONObject(result);
			event.onResult(obj, url);
		} catch (JSONException e) {
			Log.e("JSONException", "Error: " + e.toString());
		} // catch (JSONException e)
	} 
}
