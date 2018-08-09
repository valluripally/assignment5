package com.stackroute.datamunger.query;

import java.util.HashMap;

//This class will be used to store the column data types as columnIndex/DataType
public class RowDataTypeDefinitions extends HashMap<Integer, String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Integer,String> rowDataType = new HashMap<Integer,String>();
	
	public RowDataTypeDefinitions(HashMap<Integer,String> rowDataType) {
		this.rowDataType=rowDataType;
	}
	
	public HashMap<Integer,String> getRowDataType(){
		return rowDataType;
	}
	
	public void setRowDataType(HashMap<Integer,String> rowDataType){
		this.rowDataType=rowDataType;
	}
	
	
	
}