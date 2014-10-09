package com.tgrange.android.documathon.webservice;

import android.util.Log;

public class WebServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebServiceException(int status) {
		Log.e("Documathon", "Error:" + status);
	}

}
