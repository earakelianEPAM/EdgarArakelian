package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Credentials {

    private String username;
    private String password;
    private String path = "src/test/resources/userCredentials";

    public Credentials() {
    }

    private void getCredentials() {

        FileInputStream fileInputStream;
        Properties property = new Properties();

        try {
            fileInputStream = new FileInputStream(path);
            property.load(fileInputStream);

            username = property.getProperty("userLogin");
            password = property.getProperty("userPassword");
            fileInputStream.close();

        } catch (IOException e) {
            System.err.println("Error, file is not found");
        }
    }

    public String getLogin() {
        getCredentials();
        return username;
    }

    public String getPassword() {
        getCredentials();
        return password;
    }
}
