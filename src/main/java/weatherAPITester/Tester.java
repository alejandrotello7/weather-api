package weatherAPITester;
import java.io.IOException;
import org.json.simple.parser.ParseException;

import beans.City;
import beans.Clouds;
import beans.Coord;
import beans.Main;
import beans.Sys;
import beans.Visibility;
import beans.Weather;
import beans.Wind;

public class Tester {


	public static void main(String[] args) throws IOException, ParseException {
		
		//mexicaliID = 3996069;
		//dresdenID = 2935022;
		
		int cityID = 3996069;
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
	

	}

}
