package com.licious.genericlib;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyLoader implements IConstants {

	private static Properties property;
    private String value;

    public static Properties getPropertyObj() {
        if (property == null) {
            property = new Properties();
            try {
                FileInputStream fileInputStream = new FileInputStream(PROPERTY_FILEPATH);
                property.load(fileInputStream);
            } catch (Exception e) {
                System.exit(1);
            }
        }
        return property;
      //  value = (String) properties.get(this.toString());
    }
}
