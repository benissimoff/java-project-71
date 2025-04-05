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

import hexlet.code.Differ;

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

        String result = Differ.generate(filepath1, filepath2, format);

        System.out.println(result);

//        System.out.println("Hello World!");
    }

    //@Override
    public void call(String filepath1, String filepath2) throws IOException {
        String result = Differ.generate(filepath1, filepath2, format);
        System.out.println(result);
    }
}
