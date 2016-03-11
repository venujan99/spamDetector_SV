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

           //getting the file info and creating a row
           //could not get the next file's name, but able to print in console output.
           spamMessages.add(new TestFile(Main.list.get(0).toString(), Main.className , 0.00));

       }

        return spamMessages;
    }
}
