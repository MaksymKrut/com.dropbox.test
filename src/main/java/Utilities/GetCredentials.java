package Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Maksym Krutskykh on 30-Sep-16.
 */

public class GetCredentials {

    private Properties getProperties(String propFileName) throws IOException {

        Properties prop = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(
                    propFileName);
            prop.load(inputStream);
            if (inputStream == null) {
                throw new FileNotFoundException("property file '"
                        + propFileName + "' not found in the classpath");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }


    public String getPropertyValue(String property) throws IOException {

        Properties prop = getProperties("credentials.properties");

        String value = prop.getProperty(property);

        System.out.println("\n\nCredential value: " + value + "\n\nout of property: " + property);

        return value;
    }
}
