package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.")
public class App {
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
