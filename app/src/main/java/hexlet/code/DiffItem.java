package hexlet.code;

import java.util.Objects;
import java.util.Map;

public record DiffItem(String key, Object oldValue, Object newValue, Status status) {
    public enum Status {
        ADDED, DELETED, UPDATED, SAME
    }

    public static DiffItem init(String key, Map<String, Object> map1, Map<String, Object> map2) {
        Object value1 = map1.get(key);
        Object value2 = map2.get(key);
        DiffItem item;

        if (!map1.containsKey(key)) {
            item = new DiffItem(key, null, value2, Status.ADDED);
        } else if (!map2.containsKey(key)) {
            item = new DiffItem(key, value1, null, Status.DELETED);
        } else if (Objects.equals(value1, value2)) {
            item = new DiffItem(key, value1, value2, Status.SAME);
        } else {
            item = new DiffItem(key, value1, value2, Status.UPDATED);
        }

        return item;
    }
}
