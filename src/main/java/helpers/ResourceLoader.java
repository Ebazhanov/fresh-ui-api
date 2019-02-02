package helpers;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.ClassLoader.getSystemClassLoader;

public class ResourceLoader {

    private static final String APP_PROPERTIES_FILE_NAME = "test.properties";
    private static Logger log = LoggerFactory.getLogger(ResourceLoader.class);

    public static String loadPropertyName(String name) {
        return loadProperty(name, APP_PROPERTIES_FILE_NAME);
    }

    private static String loadProperty(String name, String filename) {
        String propertyValue = "";
        Properties prop = new Properties();
        getSystemClassLoader();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(filename)) {
            prop.load(is);
        } catch (Exception e) {
            log.error("Failed to get property: " + name, e);
        }
        if (name != null) {
            propertyValue = prop.getProperty(name);
        }
        return propertyValue;
    }

    public static String getResourceAsString(String resourcePath) {
        String resourceString = "";
        try {
            resourceString = Resources.toString(Resources.getResource(resourcePath), Charsets.UTF_8);
        } catch (IOException e) {
            log.error("Failed to read resource as string: " + resourcePath, e);
        }
        return resourceString;
    }

}
