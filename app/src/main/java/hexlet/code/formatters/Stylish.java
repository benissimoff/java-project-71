package hexlet.code.formatters;

import hexlet.code.DiffItem;
import java.util.ArrayList;
import java.util.List;

public class Stylish implements Format {
    public final String format(List<DiffItem> changes) {
        ArrayList<String> result = new ArrayList<String>();

        for (DiffItem change : changes) {
            String key = change.key();
            Object newValue = change.newValue();
            Object oldValue = change.oldValue();

            String str = "";

            switch (change.status()) {
                case ADDED:
                    str = String.format("  + %s: %s", key, newValue);
                    result.add(str);
                    break;
                case DELETED:
                    str = String.format("  - %s: %s", key, oldValue);
                    result.add(str);
                    break;
                case UPDATED:
                    str = String.format("  - %s: %s", key, oldValue);
                    result.add(str);
                    str = String.format("  + %s: %s", key, newValue);
                    result.add(str);
                    break;
                case SAME:
                    str = String.format("    %s: %s", key, newValue);
                    result.add(str);
                    break;
                default:
                    break;
            }
        }

        result.addFirst("{");
        result.add("}");

        return String.join("\n", result);
    }
}
