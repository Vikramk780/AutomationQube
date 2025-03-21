package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

private Properties prop;

    public Properties init_prop() throws IOException {

         prop = new Properties();

        FileInputStream file = new FileInputStream("src/test/resources/Config/config.properties");

        prop.load(file);
        return prop;

    }
}
