package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesReader {

	static Properties prop = null;

	public static String getPropertyValueByKey(String key) throws Exception {
		String value = "";

		if (prop == null) {
			prop = new Properties();
			// location
			String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
			FileInputStream fip = new FileInputStream(propFilePath);
			// load
			prop.load(fip);
			fip.close();
		}

		// get value
		value = prop.get(key).toString();

		if (StringUtils.isEmpty(value)) {
			throw new Exception("No Value specified for " + key);
		}
		return value;
	}

}
