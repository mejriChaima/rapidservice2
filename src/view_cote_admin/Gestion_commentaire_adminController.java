
package view_cote_admin;

import BD.DataSource;
import entite.Reclamation;
import entite.commentaire;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.commentaireService;
import service.reclamationService;


public class Gestion_commentaire_adminController implements Initializable {

    @FXML
    private Label lblDate;
    @FXML
    private Label lblHeure;
    @FXML
    private TableView<commentaire> table_commentaire;
    @FXML
    private TableColumn<commentaire, Integer> col_id_commentaire;
    @FXML
    private TableColumn<commentaire, Integer> col_id_client;
    @FXML
    private TableColumn<commentaire, String> col_date_commentaire;
    @FXML
    private TableColumn<commentaire, String> col_contenu;
    @FXML
    private TableColumn<commentaire, Integer> col_id_fichier;
    
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        commentaireService comserv = new commentaireService();
    }    

    @FXML
    private void remplirTab(ActionEvent event) {
         commentaireService comserv = new commentaireService();
        ArrayList<commentaire> list = comserv.getAllCommentaires();
        

        ObservableList<commentaire> obs = FXCollections.observableArrayList(list);
        col_id_commentaire.setCellValueFactory(new PropertyValueFactory<commentaire,Integer>("idCommentaire"));
        col_id_client.setCellValueFactory(new PropertyValueFactory<commentaire,Integer>("id_client"));
        col_id_fichier.setCellValueFactory(new PropertyValueFactory<commentaire,Integer>("idFichier"));
        col_date_commentaire.setCellValueFactory(new PropertyValueFactory<commentaire,String>("dateCommentaire"));
        col_contenu.setCellValueFactory(new PropertyValueFactory<commentaire,String>("contenu"));
           
    }
    
    
    public void showAll(ActionEvent ae){
			try {
				 cnx = DataSource.getInstance().getConnection();
				String sql="select * from commentaire";
				pst=cnx.prepareStatement(sql);
				
				rs=pst.executeQuery();
				while(rs.next()){
	col_id_commentaire.setCellValueFactory(new PropertyValueFactory<commentaire,Integer>("idCommentaire"));
        col_contenu.setCellValueFactory(new PropertyValueFactory<commentaire,String>("contenu"));
        col_date_commentaire.setCellValueFactory(new PropertyValueFactory<commentaire,String>("dateCommentaire"));
         col_id_fichier.setCellValueFactory(new PropertyValueFactory<commentaire,Integer>("idFichier"));
        col_id_client.setCellValueFactory(new PropertyValueFactory<commentaire,Integer>("id_client"));
       
        
        
					ObservableList<commentaire> data = FXCollections.observableArrayList(
					         new commentaire(rs.getInt("idCommentaire"),rs.getString("contenu"),rs.getString("dateCommentaire"),rs.getInt("idFichier"),rs.getInt("id_client"))
					);
					table_commentaire.getItems().addAll(data);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//    
    
    
    

    @FXML
    private void supp_commentaire_on_action(ActionEvent event) {
        table_commentaire.getItems().removeAll(table_commentaire.getSelectionModel().getSelectedItem());
    
    }

    @FXML
    private void retour_on_action(ActionEvent event) {
        Stage stage =(Stage) lblDate.getScene().getWindow();
    stage.close();
    }
    
}
