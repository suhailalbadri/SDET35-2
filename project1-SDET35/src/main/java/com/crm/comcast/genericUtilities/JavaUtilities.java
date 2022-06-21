package com.crm.comcast.genericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * It contains java specific libraries like getRandomNumber, getSystemDate etc
 * @author FARHAN SD
 *
 */
public class JavaUtilities {
	/**
	 * It is used to generate a Random Number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		int randnum = r.nextInt(200);
		return randnum;
	}
	/**
	 * It is used to generate Date and Time in IST format
	 * @return
	 */
	public String getSystemDateAndTimeInISTFormat() {
		Date date=new Date();
		String dateandtimeIST = date.toString();
		return dateandtimeIST;
	}
	/**
	 * It is used to generate Date and Time in Standard format
	 * @return
	 */
	public String getDateAndTimeInStandardFormat() {
		Date date=new Date();
		String dandt = date.toString();
		String YYYY = dandt.split(" ") [5];
		String DD = dandt.split(" ") [2];
		@SuppressWarnings("deprecation")
		int MM = date.getMonth()+1;
		String stdformat = YYYY+" "+DD+" "+MM;
		return stdformat;
	}
}