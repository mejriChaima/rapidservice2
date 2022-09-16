
package view_cote_client;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EspaceClientController  {
    public AnchorPane rootPane;

    
     @FXML
    public void gestionReclamation_OnAction(ActionEvent actionEvent) throws IOException {
        Stage primaryStage= new Stage() ;
        Parent root = FXMLLoader.load(getClass().getResource("../view_cote_client/AjoutReclamation.fxml"));
        primaryStage.setTitle("Gérer mes reclamations ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
       
    
}
