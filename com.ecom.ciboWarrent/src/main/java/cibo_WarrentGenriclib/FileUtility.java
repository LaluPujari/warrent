package cibo_WarrentGenriclib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author User
 *
 */


public class FileUtility {
	/**
	 * this methos is used for fetch the data from properties file
	 * @author User
	 *
	 */
	
	public String getPropertyKeyValue(String key) throws IOException {
	FileInputStream fileInputStream=new FileInputStream( IpathConstants.propertyFilepath);
	
	Properties properties = new Properties();
	
	properties.load(fileInputStream);
	String value = properties.getProperty(key);
	
        return value;
}
}
