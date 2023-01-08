package com.epam.tc.hw5.context;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private static TestContext instance;
    public static final String WEB_DRIVER = "webDriver";


    private Map<String, Object> context = new HashMap<>();

    public void setObject(String key, Object object) {
        context.put(key, object);
    }

    public <T> T getObject(String key) {
        return (T) context.get(key);
    }

    public void cleanContext() {
        context.clear();
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
