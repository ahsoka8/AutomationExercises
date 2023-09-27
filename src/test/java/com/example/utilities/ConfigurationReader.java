package com.example.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {
        try {
            //path of file which is wanted to read
            String path = "configuration.properties";
            //read file into java
            //using string path to find the file
            FileInputStream input = new FileInputStream(path);
            //properties -> class that can store data (properties) in key /value format
            properties = new Properties();
            //the values(data) from input is loaded to the properties object
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName){
        return properties.getProperty(keyName);
    }



}
