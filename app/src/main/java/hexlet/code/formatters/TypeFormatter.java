package hexlet.code.formatters;

import java.util.List;
import hexlet.code.DiffItem;

public interface TypeFormatter {
    String format(List<DiffItem> changes);
}
