package my.home.homework24;

public class FileLoggerConfigurationLoader extends AbstractLoggerConfigurationLoader<FileLoggerConfiguration> {

    @Override
    protected void oneLineProcessing(String line, FileLoggerConfiguration configuration) {
        if (line.startsWith("FILE:")) {
            configuration.setFileName(line.split(":")[1].trim());
        } else if (line.startsWith("LEVEL:")) {
            configuration.setLevel(LoggingLevel.valueOf(line.split(":")[1].trim()));
        } else if (line.startsWith("MAX-SIZE:")) {
            configuration.setFileSize(Long.parseLong(line.split(":")[1].trim()));
        } else if (line.startsWith("FORMAT:")) {
            configuration.setFormatString(line.split("AT:")[1].trim());
        }
    }

    @Override
    protected FileLoggerConfiguration generateNewInstance() {
        return new FileLoggerConfiguration();
    }
}
