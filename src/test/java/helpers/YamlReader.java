package helpers;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlReader {
    public static SqlConnection connection = null;
    public static void getConnection() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            connection = mapper.readValue(new File("app.yml"), SqlConnection.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}