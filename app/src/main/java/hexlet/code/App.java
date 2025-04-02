package hexlet.code;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.")
public class App {
    @Option(names = {"-f", "--format"}, paramLabel="format", description = "output format [default: stylish]")
    private static String format = "stylish";
    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private static String filepath1;
    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private static String filepath2;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private static boolean usageHelpRequested;
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private static boolean versionInfoRequested;

    public static void main(String[] args) throws IOException {
        // display help
        CommandLine commandLine = new CommandLine(new App());
        commandLine.parseArgs(args);
        if (commandLine.isUsageHelpRequested()) {
            commandLine.usage(System.out);
            return;
        } else if (commandLine.isVersionHelpRequested()) {
            commandLine.printVersionHelp(System.out);
            return;
        }

        // get file path
        Path path1 =  Paths.get(filepath1);
        Path path2 = Paths.get(filepath2);

        System.out.println(filepath1);
        System.out.println(filepath2);

        // read file
        File file1 = new File(filepath1);
        File file2 = new File(filepath2);
        // parse file to Map
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map1 = objectMapper.readValue(file1, new TypeReference<Map<String,Object>>(){});
        Map<String, Object> map2 = objectMapper.readValue(file2, new TypeReference<Map<String,Object>>(){});
        System.out.println(map1);
        System.out.println(map1.get("timeout"));
        System.out.println(map2);

        System.out.println("Hello World!");
    }
}
