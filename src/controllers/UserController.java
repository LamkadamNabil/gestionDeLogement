package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import services.UserService;

public  class UserController {

    @FXML
    private Button btnshow;

    @FXML
    private Label lbl1;

    @FXML
    void showuser(MouseEvent event) {
            getuser();
    }

    public void getuser(){
        String email = UserService.findUserbyID();
        lbl1.setText(email);
    }

}
