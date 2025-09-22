package model;

import Type.TypeSinistre;

import java.time.LocalDate;

public class Sinistre {

    private Integer sinistreId ;

    private LocalDate date ;

    private Double montant ;

    private String description ;

    private TypeSinistre type;

    private static  int counter=0;


    public Sinistre(LocalDate date , Double montant ,String description){
        counter++;

        this.sinistreId=counter;

        this.date=date;

        this.montant = montant ;

        this.description = description ;


    }

    public Sinistre(Integer id, LocalDate date, Double montant, String description) {
        this.sinistreId = id;
        this.date = date;
        this.montant = montant;
        this.description = description;
    }

    public Integer getId() {
        return sinistreId;
    }

    public void setId(Integer id) {
        this.sinistreId = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Sinistre.counter = counter;
    }


    public TypeSinistre getType() {
        return type;
    }

    public void setType(TypeSinistre type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Sinistre{" +
                "id=" + sinistreId +
                ", date=" + date +
                ", montant=" + montant +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
