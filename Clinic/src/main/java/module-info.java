module Clinic {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires jakarta.transaction;
    requires jakarta.annotation;
    requires spring.beans;
    requires spring.data.jpa;
    opens com.project to javafx.fxml;

    exports com.project;
}

