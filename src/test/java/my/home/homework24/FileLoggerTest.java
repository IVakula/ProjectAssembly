package my.home.homework24;

import org.junit.jupiter.api.*;

import java.io.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FileLoggerTest {
    private static final String FILE_PATH = "/home/ivakula/MyProjects/ProjectAssembly/logWithoutLoader.log";
    private  FileLogger fileLogger;

    @BeforeAll
    public void initialisation() {
        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration();
        fileLoggerConfiguration.setFileName(FILE_PATH);
        fileLoggerConfiguration.setLevel(LoggingLevel.INFO);
        fileLoggerConfiguration.setFormatString("[%s] [%s] MESSAGE : [%s]");
        fileLoggerConfiguration.setFileSize(90);

        fileLogger = new FileLogger(fileLoggerConfiguration);
    }

    @Test
    @Order(1)
    public void testInfoMessage_whenLoggingLevelInfo() throws IOException {
        fileLogger.info("Info test message");
        FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        Assertions.assertTrue(line.contains("Info test message"));
    }

    @Test
    @Order(2)
    public void testInfoMessage_whenThrowFileMaxSizeReachedException() {
        Assertions.assertThrows(FileMaxSizeReachedException.class,()->{
                    fileLogger.info("Info test message for throw File max size reached Exception");
                    fileLogger.info("Info test message for throw File max size reached Exception");
                    fileLogger.info("Info test message for throw File max size reached Exception");
                }
            );

    }

    @AfterAll
    public  void finalisation(){
        File file = new File(FILE_PATH);
        file.delete();
    }
}
