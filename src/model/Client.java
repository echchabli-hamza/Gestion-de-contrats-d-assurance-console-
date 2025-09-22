package model;

import java.util.ArrayList;

public class Client extends Person{

    private Integer clientId ;

    private ArrayList<Contrat> liseDeContract;

     private static int counter = 0;


    public Client(String nom, String prenom, String email) {
        super(nom, prenom, email);

        counter++;

        this.clientId = counter;

        this.liseDeContract=new ArrayList<>();

    }

    public Client(String nom, String prenom, String email ,int id) {
        super(nom, prenom, email);

        counter++;

        this.clientId = id;

        this.liseDeContract=new ArrayList<>();

    }


}





