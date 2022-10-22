package ism.inscription.services;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Inscription;
import ism.inscription.entities.ProfClasse;
import ism.inscription.entities.Professeur;
import ism.inscription.entities.User;
import ism.inscription.repositories.IClasseRepository;
import ism.inscription.repositories.IEtudiantRepository;
import ism.inscription.repositories.IInscriptionRepository;
import ism.inscription.repositories.IProfesseurRepository;
import ism.inscription.repositories.IUserRepository;
import ism.inscription.repositories.bd.EtudiantRepository;
import ism.inscription.repositories.bd.InscriptionRepository;
import ism.inscription.repositories.bd.ProfesseurRepository;



public class Service implements IService {

    IClasseRepository classeRepository;
    IEtudiantRepository etudiantRepository;
    IProfesseurRepository professeurRepository;
    IUserRepository userRepository;
    IInscriptionRepository inscriptionRepository;
   
    public Service(IClasseRepository classeRepository, IProfesseurRepository professeurRepository,
            IEtudiantRepository etudiantRepository, IUserRepository userRepository,InscriptionRepository inscriptionRepository) {
        this.classeRepository = classeRepository;
        this.etudiantRepository = etudiantRepository;
        this.professeurRepository = professeurRepository;
        this.userRepository = userRepository;
        this.inscriptionRepository = inscriptionRepository;
    }

    public Service() {
        this.classeRepository = classeRepository;
        this.etudiantRepository = etudiantRepository;
        this.professeurRepository = professeurRepository;
        this.userRepository = userRepository;
        this.inscriptionRepository = inscriptionRepository;
    }
    
    public List<Classe> listerClasse(){
        return classeRepository.findAll();
    }
    public Classe ajouterClasse(Classe classe){
        return classeRepository.insert(classe);
    }
    public Classe rechercherClasseParLibelle(String libelle){
        return classeRepository.findByLibelle(libelle);
    }


    public List<Etudiant> listerEtudiant(){
    return etudiantRepository.findAll();
    }
    @Override
    public List<Etudiant> listerEtudiantAnnee() {
        return null;
    }
    @Override
    public Etudiant creerEtudiant(Etudiant etudiant) {

        return etudiantRepository.insert(etudiant);
    }
    


    public  Professeur creerProfesseur(Professeur professeur){
        return professeurRepository.insert(professeur);
    }
    public List<Professeur> listerProfesseur(){
        return professeurRepository.findAll();
    }
    @Override
    public ProfClasse affecterClasseProfesseur(ProfClasse profClasse ) {
        return professeurRepository.affecterClasseProfesseur(profClasse);
    }
    @Override
    public List<Classe> listerClasseProfesseur(String nci) {
        return professeurRepository.listerClasseProfesseur(nci);
    }
    public Professeur findByNci(String nci) {
        return professeurRepository.findByNci(nci);
    }



    public void insert(Classe classe) {
    }
    

    @Override
    public User seConnecter(String login, String password) {
        return userRepository.seConnecter(login, password);
    }

    @Override
    public Inscription inscrireEtudiant(Inscription inscription) {
      
        return inscriptionRepository.inscrireEtudiant(inscription);
    }

    @Override
    public Inscription réinscrireEtudiant(Inscription inscription) {
        
        return  inscriptionRepository.reinscrireEtudiant(inscription);
    }

    @Override
    public Etudiant findByMatricule(String matricule) {
       
        return etudiantRepository.findByMatricule(matricule);
    }
    

  
   

    
  
    
}
