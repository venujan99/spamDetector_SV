package spamDetector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by venujan on 06/03/16.
 */
public class DataSource {

    private ArrayList<String> words;
    private static int i = 0;


   public static ObservableList<TestFile> getAllSpam() {
        ObservableList<TestFile> spamMessages = FXCollections.observableArrayList();

        //creating the table info
       //getting the file name from the method in Main class

       for (File file : Main.fList) {

           spamMessages.add(new TestFile(Main.list.get(0).toString(), Main.className , 2.85));

       }

       /* spamMessages.add(new TestFile(Main.list.toString(), Main.className , 2.85));
        spamMessages.add(new TestFile("100100101", "", 2.90));
        spamMessages.add(new TestFile("100100102", "", 3.4));
        spamMessages.add(new TestFile("100100103", "", 4.0));
        spamMessages.add(new TestFile("100100104", "", 4.3));*/

       //above code used for testing hardcoded

        return spamMessages;
    }
}
