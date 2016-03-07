package spamDetector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by venujan on 06/03/16.
 */
public class DataSource {

    public static ObservableList<TestFile> getAllSpam() {
        ObservableList<TestFile> spamMessages = FXCollections.observableArrayList();

        spamMessages.add(new TestFile("100100100", "Janet", 2.85));
        spamMessages.add(new TestFile("100100101", "Abichal", 2.90));
        spamMessages.add(new TestFile("100100102", "Cecile", 3.4));
        spamMessages.add(new TestFile("100100103", "Pablo", 4.0));
        spamMessages.add(new TestFile("100100104", "Flora", 4.3));


        return spamMessages;
    }
}
