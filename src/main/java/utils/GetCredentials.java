package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetCredentials {
    private String username;
    private String password;

    public GetCredentials() {
    }

    private void getCredentials() {

        FileInputStream fileInputStream;
        Properties property = new Properties();

        try {
            fileInputStream = new FileInputStream("src/test/resources/userCredentials");
            property.load(fileInputStream);

            username = property.getProperty("userLogin");
            password = property.getProperty("userPassword");


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
