package ism.inscription.controlleurs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.App;
import ism.inscription.core.Fabrique;
import ism.inscription.entities.Classe;
import ism.inscription.services.Service;
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
import javafx.scene.layout.AnchorPane;

public class ClasseController implements Initializable {
     @FXML
     private TableView<Classe> tabClasse;
 
     @FXML
     private TableColumn<Classe,String> tdId;
 
     @FXML
     private TableColumn<Classe,String> tdLibelle;
 
     @FXML
     private TextField txtLibelle;
     @FXML
     private AnchorPane anchorContent;
 



    //Conversion de la liste de classe retounée par la classe inscriptionsservices en un objet de type ObservablesList

    private ObservableList obClasse=FXCollections.observableList(Fabrique.getService().listerClasse());

     @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
     tdId.setCellValueFactory(new PropertyValueFactory<>("id"));
     tdLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
     tabClasse.setItems(obClasse);
        
    }
  
 
   
 
    @FXML
   private void onSaveClasse() throws IOException {
            String Libelle=txtLibelle.getText().trim();
            Classe classe= Fabrique.getService().ajouterClasse(
                 new Classe(Libelle)
            );
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion Inscription");
            alert.setContentText("classe ajouté avec succes");
            alert.show();
            obClasse.add(classe);
         
            tabClasse.getItems().clear();
       
   }
 
   public void loadView(String fxml) throws IOException{
     AnchorPane root =(AnchorPane) App.loadFXML(fxml);
     anchorContent.getChildren().clear();
     anchorContent.getChildren().add(root);
 }
      
 public void handleloadViewClasseProf() throws IOException{
     this.loadView("classeProf");
 }   
      
      
}
       
       