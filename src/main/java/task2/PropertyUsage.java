package task2;

import task2.utils.PropertiesReaderClass;

public class PropertyUsage {

    public static void main(String[] args) {

        String timeoutValue = PropertiesReaderClass.getInstance().getValueFromProperty("defaultTimeout");
        String baseUrlValue = PropertiesReaderClass.getInstance().getValueFromProperty("baseUrl");

        System.out.println("timeout value: " + timeoutValue);
        System.out.println("baseUrl value: " + baseUrlValue);
    }
}
