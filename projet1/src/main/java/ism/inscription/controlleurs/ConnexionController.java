package ism.inscription.controlleurs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.App;
import ism.inscription.core.Fabrique;
import ism.inscription.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConnexionController implements Initializable {
    @FXML
   Text lblErrorMessage;
    @FXML
   Button btnConnexion,btnAnnuler;
   @FXML
   TextField txtLogin;
   @FXML
   PasswordField txtPassword;
  
    public void handleConnexion() throws IOException{
 
        String login =txtLogin.getText().trim();
        String password =txtPassword.getText().trim();
       User user=Fabrique.getService().seConnecter(login, password);
        if(user!=null){
           lblErrorMessage.setVisible(false);
             App.setRoot("home");
    
        }else{
             lblErrorMessage.setVisible(true);
        }
    
     }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lblErrorMessage.setVisible(false);
        
    }
   
  /*   @FXML
    TextField txtLogin;
  @FXML
  PasswordField txtPassword;


       lblErrorLogin.setVisible(false);
       lblErrorPassword.setVisible(false);

      txtLogin.textProperty().addListener((ob,oldV,newV)->{
          boolean ok=false;
          if(!newV.isEmpty()){
             Pattern pattern =
               Pattern.compile("[a-zA-Z0-9]*@(gmail|yahoo){1}.(com|fr)",
               Pattern.CASE_INSENSITIVE);
             Matcher matcher=pattern.matcher(newV);
              if(!(matcher.find() && matcher.group().equals(newV))){
                  lblErrorLogin.setText("veuillez saisir un email");
                  ok=true;
           }
          }
          lblErrorLogin.setVisible(ok);
       });


       txtPassword.textProperty().addListener((ob,oldV,newV)->{
         lblErrorPassword.setVisible(newV.isEmpty());
      });

*/
  
} 