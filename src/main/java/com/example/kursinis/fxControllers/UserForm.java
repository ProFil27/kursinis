package com.example.kursinis.fxControllers;

import com.example.kursinis.HelloApplication;
import com.example.kursinis.hibernateControl.GenericHibernate;
import com.example.kursinis.model.BasicUser;
import com.example.kursinis.model.Driver;
import com.example.kursinis.model.User;
import com.example.kursinis.model.VehicleType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
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
    public AnchorPane defaultInfoPane;
    public AnchorPane addressInfoPane;
    private EntityManagerFactory entityManagerFactory;
  private GenericHibernate genericHibernate;
  public void setData(EntityManagerFactory entityManagerFactory, User user, boolean isForUpdate) {
      this.entityManagerFactory = entityManagerFactory;
      this.genericHibernate = new GenericHibernate(entityManagerFactory);
//      this.userForUpdate = user;
//      this.isForUpdate = isForUpdate;
//      fillUserDataForUpdate();
  }

  public void disableFields() {
      boolean isUser = userRadio.isSelected();
      boolean isRestaurant = restaurantRadio.isSelected();
      boolean isClient = clientRadio.isSelected();
      boolean isDriver = driverRadio.isSelected();

      defaultInfoPane.setVisible(true);
      defaultInfoPane.setDisable(false);

      addressInfoPane.setVisible(isClient || isRestaurant);
      addressInfoPane.setDisable(!(isClient || isRestaurant));

      driverInfoPane.setVisible(isDriver);
      driverInfoPane.setDisable(!isDriver);

      restaurantInfoPane.setVisible(isRestaurant);
      restaurantInfoPane.setDisable(!isRestaurant);
    }

    public <T> void createNewUser() {
        if (userRadio.isSelected())
        {
            User user = new User(usernameField.getText(),
                passwordField.getText(),
                nameField.getText(),
                surnameField.getText(),
                phoneNumberField.getText());
            genericHibernate.create(user);
        } else if (clientRadio.isSelected()){
            BasicUser basicUser = new BasicUser(usernameField.getText(),
                passwordField.getText(),
                nameField.getText(),
                surnameField.getText(),
                phoneNumberField.getText(),
                addressField.getText());
            genericHibernate.create(basicUser);
        } else if (driverRadio.isSelected()){
            Driver driver = new Driver(usernameField.getText(),
                passwordField.getText(),
                nameField.getText(),
                surnameField.getText(),
                phoneNumberField.getText(),
                addressField.getText(),
                bDateField.getValue(),
                licenseField.getText(),
                VehicleType.valueOf(vehicleTypeField.getText()));
            genericHibernate.create(driver);
        }
//        else if (restaurantRadio.isSelected()) {
//            Driver driver = new Driver(usernameField.getText(),
//                passwordField.getText(),
//                nameField.getText(),
//                surnameField.getText(),
//                phoneNumberField.getText(),
//                addressField.getText(),
//                bDateField.getValue(),
//                licenseField.getText(),
//                VehicleType.valueOf(vehicleTypeField.getText()));
//            genericHibernate.create(driver);
//        }

    }
}
