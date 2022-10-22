package ism.inscription.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.core.Mysqldb;
import ism.inscription.entities.Classe;
import ism.inscription.entities.ProfClasse;
import ism.inscription.entities.Professeur;
import ism.inscription.entities.Role;
import ism.inscription.repositories.IProfesseurRepository;

public class ProfesseurRepository extends Mysqldb implements IProfesseurRepository  {

    




    private final static String SELECT="SELECT * FROM user WHERE role LIKE 'PROFESSEUR'";
    private final static String SELECT_BY_NCI="SELECT * FROM `user` WHERE `nci` LIKE ?";
    private final static String INSERT="INSERT INTO `user` (`nom_complet`, `nci`, `grade`,role) VALUES (?,?,?,?);";
    private final static String SELECT_CLASSE="SELECT c.* FROM `classe` c,prof_classe pc ,user u WHERE c.id = pc.classe_id and u.id = pc.prof_id and u.nci like ?";
    private final static String INSERT_INTO="INSERT INTO`prof_classe` (`classe_id`, `prof_id`) VALUES (?, ?);";
    

    @Override
    public List<Professeur> findAll() {
       
            List <Professeur> professeurs=new ArrayList<>();
            this.openConnexion();
            try {
                ps=conn.prepareStatement (SELECT);
                ResultSet rs=ps.executeQuery();
                while (rs.next()){
                    Professeur professeur=new Professeur(rs.getInt("id"),rs.getString("role").compareTo("PROFESSEUR")==0?Role.PROFESSEUR:Role.RP,rs.getString("login"),rs.getString("password"),rs.getString("nom_complet"),rs.getString("nci"),rs.getString("grade"));
                    professeurs.add(professeur);
               
            
                }
          
                }catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnexion();
        return professeurs;
    
    }
    

    


    @Override
    public Professeur insert(Professeur professeur) {
        
            this.openConnexion();
            try {
                ps=conn.prepareStatement (INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, professeur.getNomComplet());
                ps.setString(2, professeur.getNci());
        
                ps.setString(3, professeur.getGrade());
                ps.setString(4, professeur.getRole().name());
                ps.executeUpdate();
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()){
                    professeur.setId(rs.getInt(1));
                  
               
                }
         
        }catch (SQLException e) {
            e.printStackTrace(); 
        }
        this.closeConnexion();
        return professeur;
    }


    @Override
    public Professeur findByNci(String nci) {
        Professeur professeur=null;
        this.openConnexion();
        try {
            ps=conn.prepareStatement (SELECT_BY_NCI);
            ps.setString(1, nci);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                professeur=new Professeur(rs.getInt("id"),rs.getString("role").compareTo("PROFESSEUR")==0?Role.PROFESSEUR:Role.RP,rs.getString("login"),rs.getString("password"),rs.getString("nom_complet"),rs.getString("nci"),rs.getString("grade"));
               
           
        
            }
      
            }catch (SQLException e) {
        e.printStackTrace();
    }
    this.closeConnexion();
    return professeur;
    
}





@Override
public ProfClasse affecterClasseProfesseur( ProfClasse profClasse) {
    this.openConnexion();
            try {
                ps=conn.prepareStatement (INSERT_INTO,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, profClasse.getClasse().getId());
                ps.setInt(2, profClasse.getProfesseur().getId());
        
                ps.executeUpdate();
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()){
                    profClasse.setId(rs.getInt(1));
                  
               
                }
         
        }catch (SQLException e) {
            e.printStackTrace(); 
        }
        this.closeConnexion();
        return profClasse;
    }
   







@Override
public List<Classe> listerClasseProfesseur(String nci) {
    List <Classe> classes=new ArrayList<>();
    this.openConnexion();
    try {
        ps=conn.prepareStatement (SELECT_CLASSE);
        ps.setString(1, nci);
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

}

