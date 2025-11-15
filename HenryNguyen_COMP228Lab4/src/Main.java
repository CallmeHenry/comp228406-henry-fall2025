import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.util.List;
import java.util.ArrayList;

public class Main extends Application {
    private BorderPane border;
    private List<TextField> studentFields = new ArrayList<>();
    private List<String> selectedCourses = new ArrayList<>();
    private List<CheckBox> additionalInfo = new ArrayList<>();


    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createPane(), 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Region createPane() {
        BorderPane border = new BorderPane();
        border.setTop(createTop());
        border.setLeft(createLeft());
        border.setCenter(createStudentForm());
        border.setBottom(createTextArea());
        this.border = border;
        return border;
    }

    private Region createTop() {
        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(18, 12, 18, 12));
        hbox.setStyle("-fx-background-color: #5899ed");

        Text title = new Text("Student Form Application");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        hbox.getChildren().add(title);
        hbox.setAlignment(Pos.CENTER);

        return hbox;
    }

    private Region createLeft() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Text title = new Text("Options");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        Hyperlink options[] = new Hyperlink[]{
                new Hyperlink("Student Form"),
                new Hyperlink("Major"),
                new Hyperlink("Additional Information")
        };

        for (Hyperlink option : options) {
            VBox.setMargin(option, new Insets(0, 0, 0, 8));
            vbox.getChildren().add(option);
        }

        options[0].setOnAction(e -> border.setCenter(createStudentForm()));
        options[1].setOnAction(e -> border.setCenter(createMajorForm()));
        options[2].setOnAction(e -> border.setCenter(createAdditionalForm()));

        return vbox;
    }

    private Region createStudentForm() {
        VBox form = new VBox(20);
        form.setPadding(new Insets(20));

        Text title = new Text("Student Form");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        form.getChildren().add(title);

        String[] labels = {
                "Name",
                "Address",
                "Province",
                "City",
                "Postal Code",
                "Phone Number",
                "Email"
        };

        for (String label : labels) {
            Label foo = new Label(label + ":");
            foo.setMinWidth(150);
            TextField bar = new TextField();
            HBox field = new HBox(foo, bar);
            studentFields.add(bar);
            field.setAlignment(Pos.CENTER);
            form.getChildren().add(field);
        }
        form.setAlignment(Pos.TOP_CENTER);

        return form;
    }

    private Region createMajorForm() {
        VBox form = new VBox(20);
        form.setPadding(new Insets(20));


        RadioButton compsci = new RadioButton();
        Label compsciLabel = new Label("Computer Science");
        compsciLabel.setMinWidth(150);

        HBox compsciRow = new HBox(10, compsci, compsciLabel);
        compsciRow.setAlignment(Pos.CENTER);

        RadioButton business = new RadioButton();
        Label busLabel = new Label("Business");
        busLabel.setMinWidth(150);

        HBox businessRow = new HBox(10, business, busLabel);
        businessRow.setAlignment(Pos.CENTER);

        ToggleGroup group = new ToggleGroup();
        compsci.setToggleGroup(group);
        business.setToggleGroup(group);

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPromptText("Select a course");

        String[] compsciCourses = {"Python", "C#", "Java"};
        String[] businessCourses = {"Sales", "Marketing", "Business"};

        ListView<String> lv = new ListView<>();
        List<String> selectedCourses = new ArrayList<>();

        compsci.setOnAction(e -> {
            if (compsci.isSelected()) {
                comboBox.getItems().setAll(compsciCourses);
            }
        });

        business.setOnAction(e -> {
            if (business.isSelected()) {
                comboBox.getItems().setAll(businessCourses);
            }
        });

        comboBox.setOnAction(e -> {
            String selected = comboBox.getValue();

            boolean flag = false;
            for (String course : selectedCourses) {
                if (course.equals(selected)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                selectedCourses.add(selected);
                lv.setItems(FXCollections.observableList(selectedCourses));
                this.selectedCourses = selectedCourses;
            }

        });

        form.getChildren().addAll(compsciRow, businessRow, comboBox, lv);
        form.setAlignment(Pos.TOP_CENTER);

        return form;
    }

    private Region createAdditionalForm() {
        VBox form = new VBox(20);
        form.setPadding(new Insets(10));

        Text title = new Text("Additional Information");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        form.getChildren().add(title);

        String[] additionalInfo = {
                "Student Council",
                "Volunteer Work",
                "Dean's List",
                "Full-time",
                "Part-time",
                "Co-op"
        };

        for (String info : additionalInfo) {
            CheckBox cb = new CheckBox(info);
            form.getChildren().add(cb);
            this.additionalInfo.add(cb);
        }

        form.setAlignment(Pos.TOP_CENTER);

        return form;
    }

    private Region createTextArea() {
        VBox form = new VBox(20);
        form.setPadding(new Insets(10));
        form.setAlignment(Pos.CENTER);

        TextArea textArea = new TextArea();

        Button display = new Button("Display");
        display.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();

            sb.append("Student Info:\n");
            for (int i = 0; i < studentFields.size(); i++) {
                sb.append(studentFields.get(i).getText());
            }
            sb.append("\n").append("\nCourses:\n");
            for (String course : selectedCourses) {
                sb.append(course).append("\n");
            }

            sb.append("\n").append("Additional Information:\n");
            for (CheckBox checkbox : this.additionalInfo) {
                if (checkbox.isSelected()) {
                    sb.append(checkbox.getText()).append("\n");
                }
            }
            textArea.setText(sb.toString());
        });

        form.getChildren().addAll(display, textArea);

        return form;
    }

    public static void main(String[] args) {
        launch(args);
    }
}