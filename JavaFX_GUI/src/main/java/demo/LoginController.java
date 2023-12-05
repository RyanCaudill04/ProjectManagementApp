package demo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.*;

public class LoginController {

    @FXML
    private Button ButtonLogin;

    @FXML
    private Button ButtonSignUp;

    @FXML
    private TextField txt_password;

    @FXML
    private TextField txt_username;

    @FXML
    void userLogin(ActionEvent event) throws IOException {
        String userName = txt_username.getText();
        String password = txt_password.getText();

        ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();

        User user = facade.login(userName, password);

        if(user == null){
            System.out.println("ERROR");
            return;
        }
        facade.setUser(user);
        System.out.println("Logged in " + user.toString());
        App.setRoot("ProjectListView");

    }

    @FXML
    void userSignup(ActionEvent event) {

    }

}
