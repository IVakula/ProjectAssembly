package my.home.homework24;

public class BaseLoggerConfiguration {
    private LoggingLevel level;
    private String formatString;

    public LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }

    public String getFormatString() {
        return formatString;
    }

    public void setFormatString(String formatString) {
        this.formatString = formatString;
    }
}
