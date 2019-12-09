package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.InputStream;
import java.util.ArrayList;

public class studentAmbassadorCntrl {
    @FXML
    public Label profile_info;


    @FXML
    private ImageView profilePicture;

    @FXML
    private Button sendMessage_btn;

    @FXML
    private Button programInfo_btn;

    @FXML
    private Label sceneLabel;

    @FXML
    private Button eventSignup_btn;

    @FXML
    private Button downloadEventLog_btn;

    @FXML
    private Button addEventReflection_btn;

    @FXML
    private Label upCommingEvents_lbl;

    public void setProfilePicture(InputStream profilePic)
    {Image img = new Image(profilePic);
        profilePicture.setImage(img);

    }

    public void setProfileInfo(ArrayList<String> profileInfo) {
        StringBuilder info = new StringBuilder();
        info.append("Student ID: "+profileInfo.get(0));
        info.append("\n");
        info.append("Name: "+profileInfo.get(1)+" " + profileInfo.get(2));
        info.append("\n");
        info.append("Phone No: "+profileInfo.get(3));
        info.append("\n");
        info.append("Email: "+profileInfo.get(4));
        info.append("\n");
        info.append("Campus: "+profileInfo.get(5));
        info.append("\n");

       // System.out.println("hello:" + info.toString());
        profile_info.setText(info.toString());

    }

    public void setUpCommingEvents_lbl(Label upCommingEvents_lbl) {

    }

    public void onClickeventSignUp_btn(javafx.event.ActionEvent actionEvent) {
    }

    public void onClickProgramInformation(javafx.event.ActionEvent actionEvent) {

    }

    public void onClickDownloadEventLog_btn(javafx.event.ActionEvent actionEvent) {
    }

    public void onClickaddEventReflection_btn(javafx.event.ActionEvent actionEvent) {
    }

    public void onClickSendMessage(javafx.event.ActionEvent actionEvent) {
    }
}
