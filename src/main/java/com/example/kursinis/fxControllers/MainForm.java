package com.example.kursinis.fxControllers;

import com.example.kursinis.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainForm {
    public Button createButton;

    public void registerNewUser() throws IOException {
        // surenku is lauku duomenis (login ir psw) ir tikrinu DB
        //sekmes atvejis - user yra -> atidaryti main forma
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) createButton.getScene().getWindow();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
