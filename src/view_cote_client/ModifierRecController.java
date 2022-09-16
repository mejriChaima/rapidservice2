
package view_cote_client;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import testconnrapidservice.Reclamation;
import testconnrapidservice.reclamationService;


public class ModifierRecController implements Initializable {

    @FXML
    private Button btnConf_Modif_Reclamation;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblHeure;
    private TextField txtNom;
    private TextField txtPrenom;
    private TextField txtTel;
    private TextField txtMail;
    private TextField txtMission;
    private TextField txtMissionDesc;
    private DatePicker txtDate;
    private ComboBox<String> txtNomPrestataire;
    @FXML
    private ComboBox<String> reclamationId;

   private String responsePREST ,responseID;
   private Alert alertModification= new Alert(Alert.AlertType.INFORMATION);
    
   
   
      @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            loadDateAndTime();
            loadNomsPrestataire();
            loadIdReclamation();

        } catch (SQLException ex) {
            Logger.getLogger(ModifierRecController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifierRecController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    private void loadIdReclamation() throws SQLException, ClassNotFoundException {
        reclamationService recservice= new reclamationService();
       
        List<String> listIdRec = recservice.getReclamationIds();
        reclamationId.getItems().addAll( listIdRec);
    }
           
   
    private void loadNomsPrestataire() throws SQLException, ClassNotFoundException {
        reclamationService recservice= new reclamationService();
       
        List<String> NomsPrestataire = recservice.getPrestataireNames();
        txtNomPrestataire.getItems().addAll( NomsPrestataire);
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

    @FXML
    private void Confirmer_Modif_Rec_On_Action(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        // recuperer le nom dutilisateur choisie
        
        reclamationService recservice= new reclamationService();
        ArrayList<String> listN=  recservice.getPrestataireNames();
        ArrayList<String> listId=  recservice.getReclamationIds();
        ObservableList <String> prestataireNames;
        ObservableList <String> reclamationIds;
        prestataireNames = FXCollections.observableArrayList(listN);
        reclamationIds = FXCollections.observableArrayList(listId);
        SingleSelectionModel<String> nomchoisie= txtNomPrestataire.getSelectionModel();
         SingleSelectionModel<String> idchoisie= reclamationId.getSelectionModel();
       nomchoisie.selectedItemProperty().addListener((ObservableValue<? extends String> changed, String oldVal, String newVal) -> {
           responsePREST=newVal;
        });
       idchoisie.selectedItemProperty().addListener((ObservableValue<? extends String> changed, String oldVal, String newVal) -> {
           responseID=newVal;
        });
        
        
        
        
        Reclamation rec= new Reclamation(txtNom.getText(),
                txtPrenom.getText(),
                txtMail.getText(),
                Integer.parseInt(txtTel.getText()),
                txtMission.getText(),
                txtDate.getEditor().getText(),
                nomchoisie.getSelectedItem(),
                txtMissionDesc.getText());
       int index =Integer.parseInt(idchoisie.getSelectedItem());
      recservice.updateReclamation(rec,index);
        alertModification.setTitle("Infos");
            alertModification.setHeaderText(null);
            alertModification.setContentText("Modification de reclamation n :"+responsePREST+" valide");
            alertModification.showAndWait();
    }

    @FXML
    private void Annuler_Modifier_Rec_On_Action(ActionEvent event) throws IOException {
//        Stage primaryStage= new Stage() ;
//        Parent root = FXMLLoader.load(getClass().getResource("../view_cote_client/AjoutReclamation.fxml"));
//        primaryStage.setTitle("Suppression d'une reclamation");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();

            Parent modificationParent = FXMLLoader.load(getClass().getResource("../view_cote_client/AjoutReclamation.fxml"));
        Scene modificationScene = new Scene(modificationParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(modificationScene);
        window.show();
    }
}
