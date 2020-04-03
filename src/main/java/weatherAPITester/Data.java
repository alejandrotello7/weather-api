package weatherAPITester;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Data {
	
	private static JSONParser parse = new JSONParser();	
	private static JSONObject dataObject;
	
	public static void parser(String dataRetrieved) throws ParseException{
		dataObject = (JSONObject)parse.parse(dataRetrieved);
	}
	
	public static String getCountry() {
		
		String[] arrOfStr = splitter((String) dataObject.get("sys").toString());
		return null;
		
	}
	
	
	private static String[] splitter(String input) {
		
		String[] arrOfStr = input.split(",", -2);
		return arrOfStr;
			
	}
}
