package hexlet.code.formatters;

import java.util.List;
import hexlet.code.DiffItem;

public interface Format {
    String format(List<DiffItem> changes);
}
