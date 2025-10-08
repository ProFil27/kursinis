package com.example.kursinis.fxControllers;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class UserForm {
    public RadioButton userRadio;
    public RadioButton restaurantRadio;
    public RadioButton clientRadio;
    public RadioButton driverRadio;
    public TextField loginField;
    public PasswordField passwordField;
    public PasswordField passwordFieldTwo;
    public TextField nameField;
    public TextField surnameField;
    public TextField phoneNumberField;
    public AnchorPane restaurantInfoPane;

    public void disableFields() {
        if(userRadio.isSelected()) {
            passwordFieldTwo.setDisable(true);
            restaurantInfoPane.setVisible(false);
        } else if (restaurantRadio.isSelected()) {

        } else if (clientRadio.isSelected()) {

        } else {

        }
    }

    public void createNewUser(ActionEvent actionEvent) {
    }
}
