package hexlet.code.formatters;

import hexlet.code.DiffItem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class Plain implements Format {
    public String format(List<DiffItem> changes) {
        ArrayList<String> result = new ArrayList<String>();

        for (DiffItem change : changes) {
            StringBuilder item = new StringBuilder();
            String key = strValue(change.key());
            Object newValue = strValue(change.newValue());
            Object oldValue = strValue(change.oldValue());

            String oldType = Objects.isNull(oldValue) ? "isNull" : oldValue.getClass().getName();
            String newType = Objects.isNull(newValue) ? "isNull" : newValue.getClass().getName();

//            System.out.println("key " + key + " oldType " + oldType);
//            System.out.println("key " + key + " newType " + newType);

            String str = "";

            switch (change.status()) {
                case ADDED:
                    str = String.format("Property %s was added with value: %s", key, newValue);
                    result.add(str);

//                    item.append("Property ").append(key).append(" was added with value: ").append(newValue);
                    break;
                case DELETED:
                    str = String.format("Property %s was was removed", key);
                    result.add(str);

//                    item.append("Property ").append(key).append(" was was removed");
                    break;
                case UPDATED:
                    str = String.format("Property %s was updated. From value: %s to %s", key, oldValue, newValue);
                    result.add(str);

//                    item.append("Property ").append(key).append(" was updated. From value: ")
//                    .append(oldValue).append(" to ").append(newValue);
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
