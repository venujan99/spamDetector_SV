package spamDetector;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main extends Application {

    private Stage window;
    private BorderPane layout;
    private TableView<TestFile> table;
    public static File[] fList;
    public static ArrayList<String> list;
    public static String className;

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Spam Detector");



        //training
        Map<String, Integer> trainHamFreq = new TreeMap<>();
        int hamFileCount=0;
        for (File fileEntry:new File("./data/train/ham").listFiles()){
            hamFileCount++;
        }
        ScanFile trainHam= new ScanFile("./data/train/ham", trainHamFreq);
        trainHamFreq = trainHam.readFiles(new File("./data/train/ham"), trainHamFreq);

        int spamFileCount=0;
        for (File fileEntry:new File("./data/train/spam").listFiles()){
            spamFileCount++;
        }

        Map<String, Integer> trainSpamFreq = new TreeMap<>();
        ScanFile trainSpam= new ScanFile("./data/train/spam", trainSpamFreq);
        trainSpamFreq = trainSpam.readFiles(new File("./data/train/spam"), trainSpamFreq);

        //probability words
        Map hamWordFolder = trainHam.getProbabilities(trainHamFreq,hamFileCount);

        Map spamWordFolder = trainSpam.getProbabilities(trainSpamFreq,spamFileCount);

        Probabilities spam=new Probabilities(hamWordFolder,spamWordFolder);

        Map spamWords = spam.spamProbability(hamWordFolder,spamWordFolder);








        // Opening the file dialog to allow user to choose a directory
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("."));
        File mainDirectory = directoryChooser.showDialog(primaryStage);

        // getting the name of the directory chosen
        File directory = new File(String.valueOf(mainDirectory));

        if (String.valueOf(mainDirectory).endsWith("ham") || String.valueOf(mainDirectory).endsWith("ham2"))
        {
            className = "Ham";
        }

        if (String.valueOf(mainDirectory).endsWith("spam"))
        {
            className = "Spam";
        }

        //get all the files from a directory and putting into a list
        fList = directory.listFiles();

        // for loop to add each file name into an ArrayList
        for (File file : fList) {

            if (file.isFile()) {

                //list = new ArrayList<String>();
                list.add(file.getName());
            }
        }

        System.out.println(list.size());

        //initializing tableview
        table = new TableView<>();
        //calling the getAllSpam method to set table values
        table.setItems(DataSource.getAllSpam());
        table.setEditable(true);

        //creating filename column
        TableColumn<TestFile, String> fileNameColumn = null;
        fileNameColumn = new TableColumn<>("File");
        fileNameColumn.setMinWidth(400);
        fileNameColumn.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        fileNameColumn.setOnEditCommit((TableColumn.CellEditEvent<TestFile, String> event) -> {
            ((TestFile) event.getTableView().getItems().get(event.getTablePosition().getRow())).setFileName(event.getNewValue());
        });

        //creating actualClass column
        TableColumn<TestFile, String> actualClassColumn = null;
        actualClassColumn = new TableColumn<>("Actual Class");
        actualClassColumn.setMinWidth(150);
        actualClassColumn.setCellValueFactory(new PropertyValueFactory<>("actualClass"));
        actualClassColumn.setCellFactory(TextFieldTableCell.<TestFile>forTableColumn());
        actualClassColumn.setOnEditCommit((TableColumn.CellEditEvent<TestFile, String> event) -> {
            ((TestFile) event.getTableView().getItems().get(event.getTablePosition().getRow())).setActualClass(event.getNewValue());
        });

        //creating spamProbability column
        TableColumn<TestFile, Double> spamProbabilityColumn = null;
        spamProbabilityColumn = new TableColumn<>("Spam Probability");
        spamProbabilityColumn.setMinWidth(300);
        spamProbabilityColumn.setCellValueFactory(new PropertyValueFactory<>("spamProbability"));

        table.getColumns().add(fileNameColumn);
        table.getColumns().add(actualClassColumn);
        table.getColumns().add(spamProbabilityColumn);

        /* create an edit form (for the bottom of the user interface) */
        GridPane editArea = new GridPane();
        editArea.setPadding(new Insets(10, 10, 10, 10));
        editArea.setVgap(10);
        editArea.setHgap(10);

        //labels for bottom of UI
        Label accuracyLabel = new Label("Accuracy:");
        editArea.add(accuracyLabel, 0, 0);
        TextField accField = new TextField();
        accField.setPromptText("");
        editArea.add(accField, 1, 0);

        Label precisionLabel = new Label("Precision:");
        editArea.add(precisionLabel, 0, 1);
        TextField precisionField = new TextField();
        precisionField.setPromptText("");
        editArea.add(precisionField, 1, 1);


        layout = new BorderPane();
        layout.setCenter(table);
        layout.setBottom(editArea);

        //screen size
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);


    }


}