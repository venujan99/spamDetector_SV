package spamDetector;

/**
 * Created by venujan on 04/03/16.
 */
public class Spam {

    private int fileName;
    private String actualClass;
    private double spamProbability;

    public Spam(int fileName, String actualClass, double spamProbability) {

        this.fileName = fileName;
        this.actualClass = actualClass;
        this.spamProbability = spamProbability;
    }

    public int getFileName() { return this.fileName; }
    public String getActualClass() { return this.actualClass; }
    public double getSpamProbability() { return this.spamProbability; }

    public void setFileName(int fileName) { this.fileName = fileName; }
    public void setActualClass(String actualClass) { this.actualClass = actualClass; }
    public void setSpamProbability(double spamProbability) { this.spamProbability = spamProbability; }
}
