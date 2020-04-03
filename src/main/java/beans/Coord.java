package beans;

public class Coord {
	private static long longitude;
	private static long latitude;
	public static long getLongitude() {
		return longitude;
	}
	public static void setLongitude(long longitude) {
		Coord.longitude = longitude;
	}
	public static long getLatitude() {
		return latitude;
	}
	public static void setLatitude(long latitude) {
		Coord.latitude = latitude;
	}
	
}
