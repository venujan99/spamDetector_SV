package spamDetector;

/**
 * Created by venujan on 04/03/16.
 */
public class Spam {

    private int fileName;
    private String lastName;
    private double gpa;

    public Spam(int fileName, String lastName, double gpa) {

        this.fileName = fileName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    public int getFileName() { return this.fileName; }
    public String getLastName() { return this.lastName; }
    public double getGpa() { return this.gpa; }

    public void setFileName(int fileName) { this.fileName = fileName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setGpa(double gpa) { this.gpa = gpa; }
}
