package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filepath) throws IOException {
        File file = new File(filepath);

        String fileType = filepath.substring(filepath.lastIndexOf('.') + 1);
        ObjectMapper objectMapper = new YAMLMapper();
        if (fileType.endsWith(".json")) {
            objectMapper = new ObjectMapper();
        }

        Map<String, Object> result = objectMapper.readValue(file, new TypeReference<Map<String, Object>>() { });

        return result;
    }
}
