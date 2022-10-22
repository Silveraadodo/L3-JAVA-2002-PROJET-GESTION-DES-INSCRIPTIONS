

package ism.inscription.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.core.Mysqldb;
import ism.inscription.repositories.IClasseRepository;

public class ClasseRepository extends Mysqldb implements IClasseRepository {

    private  final static String SELECT_BY_ID="SELECT * FROM `classe` WHERE `libelle` LIKE ?";
    private  final static String SELECT="SELECT * FROM `classe`";
    private final static String INSERT="INSERT INTO `classe` (`libelle`) VALUES (?);";

    @Override
    public List<Classe> findAll() {
        List <Classe> classes=new ArrayList<>();
        this.openConnexion();
        try {
            ps=conn.prepareStatement (SELECT);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Classe classe=new Classe(rs.getInt("id"),rs.getString("libelle"));
                classes.add(classe);
           
            }
      
      
    }catch (SQLException e) {
        e.printStackTrace();
    }
    this.closeConnexion();
    return classes;

}


    @Override
    public Classe insert(Classe classe) {
            this.openConnexion();
            try {
                ps=conn.prepareStatement (INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, classe.getLibelle());
                ps.executeUpdate();
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()){
                    classe.setId(rs.getInt(1));
                  
               
                }
         
        }catch (SQLException e) {
            e.printStackTrace(); 
        }
        this.closeConnexion();
        return classe;
    }

    @Override
    public Classe findByLibelle(String lib) {
            Classe classe=null;
            this.openConnexion();
            try {
                ps=conn.prepareStatement (SELECT_BY_ID);
                ps.setString(1, lib);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    classe=new Classe(rs.getInt("id"),rs.getString("libelle"));
                }
           
        }catch (SQLException e) {
            e.printStackTrace();
    }
    this.closeConnexion();
    return classe;
}
    
}
