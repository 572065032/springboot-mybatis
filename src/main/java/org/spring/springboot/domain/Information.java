package org.spring.springboot.domain;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Information {

    static private Information instance;

    private Information() {

    }

    static public Information getInstance() {
        if(instance == null)
            instance = new Information();
        return instance;
    }

    public String getErrorInfo(String errorCode) {
        Properties properties = new Properties();
        InputStream in = this.getClass().getResourceAsStream("/errorcode.properties");
        try {
            properties.load(new InputStreamReader(in, "gbk"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return properties.getProperty(errorCode + "", "null");
    }

}
