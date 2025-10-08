package com.example.kursinis.fxControllers;

import com.example.kursinis.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForm {

    public TextField usernameField;
    public PasswordField passwordField;
    public Button loginButton;
    public Button registerButton;

  public void validateAndLoad() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // surenku is lauku duomenis (login ir psw) ir tikrinu DB
        //sekmes atvejis - user yra -> atidaryti main forma
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) passwordField.getScene().getWindow();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void registerNewUser() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // surenku is lauku duomenis (login ir psw) ir tikrinu DB
        //sekmes atvejis - user yra -> atidaryti main forma
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) passwordField.getScene().getWindow();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
