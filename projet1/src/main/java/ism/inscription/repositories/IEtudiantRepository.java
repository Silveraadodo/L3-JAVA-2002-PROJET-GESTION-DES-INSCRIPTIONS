package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.Etudiant;

public interface IEtudiantRepository {
    
    public List<Etudiant> findAll();
     
    public Etudiant insert (Etudiant etudiant);
       
    public Etudiant findByMatricule(String mat);
        //stream c'est un tunel les elements qui sont a l'interieur,prendre chaque element de la lister et aplliquer autant d'operations qu'on veutpipe permettent d'ecrire des requetes sur les collections
         
    }

