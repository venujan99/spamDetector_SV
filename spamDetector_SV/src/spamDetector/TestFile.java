package spamDetector;

import java.text.DecimalFormat;

/**
 * Created by venujan on 04/03/16.
 */
public class TestFile {


    private String fileName;
    private double spamProbability;
    private String actualClass;
    public TestFile(String fileName,
                    String actualClass,
                    double spamProbability) {
        this.fileName = fileName;
        this.spamProbability = spamProbability;
        this.actualClass = actualClass;
    }
    public String getFileName() { return this.fileName; }
    public double getSpamProbability() { return this.spamProbability; }
    public String getSpamProbRounded() {
        DecimalFormat df = new DecimalFormat("0.00000");
        return df.format(this.spamProbability);
    }
    public String getActualClass() { return this.actualClass; }
    public void setFileName(String value) { this.fileName = value; }
    public void setSpamProbability(double val) { this.spamProbability = val; }
    public void setActualClass(String value) { this.actualClass = value; }


}
