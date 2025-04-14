package hexlet.code.formatters;

import hexlet.code.DiffItem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PlainFormatter implements TypeFormatter {
    public final String format(List<DiffItem> changes) {
        ArrayList<String> result = new ArrayList<>();

        for (DiffItem change : changes) {
            String key = strValue(change.key());
            Object newValue = strValue(change.newValue());
            Object oldValue = strValue(change.oldValue());
            String formattedString;

            switch (change.status()) {
                case ADDED:
                    formattedString = String.format("Property %s was added with value: %s", key, newValue);
                    result.add(formattedString);
                    break;
                case DELETED:
                    formattedString = String.format("Property %s was removed", key);
                    result.add(formattedString);
                    break;
                case UPDATED:
                    formattedString = String.format("Property %s was updated. From %s to %s", key, oldValue, newValue);
                    result.add(formattedString);
                    break;
                case SAME:
                default:
                    break;
            }
        }

        return String.join("\n", result);
    }

    private String strValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof ArrayList || value instanceof LinkedHashMap) {
            return "[complex value]";
        }
        return String.valueOf(value);
    }
}
