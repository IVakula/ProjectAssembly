package my.home.homework24;

public enum Fields {
    FILE("FILE:"){
        public void fieldLoad(String line, FileLoggerConfiguration configuration){
            configuration.setFileName(line.split(":")[1].trim());
        }
    },

    LEVEL("LEVEL:") {
        public void fieldLoad(String line, FileLoggerConfiguration configuration) {
            configuration.setLevel(LoggingLevel.valueOf(line.split(":")[1].trim()));
        }
    },

    MAX_SIZE("MAX-SIZE:"){
        public void fieldLoad(String line, FileLoggerConfiguration configuration) {
            configuration.setFileSize(Long.parseLong(line.split(":")[1].trim()));
        }
    },

    FORMAT("FORMAT:"){
        public void fieldLoad(String line, FileLoggerConfiguration configuration) {
            configuration.setFormatString(line.split("AT:")[1].trim());
        }
    };

    private  final  String description;

    Fields(String field) {
        this.description = field;
    }

    public String getDescription() {
        return description;
    }

    public abstract void fieldLoad(String line, FileLoggerConfiguration configuration);

}
