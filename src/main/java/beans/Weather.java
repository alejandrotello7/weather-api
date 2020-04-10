package beans;

public class Weather {
	
	private static String id;
	private static String main;
	private static String description;
	private static String icon;
	
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		Weather.id = id;
	}
	public static String getMain() {
		return main;
	}
	public static void setMain(String main) {
		Weather.main = main;
	}
	public static String getDescription() {
		return description;
	}
	public static void setDescription(String description) {
		Weather.description = description;
	}
	public static String getIcon() {
		return icon;
	}
	public static void setIcon(String icon) {
		Weather.icon = icon;
	}

}
