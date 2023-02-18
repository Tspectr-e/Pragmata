import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
    
    private ListView<String> toDoListView;
    private TextField toDoTextField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("To-Do List");

        // Create a ListView to display the to-do items
        toDoListView = new ListView<String>();
        toDoListView.setItems(FXCollections.observableArrayList());

        // Create a TextField to allow users to add new to-do items
        toDoTextField = new TextField();

        // Create a button to add new to-do items
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addToDoItem());

        // Create a layout to hold the text field and the button
        HBox inputBox = new HBox(10);
        inputBox.getChildren().addAll(toDoTextField, addButton);
        inputBox.setPadding(new Insets(10));

        // Create a border pane to hold the ListView and the input layout
        BorderPane root = new BorderPane();
        root.setCenter(toDoListView);
        root.setBottom(inputBox);

        // Set the scene
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addToDoItem() {
        String item = toDoTextField.getText().trim();
        if (!item.isEmpty()) {
            toDoListView.getItems().add(item);
            toDoTextField.clear();
        }
    }
}
