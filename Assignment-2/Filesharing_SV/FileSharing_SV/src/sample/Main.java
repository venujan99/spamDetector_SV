package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Main extends Application {
    private BorderPane layout;
    private TableView <FileInfo> uploadTable;
    private TableView <FileInfo> downloadTable;
    private TableColumn<FileInfo, String> localFilesCol;
    private TableColumn<FileInfo, String> remoteFilesCol;
    private Map<String,Integer> wordCounts;



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("FileShare");
      //  primaryStage.setScene(new Scene(root, 800, 600));


    /* create the table (for the center of the user interface) */
        uploadTable = new TableView<>();
        uploadTable.setItems(null);
        uploadTable.setEditable(true);

        TableColumn uploadNameColumn = null;
        uploadNameColumn = new TableColumn<>("Local Shared Folder");
        uploadNameColumn.setMinWidth(295);
        uploadNameColumn.setCellValueFactory(new PropertyValueFactory<>("uploadfileName"));

        uploadTable.getColumns().add(uploadNameColumn);


        downloadTable = new TableView<>();
        downloadTable.setItems(null);
        downloadTable.setEditable(true);

        TableColumn downloadNameColumn = null;
        downloadNameColumn = new TableColumn<>("Download Files");
        downloadNameColumn.setMinWidth(295);
        downloadNameColumn.setCellValueFactory(new PropertyValueFactory<>("downloadfileName"));


        downloadTable.getColumns().add(downloadNameColumn);


        /* create an edit form (for the bottom of the user interface) */
        GridPane editArea = new GridPane();
        editArea.setPadding(new Insets(10, 10, 10, 10));
        editArea.setVgap(10);
        editArea.setHgap(10);


        Button downloadBtn = new Button("Download");







        Button uploadBtn = new Button("Upload");

        uploadBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TablePosition tablePosition = uploadTable.getSelectionModel().getSelectedCells().get(0);
                int row = tablePosition.getRow();
                FileInfo fileRecord = uploadTable.getItems().get(row);
                TableColumn column = tablePosition.getTableColumn();
                String fileName = (String) column.getCellObservableValue(fileRecord).getValue();
                System.out.println("fileName selected = " + fileName);
                connect();
                out.println("UPLOAD " + fileName);
                out.flush();
                String line;
                try {
                    fileIn = new BufferedReader(new FileReader(myDirectory.getPath() + "\\" + fileName));
                    while ((line = fileIn.readLine()) != null) {
                        System.out.println("File content: " + line);
                        out.println(line);
                        out.flush();
                    }
                    out.println("\0");
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("File upload complete");
                // Refresh file listing
                if (!downloadTable.getItems().contains(fileRecord)) {
                    downloadTable.getItems().add(fileRecord);
                }
                //connect();
                //Thread t = new Thread(new ConnectionHandler());
                //t.start();


            }
        });


        /*addButton.setOnAction(new EventHandler<ActionEvent>()
      /*  {
            @Override public void handle(ActionEvent e) {}
        });
    }*/

        editArea.add(uploadBtn,1,0);
        editArea.add(downloadBtn,2,0);
        layout = new BorderPane();
        layout.setLeft(uploadTable);
        layout.setRight(downloadTable);
        layout.setTop(editArea);
        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }




        public static void main(String[] args) {
        launch(args);
    }
};