package sample;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Controller {

    @FXML
    private Button signIn;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Hyperlink forgotPassword;

    @FXML
    private Hyperlink reportAProblem;


    @FXML
    void onClickForgotPassword(ActionEvent event) {
        System.out.println("Redirect to the forgot password help, resets the password for the entire account.");
    }

    @FXML
    void onClickReportAProblem(ActionEvent event) {
        System.out.println("Will redirect to the general page of the bigger application");

    }

    @FXML
    void onClickSignIn(ActionEvent event) {

        String email = emailTextField.getText(); // get the email address
        ConnectionClass myConn = new ConnectionClass(); //myConn is the instance of the ConnectionClass that sets up the connection.
        Connection connection = myConn.getConnection(); //the connection returned from getConnection is returned into "connection" object.
        PreparedStatement statement;
        InputStream profilePicture;

        try {
            //prepare statement
            statement = connection.prepareStatement("select output.*\n" +
                    "from (\n" +
                    "\tselect * from student_ambassador_list\n" +
                    "\tunion all\n" +
                    "\tselect * from program_leader_list\n" +
                    ") as output\n" +
                    "where output.Email_ID = ?;");
            //setting the parameter
            statement.setString(1, email);
            //execute the query
            ResultSet resultSet = statement.executeQuery();
            //get the result, authenticate user.
            if (resultSet.first()) {
                String emailId = resultSet.getString("Email_ID");
                ArrayList<String> profileInformation = new ArrayList<String>();
                profileInformation.add(resultSet.getString("Student_ID"));
                profileInformation.add(resultSet.getString("Student_First_Name"));
                profileInformation.add(resultSet.getString("Student_Last_Name"));
                profileInformation.add(resultSet.getString("Phone_No"));
                profileInformation.add(emailId);
                profileInformation.add(resultSet.getString("Campus"));
                //profile picture
                profilePicture = resultSet.getBinaryStream("Student_Image");
                /*get index of "@" and "." using that get the substring that is there right in between.
                check if that is equal to "student", based on this determine which landing page to open. */
                int i = emailId.indexOf("@");
                i++; //check if this is industry standard logic.
                int j = emailId.indexOf(".", i);
                String subString = emailId.substring(i, j);
                //System.out.println(subString); //checking purpose
                if (subString.equalsIgnoreCase("student")) {
                    //it is a student ambassador
                    //open their landing page
                    // System.out.println("Student Ambassador");
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sample/StudentAmbassador.fxml"));
                    AnchorPane root = (AnchorPane) loader.load();
                    studentAmbassadorCntrl ambassadorCntrl = loader.getController();
                    ambassadorCntrl.setProfileInfo(profileInformation);
                    ambassadorCntrl.setProfilePicture(profilePicture);
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();

                } else {
                    //they are a program leader
                    //open their landing page
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sample/ProgramLeader.fxml"));
                    AnchorPane root = (AnchorPane) loader.load();
                    ProgramLeaderCntrl leaderCntrl = loader.getController();
                    leaderCntrl.setProfileInfo(profileInformation);
                    leaderCntrl.setProfilePicture(profilePicture);
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();

                }

            } else {
                System.out.println("No Match found, either you are not yet a part of this Program or check the email id entered.");
            }

        } catch (Exception e) {
            System.out.println("Coming from Controller Code: " + e);
        }//end catch

    }//end onClickSignIn

}//end controller class


