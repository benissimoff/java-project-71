package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DiffItem;
import java.util.List;

public class Json implements Format {

    @Override
    public String format(List<DiffItem> changes) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String output = mapper.writeValueAsString(changes);

//            System.out.println("output " + output);

            return output;
        } catch (Exception e) {
            throw new RuntimeException("Not JSON format", e);
        }
    }
}
