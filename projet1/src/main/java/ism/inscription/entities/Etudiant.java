package ism.inscription.entities;

import java.util.List;

public class Etudiant extends User {
    private String matricule;
    private String tuteur;

//one to many avec inscription
private List<Inscription> inscription;
    
//many to one avec Classe
private Classe classe;

   
    

    public Etudiant(String nomComplet, String matricule, String tuteur) {
    super(nomComplet);
    this.matricule = matricule;
    this.tuteur = tuteur;
    role=Role.ETUDIANT;
}


    public Etudiant(int id, Role role, String login, String password, String nomComplet, String matricule, String tuteur) {
    super(id, role, login, password, nomComplet);
    this.matricule = matricule;
    this.tuteur = tuteur;
    role=Role.ETUDIANT;
}


    public Etudiant(String matricule, String tuteur) {
    this.matricule = matricule;
    this.tuteur = tuteur;
}
   
    
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public String getTuteur() {
        return tuteur;
    }
    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }
    public List<Inscription> getInscription() {
        return inscription;
    }
    public void setInscription(List<Inscription> inscription) {
        this.inscription = inscription;
    }
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    @Override
    public String toString() {
        return "Etudiant [matricule=" + matricule + ", tuteur=" + tuteur + "]";
    }
    
    
}
