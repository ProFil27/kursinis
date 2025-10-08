package com.example.kursinis.fxControllers;

import com.example.kursinis.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserForm {


  public RadioButton userRadio;
  public ToggleGroup userType;
  public RadioButton restaurantRadio;
  public RadioButton clientRadio;
  public RadioButton driverRadio;
  public TextField usernameField;
  public PasswordField passwordField;
  public PasswordField passwordFieldTwo;
  public TextField nameField;
  public TextField surnameField;
  public TextField phoneNumberField;
  public Button saveButton;
  public AnchorPane driverInfoPane;
  public DatePicker bDateField;
  public TextField licenseField;
  public TextField vehicleTypeField;
  public TextField addressField;
  public AnchorPane restaurantInfoPane;
  public TextField menuField;

  public void disableFields() {
        if(userRadio.isSelected()) {
            driverInfoPane.setVisible(true);
            restaurantInfoPane.setVisible(true);
        } else if (restaurantRadio.isSelected()) {
            driverInfoPane.setVisible(false);
            restaurantInfoPane.setVisible(true);
        } else if (clientRadio.isSelected()) {
            driverInfoPane.setVisible(false);
            restaurantInfoPane.setVisible(false);
        } else {
            driverInfoPane.setVisible(true);
            restaurantInfoPane.setVisible(false);

        }
    }

    public void createNewUser() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) passwordField.getScene().getWindow();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
