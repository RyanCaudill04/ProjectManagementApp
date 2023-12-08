package demo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.ProjectSystemFACADE;
import model.User;

public class SignUpController {

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField password;

    @FXML
    private Button signUpButton;

    @FXML
    void signUpUser(ActionEvent event) throws IOException {
        String fName = firstName.getText();
        String lName = lastName.getText();
        String eMAIL = email.getText();
        String passWORD = password.getText();
        boolean isEmpty = false;

        if (fName == null || fName == "") {
            System.out.println("Error: missing first name");
            isEmpty = true;
        }
        if (lName == null || fName == "") {
            System.out.println("Error: missing last name");
            isEmpty = true;
        }
        if (fName == null || fName == "") {
            System.out.println("Error: missing email");
            isEmpty = true;
        }
        if (fName == null || fName == "") {
            System.out.println("Error: missing password");
            isEmpty = true;
        }
        if (isEmpty) {
            return;
        }
        ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();

        User user = facade.signUp(eMAIL, fName, lName, true, passWORD);

        facade.setUser(user);
        System.out.println(user.getName() + " has been signed up!");
        App.setRoot("ProjectListView");
    }

}
