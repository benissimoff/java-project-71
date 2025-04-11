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
        String filepath1 = "./src/test/resources/short/file1.json";
        String filepath2 = "./src/test/resources/short/file2.json";
        String expectedFilepath = "./src/test/resources/short/result.txt";

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

    @Test
    public void testDifferYaml() throws IOException {
        String filepath1 = "./src/test/resources/short/file1.yaml";
        String filepath2 = "./src/test/resources/short/file2.yaml";
        String expectedFilepath = "./src/test/resources/short/result.txt";

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

    @Test
    public void testDifferLongJson() throws IOException {
        String filepath1 = "./src/test/resources/long/file1.json";
        String filepath2 = "./src/test/resources/long/file2.json";
        String expectedFilepath = "./src/test/resources/long/result.txt";

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

    @Test
    public void testDifferLongYaml() throws IOException {
        String filepath1 = "./src/test/resources/long/file1.yaml";
        String filepath2 = "./src/test/resources/long/file2.yml";
        String expectedFilepath = "./src/test/resources/long/result.txt";

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

    @Test
    public void testDifferLongPlain() throws IOException {
        String filepath1 = "./src/test/resources/long/file1.yaml";
        String filepath2 = "./src/test/resources/long/file2.yml";
        String expectedFilepath = "./src/test/resources/long/resultPlain.txt";
        String format = "plain";
//        System.out.println("outFile " + outFile);

        Path expectedPath = Paths.get(expectedFilepath);
        String expected = String.join("\n", Files.readAllLines(expectedPath));

//        System.out.println("actual " + actual);

        // get differ
        String actual = Differ.generate(filepath1, filepath2, format);
//        System.out.println("actual " + actual);

        // compare result
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferLongJsonFormat() throws IOException {
        String filepath1 = "./src/test/resources/long/file1.yaml";
        String filepath2 = "./src/test/resources/long/file2.yml";
        String expectedFilepath = "./src/test/resources/long/resultJson.txt";
        String format = "json";
//        System.out.println("outFile " + outFile);

        Path expectedPath = Paths.get(expectedFilepath);
        String expected = String.join("\n", Files.readAllLines(expectedPath));

//        System.out.println("actual " + actual);

        // get differ
        String actual = Differ.generate(filepath1, filepath2, format);
//        System.out.println("actual " + actual);

        // compare result
        assertEquals(expected, actual);
    }

}
