package model;

import Type.TypeContract;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

public class Contrat {

    private Integer contractId ;

    private Date dateDebut ;

    private int clientId;

    private Date dateFin ;

    private TypeContract type;



    private ArrayList<Sinistre> liseDeSinistre ;

    private static  int counter=0;



    public Contrat( Date dateDebut, Date dateFin, TypeContract type , int clinetID) {
        counter++;

        this.clientId = clinetID;
        this.contractId = counter;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.liseDeSinistre = new ArrayList<>();
    }

    public Contrat(Integer id , Date dateDebut, Date dateFin, TypeContract type,int clinetID) {
        this.clientId = clinetID;
        this.contractId = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.liseDeSinistre = new ArrayList<>();
    }

    public Integer getId() {
        return contractId;
    }

    public void setId(Integer id) {
        this.contractId = id;
    }

    public int getclientId(){
        return this.clientId;
    }

    public void setClientId(int id ){
        this.clientId = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public TypeContract getType() {
        return type;
    }

    public void setType(TypeContract type) {
        this.type = type;
    }


    public void addSinistre(Sinistre sinistre) {
        if (sinistre != null) {
            liseDeSinistre.add(sinistre);
        }
    }

    public ArrayList<Sinistre> getSinistres() {
        return liseDeSinistre;
    }




    @Override
    public String toString() {
        return "Contract{" +
                "id=" + contractId +
                "  Client id :" + clientId+
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", type=" + type +
                '}';
    }
}
