package hexlet.code;

import java.util.ArrayList;
import java.util.List;

public class Formatter {
    public static String stylish(List<DiffItem> changes) {
        ArrayList<String> result = new ArrayList<String>();
        result.add("{");

        for (DiffItem change : changes) {
            StringBuilder item = new StringBuilder();
            String key = change.key();
            Object newValue = change.newValue();
            Object oldValue = change.oldValue();

            switch (change.status()) {
                case ADDED:
                    item.append("  + ").append(key).append(": ").append(newValue);
                    break;
                case DELETED:
                    item.append("  - ").append(key).append(": ").append(oldValue);
                    break;
                case UPDATED:
                    item.append("  - ").append(key).append(": ").append(oldValue);
                    item.append("\n");
                    item.append("  + ").append(key).append(": ").append(newValue);
                    break;
                case SAME:
                    item.append("    ").append(key).append(": ").append(newValue);
                    break;
                default:
                    break;
            }

            result.add(item.toString());
        }

        result.add("}");

        return String.join("\n", result);
    }
}
