package hexlet.code;

//import lombok.Getter;

import java.util.Objects;
import java.util.Map;
//@Getter
public record DiffItem(String key, Object oldValue, Object newValue, Status status) {
    public enum Status {
        ADDED, DELETED, UPDATED, SAME
    }

//    public static DiffItem initStatus(String key, Object oldValue, Object newValue) {
//        Status status;
//        if (Objects.isNull(oldValue)) {
//            status = Status.ADDED;
//        } else if (Objects.isNull(newValue)) {
//            status = Status.DELETED;
//        } else if (Objects.equals(oldValue, newValue)) {
//            status = Status.SAME;
//        } else {
//            status = Status.UPDATED;
//        }
//
//        return new DiffItem(key, oldValue, newValue, status);
//    }

    public static DiffItem init(String key, Map<String, Object> map1, Map<String, Object> map2) {
        Object value1 = map1.get(key);
        Object value2 = map2.get(key);

        DiffItem item;

//        System.out.println(key + ":" + value1 + "/" + value2);
        if (!map1.containsKey(key)) {
            item = new DiffItem(key, null, value2, Status.ADDED);
//            result.add("  + "  + key + ": " + value2);
        } else if (!map2.containsKey(key)) {
            item = new DiffItem(key, value1, null, Status.DELETED);
//            result.add("  - "  + key + ": " + value1);
        } else if (Objects.equals(value1, value2)) {
            item = new DiffItem(key, value1, value2, Status.SAME);
//            result.add("    " + key + ": " + value1);
        } else {
            item = new DiffItem(key, value1, value2, Status.UPDATED);
//            result.add("  - "  + key + ": " + value1);
//            result.add("  + "  + key + ": " + value2);
        }

        return item;
    }
}
