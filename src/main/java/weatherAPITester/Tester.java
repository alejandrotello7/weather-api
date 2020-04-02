package weatherAPITester;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Tester {

	public static void main(String[] args) throws IOException, ParseException {

		int cityID = 2935022;
		String tokenID = "88813fe747e2829595b9134d1a8175f0" ;
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?id="+cityID+"&appid="+tokenID);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		int status = con.getResponseCode();
		String statusMessage = con.getResponseMessage();
		System.out.println(status+": "+statusMessage);

		//method1
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		
		//method2
		String inline = "";
		Scanner sc = new Scanner(url.openStream());
		while(sc.hasNext())
		{
		inline+=sc.nextLine();
		}
		System.out.println(inline);
		sc.close();
		
		//printing
		System.out.println(content);
		System.out.println(inline);
		
		//Json
		JSONParser parse = new JSONParser();
		JSONObject jobj = (JSONObject)parse.parse(inline);
		System.out.println(jobj.get("main"));
		System.out.println(jobj.get("sys"));
		
		
		


	}

}
