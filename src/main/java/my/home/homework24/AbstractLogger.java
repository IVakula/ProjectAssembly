package my.home.homework24;

import java.time.LocalDateTime;

public abstract class AbstractLogger<T extends BaseLoggerConfiguration> implements MyLogger {
    private final T configuration;

    public AbstractLogger(T configuration) {
        this.configuration = configuration;
    }

    protected abstract void writeToFile(String message, LoggingLevel loggingLevel);

    protected boolean checkLevel(LoggingLevel loggingLevel) {
        if (LoggingLevel.DEBUG.equals(configuration.getLevel())) {
            return true;
        } else return LoggingLevel.INFO.equals(loggingLevel);
    }

    @Override
    public void debug(String message) {
        writeToFile(String.format(configuration.getFormatString(),
                LocalDateTime.now(), "DEBUG", message), LoggingLevel.DEBUG);
    }

    @Override
    public void info(String message) {
        writeToFile(String.format(configuration.getFormatString(),
                LocalDateTime.now(), "INFO", message), LoggingLevel.INFO);
    }

    public T getConfiguration() {
        return configuration;
    }
}
