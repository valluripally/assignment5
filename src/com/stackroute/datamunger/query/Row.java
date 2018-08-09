package com.stackroute.datamunger.query;

import java.util.HashMap;

//Contains the row object as ColumnName/Value. Hence, HashMap is being used
public class Row extends HashMap<String, String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	HashMap<String,String> row = new HashMap<String,String>();
	
	public Row(){
	}

	public Row(HashMap<String,String> row){
		this.row=row;
	}
	
	public HashMap<String, String> getRow() {
		return row;
	}

	public void setRow(HashMap<String, String> row) {
		this.row = row;
	}
	
	
}