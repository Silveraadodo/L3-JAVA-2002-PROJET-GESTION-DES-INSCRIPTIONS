package ism.inscription.repositories;

import ism.inscription.entities.Inscription;

public interface IInscriptionRepository {
    
    public Inscription inscrireEtudiant(Inscription inscription);
    public Inscription reinscrireEtudiant(Inscription inscription);
}
