package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public static Properties intializeProperties() {
		Properties prop = new Properties();
		File propFile = new File(System.getProperty("user.dir"+"\\src\\test\\resources2\\config\\config.properties"));
		try {
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return prop;
	}
}
