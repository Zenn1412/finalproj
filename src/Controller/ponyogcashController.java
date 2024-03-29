package Controller;


    import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ponyogcashController {

    @FXML
    private Button back2payment;

    @FXML
    private TextField numberField;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField pinField;

    @FXML
    private Button toticket;

    public void toTicket(ActionEvent event) {
        // Get the values entered by the user
        String enteredNumber = numberField.getText();
        String enteredName = nameField.getText();
        String enteredPin = pinField.getText();
    
        // Define the predefined values (case-insensitive)
        String predefinedNumber = "09051873237";
        String predefinedName = "Paulo Agapito";
        String predefinedPin = "041204";
    
        // Check if the entered details match the predefined values (case-insensitive)
        if (enteredNumber.equals(predefinedNumber) &&
            enteredName.equalsIgnoreCase(predefinedName) &&
            enteredPin.equals(predefinedPin)) {
            try {
                // Load the next scene (finalticket.fxml)
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ponyofinalticket.fxml"));
                Parent root = loader.load();
    
                // Create a new stage for the next scene
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
    
                // Show the new scene
                stage.show();
    
                // Close the current login scene
                Stage currentStage = (Stage) toticket.getScene().getWindow();
                currentStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
             Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Invalid GCash Details");
        alert.setHeaderText(null);
        alert.setContentText("The entered GCash details are invalid. Please try again.");
        alert.showAndWait();
        }

        
    }
    @FXML
private void back2Payment(ActionEvent event) {
    try {
     
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ponyopay.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) back2payment.getScene().getWindow();
        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

