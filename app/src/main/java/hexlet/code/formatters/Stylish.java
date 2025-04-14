package hexlet.code.formatters;

import hexlet.code.DiffItem;
import java.util.ArrayList;
import java.util.List;

public class Stylish implements Format {
    public final String format(List<DiffItem> changes) {
        ArrayList<String> result = new ArrayList<>();

        for (DiffItem change : changes) {
            String key = change.key();
            Object newValue = change.newValue();
            Object oldValue = change.oldValue();
            String formattedString;

            switch (change.status()) {
                case ADDED:
                    formattedString = String.format("  + %s: %s", key, newValue);
                    result.add(formattedString);
                    break;
                case DELETED:
                    formattedString = String.format("  - %s: %s", key, oldValue);
                    result.add(formattedString);
                    break;
                case UPDATED:
                    formattedString = String.format("  - %s: %s", key, oldValue);
                    result.add(formattedString);
                    formattedString = String.format("  + %s: %s", key, newValue);
                    result.add(formattedString);
                    break;
                case SAME:
                    formattedString = String.format("    %s: %s", key, newValue);
                    result.add(formattedString);
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
