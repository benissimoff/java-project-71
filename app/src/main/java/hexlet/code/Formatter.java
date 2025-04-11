package hexlet.code;

import hexlet.code.formatters.Format;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    private final Format formatter;
    Formatter(String format) {
//        System.out.println("Formatter format " + format);
        switch (format) {
            case "plain":
                formatter = new Plain();
                break;
            case "json":
                formatter = new Json();
                break;
            case "stylish":
            default:
                formatter = new Stylish();
                break;
        }
    }

    public String format(List<DiffItem> changes) {
        return formatter.format(changes);
    }
}
