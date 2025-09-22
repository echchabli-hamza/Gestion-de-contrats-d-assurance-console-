package model;

import java.util.ArrayList;

public class Conseiller extends Person{


    private Integer conseillerId;

    private ArrayList<Client> listeDEClients;


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
}
