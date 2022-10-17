package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	/**
	 * This method is used for launch the application
	 * @param key
	 * @return
	 * @throws IOException
	 * @author sunil
	 */
	public String getPropertyKeyValue1(String key) throws Throwable {
		//FileInputStream fis=new FileInputStream("./Common_data_properties.txt");
		FileInputStream fis=new FileInputStream(ipathConstant.PROPERTYFILE_PATH);
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(key);
		return value;
	}

}
