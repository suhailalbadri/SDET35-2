package com.crm.comcast.genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author FARHAN SD
 *
 */
public class FileUtility {
	/**
	 * It is used to fetch the data from the property file based on the key which you have specified as an argument
	 * @return
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.propPath);
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
}