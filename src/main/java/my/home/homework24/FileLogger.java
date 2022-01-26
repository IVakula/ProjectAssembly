package my.home.homework24;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends AbstractLogger<FileLoggerConfiguration> {

    public FileLogger(FileLoggerConfiguration configuration) {
        super(configuration);
    }

    @Override
   protected void writeToFile(String message, LoggingLevel loggingLevel) {
        File file = new File(getConfiguration().getFile());
        if (file.exists() && file.length() >= getConfiguration().getFileSize()) {
            throw new FileMaxSizeReachedException(String.format("Max file size: %s, current size: %s, file path: %s",
                    getConfiguration().getFileSize(), file.length(),
                    getConfiguration().getFile()));
        }
        if (checkLevel(loggingLevel)) {
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(message);
                fileWriter.write("\n");
                fileWriter.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
