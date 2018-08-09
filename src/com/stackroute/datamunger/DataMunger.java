package com.stackroute.datamunger;

import com.stackroute.datamunger.query.Query;
import com.stackroute.datamunger.query.parser.QueryParameter;
import com.stackroute.datamunger.query.parser.QueryParser;
import com.stackroute.datamunger.reader.CsvQueryProcessor;

public class DataMunger {
	public static Query query=null;
	public static QueryParameter queryParameter=null; 
	public static QueryParser queryParser=null;
public static String queryString=null;
public static CsvQueryProcessor csvqueryProcessor=null;
	public static void main(String[] args) {

		
		// Read the query from the user
		 queryString="select win_by_runs from data/ipl.csv where win_by_runs=140";
		 System.out.println(queryString);
		/*
		 * Instantiate Query class. This class is responsible for: 1. Parsing the query
		 * 2. Select the appropriate type of query processor 3. Get the resultSet which
		 * is populated by the Query Processor
		 */
		
		Query query = new Query();
		

		/*
		 * Instantiate JsonWriter class. This class is responsible for writing the
		 * ResultSet into a JSON file
		 */
//		JsonWriter jsonWriter = new JsonWriter();
		
		
		/*
		 * call executeQuery() method of Query class to get the resultSet. Pass this
		 * resultSet as parameter to writeToJson() method of JsonWriter class to write
		 * the resultSet into a JSON file
		 */
		
		query.executeQuery(queryString);

		
		
		
//		@SuppressWarnings("rawtypes")
//		HashMap resultSet = query.executeQuery(queryString);
//		HashMap dataset=csvqueryProcessor.getResultSet(queryParameter);
//		
//		Boolean bool = jsonWriter.writeToJson(resultSet);
//		if (bool) {
//			System.out.println("Success");
//		} else {
//			System.out.println("Failure");
//		}
		
	}
}