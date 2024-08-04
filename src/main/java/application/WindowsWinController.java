package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class WindowsWinController {

    private Button buttons[][] = Main.getButtons();
    private final int SIZE = Main.getSize();

    @FXML
    private Button tryAgainButton;

    @FXML
    private Button exitButton;

    @FXML
    private Label labelWinner;

    @FXML
    public void initialize(String WinnerPlayer) {
        labelWinner.setText(WinnerPlayer + " win the match!");
        tryAgainButton.setOnAction(e -> {
            resetGame();
            Stage stage = (Stage) tryAgainButton.getScene().getWindow();
            stage.close();
        });
        exitButton.setOnAction(e -> System.exit(0));
    };

    private void resetGame() {
    for (int row = 0; row < SIZE; row++) {
        for (int col = 0; col < SIZE; col++) {
           buttons[row][col].setText("");
        }
    }
       Main.setxTurn(true);
    }
}
