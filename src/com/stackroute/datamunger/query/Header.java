package com.stackroute.datamunger.query;

import java.util.HashMap;

//Header class containing a Collection containing the headers
public class Header extends HashMap<String, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private HashMap<String, Integer> headers = new HashMap<String,Integer>();

	public Header() {
	}

	public Header(HashMap<String,Integer> headers) {
		this.headers = headers;
	}

	public HashMap<String,Integer> getHeaders() {
		return headers;
	}

	public void setHeaders(HashMap<String,Integer> headers) {
		this.headers = headers;
	}
	
	
}