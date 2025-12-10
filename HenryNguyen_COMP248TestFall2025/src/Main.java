import controllers.*;
import models.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class Main extends Application {
    private StudentData studentData = new StudentData();

    @Override
    public void start(Stage stage) {
        Label cityLabel = new Label("Select student by city:");

        TextField cityField = new TextField();

        Button displayBtn = new Button("Display");

        TextArea textArea = new TextArea();


        displayBtn.setOnAction(e -> {
            String city = cityField.getText();
            for (Student s : studentData.getStudents(city)) {
                textArea.appendText(s.toString());
            }
        });

        GridPane top = new GridPane();

        top.add(cityLabel, 0, 0);
        top.add(cityField, 1, 0);
        top.add(displayBtn, 1, 1);

        BorderPane border = new BorderPane();
        border.setTop(top);
        border.setCenter(textArea);

        Scene scene = new Scene(border, 620, 410);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        stage.setTitle("Student Info");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}