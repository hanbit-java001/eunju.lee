package com.hanbit.eunju.lee.standalone;

import static org.hamcrest.CoreMatchers.instanceOf;

public class Location {
	public static final String HOSPITAL = "Î≥ëÏõê";
	public static final String HOME = "Ïß?";
	public static final String SCHOOL = "?ïôÍµ?";

	public static Location LOC_HOME = new Location(HOME, "?Ñú?ö∏ Í∞ïÏÑúÍµ?");
	public static Location LOC_HOSPITAL = new Location(HOSPITAL, "?Ñú?ö∏ ÎßàÌè¨Íµ?");
	public static Location LOC_SCHOOL = new School("?Ñú?ö∏ ???èâÍµ?");

	private String name;
	private String address;

	private boolean opened;
	private boolean toilet;

	private int rooms;

	public Location(String name, String address) {
		this.name = name;
		this.address = address;

		Location school = new School("?Ñú?ö∏");

		if (school instanceof School) {
			School middleSchool = (School) school;
		}
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String toString() {
		return name;
	}

	public int getRooms() {
		return rooms;
	}

	public boolean isOpened() {
		return opened;
	}

	public boolean hasToilet() {
		return toilet;
	}

}
