package helpers;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class YamlReader {

    public static Map<String, Object> read(String path) throws IOException {
        InputStream in = Files.newInputStream(Paths.get(path));
        Yaml yaml = new Yaml();
        return (Map<String, Object>) yaml.load(in);
    }

    public static <T> T read(String path, Class<T> c) throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream in = Files.newInputStream(Paths.get(path))) {
            return yaml.loadAs(in, c);
        }
    }
}