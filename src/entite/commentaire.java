
package entite;


public class commentaire {
    
    private int idCommentaire ;
    private String contenu ;
    private String dateCommentaire ;
    private int idFichier ;
    private int id_client ;

    public commentaire() {
    }

    public commentaire(String contenu, String dateCommentaire) {
        this.contenu = contenu;
        this.dateCommentaire = dateCommentaire;
    }

    public commentaire(int idCommentaire, String contenu, String dateCommentaire) {
        this.idCommentaire = idCommentaire;
        this.contenu = contenu;
        this.dateCommentaire = dateCommentaire;
    }

    public commentaire(int idCommentaire, String contenu, String dateCommentaire, int idFichier, int id_client) {
        this.idCommentaire = idCommentaire;
        this.contenu = contenu;
        this.dateCommentaire = dateCommentaire;
        this.idFichier = idFichier;
        this.id_client = id_client;
    }
    
    
    
    
    public int getIdCommentaire() {
        return idCommentaire;
    }

    public String getContenu() {
        return contenu;
    }

    public String getDateCommentaire() {
        return dateCommentaire;
    }

    public int getIdFichier() {
        return idFichier;
    }

    public int getId_client() {
        return id_client;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDateCommentaire(String dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public void setIdFichier(int idFichier) {
        this.idFichier = idFichier;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "commentaire{" + "idCommentaire=" + idCommentaire + ", contenu=" + contenu + ", dateCommentaire=" + dateCommentaire + ", idFichier=" + idFichier + ", id_client=" + id_client + '}';
    }
    
    
    
    
}
