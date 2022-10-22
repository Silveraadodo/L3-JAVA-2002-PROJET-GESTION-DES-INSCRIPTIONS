package ism.inscription.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ism.inscription.core.Mysqldb;
import ism.inscription.entities.Inscription;
import ism.inscription.repositories.IInscriptionRepository;

public class InscriptionRepository extends Mysqldb implements IInscriptionRepository {
    private final static String INSERT ="INSERT INTO `inscription` (`dateInscription`, `etudiant_id`) VALUES (?,?);";

   

    @Override
    public Inscription inscrireEtudiant(Inscription inscription) {
        this.openConnexion();
        try {
            ps=conn.prepareStatement (INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, inscription.getDateInscription());
            ps.setInt(2, inscription.getEtudiant().getId());
           
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                inscription.setId(rs.getInt(1));
              
           
            }
     
    }catch (SQLException e) {
        e.printStackTrace(); 
    }
    this.closeConnexion();
    return inscription;
}

   
    @Override
    public Inscription reinscrireEtudiant(Inscription inscription) {
        // TODO Auto-generated method stub
        return null;
    }

    

   

   
    
}
