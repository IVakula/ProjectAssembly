package my.home.homework24;

public class StdoutLoggerConfigurationLoader extends AbstractLoggerConfigurationLoader<BaseLoggerConfiguration> {
    @Override
    protected void oneLineProcessing(String line, BaseLoggerConfiguration configuration) {

        if (line.startsWith("LEVEL:")) {
            configuration.setLevel(LoggingLevel.valueOf(line.split(":")[1].trim()));
        } else if (line.startsWith("FORMAT:")) {
            configuration.setFormatString(line.split("AT:")[1].trim());
        }
    }

    @Override
    protected BaseLoggerConfiguration generateNewInstance() {
        return new BaseLoggerConfiguration();
    }
}
