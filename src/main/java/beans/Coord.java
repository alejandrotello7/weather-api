package beans;

public class Coord {
	private static String longitude;
	private static String latitude;
	public static String getLongitude() {
		return longitude;
	}
	public static void setLongitude(String longitude) {
		Coord.longitude = longitude;
	}
	public static String getLatitude() {
		return latitude;
	}
	public static void setLatitude(String latitude) {
		Coord.latitude = latitude;
	}

	
}
