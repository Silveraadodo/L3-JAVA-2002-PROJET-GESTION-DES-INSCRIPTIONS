package ism.inscription.entities;

import java.util.List;



public class Classe {
    protected int id;
    private String libelle;
   
    private static int  nbre;

//many to many

    
    public Classe(String libelle) {
        this.libelle = libelle;
        
        nbre++;
        id=nbre;

    }
    public Classe() {
        nbre++;
        id=nbre;
    }
    //one to many avec Etudiant
    private List<Etudiant> etudiant;

    //many to many avec professeur
    private List<Professeur>professeur;

    
    
    
    public Classe(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
    public int getId() {
        return id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
   
    public List<Etudiant> getEtudiant() {
        return etudiant;
    }
    public void setEtudiant(List<Etudiant> etudiant) {
        this.etudiant = etudiant;
    }

    public List<Professeur> getProfesseur() {
        return professeur;
    }
    public void setProfesseur(List<Professeur> professeur) {
        this.professeur = professeur;
    }
    @Override
    public String toString() {
        return "Classe [id=" + id + ", libellé=" + libelle + "]";
    }
    public void setId(int id) {
        this.id = id;
    }
    public static void setNbre(int nbre) {
        Classe.nbre = nbre;
    }
    
    
   
}
