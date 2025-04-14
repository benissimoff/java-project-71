package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        Map<String, Object> map1 = Parser.parse(filepath1);
        Map<String, Object> map2 = Parser.parse(filepath2);

        NavigableSet<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        List<DiffItem> changes = new ArrayList<>();

        for (String key : keys) {
            changes.add(DiffItem.init(key, map1, map2));
        }

        Formatter formatter = new Formatter(format);

        return formatter.format(changes);
    }

    public static String generate(String filepath1, String filepath2) throws IOException {
        String format = Formatter.STYLISH;
        return generate(filepath1, filepath2, format);
    }
}
