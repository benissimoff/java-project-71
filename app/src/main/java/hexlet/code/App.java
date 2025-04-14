package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.")
public class App {
    @Option(names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format [default: ${DEFAULT-VALUE}]")
    private static String format = Formatter.STYLISH;
    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private static String filepath1;
    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private static String filepath2;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private static boolean usageHelpRequested;
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private static boolean versionInfoRequested;

    public static void main(String[] args) throws IOException {
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
    }

    public void call(String filePath1, String filePath2) throws IOException {
        String result = Differ.generate(filePath1, filePath2, format);
        System.out.println(result);
    }
}
