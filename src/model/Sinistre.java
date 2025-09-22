package model;

import Type.TypeSinistre;

import java.sql.Date;

public class Sinistre {

    private Integer sinistreId ;

    private Date date ;

    private Double montant ;

    private String description ;

    private TypeSinistre type;

    private static  int counter=0;

    private int contrat_id ;


    public Sinistre(Date date , Double montant ,String description , TypeSinistre ts, int contrat_id){
        counter++;

        this.sinistreId=counter;

        this.date=date;

        this.montant = montant ;

        this.description = description ;

        this.type=ts;
        this.contrat_id=contrat_id;

    }

    public Sinistre(Integer id, Date date, Double montant, String description ,TypeSinistre ts , int contrat_id) {
        this.sinistreId = id;
        this.date = date;
        this.montant = montant;
        this.description = description;
        this.type=ts;
        this.contrat_id=contrat_id;
    }

    public Integer getId() {
        return sinistreId;
    }

    public void setId(Integer id) {
        this.sinistreId = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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


    public int getContrat_id() {
        return contrat_id;
    }

    public void setContrat_id(int contrat_id) {
        this.contrat_id = contrat_id;
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
