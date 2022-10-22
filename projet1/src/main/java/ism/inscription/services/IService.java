package ism.inscription.services;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Inscription;
import ism.inscription.entities.ProfClasse;
import ism.inscription.entities.Professeur;
import ism.inscription.entities.User;

public interface IService {
    public List<Classe> listerClasse();
    public Classe ajouterClasse(Classe classe);
    public Classe rechercherClasseParLibelle(String libelle);

    public Etudiant creerEtudiant(Etudiant etudiant);
    public List<Etudiant> listerEtudiant();
    public List<Etudiant> listerEtudiantAnnee();
    
    public  Professeur creerProfesseur(Professeur professeur);
    public List<Professeur> listerProfesseur();
    public ProfClasse affecterClasseProfesseur(ProfClasse profClasse);
    public List<Classe> listerClasseProfesseur(String nci);
    public Professeur findByNci(String nci);

    public Inscription inscrireEtudiant(Inscription inscription);
    public Inscription réinscrireEtudiant(Inscription inscription);

    public User seConnecter(String login,String password);
    public Etudiant findByMatricule(String matricule);
}
