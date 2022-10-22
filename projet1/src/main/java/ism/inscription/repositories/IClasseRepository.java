package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.Classe;

public interface IClasseRepository {

    public List<Classe> findAll();
    public Classe insert (Classe classe);
            
    public Classe findByLibelle(String lib);
        //stream c'est un tunel les elements qui sont a l'interieur,prendre chaque element de la lister et aplliquer autant d'operations qu'on veutpipe permettent d'ecrire des requetes sur les collections
         
}
