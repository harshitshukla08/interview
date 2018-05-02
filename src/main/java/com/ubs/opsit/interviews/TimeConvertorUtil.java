package com.ubs.opsit.interviews;

public class TimeConvertorUtil {

	public static String geYellowSecondLamps(int timeValue) {
		if (timeValue % TimeConverterConstants.LIGHT_MULTIPLE_OF_TWO == 0) {
			return TimeConverterConstants.LAMP_YELLOW;
		} else {
			return TimeConverterConstants.LAMP_OFF;
		}
	}

	public static String getMinutesLamps(int numericValue, String strRedLamp, String strYellowLamp) {

		StringBuilder lamps = new StringBuilder(TimeConverterConstants.LAMPS_ELEVEN_OFF);

		for (int i = 0; i < numericValue; i++) {
			if ((i + 1) % TimeConverterConstants.LIGHT_MULTIPLE_OF_THREE == 0) {
				lamps.replace(i, i + 1, strRedLamp);
			} else {
				lamps.replace(i, i + 1, strYellowLamp);
			}
		}
		return lamps.toString();
	}

	public static String getHourLamps( int numericValue, String strLamp) {
		StringBuilder lamps = new StringBuilder(TimeConverterConstants.LAMPS_FOUR_OFF);
		for (int i = 0; i < numericValue; i++) {
			lamps.replace(i, i + 1, strLamp);
		}
		return lamps.toString();
	}

}
