package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {
    @Test
    public void testDifferJson() throws IOException {
        String filepath1 = "./src/test/resources/file1.json";
        String filepath2 = "./src/test/resources/file2.json";
        String expectedFilepath = "./src/test/resources/result.txt";

//        System.out.println("outFile " + outFile);

        Path expectedPath = Paths.get(expectedFilepath);
        String expected = String.join("\n", Files.readAllLines(expectedPath));

//        System.out.println("actual " + actual);

        // get differ
        String actual = Differ.generate(filepath1, filepath2);
//        System.out.println("actual " + actual);

        // compare result
        assertEquals(expected, actual);
    }

    public void testDifferYaml() throws IOException {
        String filepath1 = "./src/test/resources/file1.yaml";
        String filepath2 = "./src/test/resources/file2.yaml";
        String expectedFilepath = "./src/test/resources/result.txt";

//        System.out.println("outFile " + outFile);

        Path expectedPath = Paths.get(expectedFilepath);
        String expected = String.join("\n", Files.readAllLines(expectedPath));

//        System.out.println("actual " + actual);

        // get differ
        String actual = Differ.generate(filepath1, filepath2);
//        System.out.println("actual " + actual);

        // compare result
        assertEquals(expected, actual);
    }

}
