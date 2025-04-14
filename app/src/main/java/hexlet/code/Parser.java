package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;
import java.io.File;
import java.io.IOException;

public class Parser {
    public static Map<String, Object> parse(String filepath) throws IOException {
        File file = new File(filepath);
        String fileType = filepath.substring(filepath.lastIndexOf('.') + 1);
        Map<String, Object> result;

        switch (fileType) {
            case "yaml":
            case "yml":
                result = readYaml(file);
                break;
            case "json":
            default:
                result = readJson(file);
                break;
        }

        return result;
    }

    private static Map<String, Object> readYaml(File file) throws IOException {
        ObjectMapper objectMapper = new YAMLMapper();

        return objectMapper.readValue(file, new TypeReference<Map<String, Object>>() { });
    }

    private static Map<String, Object> readJson(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(file, new TypeReference<Map<String, Object>>() { });
    }
}
