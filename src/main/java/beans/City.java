package beans;

public class City {
	private static String name;
	private static String id;
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		City.name = name;
	}
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		City.id = id;
	}
	
}
