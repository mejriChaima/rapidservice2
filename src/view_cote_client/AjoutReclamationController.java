
package view_cote_client;

import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import BD.DataSource;
import com.jfoenix.controls.JFXComboBox;
import entite.Reclamation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import service.reclamationService;


public class AjoutReclamationController implements Initializable {

    @FXML
    private Button btnAjoutRec;
    @FXML
    private Button btnAjoutReclamation;
    @FXML
    private Button btnModifierRec;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblHeure;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtMail;
    @FXML
    private TextField txtMission;
    @FXML
    private TextField txtMissionDesc;
    @FXML
    private JFXDatePicker txtDate;
    
    @FXML
    private JFXComboBox<String> listprest;
    @FXML
    private Label response;
    @FXML
    private Button btnListeRec;
    @FXML
    private TableView<Reclamation> tableReclamation;
    @FXML
    private TableColumn<Reclamation,String> colId;
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
    private TableColumn<Reclamation,String> col_Nom_Prestataire;
    @FXML
    private TableColumn<Reclamation,String> colDescM;
     @FXML
    private Hyperlink log_out;

    @FXML
    private Label welcome_user;
    
    private Alert alertAjout = new Alert(Alert.AlertType.INFORMATION);
     private Alert alertChampVide = new Alert(Alert.AlertType.INFORMATION);
     private Alert alertChampIncorrecte = new Alert(Alert.AlertType.INFORMATION);
     private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadNomsPrestataire();
             loadDateAndTime();
            Data_to_Table();
        } catch (SQLException ex) {
            Logger.getLogger(AjoutReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AjoutReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private  void clearAllData(){
         txtNom.clear();
         txtPrenom.clear();
        txtTel.clear();
        txtMail.clear();
        txtMission.clear();
        txtMissionDesc.clear();
    }
   
    
    @FXML
    private void Ajouter_Rec_On_Action(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        reclamationService recservice= new reclamationService();
        ArrayList<String> list=  recservice.getPrestataireNames();
        ObservableList <String> prestataireNames;
        prestataireNames = FXCollections.observableArrayList(list);
        SingleSelectionModel<String> nomchoisie= listprest.getSelectionModel();
       nomchoisie.selectedItemProperty().addListener((ObservableValue<? extends String> changed, String oldVal, String newVal) -> {
           response.setText(" :"+newVal);
        });
//       adate=ConversionDate_string();
        
        
        
        if (txtNom.getText().isEmpty()||
                txtPrenom.getText().isEmpty()||
                txtMail.getText().isEmpty()||
                txtTel.getText().isEmpty()||
                txtMission.getText().isEmpty()||
               txtDate.getEditor().getText().isEmpty()||
                nomchoisie.getSelectedItem().isEmpty()||
                txtMissionDesc.getText().isEmpty()
                )
        {
        alertChampVide.setTitle("Infos");
            alertChampVide.setHeaderText(null);
            alertChampVide.setContentText("Svp remplir tout les champs");
            alertChampVide.showAndWait();
        }
        else if (!ValideteEmail()||
                (txtNom.getText().matches("[a-zA-Z0-9{4,}]"))
                
                )
        {
            alertChampIncorrecte.setTitle("Infos");
            alertChampIncorrecte .setHeaderText(null);
            alertChampIncorrecte .setContentText(" SVP Verifier les champs invalides  ");
            alertChampIncorrecte .showAndWait();
        }
            
            
        else    
        {
        Reclamation rec;
        rec = new Reclamation(txtNom.getText(),
                txtPrenom.getText(),
                txtMail.getText(),
                Integer.parseInt(txtTel.getText()),
                txtMission.getText(),
               txtDate.getEditor().getText(),
                nomchoisie.getSelectedItem(),
                txtMissionDesc.getText()
        );
        recservice.saveReclamation(rec);
        clearAllData();
        alertAjout.setTitle("Infos");
            alertAjout.setHeaderText(null);
            alertAjout.setContentText("Insetion des informations valide");
            alertAjout.showAndWait();
        }
    }
       
    

    // charger la liste 
    private void loadNomsPrestataire() throws SQLException, ClassNotFoundException {
        reclamationService recservice= new reclamationService();
       
        List<String> NomsPrestataire = recservice.getPrestataireNames();
        listprest.getItems().addAll( NomsPrestataire);
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
    private void Supp_Rec_On_Action(ActionEvent event) throws IOException {
        Stage primaryStage= new Stage() ;
        Parent root = FXMLLoader.load(getClass().getResource("../view_cote_client/SupprimerRec.fxml"));
        primaryStage.setTitle("Suppression d'une reclamation");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    
    @FXML
    private void Modifier_Rec_On_Action(ActionEvent event) throws IOException {
        Stage primaryStage= new Stage() ;
        Parent root = FXMLLoader.load(getClass().getResource("../view_cote_client/ModifierRec.fxml"));
        primaryStage.setTitle(" Modification d'une reclamation ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

   
    @FXML
    private void remplirTab(ActionEvent event) {
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
    
    //
    //Affichage des reclamations d'un utilisateur
    public void Data_to_Table()
      {
             cnx = DataSource.getInstance().getConnection();
          ObservableList<Reclamation> listREC = FXCollections.observableArrayList();
          String usernom = txtNom.getText();
          try
                {    
                    pst = cnx.prepareStatement("SELECT * FROM reclamation WHERE nom='"+ usernom + "';");  
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next())
                            {
                                Reclamation rec = new Reclamation();
                                rec.setnRec(Integer.parseInt(rs.getString("nRec")));
                                rec.setNom(rs.getString("nom"));
                                rec.setPrenom(rs.getString("prenom"));
                                rec.setEmail(rs.getString("email"));
                                rec.setTel(Integer.parseInt(rs.getString("tel")));
                                rec.setMission(rs.getString("mission"));
                                rec.setDatemission(rs.getString("datemission"));
                                rec.setNomPrestataire(rs.getString("nomPrestataire"));
                                rec.setMissionDesc(rs.getString("missionDesc"));

                                listREC.add(rec);
                            }
                    }

                    tableReclamation.setItems(listREC);
                    
                    colId.setCellValueFactory(new PropertyValueFactory<>("nRec"));
                    colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                    colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                    colMail.setCellValueFactory(new PropertyValueFactory<>("email"));
                    colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
                    colMission.setCellValueFactory(new PropertyValueFactory<>("mission"));
                    colMDate.setCellValueFactory(new PropertyValueFactory<>("datemission"));
                    col_Nom_Prestataire.setCellValueFactory(new PropertyValueFactory<>("nomPrestataire"));
                    colDescM.setCellValueFactory(new PropertyValueFactory<>("missionDesc"));
                  }
   
            catch (SQLException ex)
                {
                    Logger.getLogger(reclamationService.class.getName()).log(Level.SEVERE, null, ex);
                }
    
}
      private boolean ValideteEmail(){

        String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txtMail.getText());
        return matcher.matches();
    /*
        
        Pattern p =Pattern.compile(" [a-zA-Z0-9] [a-zA-Z0-9._] *@[a-zA-Z0-9]+ ([.][a-zA-Z0-9._]+)+");
        Matcher m =p.matcher(mailc.getText());
        if( m.find() && m.group().equals(mailc.getText())){
         return true;
        
        }else {
        
        
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Email valide");
        alert.setContentText("SVP Entrez vous un Email Valide");
        alert.showAndWait();
       
        return false;*/
    }
}