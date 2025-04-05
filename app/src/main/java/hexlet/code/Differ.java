package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import java.util.ArrayList;
import java.util.TreeSet;


public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        // get files

        // parse to Map

        // get file path
        Path path1 =  Paths.get(filepath1);
        Path path2 = Paths.get(filepath2);
//
//        System.out.println(filepath1);
//        System.out.println(filepath2);

        // read file
        File file1 = new File(filepath1);
        File file2 = new File(filepath2);

        // parse file to Map
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map1 = objectMapper.readValue(file1, new TypeReference<Map<String,Object>>(){});
        Map<String, Object> map2 = objectMapper.readValue(file2, new TypeReference<Map<String,Object>>(){});
//        System.out.println(map1);
//        System.out.println(map1.get("timeout"));
//        System.out.println(map2);


        // compare
        // get all keys
//        Set keys = map1.keySet();
        TreeSet<String> keys = new TreeSet<String>(map1.keySet());
        keys.addAll(map2.keySet());
        // sort all keys
        // run through keys and compare
//        System.out.println("keys " + keys);
//        keys.forEach();

        ArrayList<String> result = new ArrayList<String>();
        result.add("{");

        for (String key : keys) {
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);

//            System.out.println(key + ":" + value1 + "/" + value2);
            if (!map1.containsKey(key)) {
                result.add("  + "  + key + ": " + value2);
            } else if (!map2.containsKey(key)) {
                result.add("  - "  + key + ": " + value1);
            } else if (value1.equals(value2)) {
                result.add("    " + key + ": " + value1);
            } else {
                result.add("  - "  + key + ": " + value1);
                result.add("  + "  + key + ": " + value2);
            }
        }

        result.add("}");

        // format out string
        // return result
        String output = String.join("\n", result);

//        System.out.println("output\n" + output);

        return (output);
    }
}
