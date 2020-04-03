package weatherAPITester;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Connection {
	private static int cityID;
	private static String tokenID;
	private static URL url; 
	
	public static int getCityID() {
		return cityID;
	}
	public static void setCityID(int cityID) {
		Connection.cityID = cityID;
	}
	
	public static String getTokenID() {
		return tokenID;
	}
	public static void setTokenID(String tokenID) {
		Connection.tokenID = tokenID;
	}
	public static URL getUrl() {
		return url;
	}
	public static void setUrl() throws MalformedURLException {
		Connection.url = new URL("http://api.openweathermap.org/data/2.5/weather?id="+Connection.getCityID()+"&appid="+Connection.getTokenID());
	}
	
	public static String establish() throws IOException {
		HttpURLConnection con = (HttpURLConnection) Connection.getUrl().openConnection();
		con.setRequestMethod("GET");
		int status = con.getResponseCode();
		String statusMessage = con.getResponseMessage();
		System.out.println(status+": "+statusMessage);
		String inline = "";
		Scanner sc = new Scanner(url.openStream());
		while(sc.hasNext())
		{
			inline+=sc.nextLine();
		}
		sc.close();
		return inline;
		
	}

	

}

