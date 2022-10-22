package ism.inscription.controlleurs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.core.Fabrique;
import ism.inscription.entities.Etudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class EtudiantController implements Initializable {

    @FXML
    private TableView<Etudiant> tabEtudiant;

    @FXML
    private TableColumn<Etudiant, String> tdID;

    @FXML
    private TableColumn<Etudiant, String> tdMatricule;

    @FXML
    private TableColumn<Etudiant, String> tdNomComplet;

    @FXML
    private TableColumn<Etudiant, String> tdTuteur;
    @FXML
    private TextField txtMatricule;

    @FXML
    private TextField txtNomComplet;

    @FXML
    private TextField txtTuteur;



    private ObservableList obEtudiant=FXCollections.observableList(Fabrique.getService().listerEtudiant());
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    tdID.setCellValueFactory(new PropertyValueFactory<>("id"));
    tdNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
    tdMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
    tdTuteur.setCellValueFactory(new PropertyValueFactory<>("tuteur"));
    tabEtudiant.setItems(obEtudiant);
     
        
    }
    

   
 

  

   @FXML
  private void onSaveEtudiant() throws IOException {
    String NomComplet=txtNomComplet.getText().trim();
    String Matricule=txtMatricule.getText().trim();
    String tuteur=txtTuteur.getText().trim();
           Etudiant etudiant= Fabrique.getService().creerEtudiant(
                new Etudiant(NomComplet,Matricule,tuteur)
           );

           Alert alert=new Alert(AlertType.INFORMATION);
           alert.setTitle("Gestion Etudiant");
           alert.setContentText("Etudiant ajouté avec succes");
           alert.show();
     
           obEtudiant.add(etudiant);
           tabEtudiant.getItems().clear();
          
  }







     
       }
     
     
    
    

