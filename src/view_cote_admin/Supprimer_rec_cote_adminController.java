
package view_cote_admin;

import com.jfoenix.controls.JFXComboBox;
import java.sql.SQLException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import service.reclamationService;


public class Supprimer_rec_cote_adminController  {

    @FXML
    private Label response;
    @FXML
    private JFXComboBox<String> list_id;
    
    @FXML
    private Button btnsupp;
    private Alert alertSupp = new Alert(Alert.AlertType.INFORMATION);
    
    
    
    
    
    public void initialize()throws SQLException, ClassNotFoundException {
        
            loadIdReclamation();
//       System.out.println( getid());
    } 
    
    

    @FXML
    private void supp_rec_on_action(ActionEvent event) throws SQLException, ClassNotFoundException {
     
       String recId = list_id.getValue(); 
       int id=Integer.parseInt(recId);
       response.setText("supprimer la reclamation n :"+recId);
     reclamationService recservice= new reclamationService();
      recservice.deleteReclamation(id);
      alertSupp.setTitle("supprimer reclamation");
            alertSupp.setHeaderText(null);
            alertSupp.setContentText(" la reclamation n :"+recId+" a ete supprimer avec succees");
            alertSupp.showAndWait();
    }
    @FXML
    public void close_on_action(ActionEvent event){
     Stage stage =(Stage) list_id.getScene().getWindow();
       stage.close();
    }
   
    
    
    
    private void loadIdReclamation() throws SQLException, ClassNotFoundException {
        reclamationService recservice= new reclamationService();
       
        List<String> listId= recservice.getReclamationIds();
        list_id.getItems().addAll( listId);
    } 
}
