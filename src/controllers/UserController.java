package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.User;
import services.UserService;

public class UserController {

    @FXML
    private Button btnshow;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    void showuser(MouseEvent event) {
        addUser();
    }

    public  void addUser(){
        UserService userService = new UserService();
        User user = new User(1, "qfj@gmail.com", "fqsdf", "admin");
        boolean var = userService.addUser(user);
        if(var == true ){
            lbl1.setText("inserted");
        }
    }

}

