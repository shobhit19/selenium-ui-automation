package com.practice.utils;

import com.practice.contants.FrameworkConstants;
import com.practice.enums.ConfigProperties;
import com.practice.exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtil {

    private PropertyUtil(){

    }
    private static Properties properties = new Properties();

    static{
        try(FileInputStream file = new FileInputStream(FrameworkConstants.getCONFIGFILEPATH())){
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }


    public static String getValue(ConfigProperties key) {
        if(Objects.isNull(properties.getProperty(key.name().toLowerCase())) || Objects.isNull(key)){
            throw new PropertyFileUsageException("Property name "+key+" is not found. Please check config.properties");
        }
        return properties.getProperty(key.name().toLowerCase());
    }


}
