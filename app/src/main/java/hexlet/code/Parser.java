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

        // parse file to Map
        String fileType = filepath.substring(filepath.lastIndexOf('.') + 1);
//        System.out.println("fileType " + fileType);
        ObjectMapper objectMapper = new YAMLMapper();
        if ("json".equals(fileType)) {
            objectMapper = new ObjectMapper();
        }

        Map<String, Object> result = objectMapper.readValue(file, new TypeReference<Map<String, Object>>() { });

        return result;
    }
}
