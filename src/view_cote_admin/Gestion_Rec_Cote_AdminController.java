
package view_cote_admin;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import testconnrapidservice.Reclamation;
import testconnrapidservice.reclamationService;


public class Gestion_Rec_Cote_AdminController {

    @FXML
    private Label lblDate;
    @FXML
    private Label lblHeure;
    @FXML
    private ComboBox<String> listprest;
    @FXML
    private Label response;
    
     @FXML
    private TableView<Reclamation> tableReclamation;

    @FXML
    private TableColumn<Reclamation,Integer> colId;

    @FXML
    private TableColumn<Reclamation,String> colNom;

    @FXML
    private TableColumn<Reclamation,String> colPrenom;

    @FXML
    private TableColumn<Reclamation,Integer> colTel;

    @FXML
    private TableColumn<Reclamation,String> colMail;

    @FXML
    private TableColumn<Reclamation,String> colMission;
    @FXML
    private TableColumn<Reclamation,String> colMDate;

    @FXML
    private TableColumn<Reclamation,String> colDescM;
    
    @FXML
    private TableColumn<Reclamation,String> col_Nom_Prestataire;

    
        private FXMLLoader fxmlLoader = null;
        private Parent root1=null;
        private Stage stage=null;
  
    public void initialize() {
         loadDateAndTime();
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
    public void remplirTab() throws SQLException, ClassNotFoundException {
        reclamationService ps = new reclamationService();
        ArrayList<Reclamation> list = ps.getAllReclamation();
        

        ObservableList<Reclamation> obs = FXCollections.observableArrayList(list);

        colId.setCellValueFactory(new PropertyValueFactory<>("nRec"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colMail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colMission.setCellValueFactory(new PropertyValueFactory<>("mission"));
        colMDate.setCellValueFactory(new PropertyValueFactory<>("datemission"));
        col_Nom_Prestataire.setCellValueFactory(new PropertyValueFactory<>("nomPrestataire"));
        colDescM.setCellValueFactory(new PropertyValueFactory<>("missionDesc"));
        
        
        
        tableReclamation.setItems(obs);

    }

        @FXML
    void Supp_Rec_On_Action(ActionEvent event) throws IOException {
     fxmlLoader = new FXMLLoader(getClass().getResource("../view_cote_admin/Supprimer_rec_cote_admin.fxml"));
                root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.setTitle("Suppression");
                stage.setScene(new Scene(root1));
                stage.show();
            




    }
    
}
