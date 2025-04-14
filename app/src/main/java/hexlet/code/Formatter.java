package hexlet.code;

import hexlet.code.formatters.TypeFormatter;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;

public class Formatter {
    private final TypeFormatter formatter;
    public static final String STYLISH = "stylish";
    public static final String PLAIN = "plain";
    public static final String JSON = "json";
    Formatter(String format) {

        switch (format) {
            case PLAIN:
                formatter = new PlainFormatter();
                break;
            case JSON:
                formatter = new JsonFormatter();
                break;
            case STYLISH:
            default:
                formatter = new StylishFormatter();
                break;
        }
    }

    public final String format(List<DiffItem> changes) {
        return formatter.format(changes);
    }
}
