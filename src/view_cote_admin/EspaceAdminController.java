
package view_cote_admin;

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
        Parent root = FXMLLoader.load(getClass().getResource("../view_cote_admin/Gestion_Rec_Cote_Admin.fxml"));
        primaryStage.setTitle("Gérer  reclamations ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @FXML
    private void gestion_commentaire_on_action(ActionEvent event) throws IOException {
        Stage primaryStage= new Stage() ;
        Parent root = FXMLLoader.load(getClass().getResource("../view_cote_admin/Gestion_commentaire_admin.fxml"));
        primaryStage.setTitle("Gérer les commentaires ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    private void gestion_statistique_on_action(ActionEvent event) {
    }
        
    
}
