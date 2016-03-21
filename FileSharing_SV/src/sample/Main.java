package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private BorderPane layout;
    private TableView table;
    private TableView table2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("FileShare");
      //  primaryStage.setScene(new Scene(root, 800, 600));


    /* create the table (for the center of the user interface) */
        table = new TableView<>();
        table.setItems(null);
        table.setEditable(true);

        TableColumn uploadNameColumn = null;
        uploadNameColumn = new TableColumn<>("Local Shared Folder");
        uploadNameColumn.setMinWidth(295);
        uploadNameColumn.setCellValueFactory(new PropertyValueFactory<>("uploadfileName"));

        table.getColumns().add(uploadNameColumn);


        table2 = new TableView<>();
        table2.setItems(null);
        table2.setEditable(true);

        TableColumn downloadNameColumn = null;
        downloadNameColumn = new TableColumn<>("Download Files");
        downloadNameColumn.setMinWidth(295);
        downloadNameColumn.setCellValueFactory(new PropertyValueFactory<>("downloadfileName"));


        table2.getColumns().add(downloadNameColumn);


        /* create an edit form (for the bottom of the user interface) */
        GridPane editArea = new GridPane();
        editArea.setPadding(new Insets(10, 10, 10, 10));
        editArea.setVgap(10);
        editArea.setHgap(10);


        Button addButton = new Button("Download");
        Button addBtn2 = new Button("Upload");

        /*addButton.setOnAction(new EventHandler<ActionEvent>()
      /*  {
            @Override public void handle(ActionEvent e) {}
        });
    }*/

        editArea.add(addButton,1,0);
        editArea.add(addBtn2,2,0);
        layout = new BorderPane();
        layout.setLeft(table);
        layout.setRight(table2);
        layout.setTop(editArea);
        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }




        public static void main(String[] args) {
        launch(args);
    }
};