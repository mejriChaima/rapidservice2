
package view;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class EspaceAdminController {

   public AnchorPane rootPane;

    
     @FXML
    public void gestionReclamation_Admin_OnAction(ActionEvent actionEvent) throws IOException {
        Stage primaryStage= new Stage() ;
        Parent root = FXMLLoader.load(getClass().getResource("../view/Gestion_Rec_Cote_Admin.fxml"));
        primaryStage.setTitle("Gérer  reclamations ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
        
    
}
