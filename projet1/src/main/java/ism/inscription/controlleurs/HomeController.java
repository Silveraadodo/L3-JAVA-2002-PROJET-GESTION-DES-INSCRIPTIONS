package ism.inscription.controlleurs;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable{
    @FXML
    private AnchorPane anchorContent;
    public void loadView(String fxml) throws IOException{
        AnchorPane root =(AnchorPane) App.loadFXML(fxml);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);
    }
    public void handleloadViewClasse() throws IOException{
        this.loadView("classe");
        
    }
    public void handleloadViewEtudiant() throws IOException{
        this.loadView("etudiant");
    }
    public void handleloadViewProfesseur() throws IOException{
        this.loadView("professeur");
    }
    public void handleloadViewInscription() throws IOException{
        this.loadView("inscription");
    }
   
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       
        }
        
      

}