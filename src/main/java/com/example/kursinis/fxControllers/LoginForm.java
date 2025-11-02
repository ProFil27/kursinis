package com.example.kursinis.fxControllers;

import com.example.kursinis.HelloApplication;
import com.example.kursinis.hibernateControl.CustomHibernate;
import com.example.kursinis.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForm {
    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kursinis");

  public void validateAndLoad() throws IOException {
        CustomHibernate customHibernate = new CustomHibernate(entityManagerFactory);
        User user = customHibernate.getUserByCredentials(usernameField.getText(), passwordField.getText());
        if (user != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-form.fxml"));
            Parent parent = fxmlLoader.load();

            MainForm mainForm = fxmlLoader.getController();
            mainForm.setData(entityManagerFactory, user);

            Scene scene = new Scene(parent);
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } else {
            FxUtils.generateAlert(Alert.AlertType.WARNING, "Warning", "Something went wrong during login", "No such user or wrong credentials");
        }
    }

    public void registerNewUser() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-form.fxml"));
        Parent parent = fxmlLoader.load();

        UserForm userForm = fxmlLoader.getController();
        userForm.setData(entityManagerFactory, null, false);

        Scene scene = new Scene(parent);
        Stage stage = (Stage) passwordField.getScene().getWindow();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
