package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.")
public class App {
    @Option(names = {"-f", "--format"}, paramLabel="format", description = "output format [default: stylish]")
    String format = "stylish";
    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    String filepath1;
    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    String filepath2;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new App());
        commandLine.parseArgs(args);
        if (commandLine.isUsageHelpRequested()) {
            commandLine.usage(System.out);
            return;
        } else if (commandLine.isVersionHelpRequested()) {
            commandLine.printVersionHelp(System.out);
            return;
        }

        System.out.println("Hello World!");
    }
}
