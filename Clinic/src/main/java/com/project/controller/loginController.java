package com.project.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class loginController implements Initializable {
    @FXML
    private TextField email_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button log_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("press log_butten");
            }
        });
    }
}
