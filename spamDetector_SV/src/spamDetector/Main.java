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
import javafx.stage.Stage;

public class Main extends Application {

    private Stage window;
    private BorderPane layout;
    private javafx.scene.control.TableView<Spam> table;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Spam Detector");

        /* create the table (for the center of the user interface) */
        table = new TableView<>();
      //  table.setItems(DataSource.getAllStudents());
        table.setEditable(true);

        /* create the table's columns */
       /* TableColumn<Spam,Integer> sidColumn = null;
        sidColumn = new TableColumn<>("SID");
        sidColumn.setMinWidth(100);
        sidColumn.setCellValueFactory(new PropertyValueFactory<>("sid"));
*/
        TableColumn<Spam,String> firstNameColumn = null;
        firstNameColumn = new TableColumn<>("File");
        firstNameColumn.setMinWidth(300);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("file"));
        firstNameColumn.setCellFactory(TextFieldTableCell.<Spam>forTableColumn());
        firstNameColumn.setOnEditCommit((TableColumn.CellEditEvent<Spam, String> event) -> {
            ((Spam)event.getTableView().getItems().get(event.getTablePosition().getRow())).setFirstName(event.getNewValue());
        });

        TableColumn<Spam,String> lastNameColumn = null;
        lastNameColumn = new TableColumn<>("Actual Class");
        lastNameColumn.setMinWidth(150);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("actualClass"));
        lastNameColumn.setCellFactory(TextFieldTableCell.<Spam>forTableColumn());
        lastNameColumn.setOnEditCommit((TableColumn.CellEditEvent<Spam, String> event) -> {
            ((Spam)event.getTableView().getItems().get(event.getTablePosition().getRow())).setLastName(event.getNewValue());
        });

        TableColumn<Spam,Double> gpaColumn = null;

        /* create an edit form (for the bottom of the user interface) */
        GridPane editArea = new GridPane();
        editArea.setPadding(new Insets(10, 10, 10, 10));
        editArea.setVgap(10);
        editArea.setHgap(10);

        Label sidLabel = new Label("Accuracy:");
        editArea.add(sidLabel, 0, 0);
        TextField sidField = new TextField();
        sidField.setPromptText("");
        editArea.add(sidField, 1, 0);

        Label fnameLabel = new Label("Precision:");
        editArea.add(fnameLabel, 0, 1);
        TextField fnameField = new TextField();
        fnameField.setPromptText("");
        editArea.add(fnameField, 1, 1);



       /* Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                int sid = Integer.parseInt(sidField.getText());
                String firstName = fnameField.getText();


                table.getItems().add(new Spam(sid, firstName));

                sidField.setText("");
                fnameField.setText("");
            }
        });
        editArea.add(addButton, 1, 4); */

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
