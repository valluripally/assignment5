package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.stackroute.datamunger.query.DataSet;
import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Filter;
import com.stackroute.datamunger.query.Header;
import com.stackroute.datamunger.query.Row;
import com.stackroute.datamunger.query.RowDataTypeDefinitions;
import com.stackroute.datamunger.query.parser.QueryParameter;
import com.stackroute.datamunger.query.parser.Restriction;

public class CsvQueryProcessor implements QueryProcessingEngine {

	/*
	 * This method will take QueryParameter object as a parameter which contains the
	 * parsed query and will process and populate the ResultSet
	 */
	DataSet dataSet = new DataSet();
	public DataSet getResultSet(QueryParameter queryParameter) {

		//DataSet dataSet = null;
		BufferedReader br = null;
		int count = 0;
		String str=null;
		StringBuffer headerBfr= new StringBuffer();
		StringBuffer dataRowDataTypeBfr = new StringBuffer();
		String[] headerStr = null;
		String[] dataRowDataTypeStr = null;
		Header header = null;
		HashMap<Integer, String> dataTypeDefinitionsMap = null;
		RowDataTypeDefinitions rowDataTypeDefinitions = null;
		long rownum=1;
		/*
		 * initialize BufferedReader to read from the file which is mentioned in
		 * QueryParameter. Consider Handling Exception related to file reading.
		 */
		try {
			br = new BufferedReader(new FileReader(queryParameter.getFileName()));

			/*
			 * read the first line which contains the header. Please note that the headers
			 * can contain spaces in between them. For eg: city, winner
			 */

			/*
			 * read the next line which contains the first row of data. We are reading this
			 * line so that we can determine the data types of all the fields. Please note
			 * that ipl.csv file contains null value in the last column. If you do not
			 * consider this while splitting, this might cause exceptions later
			 */
			headerBfr = new StringBuffer();
			//dataRowDataTypeBfr = new StringBuffer();
			br.mark(1);
			count = 1;
			while ((str = br.readLine()) != null && count < 3) {
				// read the second line
				if (count == 1) {
					headerBfr.append(str);
					headerStr = headerBfr.toString().trim().split("[,]+");//("\\s*,\\s")
				} else if (count == 2) {
					dataRowDataTypeBfr.append(str).append(" ,");
					dataRowDataTypeStr = dataRowDataTypeBfr.toString().trim().split("[,]+");
				}
				count++;
			}
			br.reset();
//System.out.println(dataRowDataTypeStr);
			/*
			 * populate the header Map object from the header array. header map is having
			 * data type <String,Integer> to contain the header and it's index.
			 */
			HashMap<String, Integer> headerMap = new HashMap<String, Integer>();
			for (int i = 0; i < headerStr.length; i++) {
				headerMap.put(headerStr[i], i);
			}
			header = new Header(headerMap);

			/*
			 * We have read the first line of text already and kept it in an array. Now, we
			 * can populate the RowDataTypeDefinition Map object. RowDataTypeDefinition map
			 * is having data type <Integer,String> to contain the index of the field and
			 * it's data type. To find the dataType by the field value, we will use
			 * getDataType() method of DataTypeDefinitions class
			 */
			dataTypeDefinitionsMap = new HashMap<Integer, String>();
			for (int i = 0; i < dataRowDataTypeStr.length; i++) {
				dataTypeDefinitionsMap.put(i, DataTypeDefinitions.getDataType(dataRowDataTypeStr[i]).toString());
			}
			rowDataTypeDefinitions = new RowDataTypeDefinitions(dataTypeDefinitionsMap);

			/*
			 * once we have the header and dataTypeDefinitions maps populated, we can start
			 * reading from the first line. We will read one line at a time, then check
			 * whether the field values satisfy the conditions mentioned in the query,if
			 * yes, then we will add it to the resultSet. Otherwise, we will continue to
			 * read the next line. We will continue this till we have read till the last
			 * line of the CSV file.
			 */
br.mark(1);
br.reset();
			/* reset the buffered reader so that it can start reading from the first line */

			/*
			 * skip the first line as it is already read earlier which contained the header
			 */
String line;
String headrline=br.readLine();
while((line=br.readLine())!=null) {
	line+=",";

/* read one line at a time from the CSV file till we have any lines left */

			/*
			 * once we have read one line, we will split it into a String Array. This array
			 * will continue all the fields of the row. Please note that fields might
			 * contain spaces in between. Also, few fields might be empty.
			 */
			String []lineArray=line.trim().split("//s*,//s*");
			/*
			 * if there are where condition(s) in the query, test the row fields against
			 * those conditions to check whether the selected row satisfies the conditions
			 */
			if(queryParameter.getRestrictions()!=null){
				
			}

			/*
			 * from QueryParameter object, read one condition at a time and evaluate the
			 * same. For evaluating the conditions, we will use evaluateExpressions() method
			 * of Filter class. Please note that evaluation of expression will be done
			 * differently based on the data type of the field. In case the query is having
			 * multiple conditions, you need to evaluate the overall expression i.e. if we
			 * have OR operator between two conditions, then the row will be selected if any
			 * of the condition is satisfied. However, in case of AND operator, the row will
			 * be selected only if both of them are satisfied.
			 */
			
			/*
			 * check for multiple conditions in where clause for eg: where salary>20000 and
			 * city=Bangalore for eg: where salary>20000 or city=Bangalore and dept!=Sales
			 */
			count=1;
			LinkedHashMap<Long, Row> result = new LinkedHashMap<Long,Row>();
			while ((str = br.readLine()) != null) {
				
				if (count == 1) {
					//Ignore header line
					count++;
					continue;
				}
				
				Filter filter=null;
				boolean condition[]= null;
				String logicalOperators[]=null;
				List<String> logicalOperatorslist=null;
				int index=0;
				String data[]=null;
				StringBuffer dataBfr = new StringBuffer();
				boolean finalcondition=false;
				Row rowMapObj = new Row();
				//logical operators
				logicalOperatorslist= queryParameter.getLogicalOperators();
				if(logicalOperatorslist!=null) {
					logicalOperators=new String[logicalOperatorslist.size()];
					int m=0;
					for(String string: logicalOperatorslist ) {
						logicalOperators[m]=string;
						m++;
					}
					condition= new boolean[logicalOperators.length+1];
				}
				else if(logicalOperatorslist==null && headerMap.containsKey("where")){
					condition= new boolean[1];
				}
				
				dataBfr.append(str).append(" ,");
				data = dataBfr.toString().trim().split("[,]+");
				
				//restrictions
				if(queryParameter.getRestrictions()!=null) {
					
					Iterator<Restriction> iter= null;
					filter = new Filter();
					iter = queryParameter.getRestrictions().iterator();
					int n=0;
					while (iter.hasNext()) {
						Iterator<Map.Entry<String, Integer>> iterator = header.getHeaders().entrySet().iterator();
						while (iterator.hasNext()) {
							//Map.Entry<String, Integer> myEntry = iterator.next();
							Map.Entry<String, Integer> myEntry = iterator.next();
						
							if (myEntry.getKey().equals(iter.next().getPropertyName())) {
								index = myEntry.getValue();
							}
						}
						}
						condition[n] = filter.evaluateExpressions(iter.next().getPropertyValue(),iter.next().getCondition(), data[index], DataTypeDefinitions.getDataType(dataRowDataTypeStr[index]).toString());
						n++;
					}
				
				
				//final condition
				if(condition!=null && condition.length>1) {
					for(int i=0;i<logicalOperators.length;i++) {
						for(int j=0;j<condition.length-1;j++) {
							if(logicalOperators[i]=="and") {
								finalcondition=condition[j]&condition[j+1];
								break;
							}
							else if(logicalOperators[i]=="or") {
								finalcondition=condition[j]|condition[j+1];
								break;
							}
						}
					}
				}
				else if(condition!=null && condition.length==1) {
					finalcondition=condition[0];
				}
				else {
					finalcondition=true;
				}
				
				
				//add data to object
				if(!finalcondition) {
					continue;
				}
				else {
					String[] field =null;
					List<String> fields = null;
					HashMap<String,String> rowMap =null;
					int l=0;
					
					//get fields
					fields=queryParameter.getFields();
					field =new String[fields.size()];
					l=0;
					for (String string : fields) {
						field[l]=string;
						l++;
					}
						
					
					
					//get all columns
					rowMap = new HashMap<String,String>();
					if(field[0].equals("*"))
					{
						for(int i=0;i<headerStr.length;i++) {
							rowMap.put(headerStr[i], data[i]);		
						}
						
					}
					//get selected columns
					else{
						l=0;
						for(int i=0;i<headerStr.length;i++) {
							for(int j=0;j<field.length;j++) {
								if(headerStr[i].equals(field[j])) {
									rowMap.put(headerStr[i], data[i]);
									l++;
								}
							}
						}
					}
					rowMapObj = new Row(rowMap);
					result.put(rownum, rowMapObj);
					System.out.println(rownum+"="+result.get(rownum).getRow());
				}
				rownum++;
				str="";
			}		

			/*
			 * if the overall condition expression evaluates to true, then we need to check
			 * if all columns are to be selected(select *) or few columns are to be
			 * selected(select col1,col2). In either of the cases, we will have to populate
			 * the row map object. Row Map object is having type <String,String> to contain
			 * field Index and field value for the selected fields. Once the row object is
			 * populated, add it to DataSet Map Object. DataSet Map object is having type
			 * <Long,Row> to hold the rowId (to be manually generated by incrementing a Long
			 * variable) and it's corresponding Row Object.
			 */
			dataSet = (DataSet) result;
			br.close();
}
} catch (Exception e) {
			e.printStackTrace();
		}

		/* return data set object */
		return dataSet;
	}
}