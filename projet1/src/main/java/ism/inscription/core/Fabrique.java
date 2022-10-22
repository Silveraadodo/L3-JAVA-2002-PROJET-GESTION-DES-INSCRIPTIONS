package ism.inscription.core;

import ism.inscription.repositories.IClasseRepository;
import ism.inscription.repositories.IEtudiantRepository;

import ism.inscription.repositories.IProfesseurRepository;
import ism.inscription.repositories.IUserRepository;
import ism.inscription.repositories.bd.ClasseRepository;
import ism.inscription.repositories.bd.EtudiantRepository;
import ism.inscription.repositories.bd.InscriptionRepository;
import ism.inscription.repositories.bd.ProfesseurRepository;
import ism.inscription.repositories.bd.UserRepository;

import ism.inscription.services.IService;
import ism.inscription.services.Service;

public class Fabrique {
    public static IService getService(){
        //couplage faible
        IClasseRepository classeRepository=new ClasseRepository();
        IProfesseurRepository professeurRepository=new ProfesseurRepository();
        IEtudiantRepository etudiantRepository=new EtudiantRepository();
        InscriptionRepository inscriptionRepository=new InscriptionRepository();
      
       
        IUserRepository userRepository=new UserRepository();
        
        return new Service(classeRepository,professeurRepository,etudiantRepository,userRepository,inscriptionRepository);
    }
    
}
