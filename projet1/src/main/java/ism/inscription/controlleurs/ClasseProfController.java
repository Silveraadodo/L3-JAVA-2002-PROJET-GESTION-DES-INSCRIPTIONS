package ism.inscription.controlleurs;


import ism.inscription.core.Fabrique;
import ism.inscription.entities.Classe;
import ism.inscription.entities.ProfClasse;
import ism.inscription.entities.Professeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ClasseProfController {
    @FXML
    private AnchorPane anchorAffecter;


    @FXML
    private TableView<Classe> tabClasseprof;

    @FXML
    private TableColumn<Classe, String> tdId;

    @FXML
    private TableColumn<Classe, String> tdlibellé;

    @FXML
    private TextField txtNci;

    @FXML
    private TextField txtClasseID;

    
    @FXML
    private TextField txtProfId;





    Professeur professeur;
    
    public void handlelisterclasseProf(){
        String Nci=txtNci.getText().trim();
        professeur=Fabrique.getService().findByNci(Nci);
        if (professeur!=null){
            ObservableList obClasse=FXCollections.observableList(Fabrique.getService().listerClasseProfesseur(Nci));
            tdId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tdlibellé.setCellValueFactory(new PropertyValueFactory<>("libelle"));
            tabClasseprof.setItems(obClasse);  

        }
        else{
            
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("il existe pas");
            alert.show();
        }
        tabClasseprof.getItems().clear();
       
    }

    public Professeur handlerechercherProf(){
        String Nci=txtNci.getText().trim();
        professeur=Fabrique.getService().findByNci(Nci);
        if (professeur!=null){
            anchorAffecter.setDisable(false);

        }else{
            anchorAffecter.setDisable(true);
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("il existe pas");
            alert.show();
        }
        return professeur;


    }
    public void handleAffecterclasseprof(){
        String ClasseID=txtClasseID.getText().trim();
        String profId=txtProfId.getText().trim();
        Classe classe=Fabrique.getService().rechercherClasseParLibelle( ClasseID);
         if (classe!=null){
           professeur=Fabrique.getService().findByNci(profId);
           if (professeur!=null){
            ProfClasse  profClasse=Fabrique.getService().affecterClasseProfesseur(new ProfClasse(professeur, classe));
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("Classe Affecté");
            alert.show();


           }
        }
    }
 

}


