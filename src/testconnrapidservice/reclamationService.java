
package testconnrapidservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class reclamationService {
    
    
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public reclamationService() {
        cnx = DataSource.getInstance().getConnection();
    }
    
    

 public void saveReclamation(Reclamation rec) throws SQLException{
        
        String requete= "INSERT INTO reclamation (nom, prenom, email, tel, mission,datemission,nomPrestataire,missionDesc) VALUES(?,?,?,?,?,?,?,?)";
        pst=cnx.prepareStatement(requete);
        
        pst.setString(1,rec.getNom());
        pst.setString(2, rec.getPrenom());
        pst.setString(3, rec.getEmail());
        pst.setInt(4,rec.getTel());
        pst.setString(5,rec.getMission());
        pst.setString(6,rec.getDatemission());
        pst.setString(7,rec.getNomPrestataire());
        pst.setString(8,rec.getMissionDesc());
       
       pst.executeUpdate();
    }
        
        

        
 public void deleteReclamation(int indexRec) throws SQLException, ClassNotFoundException{
     String requete ="DELETE FROM reclamation WHERE nRec='" + indexRec + "';"; 
     pst=cnx.prepareStatement(requete);
   pst.executeUpdate();
    
    }
 
 public boolean deleteALLReclamation() throws SQLException, ClassNotFoundException{
     String requete ="DELETE  FROM reclamation"; 
     pst=cnx.prepareStatement(requete);
    return( pst.executeUpdate()>0);
    
    }


 public Reclamation getReclamation(int indexRec) throws SQLException, ClassNotFoundException {
        String requete = "SELECT * FROM reclamation WHERE nRec='"+ indexRec + "';";
        pst = cnx.prepareStatement(requete);
        rs = pst.executeQuery();
        if (rs.next()) {
            return new Reclamation(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9)
            );
        }else {
            return null;
        }
    }



 public ArrayList<Reclamation> getAllReclamation() {
              ArrayList<Reclamation> Reclamations = new ArrayList<>();
              
          try
          {
           String requete="SELECT * FROM reclamation";
        
            ste=cnx.createStatement();
            rs = ste.executeQuery(requete); 
            while (rs.next()){
                
                
                
                
                    Reclamation rec =new Reclamation(
                     Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9)
                   
            );
           Reclamations.add(rec);
        }
            } catch (SQLException ex)
              {
            Logger.getLogger(reclamationService.class.getName()).log(Level.SEVERE, null, ex);
              }
        
        return Reclamations;
        
        }

 


 
 
 
 
 
 
 public void updateReclamation(Reclamation rec, int index) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DataSource.getInstance().getConnection().prepareStatement(
                "UPDATE reclamation SET nom=?,prenom=?,email=?,tel=?, mission=?, datemission=?, nomPrestataire=?, missionDesc=? WHERE nRec='"+index+"';");
        
        statement.setString(1,rec.getNom());
        statement.setString(2, rec.getPrenom());
        statement.setString(3, rec.getEmail());
        statement.setInt(4, rec.getTel());
        statement.setString(5,rec.getMission());
        statement.setString(6,rec.getDatemission());
        statement.setString(7,rec.getNomPrestataire());
        statement.setString(8,rec.getMissionDesc());
       

         statement.executeUpdate();

    }


    public ArrayList<String> getReclamationIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = DataSource.getInstance().getConnection().prepareStatement("SELECT nRec FROM reclamation ").executeQuery();
        ArrayList<String> RecId = new ArrayList<>();
        while (rst.next()) {
            RecId.add(
                    rst.getString(1)
            );
        }
        return RecId;
    }
    
    
    
    public ArrayList<String> getPrestataireNames() throws SQLException, ClassNotFoundException {
        ResultSet rst = DataSource.getInstance().getConnection().prepareStatement("SELECT CONCAT(nom,' ',prenom) as  'FullName' FROM prestataire ").executeQuery();
        ArrayList<String> UserNames = new ArrayList<>();
        while (rst.next()) {
            UserNames.add(
                    rst.getString(1)
            );
        }
        return UserNames;
    }
       
    
}
