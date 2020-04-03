package weatherAPITester;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Tester {


	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException, ParseException {

		int cityID = 2935022;
		String tokenID = "88813fe747e2829595b9134d1a8175f0" ;
		
		Connection.setCityID(cityID);
		Connection.setTokenID(tokenID);
		Connection.setUrl();
		
		String inline = Connection.establish();
		Data.parser(inline);
		
		//printing
		//System.out.println(content);
		System.out.println("Full information retrieved: " +inline);
		System.out.println("----------------------");
		//Json
		
		JSONParser parse = new JSONParser();
		JSONObject jobj = (JSONObject)parse.parse(inline);
		
		
		//country
		String tester = (String) jobj.get("sys").toString();
		String[] arrOfStr = tester.split(",", -2);
		
		String temp = arrOfStr[0].replace("{","");
		arrOfStr[0]=temp;
		temp = arrOfStr[arrOfStr.length-1].replace("}","");
		arrOfStr[arrOfStr.length-1] = temp;
		
		for(int i=0; i<arrOfStr.length; i++ ) {
			temp = arrOfStr[i].replace("\"","");
			arrOfStr[i]=temp;
		}
		
		HashMap<String, String >countryMap = new HashMap<String, String>();
	
		for(String a: arrOfStr) {
			String[] temp2 = a.split(":", -2);
			countryMap.put(temp2[0],temp2[1]);
		}
		
		
	

	}

}
