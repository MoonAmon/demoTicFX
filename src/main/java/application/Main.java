package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private static final int SIZE = 3;
    private static Button[][] buttons = new Button[SIZE][SIZE];
    private static boolean xTurn = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Tic Tac Toe");

        GridPane gridPane = new GridPane();
        initializeGrid(gridPane);

        Field field = new Field();
        field.setStrokeWidth(5);

        Group root = new Group();
        root.getChildren().addAll(gridPane, field.getLine1(), field.getLine2(), field.getLine3(), field.getLine4());

        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void initializeGrid(GridPane gridPane) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Button button = new Button();
                button.setMinSize(200, 200);
                button.setFont(Font.font("Verdana", 80));
                button.setOnAction(e -> handleButtonClick(button));
                buttons[row][col] = button;
                gridPane.add(button, col, row);
            }
        }
    }

    private void handleButtonClick(Button button) {
        if (button.getText().isEmpty()) {
            button.setText(xTurn ? "X" : "O");
            wonTheMatch();
            xTurn = !xTurn;
        }
    }

    private void wonTheMatch() {
        if (isWinningCombination("X")) {
            openWinnerWindows("X");
        } else if (isWinningCombination("O")) {
           openWinnerWindows("O");
        }
    }

    private void openWinnerWindows(String player) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/win-windows.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            WindowsWinController controller = fxmlLoader.getController();
            controller.initialize(player);

            stage.setTitle("Winner");
            stage.setScene(scene);
            stage.setWidth(340);
            stage.setHeight(160);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isWinningCombination(String player) {
        for (int row = 0; row < SIZE; row++) {
            if (buttons[row][0].getText().equals(player) &&
                buttons[row][1].getText().equals(player) &&
                buttons[row][2].getText().equals(player)) {
                return true;
            }
        }

        for (int col = 0; col < SIZE; col++) {
            if (buttons[0][col].getText().equals(player) &&
                buttons[1][col].getText().equals(player) &&
                buttons[2][col].getText().equals(player)) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(player) &&
            buttons[1][1].getText().equals(player) &&
            buttons[2][2].getText().equals(player)) {
            return true;
        }

        if (buttons[0][2].getText().equals(player) &&
            buttons[1][1].getText().equals(player) &&
            buttons[2][0].getText().equals(player)) {
            return true;
        }

        return false;
    }

    public static Button[][] getButtons() {
        return buttons;
    }

    public static void setButtons(Button[][] buttons) {
        Main.buttons = buttons;
    }

    public static boolean isxTurn() {
        return xTurn;
    }

    public static void setxTurn(boolean xTurn) {
        Main.xTurn = xTurn;
    }

    public static int getSize() {
        return SIZE;
    }
}
