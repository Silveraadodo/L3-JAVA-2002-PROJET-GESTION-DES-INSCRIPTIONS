package ism.inscription.repositories;

import ism.inscription.entities.User;

public interface IUserRepository {
    public User seConnecter (String login, String password);
    
}
