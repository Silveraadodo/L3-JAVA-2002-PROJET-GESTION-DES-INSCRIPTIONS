package ism.inscription.entities;

public class User {
    private static int  nbre;
    protected int id;
    protected Role role;
    protected String login;
    protected String password;
    protected String nomComplet;
   
    

    public User(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public User(int id, Role role, String login, String password, String nomComplet) {
        this.id = id;
        this.role = role;
        this.login = login;
        this.password = password;
        this.nomComplet = nomComplet;
        role=Role.RP;
    }
    public User() {
        nbre++;
        id=nbre;
    }
    public User(String login, String password, String nomComplet) {
        this.login = login;
        this.password = password;
        this.nomComplet = nomComplet;
        role=Role.RP;
        nbre++;
        id=nbre;

   
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    
}
