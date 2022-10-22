package ism.inscription.entities;

public class Inscription {
    private int id;
    
    private String dateInscription;
    


    

    

//many to one avec etuadiant
private Etudiant etudiant;


   

    public Inscription(String dateInscription, Etudiant etudiant) {
    this.dateInscription = dateInscription;
   
    this.etudiant = etudiant;
}

    public Inscription(String dateInscription, String annee) {
    this.dateInscription = dateInscription;
   
}

    public Inscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }
    
    public Etudiant getEtudiant() {
        return etudiant;
    }
    
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    @Override
    public String toString() {
        return "Inscription [dateInscription=" + dateInscription + "]";
    }
    
}
