package ism.inscription.entities;

import java.util.List;

public class Professeur extends User{
    
    private String Nci;
    private String grade;


    //many to many avec classe
     private List<Classe>classe;


    
    
  
   
    public Professeur(String nomComplet, String nci, String grade) {
        super(nomComplet);
        Nci = nci;
        this.grade = grade;
        role=Role.PROFESSEUR;
    }
    public Professeur(int id, Role role, String login, String password, String nomComplet, String nci, String grade) {
        super(id, role, login, password, nomComplet);
        Nci = nci;
        this.grade = grade;
        role=Role.PROFESSEUR;
    }
    public Professeur(String nci, String grade) {
        Nci = nci;
        this.grade = grade;
    }
    public Professeur(String login, String password, String nomComplet, String nci, String grade) {
        super(login, password, nomComplet);
        Nci = nci;
        this.grade = grade;
        role=Role.PROFESSEUR;
    }
    public String getNci() {
        return Nci;
    }
    public void setNci(String nci) {
        Nci = nci;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<Classe> getClasse() {
        return classe;
    }
    public void setClasse(List<Classe> classe) {
        this.classe = classe;
    }
    @Override
    public String toString() {
        return "Professeur [Nci=" + Nci + ", grade=" + grade + "]";
    }
   
}
