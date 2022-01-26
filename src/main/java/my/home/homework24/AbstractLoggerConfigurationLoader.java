package my.home.homework24;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractLoggerConfigurationLoader<T extends BaseLoggerConfiguration>{
    public  T load(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.length() > 0) {
            T configuration= generateNewInstance();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                bufferedReader.lines().forEach(line -> oneLineProcessing(line, configuration));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return configuration;
        }
        return null;
    }
    protected abstract void oneLineProcessing(String line, T configuration);
    protected abstract T generateNewInstance();

}
