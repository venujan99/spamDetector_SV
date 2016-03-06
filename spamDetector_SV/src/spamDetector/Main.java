package spamDetector;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        gpaColumn = new TableColumn<>("Spam Probability");
        gpaColumn.setMinWidth(300);
        gpaColumn.setCellValueFactory(new PropertyValueFactory<>("spamProbability"));

        table.getColumns().add(firstNameColumn);
        table.getColumns().add(lastNameColumn);
        table.getColumns().add(gpaColumn);

        /* create an edit form (for the bottom of the user interface) */
        GridPane editArea = new GridPane();
        editArea.setPadding(new Insets(10, 10, 10, 10));
        editArea.setVgap(10);
        editArea.setHgap(10);

        Label sidLabel = new Label("SID:");
        editArea.add(sidLabel, 0, 0);
        TextField sidField = new TextField();
        sidField.setPromptText("SID");
        editArea.add(sidField, 1, 0);

        Label fnameLabel = new Label("First name:");
        editArea.add(fnameLabel, 0, 1);
        TextField fnameField = new TextField();
        fnameField.setPromptText("First Name");
        editArea.add(fnameField, 1, 1);

        Label lnameLabel = new Label("Last name:");
        editArea.add(lnameLabel, 0, 2);
        TextField lnameField = new TextField();
        lnameField.setPromptText("Last Name");
        editArea.add(lnameField, 1, 2);

        Label gpaLabel = new Label("GPA:");
        editArea.add(gpaLabel, 0, 3);
        TextField gpaField = new TextField();
        gpaField.setPromptText("GPA");
        editArea.add(gpaField, 1, 3);

        Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                int sid = Integer.parseInt(sidField.getText());
                String firstName = fnameField.getText();
                String lastName = lnameField.getText();
                double gpa = Double.parseDouble(gpaField.getText());

                table.getItems().add(new Spam(sid, firstName, lastName, gpa));

                sidField.setText("");
                fnameField.setText("");
                lnameField.setText("");
                gpaField.setText("");
            }
        });
        editArea.add(addButton, 1, 4);

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
