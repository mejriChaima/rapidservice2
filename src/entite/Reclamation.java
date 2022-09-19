
package entite;

import java.util.Date;
import javafx.scene.control.SingleSelectionModel;



public class Reclamation {
    private int nRec ;
    private String  nom;
    private String  prenom;
    private String  email;
    private int tel ;
    private String  mission;
    private String datemission ;
    private String nomPrestataire;
    private String  missionDesc;

    public Reclamation(int nRec, String nom, String prenom, String email, int tel, String mission, String datemission, String nomPrestataire, String missionDesc) {
        this.nRec = nRec;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.mission = mission;
        this.datemission = datemission;
        this.nomPrestataire = nomPrestataire;
        this.missionDesc = missionDesc;
    }
    
    
    

    public Reclamation(String nom, String prenom, String email, int tel, String mission, String datemission, String nomPrestataire, String missionDesc) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.mission = mission;
        this.datemission = datemission;
        this.nomPrestataire = nomPrestataire;
        this.missionDesc = missionDesc;
    }

    public Reclamation() {
    }

    
    
    
    

    public int getnRec() {
        return nRec;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public int getTel() {
        return tel;
    }

    public String getMission() {
        return mission;
    }

    public String getDatemission() {
        return datemission;
    }

    public String getNomPrestataire() {
        return nomPrestataire;
    }

    public String getMissionDesc() {
        return missionDesc;
    }

    public void setnRec(int nRec) {
        this.nRec = nRec;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public void setDatemission(String datemission) {
        this.datemission = datemission;
    }

    public void setNomPrestataire(String nomPrestataire) {
        this.nomPrestataire = nomPrestataire;
    }

    public void setMissionDesc(String missionDesc) {
        this.missionDesc = missionDesc;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.nRec;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.nRec != other.nRec) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "Num Rec=" + nRec + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", tel=" + tel + ", mission=" + mission + ", datemission=" + datemission + ", nomPrestataire=" + nomPrestataire + ", missionDesc=" + missionDesc + '}';
    }
    
    
    








}
