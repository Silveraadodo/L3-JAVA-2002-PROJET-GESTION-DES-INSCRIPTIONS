package ism.inscription.controlleurs;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.core.Fabrique;
import ism.inscription.entities.Professeur;
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

public class ProfesseurController  implements Initializable  {
    @FXML
    private TableView<Professeur> tabProf;

    @FXML
    private TableColumn<Professeur, String> tdGrade;

    @FXML
    private TableColumn<Professeur, String> tdId;

    @FXML
    private TableColumn<Professeur, String> tdNci;

    @FXML
    private TableColumn<Professeur, String> tdNomComplet;

    @FXML
    TextField txtGrade;

    @FXML
    TextField txtNci;

    @FXML
     TextField txtNomComplet;

    
private ObservableList obProfesseur=FXCollections.observableList(Fabrique.getService().listerProfesseur());


@Override
public void initialize(URL location, ResourceBundle resources) {
tdId.setCellValueFactory(new PropertyValueFactory<>("id"));
tdNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
tdNci.setCellValueFactory(new PropertyValueFactory<>("Nci"));
tdGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));

tabProf.setItems(obProfesseur);

     
}
   public void onSaveProfesseur() throws IOException {
          String NomComplet=txtNomComplet.getText().trim();
          String Nci=txtNci.getText().trim();
          String grade=txtGrade.getText().trim();
            Professeur professeur= Fabrique.getService().creerProfesseur(
               new Professeur(NomComplet,Nci,grade)
            );

            
           Alert alert=new Alert(AlertType.INFORMATION);
           alert.setTitle("Gestion Etudiant");
           alert.setContentText("prof ajouté avec succes");
           alert.show();
     
           obProfesseur.add(professeur);
           tabProf.getItems().clear();
           
         
           
   }
    







}
