import java.sql.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.util.ArrayList;

public class Main extends Application {
    private BorderPane border;
    private TextArea textArea = new TextArea();
    private Integer currentPlayerId;
    private ComboBox<Integer> playerBox;

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createPane(), 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lab 5");
        primaryStage.show();
    }

    private Region createPane() {
        border = new BorderPane();
        border.setTop(createTop());
        border.setLeft(createLeft());
        border.setCenter(createPlayerForm());
        return border;
    }

    private Region createTop() {
        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(18, 12, 18, 12));
        hbox.setStyle("-fx-background-color: #5899ed");

        Text title = new Text("Lab 5");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 28));

        Label loginLabel = new Label("Select Player:");
        playerBox = new ComboBox<>();
        PlayerData playerData = new PlayerData();
        playerBox.setItems(FXCollections.observableArrayList(playerData.getAllPlayerIds()));

        playerBox.setOnAction(e -> {
            currentPlayerId = playerBox.getValue();
        });

        hbox.getChildren().addAll(title, loginLabel, playerBox);
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
                new Hyperlink("Insert Player"),
                new Hyperlink("Insert Game"),
                new Hyperlink("Update Player"),
                new Hyperlink("Display Report")
        };

        for (Hyperlink option : options) {
            VBox.setMargin(option, new Insets(0, 0, 0, 8));
            vbox.getChildren().add(option);
        }

        options[0].setOnAction(e -> border.setCenter(createPlayerForm()));
        options[1].setOnAction(e -> border.setCenter(createGameForm()));
        options[2].setOnAction(e -> border.setCenter(createUpdateForm()));
        options[3].setOnAction(e -> border.setCenter(createReport()));

        return vbox;
    }

    private Region createPlayerForm() {
        VBox form = new VBox(20);
        form.setPadding(new Insets(20));

        Text title = new Text("Insert Player");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        form.getChildren().add(title);

        TextField firstName = new TextField();
        TextField lastName = new TextField();
        TextField address = new TextField();
        TextField province = new TextField();
        TextField postal = new TextField();
        TextField phone = new TextField();

        Button insertBtn = new Button("Insert Player");
        insertBtn.setOnAction(e -> {
            Player player = new Player(0, firstName.getText(), lastName.getText(),
                    address.getText(), postal.getText(), province.getText(), phone.getText());
            new PlayerData(player).insertPlayer();
            playerBox.getItems().add(player.getPlayerId());
        });

        form.getChildren().addAll(
                new HBox(new Label("First Name:"), firstName),
                new HBox(new Label("Last Name:"), lastName),
                new HBox(new Label("Address:"), address),
                new HBox(new Label("Province:"), province),
                new HBox(new Label("Postal Code:"), postal),
                new HBox(new Label("Phone:"), phone),
                insertBtn
        );
        form.setAlignment(Pos.TOP_CENTER);
        return form;
    }

    private Region createGameForm() {
        VBox form = new VBox(20);
        form.setPadding(new Insets(20));

        Text title = new Text("Insert Game");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        form.getChildren().add(title);

        TextField gameTitle = new TextField();
        TextField scoreField = new TextField();
        TextField dateField = new TextField();

        Button insertBtn = new Button("Insert Game");
        insertBtn.setOnAction(e -> {
            Game game = new Game(0, gameTitle.getText());
            GameData gameData = new GameData(game);
            gameData.insertGame();

            int score = Integer.parseInt(scoreField.getText());
            Date playDate = Date.valueOf(dateField.getText());

            PlayerAndGame playerGame = new PlayerAndGame(
                    0,
                    gameData.getGameId(),
                    currentPlayerId,
                    score,
                    playDate
            );
            new PlayerAndGameData(playerGame).insertPlayerAndGame();
        });

        form.getChildren().addAll(
                new HBox(new Label("Game Title:"), gameTitle),
                new HBox(new Label("Score:"), scoreField),
                new HBox(new Label("Date:"), dateField),
                insertBtn
        );
        form.setAlignment(Pos.TOP_CENTER);
        return form;
    }

    private Region createUpdateForm() {
        VBox form = new VBox(20);
        form.setPadding(new Insets(20));

        Text title = new Text("Update Player");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        form.getChildren().add(title);

        TextField idField = new TextField();
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField addressField = new TextField();
        TextField provinceField = new TextField();
        TextField postalField = new TextField();
        TextField phoneField = new TextField();

        Button updateBtn = new Button("Update Player");
        updateBtn.setOnAction(e -> {
            int id = Integer.parseInt(idField.getText());
            Player player = new Player(
                    id,
                    firstNameField.getText(),
                    lastNameField.getText(),
                    addressField.getText(),
                    postalField.getText(),
                    provinceField.getText(),
                    phoneField.getText()
            );
            new PlayerData(player).updatePlayer();
        });

        form.getChildren().addAll(
                new HBox(new Label("Player ID:"), idField),
                new HBox(new Label("First Name:"), firstNameField),
                new HBox(new Label("Last Name:"), lastNameField),
                new HBox(new Label("Address:"), addressField),
                new HBox(new Label("Province:"), provinceField),
                new HBox(new Label("Postal Code:"), postalField),
                new HBox(new Label("Phone:"), phoneField),
                updateBtn
        );
        form.setAlignment(Pos.TOP_CENTER);
        return form;
    }

    private Region createReport() {
        VBox form = new VBox(20);
        form.setPadding(new Insets(10));
        form.setAlignment(Pos.CENTER);

        Button displayBtn = new Button("Display Report");
        displayBtn.setOnAction(e -> {

            PlayerAndGameData data = new PlayerAndGameData();
            ArrayList<String[]> rows = data.displayReport(currentPlayerId);

            String[] playerInfoRow = rows.get(0);
            StringBuilder sb = new StringBuilder();
            sb.append("Report for Player ID ").append(currentPlayerId).append("\n")
                    .append("Name: ").append(playerInfoRow[0]).append(" ").append(playerInfoRow[1]).append("\n")
                    .append("Address: ").append(playerInfoRow[2]).append("\n")
                    .append("Postal Code: ").append(playerInfoRow[3]).append("\n")
                    .append("Province: ").append(playerInfoRow[4]).append("\n")
                    .append("Phone: ").append(playerInfoRow[5]).append("\n\n")
                    .append("Games:\n");

            for (String[] row : rows) {
                sb.append("Game: ").append(row[6])
                        .append("\n\tDate: ").append(row[7])
                        .append("\n\tScore: ").append(row[8])
                        .append("\n\n");
            }

            textArea.setText(sb.toString());
        });

        form.getChildren().addAll(displayBtn, textArea);
        return form;
    }

    public static void main(String[] args) {
        launch(args);
    }
}