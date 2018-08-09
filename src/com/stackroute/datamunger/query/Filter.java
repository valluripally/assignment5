package com.stackroute.datamunger.query;

//This class contains methods to evaluate expressions
public class Filter {
	
	/* 
	 * The evaluateExpression() method of this class is responsible for evaluating 
	 * the expressions mentioned in the query. It has to be noted that the process 
	 * of evaluating expressions will be different for different data types. there 
	 * are 6 operators that can exist within a query i.e. >=,<=,<,>,!=,= This method 
	 * should be able to evaluate all of them. 
	 * Note: while evaluating string expressions, please handle uppercase and lowercase 
	 * 
	 */
	
	boolean result=false;
	
	public boolean evaluateExpressions(String propertyValue,String condition, String value, String dataType) {
		boolean bool=false;
		
		switch(dataType) {
		
			case "java.lang.String": switch(condition) {
										case "=": bool=equalToString(value,propertyValue);
													break;
										case "!=": bool=notEqualToString(value,propertyValue);
													break;
										default: bool=false;
									} break;
			case "java.lang.Integer": switch(condition) {
										case "=": bool=equalToInt(value,propertyValue);
													break;
										case "!=": bool=notEqualToInt(value,propertyValue);
													break;
										case ">": bool=greaterThanInt(value,propertyValue);
													break;
										case ">=": bool=greaterThanEqualToInt(value,propertyValue);
													break;
										case "<": bool=lessThanInt(value,propertyValue);
													break;
										case "<=": bool=lessThanEqualToInt(value,propertyValue);
													break;
										default: bool=false;

									}break;
									
			case "java.lang.Double": switch(condition) {
										case "=": bool=equalToDouble(value,propertyValue);
													break;
										case "!=": bool=notEqualToDouble(value,propertyValue);
													break;
										case ">": bool=greaterThanDouble(value,propertyValue);
													break;
										case ">=": bool=greaterThanEqualToDouble(value,propertyValue);
													break;
										case "<": bool=lessThanDouble(value,propertyValue);
													break;
										case "<=": bool=lessThanEqualToDouble(value,propertyValue);
													break;
										default: bool=false;
										}break;
										
			case "java.util.Date": switch(condition) {
										case "=": bool=equalToDate(value,propertyValue);
													break;
										case "!=": bool=notEqualToDate(value,propertyValue);
													break;
										case ">": bool=greaterThanDate(value,propertyValue);
													break;
										case ">=": bool=greaterThanEqualToDate(value,propertyValue);
													break;
										case "<": bool=lessThanDate(value,propertyValue);
													break;
										case "<=": bool=lessThanEqualToDate(value,propertyValue);
													break;
										default: bool=false;
										}break;
										
			case "java.lang.Object": switch(condition) {
										case "=": bool=equalToObject(value,propertyValue);
													break;
										case "!=": bool=notEqualToObject(value,propertyValue);
													break;
										default: bool=false;
										}break;	
			default: bool=false;
		}
		
		return bool;
	}
	
	
	//Method containing implementation of equalTo operator
	private boolean equalToString(String value,String propertyValue) {
		if(value.equals(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean equalToInt(String value,String propertyValue) {
		if(Integer.parseInt(value) == Integer.parseInt(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean equalToDouble(String value,String propertyValue) {
		if(Double.parseDouble(value) == Double.parseDouble(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean equalToObject(String value,String propertyValue) {
		if(value.equals(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean equalToDate(String value,String propertyValue) {
		if(value.compareTo(propertyValue)==0) {
			result=true;
		}
		return result;
	}
	
	//Method containing implementation of notEqualTo operator
	
	private boolean notEqualToString(String value,String propertyValue) {
		if(!value.equals(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean notEqualToInt(String value,String propertyValue) {
		if(Integer.parseInt(value) != Integer.parseInt(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean notEqualToDouble(String value,String propertyValue) {
		if(Double.parseDouble(value) != Double.parseDouble(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean notEqualToObject(String value,String propertyValue) {
		if(!value.equals(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean notEqualToDate(String value,String propertyValue) {
		if(value.compareTo(propertyValue)!=0) {
			result=true;
		}
		return result;
	}
	
	
	
	//Method containing implementation of greaterThan operator
	
	private boolean greaterThanInt(String value,String propertyValue) {
		if(Integer.parseInt(value) > Integer.parseInt(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean greaterThanDouble(String value,String propertyValue) {
		if(Double.parseDouble(value) > Double.parseDouble(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean greaterThanDate(String value,String propertyValue) {
		if(value.compareTo(propertyValue)>0) {
			result=true;
		}
		return result;
	}
	
	
	
	//Method containing implementation of greaterThanOrEqualTo operator
	
	private boolean greaterThanEqualToInt(String value,String propertyValue) {
		if(Integer.parseInt(value) >= Integer.parseInt(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean greaterThanEqualToDouble(String value,String propertyValue) {
		if(Double.parseDouble(value) >= Double.parseDouble(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean greaterThanEqualToDate(String value,String propertyValue) {
		if(value.compareTo(propertyValue)>=0) {
			result=true;
		}
		return result;
	}
	
	
	
	//Method containing implementation of lessThan operator
	  
	private boolean lessThanInt(String value,String propertyValue) {
		if(Integer.parseInt(value) < Integer.parseInt(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean lessThanDouble(String value,String propertyValue) {
		if(Double.parseDouble(value) < Double.parseDouble(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean lessThanDate(String value,String propertyValue) {
		if(value.compareTo(propertyValue)<0) {
			result=true;
		}
		return result;
	}
	
	
	//Method containing implementation of lessThanOrEqualTo operator
	
	private boolean lessThanEqualToInt(String value,String propertyValue) {
		if(Integer.parseInt(value) < Integer.parseInt(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean lessThanEqualToDouble(String value,String propertyValue) {
		if(Double.parseDouble(value) < Double.parseDouble(propertyValue)) {
			result=true;
		}
		return result;
	}
	
	private boolean lessThanEqualToDate(String value,String propertyValue) {
		if(value.compareTo(propertyValue)<=0) {
			result=true;
		}
		return result;
	}
	
}