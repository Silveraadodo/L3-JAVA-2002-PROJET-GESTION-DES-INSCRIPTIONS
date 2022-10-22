package ism.inscription.controlleurs;


import java.io.IOException;

import ism.inscription.App;
import ism.inscription.core.Fabrique;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Inscription;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class InscriptionController {
    
    @FXML
    private AnchorPane anchorContent;

    @FXML
    private Text txt;

    @FXML
    private TextField txtClasse;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtMat;

    @FXML
    private TextField txtNcomplet;

    @FXML
    private TextField txtTut;

    public void handleInscription(){
    String NComplet=txtNcomplet.getText().trim();
    String Matricule=txtMat.getText().trim();
    String tuteur=txtTut.getText().trim();
           Etudiant etudiant= Fabrique.getService().creerEtudiant(
                new Etudiant(NComplet,Matricule,tuteur));
           


                Inscription inscription;
                String dateInscription=txtDate.getText().trim();
                inscription=new Inscription (dateInscription);
                inscription.setEtudiant(etudiant);

                Fabrique.getService().inscrireEtudiant(inscription);

                Alert alert=new Alert(AlertType.INFORMATION);
                alert.setTitle("Gestion Etudiant");
                alert.setContentText("Etudiant inscrit avec succes");
                alert.show();
                txtClasse.clear();
                txtDate.clear();
                txtMat.clear();
                txtNcomplet.clear();
                txtTut.clear();
    }








    public void loadView(String fxml) throws IOException{
        AnchorPane root =(AnchorPane) App.loadFXML(fxml);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);
    }
         
    public void handleloadViewReinscription() throws IOException{
        this.loadView("reinscription");
    }   

}


