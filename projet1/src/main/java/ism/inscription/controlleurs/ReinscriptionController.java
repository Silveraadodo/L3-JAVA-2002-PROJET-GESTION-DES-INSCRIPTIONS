package ism.inscription.controlleurs;


import ism.inscription.core.Fabrique;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Inscription;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ReinscriptionController {

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtMat;


    public void handleReinscription(){
        String Matricule= txtMat.getText().trim();
        Etudiant etudiant= Fabrique.getService().findByMatricule(
            Matricule);
            Inscription inscription;
            if(etudiant!=null){
                String dateInscription=txtDate.getText().trim();
                inscription=new Inscription(dateInscription);

                inscription.setEtudiant(etudiant);

                Fabrique.getService().inscrireEtudiant(inscription);
                Alert alert=new Alert(AlertType.INFORMATION);
                alert.setTitle("Gestion reinscription");
                alert.setContentText("Etudiant réinscrit avec succes");
                alert.show();
                txtMat.clear();
                txtDate.clear();
            }
            
       
    }

}

    

