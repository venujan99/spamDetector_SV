package sample;

import java.io.File;

/**
 * Created by venujan on 24/03/16.
 */
public class FileInfo {

    private File actualFile;
    private String fileName;

    public FileInfo(String fileName) {
        this.fileName = fileName;
    }
    public FileInfo(File actualFile) {
        this.actualFile = actualFile;
        this.fileName = actualFile.getName();
    }
    public String getFileName() {
        //return this.fileName;
        return fileName;
    }
    public File getActualFile() {
        return actualFile;
    }
}
