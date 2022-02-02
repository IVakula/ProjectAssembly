package my.home.homework24;

public class StdoutLogger extends AbstractLogger<BaseLoggerConfiguration> {
    public StdoutLogger(BaseLoggerConfiguration configuration) {
        super(configuration);
    }

    @Override
    protected void writeToFile(String message, LoggingLevel loggingLevel) {
        if (checkLevel(loggingLevel)) {
            System.out.println(message);
        }
    }
}


