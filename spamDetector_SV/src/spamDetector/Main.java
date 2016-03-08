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
import java.util.List;

public class Main extends Application {

    private Stage window;
    private BorderPane layout;
    private TableView<TestFile> table;
    public static File[] fList;
    public static List list;



    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Spam Detector");

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("."));
        File mainDirectory = directoryChooser.showDialog(primaryStage);

        File directory = new File(String.valueOf(mainDirectory));

        //get all the files from a directory and putting into a list
        fList = directory.listFiles();


        for (File file : fList) {

            if (file.isFile()) {

                // System.out.println(file.getName());
                List<String> list = new ArrayList<String>();
                list.add(file.getName());
                System.out.println(list);

            }
        }

        /* create the table (for the center of the user interface) */
        table = new TableView<>();
        table.setItems(DataSource.getAllSpam());
        table.setEditable(true);


        TableColumn<TestFile, String> fileNameColumn = null;
        fileNameColumn = new TableColumn<>("File");
        fileNameColumn.setMinWidth(300);
        fileNameColumn.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        fileNameColumn.setOnEditCommit((TableColumn.CellEditEvent<TestFile, String> event) -> {
            ((TestFile) event.getTableView().getItems().get(event.getTablePosition().getRow())).setFileName(event.getNewValue());
        });

        TableColumn<TestFile, String> actualClassColumn = null;
        actualClassColumn = new TableColumn<>("Actual Class");
        actualClassColumn.setMinWidth(150);
        actualClassColumn.setCellValueFactory(new PropertyValueFactory<>("actualClass"));
        actualClassColumn.setCellFactory(TextFieldTableCell.<TestFile>forTableColumn());
        actualClassColumn.setOnEditCommit((TableColumn.CellEditEvent<TestFile, String> event) -> {
            ((TestFile) event.getTableView().getItems().get(event.getTablePosition().getRow())).setActualClass(event.getNewValue());
        });

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


        /* arrange all components in the main user interface */
        layout = new BorderPane();
        // layout.setTop(menuBar);
        layout.setCenter(table);
        layout.setBottom(editArea);

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);


    }


}


