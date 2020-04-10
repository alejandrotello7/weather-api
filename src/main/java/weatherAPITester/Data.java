package weatherAPITester;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import beans.Coord;
import beans.Sys;
import beans.Weather;

public class Data {

	private static JSONParser parse = new JSONParser();	
	private static JSONObject dataObject;

	public static void parser(String dataRetrieved) throws ParseException{
		dataObject = (JSONObject)parse.parse(dataRetrieved);
		setBeans();
	}

	public static String getCountry() {
		String[] arrOfStr = splitter((String) dataObject.get("sys").toString());
		return null;
	}


	private static String[] splitter(String input) {
		String[] arrOfStr = input.split(",", -2);
		return arrOfStr;

	}

	private static void setBeans() {
		
		//sys
		String sys = (String) dataObject.get("sys").toString();
		String[] sysArray = removeBrackets(sys);
		HashMap<String, String >propertyHashMap = getHashMap(sysArray);
		Sys.setCountry(propertyHashMap.get("country"));
		Sys.setSunrise(propertyHashMap.get("sunrise"));
		Sys.setSunset(propertyHashMap.get("sunset"));
		Sys.setId(propertyHashMap.get("id"));
		Sys.setType(propertyHashMap.get("type"));
		
		//coord
		String coord = (String) dataObject.get("coord").toString();
		String[] coordArray = removeBrackets(coord);
		propertyHashMap = getHashMap(coordArray);
		Coord.setLongitude(propertyHashMap.get("lon"));
		Coord.setLatitude(propertyHashMap.get("lat"));
		
		//weather
		String weather = (String) dataObject.get("weather").toString();
		String[] weatherArray = weather.split(",", -2);
		String temp = weatherArray[0].replace("[","");
		weatherArray[0] = temp;
		temp = weatherArray[weatherArray.length-1].replace("]","");
		weatherArray[weatherArray.length-1] = temp;
		
		for(int i=0; i<weatherArray.length; i++ ) {
			temp = weatherArray[i].replace("\"","");
			weatherArray[i]=temp;
		}
		propertyHashMap = getHashMap(weatherArray);
		Weather.setId(propertyHashMap.get("id"));
		Weather.setMain(propertyHashMap.get("main"));
		Weather.setDescription(propertyHashMap.get("description"));
		Weather.setIcon(propertyHashMap.get("icon"));
		
	
		
	}
	
	private static String[] removeBrackets(String property) {
		String[] arrOfStr = property.split(",", -2); //separar por comas
		String temp = arrOfStr[0].replace("{",""); 
		arrOfStr[0]=temp;
		temp = arrOfStr[arrOfStr.length-1].replace("}","");
		arrOfStr[arrOfStr.length-1] = temp;
		for(int i=0; i<arrOfStr.length; i++ ) {
			temp = arrOfStr[i].replace("\"","");
			arrOfStr[i]=temp;
		} //despues de aqui ya esta todo en el array en formato bueno
		
		return arrOfStr;
	}
	
	private static HashMap<String, String> getHashMap(String[] propertyArray){
		HashMap<String, String > propertyHashMap = new HashMap<String, String>();
		for(String a: propertyArray) {
			String[] temp2 = a.split(":", -2);
			propertyHashMap.put(temp2[0],temp2[1]);
		}
		return propertyHashMap;
		
	}
	
	
}
