package Controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ponyofinalticketController {

    @FXML
    private Label selectedSeatLabel;

    @FXML
    private Label selectedTimeLabel;

    public void initialize() {
        String selectedSeat = DataStorage.getSelectedSeat();
        String selectedTime = DataStorage.getSelectedTime();

        selectedSeatLabel.setText(selectedSeat);
        selectedTimeLabel.setText(selectedTime);
    }

    // Other methods in your controller...
}