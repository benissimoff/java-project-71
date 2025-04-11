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

//        System.out.println("Differ format " + format);
//        System.out.println(map1);
//        System.out.println(map1.get("timeout"));
//        System.out.println(map2);

        // compare
        // get all keys
//        Set keys = map1.keySet();
        TreeSet<String> keys = new TreeSet<String>(map1.keySet());
        // sort all keys
        keys.addAll(map2.keySet());
        // run through keys and compare
        ArrayList<DiffItem> changes = new ArrayList<DiffItem>();

        for (String key : keys) {
            changes.add(DiffItem.init(key, map1, map2));
        }

        // format out string
        Formatter formatter = new Formatter(format);
        String outputStylish = formatter.format(changes);

//        System.out.println("outputStylish\n" + outputStylish);

        // return result
        return outputStylish;
    }

    public static String generate(String filepath1, String filepath2) throws IOException {
        String format = "stylish";
        return generate(filepath1, filepath2, format);
    }
}
