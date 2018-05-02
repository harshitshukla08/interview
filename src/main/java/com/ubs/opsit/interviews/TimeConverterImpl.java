package com.ubs.opsit.interviews;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This class is to convert time into Berlin clock
 */
public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String time) {

		int timeValue;
		int timeDivisibleByFive;
		int timeModulusOfFive;
		
		// Input time needs to validated first before performing conversion.
		if (!validateInputTime(time)) {
			return TimeConverterConstants.INVALID_TIME;
		}

		
		String[] splitTime = time.split(TimeConverterConstants.COLON);

		StringBuffer convertedTime = new StringBuffer();
		
		//check for yellow light blinks every 2 seconds
		convertedTime.append(TimeConvertorUtil.geYellowSecondLamps(Integer.parseInt(splitTime[2])));
		
		convertedTime.append(TimeConverterConstants.NEW_LINE);

		timeValue = Integer.parseInt(splitTime[0]);
		timeDivisibleByFive = timeValue / TimeConverterConstants.LIGHT_MULTIPLE_OF_FIVE;
		timeModulusOfFive = timeValue % TimeConverterConstants.LIGHT_MULTIPLE_OF_FIVE;
		
		convertedTime.append(TimeConvertorUtil.getHourLamps( timeDivisibleByFive,
				TimeConverterConstants.LAMP_RED));
		convertedTime.append(TimeConverterConstants.NEW_LINE);
		
		convertedTime.append(TimeConvertorUtil.getHourLamps( timeModulusOfFive,
				TimeConverterConstants.LAMP_RED));
		convertedTime.append(TimeConverterConstants.NEW_LINE);

		timeValue = Integer.parseInt(splitTime[1]);
		timeDivisibleByFive = timeValue / TimeConverterConstants.LIGHT_MULTIPLE_OF_FIVE;
		timeModulusOfFive = timeValue % TimeConverterConstants.LIGHT_MULTIPLE_OF_FIVE;

		
		convertedTime.append(TimeConvertorUtil.getMinutesLamps(timeDivisibleByFive,
				TimeConverterConstants.LAMP_RED,
				TimeConverterConstants.LAMP_YELLOW));
		convertedTime.append(TimeConverterConstants.NEW_LINE);
		
		convertedTime.append(TimeConvertorUtil.getHourLamps( timeModulusOfFive,
				TimeConverterConstants.LAMP_YELLOW));

		return convertedTime.toString();
	}

	/**
	 * This method check for the Time 
	 * Time format hh:mm:ss
	 * @param inputTime
	 *            
	 * @return true if input is correct and false if input is incorrect.
	 */
	private boolean validateInputTime(String inputTime) {

		try {
			if (inputTime != null && !inputTime.isEmpty()) {
				Pattern timeRegexPattern = Pattern
						.compile(TimeConverterConstants.TIME_REGEX);
				Matcher timeMatcher = timeRegexPattern.matcher(inputTime);
				if (!timeMatcher.matches()) {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Exception occured in validation method :-"
					+ e.getMessage());
		}
		return true;
	}

}
