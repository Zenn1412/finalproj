package Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class ponyoSeatController {

    @FXML
    private String selectedTime = null;// to be removed if error occurs

    @FXML
    private Label selectedSeatLabel;

    @FXML
    private Button go2ticket;

    @FXML
    private Button selectedSeatButton = null; // Track the currently selected seat

    @FXML
    private Button a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6,c1,c2,c3,c4,c5,c6,d1,d2,d3,d4,d5,d6;

    @FXML
    private Button t1,t2,t3; // to be removed if error occurs

    @FXML
    private Button selectedTimeLabel;

    // Add more buttons for other seats

    // Create a map to store the occupation status of seats
    private Map<String, Boolean> seatOccupation = new HashMap<>();
    //remove when error occurs
    

    public ponyoSeatController() {
        // Initialize the seatOccupation map with all seats as unoccupied
        seatOccupation.put("a1", false);
        seatOccupation.put("a2", false);
        seatOccupation.put("a3", false);
        seatOccupation.put("a4", false);
        seatOccupation.put("a5", false);
        seatOccupation.put("a6", false);
        seatOccupation.put("b1", false);
        seatOccupation.put("a2", false);
        seatOccupation.put("b3", false);
        seatOccupation.put("b4", false);
        seatOccupation.put("b5", true);
        seatOccupation.put("b6", true);
        seatOccupation.put("c1", false);
        seatOccupation.put("c2", true);
        seatOccupation.put("c3",true);
        seatOccupation.put("c4", false);
        seatOccupation.put("c5", false);
        seatOccupation.put("c6", false);
        seatOccupation.put("d1", true);
        seatOccupation.put("d2", false);
        seatOccupation.put("d3", false);
        seatOccupation.put("d4", true);
        seatOccupation.put("d5", true);
        seatOccupation.put("d6", true);
       


      
    
        
    
        // Initialize other seats in a similar way
    }

    @FXML
    private void handleSeatSelection(ActionEvent event) {
        Button button = (Button) event.getSource();
        String seatNumber = button.getText();

        if (selectedSeatButton != null) {
            // Deselect the previously selected seat
            selectedSeatButton.setStyle("-fx-background-color: transparent");
        }

        // Handle the selected seat
        if (isSeatAvailable(seatNumber)) {
            button.setStyle("-fx-background-color: #1201f7a0;"); // Set background color to blue
            selectedSeatButton = button;

            // Mark the seat as occupied
            
        } else {
            // Show a dialog to inform the user that the seat is already occupied
            showOccupiedSeatDialog();
        }
    }

    private boolean isSeatAvailable(String seatNumber) {
        Boolean isOccupied = seatOccupation.get(seatNumber);
        return isOccupied == null || !isOccupied;
    
    }

    private void markSeatAsOccupied(String seatNumber) {
        // Mark the seat as occupied
        seatOccupation.put(seatNumber, true);
    }

    private void showOccupiedSeatDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Seat Occupied");
        alert.setHeaderText("Seat Already Occupied");
        alert.setContentText("The selected seat is already occupied. Please choose another seat.");
        alert.showAndWait();
    }


@FXML
private void handleTimeSelection(ActionEvent event) {
    Button button = (Button) event.getSource();
    selectedTime = button.getText();

    // Highlight the selected time
    button.setStyle("-fx-background-color: blue;");

    if (selectedSeatButton != null) {
        selectedSeatLabel.setText("Selected Seat: " + selectedSeatButton.getText());
        selectedTimeLabel.setText("Selected Time: " + selectedTime);
    }
}
// ///////////////////////////////////////////////////////////////////////////////
// @FXML
// public void go2Ticket(ActionEvent event) {
//     try {
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/tickets.fxml"));

//         Parent root = loader.load();
//         ponyoticketController ticketController = loader.getController();
//         // ponyofinalticketController finalTicketController = loader.getController();

//         if (selectedSeatButton != null) {
//             String selectedSeat = selectedSeatButton.getText();
//             ticketController.setSelectedSeatLabel("Selected Seat: " + selectedSeat);
//         }

//         if (selectedTime != null) {
//             ticketController.setSelectedTimeLabel("Selected Time&Date: " + selectedTime);
//         }

//         Scene scene = new Scene(root);
//         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
//         stage.setScene(scene);
//     } catch (IOException e) {
//         e.printStackTrace();
//     }
// }

// to remove 
// @FXML
// public void go2Ticket(ActionEvent event) {
//     try {
//         // Store selected seat and time in the separate class
//         String selectedSeat = (selectedSeatButton != null) ? selectedSeatButton.getText() : "";
//         String selectedTime = (this.selectedTime != null) ? this.selectedTime : "";
        
//         ponyofinalticketController.setSelectedSeat(selectedSeat);
//         ponyofinalticketController.setSelectedTime(selectedTime);

//         // Load the scene for tickets.fxml
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/tickets.fxml"));
//         Parent root = loader.load();
//         ponyoticketController ticketController = loader.getController();
        
//         // Pass the selected seat and time to tickets.fxml
//         ticketController.getSelectedSeat("Selected Seat: " + selectedSeat);
//         ticketController.getSelectedTime("Selected Time&Date: " + selectedTime);
        
//         // Set the scene for tickets.fxml
//         Scene ticketsScene = new Scene(root);
//         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
//         stage.setScene(ticketsScene);
//     } catch (IOException e) {
//         e.printStackTrace();
//     }
// }

@FXML
public void go2Ticket(ActionEvent event) {
    try {
        // Store selected seat and time in DataStorage
        String selectedSeat = (selectedSeatButton != null) ? selectedSeatButton.getText() : "";
        String selectedTime = (this.selectedTime != null) ? this.selectedTime : "";
        DataStorage.setSelectedSeat(selectedSeat);
        DataStorage.setSelectedTime(selectedTime);

        // Load the scene for tickets.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/tickets.fxml"));
        Parent root = loader.load();

        Scene ticketsScene = new Scene(root);
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setScene(ticketsScene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}


//-----------------------------------------------------------------------------------------------

