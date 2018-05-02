package com.ubs.opsit.interviews;

public class BerlinClockMain {

	public static void main(String[] args) {

		TimeConverter timeConverter = new TimeConverterImpl();
		System.out.println(timeConverter.convertTime("00:00:00"));
		System.out.println(timeConverter.convertTime("13:17:01"));
		System.out.println(timeConverter.convertTime("23:59:59"));
		System.out.println(timeConverter.convertTime("24:00:00"));

	}

}
