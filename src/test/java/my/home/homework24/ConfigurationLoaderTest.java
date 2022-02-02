package my.home.homework24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConfigurationLoaderTest {
    @Test
    public void testFileConfigurationLoader() {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration fileLoggerConfiguration = loader
                .load("/home/ivakula/MyProjects/ProjectAssembly/src/test/resources/Configuration.conf");

        Assertions.assertEquals("/path/to/log/file", fileLoggerConfiguration.getFile());
        Assertions.assertEquals(LoggingLevel.DEBUG, fileLoggerConfiguration.getLevel());
        Assertions.assertEquals(250L, fileLoggerConfiguration.getFileSize());
        Assertions.assertEquals("[%s] [%s] MESSAGE : [%s]", fileLoggerConfiguration.getFormatString());
    }

    @Test
    public void testMultiFileConfigurationLoader() {
        FileLoggerConfigurationLoader multiLoader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration multiFileLoggerConfiguration = multiLoader
                .load("/home/ivakula/MyProjects/ProjectAssembly/src/test/resources/MultiConfiguration.conf");

        Assertions.assertEquals("/path/to/log/directory", multiFileLoggerConfiguration.getFile());
        Assertions.assertEquals(LoggingLevel.INFO, multiFileLoggerConfiguration.getLevel());
        Assertions.assertEquals(250L, multiFileLoggerConfiguration.getFileSize());
        Assertions.assertEquals("[%s] [%s] MESSAGE : [%s]", multiFileLoggerConfiguration.getFormatString());
    }

    @Test
    public void testStdoutConfigurationLoader() {
        StdoutLoggerConfigurationLoader stdoutLoader = new StdoutLoggerConfigurationLoader();
        BaseLoggerConfiguration baseLoggerConfiguration = stdoutLoader
                .load("/home/ivakula/MyProjects/ProjectAssembly/src/test/resources/StdoutConfiguration.conf");

        Assertions.assertEquals(LoggingLevel.DEBUG, baseLoggerConfiguration.getLevel());
        Assertions.assertEquals("[%s] [%s] MESSAGE : [%s]", baseLoggerConfiguration.getFormatString());
    }
}
