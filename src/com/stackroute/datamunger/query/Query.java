package com.stackroute.datamunger.query;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.stackroute.datamunger.query.parser.QueryParameter;
import com.stackroute.datamunger.query.parser.QueryParser;
import com.stackroute.datamunger.reader.CsvQueryProcessor;

public class Query {
	
QueryParser queryparser=null;
QueryParameter queryParameter=null;
CsvQueryProcessor queryprocessor=null; 
	/*
	 * This method will: 
	 * 1.parse the query and populate the QueryParameter object
	 * 2.Based on the type of query, it will select the appropriate Query processor.
	 * 
	 * In this example, we are going to work with only one Query Processor which is
	 * CsvQueryProcessor, which can work with select queries containing zero, one or
	 * multiple conditions
	 */
	@SuppressWarnings("rawtypes")
	public HashMap executeQuery(String queryString) {
	
		/* instantiate QueryParser class */
		
		//QueryParser queryParser = new QueryParser();
		
		
		/*
		 * call parseQuery() method of the class by passing the queryString which will
		 * return object of QueryParameter
		 */
		
		//QueryParameter queryParameter = new QueryParameter();
		//QueryParameter queryParameter =null;
		
	 queryParameter = queryparser.parseQuery(queryString);
	 
		//System.out.println(queryParameter);
		
		/*
		 * Check for Type of Query based on the QueryParameter object. In this
		 * assignment, we will process only queries containing zero, one or multiple
		 * where conditions i.e. conditions without aggregate functions, order by clause
		 * or group by clause
		 */
				
		
		
		/*
		 * call the getResultSet() method of CsvQueryProcessor class by passing the
		 * QueryParameter Object to it. This method is supposed to return resultSet
		 * which is a HashMap
		 */
		//CsvQueryProcessor csvQueryProcessor = new CsvQueryProcessor();
		//DataSet dataSet = csvQueryProcessor.getResultSet(queryParameter);
		
		DataSet dataSet = queryprocessor.getResultSet(queryParameter);
		System.out.println(queryParameter);
		LinkedHashMap<Long,Row> resultSet= dataSet.getDataSet();
		
		
		System.out.println(resultSet.toString());
		
		
		return resultSet;
		
	}

}