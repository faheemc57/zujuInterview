package genericLibrary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class InputUtils {
    Properties properties = new Properties();

    public InputUtils() throws IOException {
        FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/test/java/input/config.properties");
        properties.load(reader);
    }

    public String getProperties(String key) {
        return properties.getProperty(key);
    }


}
