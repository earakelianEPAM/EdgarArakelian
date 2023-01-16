package com.epam.tc.hw7.entities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.DataProvider;

public class MetalsAndColorsDataProvider {
    private final String jsonPath = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "JDI_ex8_metalsColorsDataSet.json")
    public Object[][] data() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<HashMap<String, MetalsAndColorsDataItem>> typeRef
                = new TypeReference<HashMap<String, MetalsAndColorsDataItem>>() {};
        HashMap<String, MetalsAndColorsDataItem> map = objectMapper
                .readValue(new File(jsonPath), typeRef);
        Object[][] result = new Object[map.size()][1];
        int i = 0;
        for (Object item : map.values()) {
            result[i][0] = item;
            i++;
        }
        return result;
    }
}
