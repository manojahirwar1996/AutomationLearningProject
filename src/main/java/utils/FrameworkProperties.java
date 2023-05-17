package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.util.Properties;

public class FrameworkProperties {
    private String result = "";
    private InputStream inputStream;

    public  String getProperty(String key)  {

        try {
            Properties properties = new Properties();
            String propFileName= Constants.PROP_FILE_NAME;
            inputStream =getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream!=null){
                properties.load(inputStream);
            }
            else
                throw new FileNotFoundException();
            String propertyValue= properties.getProperty(key);
            result=propertyValue;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

}
