package com.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

import static javafx.application.Application.launch;

@SpringBootApplication
public class ClinicApplication {

	public static void main(String[] args) {

		SpringApplication.run(ClinicApplication.class, args);
	}

}
