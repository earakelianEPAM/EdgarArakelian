package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Credentials {

    public String username;
    public String password;
    private String path = "src/test/resources/userCredentials";
    private static final Credentials instance = new Credentials();

    private Credentials() {
        FileInputStream fileInputStream;
        Properties property = new Properties();

        try {
            fileInputStream = new FileInputStream(path);
            property.load(fileInputStream);

            this.username = property.getProperty("userLogin");
            this.password = property.getProperty("userPassword");
            fileInputStream.close();

        } catch (IOException e) {
            System.err.println("Error, file is not found");
        }
    }

    public static Credentials getCredentials() {
        return instance;
    }
}
