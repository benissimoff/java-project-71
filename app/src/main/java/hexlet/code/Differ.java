package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        // parse to Map
        // parse file to Map
        Map<String, Object> map1 = Parser.parse(filepath1);
        Map<String, Object> map2 = Parser.parse(filepath2);
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

    public static String generate(String filepath1, String filepath2) throws IOException {
        String format = "stylish";
        return generate(filepath1, filepath2, format);
    }
}
