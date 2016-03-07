package spamDetector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by venujan on 06/03/16.
 */
public class DataSource {

    public static ObservableList<Spam> getAllStudents() {
        ObservableList<Spam> students = FXCollections.observableArrayList();

        students.add(new Spam(100100100, "Janet", 2.85));
        students.add(new Spam(100100101, "Abichal", 2.90));
        students.add(new Spam(100100102, "Cecile", 3.4));
        students.add(new Spam(100100103, "Pablo", 4.0));
        students.add(new Spam(100100104, "Flora", 4.3));


        return students;
    }
}
