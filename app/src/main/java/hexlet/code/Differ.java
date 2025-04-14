package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        Map<String, Object> map1 = Parser.parse(filepath1);
        Map<String, Object> map2 = Parser.parse(filepath2);

        TreeSet<String> keys = new TreeSet<String>(map1.keySet());
        keys.addAll(map2.keySet());
        ArrayList<DiffItem> changes = new ArrayList<DiffItem>();

        for (String key : keys) {
            changes.add(DiffItem.init(key, map1, map2));
        }

        Formatter formatter = new Formatter(format);
        String outputStylish = formatter.format(changes);

        return outputStylish;
    }

    public static String generate(String filepath1, String filepath2) throws IOException {
        String format = "stylish";
        return generate(filepath1, filepath2, format);
    }
}
