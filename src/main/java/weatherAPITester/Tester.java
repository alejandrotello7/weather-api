package weatherAPITester;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import beans.City;
import beans.CityId;
import beans.Clouds;
import beans.Coord;
import beans.Main;
import beans.Sys;
import beans.Visibility;
import beans.Weather;
import beans.Wind;
import utils.CityListDb;

public class Tester {


	public static void main(String[] args) throws IOException, ParseException, Exception {
		
		//mexicaliID = 3996069;
		//dresdenID = 2935022;
		
		int cityID = 3981609;
		String tokenID = "88813fe747e2829595b9134d1a8175f0" ;
		
		Connection.setCityID(cityID);
		Connection.setTokenID(tokenID);
		Connection.setUrl();
		String inline = Connection.establish();
		Data.parser(inline);
		System.out.println("Full information retrieved: " +inline);
		System.out.println("----------------------");

		
		System.out.println(Sys.getCountry());
		System.out.println(Coord.getLatitude());
		System.out.println(Coord.getLongitude());
		System.out.println(Weather.getMain());
		System.out.println((int)(Double.parseDouble(Main.getFeelsLike())-273.15)+" C");
		System.out.println(Visibility.getVisibility());
		System.out.println(Wind.getSpeed());
		System.out.println(Clouds.getAll());
		System.out.println(City.getId());
		System.out.println(City.getName());
		
		String cityTester = "Meoqui";
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("src/main/resources/city.list.json"));
		JSONArray cityList = (JSONArray) obj;
		HashMap<ArrayList<String>,String> ID = new HashMap <ArrayList<String>, String>();
		HashMap<String, ArrayList<String>> hashTester = new HashMap<String, ArrayList<String>>();
	
		JSONObject dataObject;
		
		for(int i=0; i<cityList.size(); i++) {
			dataObject = (JSONObject)parser.parse(cityList.get(i).toString());
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(dataObject.get("name").toString());
			temp.add(dataObject.get("country").toString());
			ID.put(temp,dataObject.get("id").toString());
			hashTester.put(dataObject.get("id").toString(),temp);
			i++;
		}
		
		for(int i=0; i<cityList.size(); i++) {
			dataObject = (JSONObject)parser.parse(cityList.get(i).toString());
			CityId bean = new CityId();
			bean.setCityName(dataObject.get("name").toString());
			bean.setCountryName(dataObject.get("country").toString());
			bean.setId(dataObject.get("id").toString());
			CityListDb.addCity(bean);
			i++;
		}

		
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("Tepechitlán");
		temp.add("MX");
		
		System.out.println("-----------------------------");
		System.out.println("Testing Zone: ");
		System.out.println("-----------------------------");
		System.out.println(ID.get(temp));
		System.out.println("Tamano de JSON: "+cityList.size());
		System.out.println("Tamano de HashMap: "+ID.size());
		System.out.println("Tamano bean"+CityListDb.getSize());



		

		
		
		
	}

}
