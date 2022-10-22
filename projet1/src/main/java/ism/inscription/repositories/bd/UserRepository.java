package ism.inscription.repositories.bd;

import java.sql.ResultSet;
import java.sql.SQLException;

import ism.inscription.core.Mysqldb;
import ism.inscription.entities.Role;
import ism.inscription.entities.User;
import ism.inscription.repositories.IUserRepository;

public class UserRepository extends Mysqldb implements IUserRepository {

    private final static String SELECT= "SELECT * FROM user WHERE login like? and password like?";

    @Override
    public User seConnecter(String login, String password) {
        User user=null;
        this.openConnexion();
        try {
            ps=conn.prepareStatement (SELECT);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                user=new User(rs.getInt("id"),rs.getString("role").compareTo("RP")==0?Role.RP:Role.AC,rs.getString("login"),rs.getString("password"),rs.getString("nom_complet"));
               
           
        
            }
      
            }catch (SQLException e) {
        e.printStackTrace();
    }
    this.closeConnexion();
    return user;
    
}
}

       
       
    
    

