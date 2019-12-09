package sample;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;


public class ProgramLeaderCntrl {

    @FXML
    private ImageView profilePicture;

    @FXML
    private Button sendMessage_btn;

    @FXML
    private Button programInformation_btn;

    @FXML
    private Label profileInformation_lbl;

    @FXML
    private Button createMeeting_btn;

    @FXML
    private Button createSA_DB_btn;

    @FXML
    private Button editProgramInfo_btn;

    @FXML
    private Button createEvent_btn;

    @FXML
    private Button SAReport_btn;

    @FXML
    private Label upCommingEvents_lbl;

    
    public void setProfileInfo(ArrayList<String> profileInfo) {
        StringBuilder info = new StringBuilder();
        info.append("Staff ID: "+profileInfo.get(0));
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
        profileInformation_lbl.setText(info.toString());
    }

    public void setProfilePicture(InputStream profilePic) {
        Image img = new Image(profilePic);
        profilePicture.setImage(img);

    }

    public void onClickSendMessage(javafx.event.ActionEvent actionEvent) {
    }

    public void onClickProgramInformation(ActionEvent actionEvent) {
    }

    public void onClickCreateMeeting_btn(ActionEvent actionEvent) {
    }

    public void onClickCreateSA_DB(ActionEvent actionEvent) {
    }

    public void onClickEditProgInfo_btn(ActionEvent actionEvent) {
    }

    public void onClickCreateEvent_btn(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sample/Create_Event_gui.fxml"));
        AnchorPane root = (AnchorPane) loader.load();
        CreateEventCtrl createEventCtrl = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void onClickSAReport_btn(ActionEvent actionEvent) {
    }
}
