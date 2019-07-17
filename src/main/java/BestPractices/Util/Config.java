package BestPractices.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties prop = new Properties();
    private static FileInputStream input;

    static {
        try {
            input = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() throws IOException {
        prop.load(input);
        return prop.getProperty("url");
    }

}
