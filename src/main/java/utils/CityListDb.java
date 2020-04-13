package utils;

import java.util.ArrayList;

import beans.CityId;

public class CityListDb {
	
	private static ArrayList<CityId> cityList = new ArrayList<CityId>();

	
	public static void addCity(CityId bean) {
		cityList.add(bean);
		
		
	}
	public static int getSize() {
		return cityList.size();

	}
	



}
