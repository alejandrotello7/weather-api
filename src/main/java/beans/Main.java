package beans;

public class Main {
	private static long temp;
	private static long feelsLike;
	private static long tempMin;
	private static long tempMax;
	private static long pressure;
	private static long humidity;
	
	public static long getTemp() {
		return temp;
	}
	public static void setTemp(long temp) {
		Main.temp = temp;
	}
	public static long getFeelsLike() {
		return feelsLike;
	}
	public static void setFeelsLike(long feelsLike) {
		Main.feelsLike = feelsLike;
	}
	public static long getTempMin() {
		return tempMin;
	}
	public static void setTempMin(long tempMin) {
		Main.tempMin = tempMin;
	}
	public static long getTempMax() {
		return tempMax;
	}
	public static void setTempMax(long tempMax) {
		Main.tempMax = tempMax;
	}
	public static long getPressure() {
		return pressure;
	}
	public static void setPressure(long pressure) {
		Main.pressure = pressure;
	}
	public static long getHumidity() {
		return humidity;
	}
	public static void setHumidity(long humidity) {
		Main.humidity = humidity;
	}
}
