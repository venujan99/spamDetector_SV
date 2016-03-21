package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private BorderPane layout;
    private TableView table;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("FileShare");
      //  primaryStage.setScene(new Scene(root, 800, 600));


    /* create the table (for the center of the user interface) */
        table = new TableView<>();


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
        layout.setTop(editArea);
        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }




        public static void main(String[] args) {
        launch(args);
    }
};