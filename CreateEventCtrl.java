package sample;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateEventCtrl {
    public TextArea eventDescription_txt;
    public TextField contactNumber_txt;
    public TextField contactPerson_txt;
    public TextField eventTime_txt;
    public TextField eventDate_txt;
    public TextField eventLocation_txt;
    public TextField eventName_txt;
    public TextField eventID_txt;


    public void onClickCreateEvent_btn(ActionEvent actionEvent) {
        ConnectionClass myConn = new ConnectionClass(); //myConn is the instance of the ConnectionClass that sets up the connection.
        Connection connection = myConn.getConnection(); //the connection returned from getConnection is returned into "connection" object.
        PreparedStatement statement;
        try {
            String query = "INSERT INTO OCC_SA_DB.events (Event_ID,Event_Name,Event_Location,\n" +
                    "Contact_Person,\n" +
                    "Contact_Number,Event_Description) VALUES (?,?,?,?,?,?);";
            //prepare statement
            statement = connection.prepareStatement(query);

            //setting the parameter
            statement.setString(1,eventID_txt.getText());
            statement.setString(2,eventName_txt.getText());
            statement.setString(3,eventLocation_txt.getText());
            statement.setString(4,contactPerson_txt.getText());
            statement.setString(5,contactNumber_txt.getText());
            statement.setString(6,eventDescription_txt.getText());

            //execute update
            int row = statement.executeUpdate();

            System.out.println(row);


        }
        catch (Exception e ){
            System.out.println(e.getStackTrace());
        }

    }

    public void onClickgoBack_btn(ActionEvent actionEvent) {
        //open the same profile that opened create event in the first place.
    }
}
