package model;

public class Client extends Person{

    private String personId ;


    public Client(String nom, String prenom, String email, String id) {
        super(nom, prenom, email);
        this.personId = id;
    }
}
