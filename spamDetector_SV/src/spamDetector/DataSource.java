package spamDetector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by venujan on 06/03/16.
 */
public class DataSource {

    private ArrayList<String> words;

   public static ObservableList<TestFile> getAllSpam() {
        ObservableList<TestFile> spamMessages = FXCollections.observableArrayList();


        spamMessages.add(new TestFile(Main.fList.toString(), "Ham", 2.85));
        spamMessages.add(new TestFile("100100101", "Spam", 2.90));
        spamMessages.add(new TestFile("100100102", "Spam", 3.4));
        spamMessages.add(new TestFile("100100103", "Ham", 4.0));
        spamMessages.add(new TestFile("100100104", "Spam", 4.3));

        return spamMessages;
    }
}
