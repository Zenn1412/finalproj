package Controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

// public class ponyoticketController {

//     @FXML
//     private Button paybtn;

//     @FXML
//     private Label selectedTimeLabel; //remove when error occurs

//     @FXML
//     private Label selectedSeatLabel;

//     public void getSelectedSeat(String text) {
//         selectedSeatLabel.setText(text);
//         selectedSeatLabel.setVisible(true); // Make the label visible when a seat is selected
//     }

//     public void getSelectedTime(String text) {
//         selectedTimeLabel.setText(text);
//         selectedTimeLabel.setVisible(true);
//     }

// @FXML
// private void payBtn(ActionEvent event) {
//     try {
        
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ponyopay.fxml"));
//         Parent root = loader.load();

       
//         Scene scene = new Scene(root);
//         Stage stage = (Stage) paybtn.getScene().getWindow();
//         stage.setScene(scene);
//     } catch (IOException e) {
//         e.printStackTrace();
//     }
// }

public class ponyoticketController {

    @FXML
    private Button paybtn;

    @FXML
    private Label selectedTimeLabel;

    @FXML
    private Label selectedSeatLabel;

    public void initialize() {
        String selectedSeat = DataStorage.getSelectedSeat();
        String selectedTime = DataStorage.getSelectedTime();

        selectedSeatLabel.setText(selectedSeat);
        selectedTimeLabel.setText(selectedTime);

        // Make the labels visible when data is available
        selectedSeatLabel.setVisible(!selectedSeat.isEmpty());
        selectedTimeLabel.setVisible(!selectedTime.isEmpty());
    }

    @FXML
private void payBtn(ActionEvent event) {
    try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ponyopay.fxml"));
        Parent root = loader.load();

       
        Scene scene = new Scene(root);
        Stage stage = (Stage) paybtn.getScene().getWindow();
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    // Other methods in your controller...
}


    


    
  
