package com.stackroute.datamunger.query;

import java.util.LinkedHashMap;

//This class will be acting as the DataSet containing multiple rows
public class DataSet extends LinkedHashMap<Long, Row> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LinkedHashMap<Long,Row> dataSet = new LinkedHashMap<Long,Row>();
	
	
	public DataSet() {
		
	}
	
	public DataSet(LinkedHashMap<Long, Row> dataSet) {
		this.dataSet=dataSet;
//		for(Map.Entry<Long, Row> entry : dataSet.entrySet()) {
//		    long key1 = entry.getKey();
//		    Row value1 = entry.getValue();
//		    System.out.println(key1);
//		    HashMap<String,String> values =  value1.getRow();
//		    for(Map.Entry<String, String> entry2 : values.entrySet()) {
//		    	String a=entry2.getKey();
//		    	String b=entry2.getValue();
//		    	System.out.println(a+" : "+b);
//		    }
//		    System.out.println("-----------");
//		}
	}
	
	public LinkedHashMap<Long, Row> getDataSet() {
		return dataSet;
	}
	public void setDataSet(LinkedHashMap<Long, Row> dataSet) {
		this.dataSet = dataSet;
	}
	
	
 
	
}