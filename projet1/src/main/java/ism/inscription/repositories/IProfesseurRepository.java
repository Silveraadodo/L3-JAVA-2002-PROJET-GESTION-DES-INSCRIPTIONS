package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.ProfClasse;
import ism.inscription.entities.Professeur;

public interface IProfesseurRepository {
    
    public List<Professeur> findAll();

    public Professeur insert (Professeur professeur);
       
    
    public Professeur findByNci(String nci);
    public ProfClasse affecterClasseProfesseur(ProfClasse profClasse);
    public List<Classe> listerClasseProfesseur(String nci);
    

}
