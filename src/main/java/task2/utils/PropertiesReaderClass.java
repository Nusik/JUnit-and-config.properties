package task2.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderClass {

  private static PropertiesReaderClass loadProperties = null;
  private static Properties properties = null;
  private static InputStream inputStream = null;

  private PropertiesReaderClass(String propertyFileName) {
    this.inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(propertyFileName);
  }

  public static PropertiesReaderClass getInstance() {
    if (loadProperties == null) {
      loadProperties = new PropertiesReaderClass("config.properties");
    }
    return loadProperties;
  }

  public String getValueFromProperty(String key) {
    if (properties == null) {
      properties = new Properties();
      try {
        properties.load(inputStream);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return properties.getProperty(key);
  }
}
