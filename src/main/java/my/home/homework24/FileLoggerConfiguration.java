package my.home.homework24;

public class FileLoggerConfiguration extends BaseLoggerConfiguration {
    private String fileName;
    private long fileSize;

    public String getFile() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

}
