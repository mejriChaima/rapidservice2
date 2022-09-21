
package service;

import BD.DataSource;
import entite.Reclamation;
import entite.commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class commentaireService {
    
    
     private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    public commentaireService(){
         cnx = DataSource.getInstance().getConnection();
    }
    
    public void saveCommentaire(commentaire comment) throws SQLException{
        
        String requete= "INSERT INTO commentaire (idCommentaire,contenu,dateCommentaire,idFichier,id_client) VALUES(?,?,?,?,?)";
        pst=cnx.prepareStatement(requete);
        
        pst.setInt(1,comment.getIdCommentaire());
        pst.setString(2, comment.getContenu());
        pst.setString(3, comment.getDateCommentaire());
        pst.setInt(4, comment.getIdFichier());
        pst.setInt(5, comment.getId_client());
        
       pst.executeUpdate();
    }
    
    public void saveCommentaire2(commentaire comment) throws SQLException{
        
        String requete= "INSERT INTO commentaire (contenu,dateCommentaire) VALUES(?,?)";
        pst=cnx.prepareStatement(requete);
        
       
        pst.setString(1,comment.getContenu());
        pst.setString(2,comment.getDateCommentaire());
        pst.executeUpdate();
    }
    
    public void deleteCommentaire(int indexCom) throws SQLException, ClassNotFoundException{
     String requete ="DELETE FROM commentaire WHERE idCommentaire='" + indexCom + "';"; 
     pst=cnx.prepareStatement(requete);
   pst.executeUpdate();
    
    }
    
     public void deleteALLReclamation() throws SQLException, ClassNotFoundException{
     String requete ="DELETE  FROM commentaire"; 
     pst=cnx.prepareStatement(requete);
    pst.executeUpdate();
    
    }
    
    public commentaire getCommentaire(int indexCom) throws SQLException, ClassNotFoundException {
        String requete = "SELECT * FROM commentaire WHERE idCommentaire='"+ indexCom + "';";
        pst = cnx.prepareStatement(requete);
        rs = pst.executeQuery();
        if (rs.next()) {
            return new commentaire(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5)
            );
        }else {
            return null;
        }
    }
    
    
    public ArrayList<commentaire> getAllCommentaires() {
              ArrayList<commentaire> commentaires = new ArrayList<>();
              
          try
          {
           String requete="SELECT * FROM commentaire";
        
            ste=cnx.createStatement();
            rs = ste.executeQuery(requete); 
            while (rs.next()){
                
                
                
                
                    commentaire com =new commentaire(
                     Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5)
                          
            );
           commentaires.add(com);
        }
            } catch (SQLException ex)
              {
            Logger.getLogger(commentaireService.class.getName()).log(Level.SEVERE, null, ex);
              }
        
        return commentaires;
        
        }
    
     
 public void updateCommentaire(commentaire com, int index) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DataSource.getInstance().getConnection().prepareStatement(
                "UPDATE commentaire SET idCommentaire=?,contenu=?,dateCommentaire=? WHERE idCommentaire='"+index+"';");
        
        statement.setInt(1,com.getIdCommentaire());
        statement.setString(2, com.getContenu());
        statement.setString(3, com.getDateCommentaire());
       
       
         statement.executeUpdate();

    }
    
}
