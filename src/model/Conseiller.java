package model;

import java.util.ArrayList;

public class Conseiller extends Person{


    private Integer conseillerId;

    private ArrayList<Client> listeDEClients;

    private static int counter = 0;



    public Conseiller(String nom, String prenom, String email) {

        super(nom, prenom, email);
        counter++;
        this.conseillerId = counter;
        this.listeDEClients = new ArrayList<>();
    }

    public Conseiller(String nom, String prenom, String email, Integer conseillerId) {
        super(nom, prenom, email);
        this.conseillerId = conseillerId;
        this.listeDEClients = new ArrayList<>();
    }

    public Integer getConseillerId() {
        return conseillerId;
    }

    public void setConseillerId(Integer conseillerId) {
        this.conseillerId = conseillerId;
    }

    public ArrayList<Client> getListeDEClients() {
        return listeDEClients;
    }

    public void addClient(Client client) {
        if (client != null) {
            this.listeDEClients.add(client);
        }
    }

    @Override
    public String toString() {
        return super.toString() +

                "conseillerId=" + conseillerId ;

    }
}
