package model;

import java.util.ArrayList;

public class Client extends Person{


    private Integer clientId ;

    private Integer conseillerID ;

    private ArrayList<Contrat> liseDeContract;

     private static int counter = 0;


    public Client(String nom, String prenom, String email ,int conseillerID) {
        super(nom, prenom, email);

        counter++;

        this.clientId = counter;
        this.conseillerID =conseillerID;

        this.liseDeContract=new ArrayList<>();

    }

    public Client(String nom, String prenom, String email ,int id  , int conseillerID) {
        super(nom, prenom, email);

        counter++;

        this.clientId = id;

        this.conseillerID =conseillerID;

        this.liseDeContract=new ArrayList<>();

    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getConseillerID() {
        return conseillerID;
    }

    public void setConseillerID(Integer conseillerID) {
        this.conseillerID = conseillerID;
    }

    @Override
    public String toString() {
        return super.toString() +
                "/ conseillerID : " + conseillerID +
                "/ clientId: " + clientId ;
    }
}





