package ism.inscription.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Role;
import ism.inscription.repositories.IEtudiantRepository;
import ism.inscription.core.Mysqldb;

public class EtudiantRepository extends Mysqldb implements IEtudiantRepository{

    private  final static String SELECT_BY_MAT="SELECT * FROM `user` WHERE `matricule` LIKE ?";
    private  final static String SELECT="SELECT * FROM `user` WHERE role LIKE 'ETUDIANT'";
    private  final static String INSERT="INSERT INTO `user` (`nom_complet`, `matricule`, `tuteur`, `role`) VALUES (?,?,?,?);";

    @Override
    public List<Etudiant> findAll() {
        List <Etudiant> etudiants=new ArrayList<>();
        this.openConnexion();
        try {
            ps=conn.prepareStatement (SELECT);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Etudiant etudiant=new Etudiant(rs.getInt("id"),rs.getString("role").compareTo("ETUDIANT")==0?Role.ETUDIANT:Role.RP,rs.getString("login"),rs.getString("password"),rs.getString("nom_complet"),rs.getString("matricule"),rs.getString("tuteur"));
                etudiants.add(etudiant);
           
            }
      
      
    }catch (SQLException e) {
        e.printStackTrace();
    }
    this.closeConnexion();
    return etudiants;

        
    }

    @Override
    public Etudiant insert(Etudiant etudiant) {
        this.openConnexion();
        try {
            ps=conn.prepareStatement (INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, etudiant.getNomComplet());
            ps.setString(2, etudiant.getMatricule());
            ps.setString(3, etudiant.getTuteur());
            ps.setString(4, etudiant.getRole().name());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                etudiant.setId(rs.getInt(1));
              
           
            }
     
    }catch (SQLException e) {
        e.printStackTrace(); 
    }
    this.closeConnexion();
    return etudiant;
}

    @Override
    public Etudiant findByMatricule(String mat) {
        Etudiant etudiant=null;
            this.openConnexion();
            try {
                ps=conn.prepareStatement (SELECT_BY_MAT);
                ps.setString(1, mat);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    etudiant=new Etudiant(rs.getInt("id"),rs.getString("role").compareTo("ETUDIANT")==0?Role.ETUDIANT:Role.RP,rs.getString("login"),rs.getString("password"),rs.getString("nom_complet"),rs.getString("matricule"),rs.getString("tuteur"));
                }
           
        }catch (SQLException e) {
            e.printStackTrace();
    }
    this.closeConnexion();
    return etudiant;
}
    
       
    }
    

