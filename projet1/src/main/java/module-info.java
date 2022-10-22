

module ism.inscription {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens ism.inscription.controlleurs to javafx.fxml;
    exports ism.inscription;
    exports ism.inscription.entities;
    exports ism.inscription.controlleurs;
    
}


 