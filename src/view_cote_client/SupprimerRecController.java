
package view_cote_client;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.reclamationService;


public class SupprimerRecController implements Initializable {

    @FXML
    private Button btnConf_Modif_Reclamation;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblHeure;
     @FXML private Hyperlink log_out;
     @FXML private Label welcome_user;
    @FXML
    private JFXComboBox<String> reclamationId;
    private Alert alertsupp= new Alert(Alert.AlertType.INFORMATION);
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 try {
            loadDateAndTime();

            loadIdReclamation();

        } catch (SQLException ex) {
            Logger.getLogger(ModifierRecController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifierRecController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    
        private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e->{
            LocalTime currentTime =  LocalTime.now();
            lblHeure.setText(
                    currentTime.getHour()+" : "+currentTime.getMinute()+" : "+currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }
        
          private void loadIdReclamation() throws SQLException, ClassNotFoundException {
        reclamationService recservice= new reclamationService();
       
        List<String> listIdRec = recservice.getReclamationIds();
        reclamationId.getItems().addAll(listIdRec);
    }
    @FXML
    private void Confirmer_Modif_Rec_On_Action(ActionEvent event) throws SQLException, ClassNotFoundException {
        reclamationService recservice= new reclamationService();
        SingleSelectionModel<String> idchoisie= reclamationId.getSelectionModel();
        recservice.deleteReclamation( Integer.parseInt(idchoisie.getSelectedItem()));
    
        alertsupp.setTitle("Infos");
            alertsupp.setHeaderText(null);
            alertsupp.setContentText("Suppression de reclamation valide");
            alertsupp.showAndWait();
    }

    @FXML
    private void Annuler_Modifier_Rec_On_Action(ActionEvent event) {
       Stage stage =(Stage) btnAnnuler.getScene().getWindow();
       stage.close();
    }
    
}
