package com.epam.tc.hw5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserData {
    private static final String filePath = "src/test/resources/userCredentials";

    public static Properties getCredentials() {
        FileInputStream fileInputStream;
        Properties credentials = new Properties();
        try {
            fileInputStream = new FileInputStream(filePath);
            credentials.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }
}
