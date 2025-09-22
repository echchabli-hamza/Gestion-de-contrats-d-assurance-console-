package model;

import Type.TypeContract;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contract {

    private Integer contractId ;

    private LocalDate dateDebut ;

    private LocalDate dateFin ;

    private TypeContract type;

    private ArrayList<Sinistre> liseDeSinistre ;

    private static  int counter=0;



    public Contract( LocalDate dateDebut, LocalDate dateFin, TypeContract type) {
        counter++;

        this.contractId = counter;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.liseDeSinistre = new ArrayList<>();
    }

    public Contract(Integer id, LocalDate dateDebut, LocalDate dateFin, TypeContract type) {
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

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public TypeContract getType() {
        return type;
    }

    public void setType(TypeContract type) {
        this.type = type;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Contract.counter = counter;
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
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", type=" + type +
                '}';
    }
}
